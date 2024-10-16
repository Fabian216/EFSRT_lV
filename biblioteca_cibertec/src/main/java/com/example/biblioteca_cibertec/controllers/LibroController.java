package com.example.biblioteca_cibertec.controllers;

import com.example.biblioteca_cibertec.models.Libro;
import com.example.biblioteca_cibertec.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private ILibroService libro;

    @Autowired
    public LibroController(ILibroService libro){
        this.libro = libro;
    }

    @GetMapping
    public List<Libro> getAll(){
        return this.libro.getAll();
    }

    @GetMapping("/{id}")
    public Libro findById(@PathVariable int id){
        return this.libro.findById(id);
    }

    @PostMapping
    public Libro create(@RequestBody Libro nuevo_libro){
        return this.libro.create(nuevo_libro);
    }

    @PutMapping("/{id}")
    public Libro update(@PathVariable int id,@RequestBody Libro libro){
        return this.libro.update(id,libro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.libro.delete(id);
    }
}
