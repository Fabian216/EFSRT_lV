package com.front.front_biblioteca.controllers;

import com.front.front_biblioteca.models.Alumno;
import com.front.front_biblioteca.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AlumnoController {

    private IAlumnoService alumno;

    @Autowired
    public AlumnoController(IAlumnoService alumno){
        this.alumno = alumno;
    }

    @GetMapping("/listaalumnos")
    public String getAll(Model model){
        List<Alumno> lista = this.alumno.getAll();
        model.addAttribute("getAllAlumnos",lista);
        return "vista_alumnos";
    }

    @PostMapping("/crearalumno")
    public String create(@ModelAttribute Alumno entity, Model model){
        Alumno obj = this.alumno.create(entity);
        model.addAttribute("createAlumno",obj);
        return "redirect:/listaalumnos";
    }

    @GetMapping("/crearalumno")
    public String formAlumno(Model model){
        model.addAttribute("formAlumno", new Alumno());
        return "/Alumno/vista_nuevo_alumno";
    }

    @GetMapping("/alumno/{id}")
    public String getById(@PathVariable int id, Model model) {
        Alumno alumno = this.alumno.findById(id);
        model.addAttribute("alumno", alumno);
        return "/Alumno/vista_detalle_alumno";
    }

    @PostMapping("/alumno/editar/{id}")
    public String update(@PathVariable int id, @ModelAttribute Alumno entity, Model model) {
        Alumno updatedAlumno = this.alumno.update(id, entity);
        model.addAttribute("updateAlumno", updatedAlumno);
        return "redirect:/listaalumnos";
    }

    @GetMapping("/alumno/eliminar/{id}")
    public String delete(@PathVariable int id) {
        this.alumno.delete(id);
        return "redirect:/listaalumnos";
    }

}