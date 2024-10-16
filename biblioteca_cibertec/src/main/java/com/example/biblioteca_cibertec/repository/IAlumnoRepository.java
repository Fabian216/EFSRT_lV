package com.example.biblioteca_cibertec.repository;

import com.example.biblioteca_cibertec.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno,Integer> {
}
