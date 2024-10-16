package com.example.biblioteca_cibertec.services.impl;

import com.example.biblioteca_cibertec.models.Libro;
import com.example.biblioteca_cibertec.repository.ILibroRepository;
import com.example.biblioteca_cibertec.services.ILibroService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {

    private ILibroRepository repository;

    public LibroServiceImpl(ILibroRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Libro> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Libro findById(int id){
        return this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Libro no encontrado"
                ));
    }

    @Override
    public Libro create(Libro entity){
        return this.repository.save(entity);
    }

    @Override
    public Libro update(int id,Libro libro){
        Libro lib = this.findById(id);

        lib.setTitulo(libro.getTitulo());
        lib.setAutor(libro.getAutor());
        lib.setCategoria(libro.getCategoria());
        lib.setEstado(libro.getEstado());
        return this.repository.save(lib);
    }

    @Override
    public void delete(int id){
        var obj = this.findById(id);
        this.repository.delete(obj);
    }
}
