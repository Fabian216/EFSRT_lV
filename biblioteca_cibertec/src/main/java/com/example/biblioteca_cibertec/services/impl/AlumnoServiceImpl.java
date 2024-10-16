package com.example.biblioteca_cibertec.services.impl;

import com.example.biblioteca_cibertec.models.Alumno;
import com.example.biblioteca_cibertec.repository.IAlumnoRepository;
import com.example.biblioteca_cibertec.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
    private IAlumnoRepository repository;

    @Autowired
    public AlumnoServiceImpl(IAlumnoRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Alumno> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Alumno findById(int id){
        return this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Alumno no encontrado"
                ));
    }

    @Override
    public Alumno create(Alumno entity){
        return this.repository.save(entity);
    }

    @Override
    public Alumno update(int id,Alumno alumno){
        Alumno alum = this.findById(id);

        alum.setDni(alumno.getDni());
        alum.setNombre(alumno.getNombre());
        alum.setEmail(alumno.getEmail());
        alum.setTelefono(alumno.getTelefono());
        return this.repository.save(alum);
    }

    @Override
    public void delete(int id){
        var obj = this.findById(id);
        this.repository.delete(obj);
    }
}
