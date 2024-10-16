package com.front.front_biblioteca.controllers;

import com.front.front_biblioteca.models.Libro;
import com.front.front_biblioteca.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibroController {

    private ILibroService libro;

    @Autowired
    public LibroController(ILibroService libro) {
        this.libro = libro;
    }

    @GetMapping("/listalibros")
    public String getAll(Model model){
        List<Libro> lista = this.libro.getAll();
        model.addAttribute("getAllLibros",lista);
        return "vista_libros";
    }

    @PostMapping("/crearlibro")
    public String create(@ModelAttribute Libro entity, Model model){
        Libro obj = this.libro.create(entity);
        model.addAttribute("createLibro",obj);
        return "redirect:/listalibros";
    }

    @GetMapping("/crearlibro")
    public String formLibro(Model model){
        model.addAttribute("formLibro", new Libro());
        return "/Libro/vista_nuevo_libro";
    }

    @GetMapping("/libro/{id}")
    public String getById(@PathVariable int id, Model model) {
        Libro libro = this.libro.findById(id);
        model.addAttribute("libro", libro);
        return "/Libro/vista_detalle_libro";
    }

    @PostMapping("/libro/editar/{id}")
    public String update(@PathVariable int id, @ModelAttribute Libro entity, Model model) {
        Libro updatedLibro = this.libro.update(id, entity);
        model.addAttribute("updateLibro", updatedLibro);
        return "redirect:/listalibros";
    }

    @GetMapping("/libro/eliminar/{id}")
    public String delete(@PathVariable int id) {
        this.libro.delete(id);
        return "redirect:/listalibros";
    }

}
