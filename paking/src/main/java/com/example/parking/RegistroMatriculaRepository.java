package com.example.parking;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroMatriculaRepository extends JpaRepository<RegistroMatricula, Long> {

    List<RegistroMatricula> findByEntrada(boolean entrada);  // Para /entradas y /salidas

    RegistroMatricula findTopByMatriculaAndEntradaOrderByHoraDesc(String matricula, boolean entrada);
    List<RegistroMatricula> findByMatriculaOrderByHoraDesc(String matricula);

}