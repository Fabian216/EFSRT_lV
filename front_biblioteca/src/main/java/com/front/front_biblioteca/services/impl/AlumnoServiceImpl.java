package com.front.front_biblioteca.services.impl;


import com.front.front_biblioteca.models.Alumno;
import com.front.front_biblioteca.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    private final RestTemplate restTemplate;

    @Autowired
    public AlumnoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Alumno> getAll(){
        String url = "http://localhost:8080/alumnos";
        Alumno[] obj = this.restTemplate.getForObject(url,Alumno[].class);
        return Arrays.asList(obj);
    }

    @Override
    public Alumno findById(int id) {
        String url = "http://localhost:8080/alumnos/" + id;
        return this.restTemplate.getForObject(url, Alumno.class);
    }

    @Override
    public Alumno create(Alumno entity) {
        String url = "http://localhost:8080/alumnos";
        return this.restTemplate.postForObject(url,entity,Alumno.class);
    }

    @Override
    public Alumno update(int id, Alumno entity) {
        String url = "http://localhost:8080/alumnos/" + id;
        HttpEntity<Alumno> requestUpdate = new HttpEntity<>(entity);
        ResponseEntity<Alumno> response = this.restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Alumno.class);
        return response.getBody();
    }

    @Override
    public void delete(int id) {
        String url = "http://localhost:8080/alumnos/" + id;
        this.restTemplate.delete(url);
    }
}
