package com.example.parking;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;

    private boolean entrada;

    private LocalDateTime fechaHora;

    @PrePersist
    protected void onCreate() {
        fechaHora = LocalDateTime.now();
    }
}