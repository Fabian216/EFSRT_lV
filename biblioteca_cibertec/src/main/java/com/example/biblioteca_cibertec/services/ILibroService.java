package com.example.biblioteca_cibertec.services;

import com.example.biblioteca_cibertec.models.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> getAll();
    Libro findById(int id);
    Libro create(Libro entity);
    Libro update(int id, Libro entity);
    void delete(int id);
}
