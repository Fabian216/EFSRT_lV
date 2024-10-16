package com.example.biblioteca_cibertec.controllers;

import com.example.biblioteca_cibertec.models.Alumno;
import com.example.biblioteca_cibertec.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    private IAlumnoService alumno;

    @Autowired
    public AlumnoController(IAlumnoService alumno){
        this.alumno = alumno;
    }

    @GetMapping
    public List<Alumno> getAll(){
        return this.alumno.getAll();
    }

    @GetMapping("/{id}")
    public Alumno findById(@PathVariable int id){
        return this.alumno.findById(id);
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno nuevo_alumno){
        return this.alumno.create(nuevo_alumno);
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable int id,@RequestBody Alumno alumno){
        return this.alumno.update(id,alumno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.alumno.delete(id);
    }
}
