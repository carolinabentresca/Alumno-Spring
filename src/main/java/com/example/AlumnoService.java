package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    //Método List
    public List<Alumno> listAlumnos() {
        return repository.findAll();

    }

    //Método Save
    public void saveAlumno(Alumno alumno) {
        repository.save(alumno);

    }

    //Método Get por Id
    public Alumno getAlumno(int id) {
        return repository.findById(id).get();

    }

    //Método Delete
    public void deleteAlumno(int id) {
        repository.deleteById(id);

    }
}
