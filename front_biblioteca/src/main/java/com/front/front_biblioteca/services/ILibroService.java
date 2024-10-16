package com.front.front_biblioteca.services;

import com.front.front_biblioteca.models.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> getAll();
    Libro findById(int id);
    Libro create(Libro entity);
    Libro update(int id,Libro entity);
    void delete(int id);
}
