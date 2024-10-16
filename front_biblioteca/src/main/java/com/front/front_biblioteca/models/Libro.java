package com.front.front_biblioteca.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private String estado;
}
