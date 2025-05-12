package com.example.parking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class RegistroMatriculaController {

    @Autowired
    private RegistroMatriculaRepository registroRepo;

    // POST: Registrar una matrícula (con la acción de entrada o salida)
    @PostMapping("/registroMatricula")
    public RegistroMatricula registrarMatricula(@RequestBody RegistroMatricula registro) {
        // Establecer la hora en el momento del registro
        registro.setHora(LocalDateTime.now());
        // Guardar el registro en la base de datos
        return registroRepo.save(registro);
    }

    // GET: Ver todos los registros
    @GetMapping("/listado")
    public List<RegistroMatricula> listarRegistros() {
        return registroRepo.findAll();
    }

    // GET: Ver los vehículos que están dentro (entrada == true)
    @GetMapping("/entradas")
    public List<RegistroMatricula> listarEntradas() {
        return registroRepo.findByEntrada(true);
    }

    // GET: Ver los vehículos que están fuera (entrada == false)
    @GetMapping("/salidas")
    public List<RegistroMatricula> listarSalidas() {
        return registroRepo.findByEntrada(false);
    }

    // GET: Calcular el coste del aparcamiento para una matrícula
    @GetMapping("/coste/{matricula}")
    public double calcularCoste(@PathVariable String matricula) {
        final double TARIFA_POR_SEGUNDO = 0.05; // Ejemplo: 0.05 € por segundo

        // Obtener última entrada
        RegistroMatricula ultimaEntrada = registroRepo.findTopByMatriculaAndEntradaOrderByHoraDesc(matricula, true);

        // Obtener última salida
        RegistroMatricula ultimaSalida = registroRepo.findTopByMatriculaAndEntradaOrderByHoraDesc(matricula, false);

        if (ultimaEntrada == null || ultimaSalida == null) {
            throw new RuntimeException("No hay registros suficientes para calcular el coste.");
        }

        if (ultimaSalida.getHora().isBefore(ultimaEntrada.getHora())) {
            throw new RuntimeException("La última salida es anterior a la entrada.");
        }

        // Calcular duración en segundos
        long segundos = Duration.between(ultimaEntrada.getHora(), ultimaSalida.getHora()).getSeconds();

        // Calcular coste total
        double coste = Math.round(segundos * TARIFA_POR_SEGUNDO * 100.0) / 100.0;

        return coste;
    }
    @GetMapping("/historico")
    public List<RegistroMatricula> obtenerHistorico(@RequestParam String matricula) {
        return registroRepo.findByMatriculaOrderByHoraDesc(matricula);
    }
}