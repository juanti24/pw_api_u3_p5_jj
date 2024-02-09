package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;
//API:Un proyecto API

//Servicio -> Controller: Clase controller
//Capacidades -> Metodos de una clase
@RestController // Servicio puede tener muchos servicios
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService iMateriaService;
	
	// Metodosd = capacidades

	@GetMapping(path = "/{id}", produces = "application/xml")
	public ResponseEntity<Estudiante> buscar(@PathVariable Integer id) {
		// 240: grupo satisfactorias
		// 240: Recurso Estudiante encontrado satisfactoriamente
		// Contrato de la API (documento pdf o el uso de Swagger.io)
		// Esto se implementa en las cabeceras el mensaje o significado de este codigo

		Estudiante estu = this.estudianteService.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(estu);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	@PostMapping()
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), estudiante.getId());
	}

	@DeleteMapping(path = "/{id}")
	public void borrar() {
		this.estudianteService.borrar(1);
	}

	// filtrar un conjunto/lista los datos
	@GetMapping(path = "/tmp", produces = MediaType.APPLICATION_JSON_VALUE)
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodos?genero=f&edad=15
	public ResponseEntity<List<Estudiante>> consultarTodos(
			@RequestParam(required = false, defaultValue = "M") String genero) {
		List<Estudiante> lista = this.estudianteService.buscarTodos(genero);

		HttpHeaders cabeceras = new HttpHeaders();

		cabeceras.add("mensaje_242", "Lista consultada de manera satisfactoria");

		return new ResponseEntity<>(lista, cabeceras, 242);
	}

	//https://localhost:8080/API/v1.0/Matricula/estudiantes GET
	//https://localhost:8080/API/v1.0/Matricula/estudiantes/1 GET
	//https://localhost:8080/API/v1.0/Matricula/estudiantes/1/materias GET
	
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> consultarMateriasPorId ( @PathVariable Integer id){
		List<MateriaTO> lista = this.iMateriaService.buscarPorIdEstudiante(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHateoas() {
		List<EstudianteTO> lista = this.estudianteService.buscarTodosTO();

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

}
