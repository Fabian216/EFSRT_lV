package com.example.biblioteca_cibertec.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "LIBRO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "AUTOR")
    private String autor;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "ESTADO")
    private String estado;
}
