package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", service.listAlumnos());
        return "index";
    }

    @RequestMapping("/showAlumno")
    public String show(Model model) {
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);
        return "save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("alumno") Alumno alumno) {
        service.saveAlumno(alumno);
        return "redirect:/";
    }

    @RequestMapping(value = "/showAlumno/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        Alumno alumno = service.getAlumno(id);
        model.addAttribute("alumno", alumno);
        return "edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        this.service.deleteAlumno(id);
        return "redirect:/";
    }
}
