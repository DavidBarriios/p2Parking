package com.example.parking;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroMatriculaRepository extends JpaRepository<RegistroMatricula, Long> {
    List<RegistroMatricula> findByEntrada(boolean entrada);  // Buscar registros por estado de entrada
    RegistroMatricula findTopByMatriculaAndEntradaOrderByHoraDesc(String matricula, boolean entrada);
}