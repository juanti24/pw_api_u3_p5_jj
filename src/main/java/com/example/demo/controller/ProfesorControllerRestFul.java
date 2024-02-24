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

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService profesorService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profesor> buscar(@PathVariable Integer id) {

		Profesor prof = this.profesorService.buscar(id);

		return ResponseEntity.status(HttpStatus.OK).body(prof);
	}

	@GetMapping(path = "/f", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>> buscarFiltro(
			@RequestParam(required = false, defaultValue = "Doctorado") String nivelEducacion,
			@RequestParam(required = false, defaultValue = "Torres") String apellido) {

		List<Profesor> listProf = this.profesorService.buscarFiltro(nivelEducacion, apellido);

		HttpHeaders headers = new HttpHeaders();

		headers.add("mensaje_aceptacion", "Se ha encontrado najo los parametros establecidos");
		headers.add("mensaje_info", "se ha buscado en la bd ...");
		return new ResponseEntity<>(listProf, headers, HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>> buscarTodos() {

		List<Profesor> listProf = this.profesorService.buscarTodos();
		HttpHeaders headers = new HttpHeaders();

		headers.add("mensaje_aceptacion", "Se ha encontrado todos");
		headers.add("mensaje_info", "se ha buscado en la bd ...");
		return new ResponseEntity<>(listProf, headers, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualziar(@RequestBody Profesor profesor, @PathVariable Integer id) {

		profesor.setId(id);
		this.profesorService.actualizar(profesor);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualziarParcial(@RequestBody Profesor profesor, @PathVariable Integer id) {
		this.profesorService.actualizarParcial(profesor.getDireccion(), profesor.getNivelEducacion(),
				profesor.getCorreo(), id);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {

		this.profesorService.borrar(id);
		
		return ResponseEntity.ok("se elimino correctamente");
	}

}
