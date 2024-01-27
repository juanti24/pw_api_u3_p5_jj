package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
//API:Un proyecto API

//Servicio -> Controller: Clase controller
//Capacidades -> Metodos de una clase
@RestController//Servicio puede tener muchos servicios
@RequestMapping(path="/estudiantes")
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudiante;

	//Capacidades: Metodos
	public void guardar(Estudiante estudiante) {
	
		
		
	}
	
	@GetMapping(path="/buscar")
	public Estudiante buscar() {
		
		return this.estudiante.buscar(1);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	
	@PostMapping(path="/guardar")
	public void guardar1(@RequestBody Estudiante estudiante) {
		this.estudiante.guardar(estudiante);
	}
	
	
}
