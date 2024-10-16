package com.example.biblioteca_cibertec.services;

import com.example.biblioteca_cibertec.models.Alumno;

import java.util.List;

public interface IAlumnoService {
    List<Alumno> getAll();
    Alumno findById(int id);
    Alumno create(Alumno entity);
    Alumno update(int id, Alumno entity);
    void delete(int id);
}
