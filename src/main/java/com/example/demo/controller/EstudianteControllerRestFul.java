package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
//API:Un proyecto API

//Servicio -> Controller: Clase controller
//Capacidades -> Metodos de una clase
@RestController // Servicio puede tener muchos servicios
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
	 
    @Autowired
    private IEstudianteService estudianteService;
 

    //Metodosd = capacidades

    @GetMapping(path="/{id}")  
    public Estudiante buscar(@PathVariable Integer id){
        return estudianteService.buscar(id);
    }

   // http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
    @PostMapping
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }
    @PutMapping(path="/{id}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id){
        estudiante.setId(id);
    	this.estudianteService.actualizar(estudiante);
    }
    @PatchMapping(path = "/{id}")
    public void actualizarParcial (@RequestBody Estudiante estudiante, @PathVariable Integer id){
    	this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
    }
    @DeleteMapping(path = "/{id}")
    public void borrar (){
        this.estudianteService.borrar(1);
    }

    //filtrar un conjunto/lista los datos
    @GetMapping
    // http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=f&edad=15
    public List<Estudiante> consultarTodos(@RequestParam (required = false, defaultValue = "M") String genero){
     
        return this.estudianteService.buscarTodos(genero);
    }


}
