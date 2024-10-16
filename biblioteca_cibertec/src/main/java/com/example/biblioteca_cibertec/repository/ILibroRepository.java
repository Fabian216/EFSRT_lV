package com.example.biblioteca_cibertec.repository;

import com.example.biblioteca_cibertec.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroRepository extends JpaRepository<Libro,Integer> {
}
