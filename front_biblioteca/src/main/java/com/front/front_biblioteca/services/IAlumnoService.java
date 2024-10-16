package com.front.front_biblioteca.services;

import com.front.front_biblioteca.models.Alumno;

import java.util.List;

public interface IAlumnoService {
    List<Alumno> getAll();
    Alumno findById(int id);
    Alumno create(Alumno entity);
    Alumno update(int id,Alumno entity);
    void delete(int id);
}
