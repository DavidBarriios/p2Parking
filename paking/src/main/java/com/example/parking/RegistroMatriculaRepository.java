package com.example.parking;

import com.example.parking.RegistroMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroMatriculaRepository extends JpaRepository<RegistroMatricula, Long> {
    // Puedes añadir métodos personalizados si lo necesitas
}