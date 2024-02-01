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
	private IEstudianteService estudiante;

	// Capacidades: Metodos
	public void guardar(Estudiante estudiante) {

	}

	@GetMapping(path = "/buscar/{id}")
	public Estudiante buscar(@PathVariable Integer id) {

		return this.estudiante.buscar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar

	@PostMapping(path = "/guardar")
	public void guardar1(@RequestBody Estudiante estudiante) {
		this.estudiante.guardar(estudiante);
	}

	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Estudiante estudiante) {
		this.estudiante.actualizar(estudiante);
	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Estudiante estudiante) {
		this.estudiante.actulizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
	}

	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudiante.borrar(id);
	}
	
	@GetMapping(path="/consultarTodos")
	public List<Estudiante> consultarTodos(@RequestParam String genero,@RequestParam Integer edad){
		System.out.println(edad);
		return this.estudiante.buscarTodos(genero);


	}
}
