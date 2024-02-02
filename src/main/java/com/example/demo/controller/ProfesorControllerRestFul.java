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

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController // Servicio puede tener muchos servicios
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {
	
		@Autowired
		private IProfesorService iProfesorService;
	
	
	 	@GetMapping(path="/{id}")  
	    public Profesor buscar(@PathVariable Integer id){
	        return iProfesorService.buscar(id);
	    }

	   // http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	    @PostMapping(path="/guardar")
	    public void guardar(@RequestBody Profesor profesor){
	        this.iProfesorService.guardar(profesor);
	    }
	    @PutMapping(path="/actualizar")
	    public void actualizar(@RequestBody Profesor profesor){
	        this.iProfesorService.actualizar(profesor);
	    }
	    @PatchMapping(path = "/actualizarParcial")
	    public void actualizarParcial (@RequestBody Profesor profesor){
	        this.iProfesorService.actualizarParcial(profesor.getApellido(), profesor.getNombre(), profesor.getId());
	    }
	    @DeleteMapping(path = "/borrar/{id}")
	    public void borrar(@PathVariable Integer id){
	        this.iProfesorService.borrar(id);
	    }

	    //filtrar un conjunto/lista los datos
	    @GetMapping(path = "/consultarTodos")
	    // http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=f&edad=15
	    public List<Profesor> consultarTodos(@RequestParam String genero){
	   
	        return this.iProfesorService.buscarTodos(genero);
	    }

	

}
