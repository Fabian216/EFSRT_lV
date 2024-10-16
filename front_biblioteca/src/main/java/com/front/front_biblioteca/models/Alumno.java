package com.front.front_biblioteca.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Alumno {
    private int id;
    private String dni;
    private String nombre;
    private String email;
    private String telefono;
}
