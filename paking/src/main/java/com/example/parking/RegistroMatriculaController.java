package com.example.parking;

import com.example.parking.RegistroMatricula;
import com.example.parking.RegistroMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class RegistroMatriculaController {

    @Autowired
    private RegistroMatriculaRepository registroRepo;

    @PostMapping("/registroMatricula")
    public RegistroMatricula registrarMatricula(@RequestBody RegistroMatricula registro) {
        return registroRepo.save(registro);
    }
}