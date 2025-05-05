package com.example.parking;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;

    @Column(nullable = false)
    private boolean entrada;  // True si el coche entra, False si sale

    @Column(nullable = false, updatable = false)
    private LocalDateTime hora;

    @PrePersist
    protected void onCreate() {
        this.hora = LocalDateTime.now();  // Establece la hora en el momento de la inserción
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
}