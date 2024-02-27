package com.example.demo.controller;

//guardar estos import
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
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
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

//API: determinada por el proyecto JAVA	

@RestController
@RequestMapping(path = "/estudiantes")
//servicio es la clase controller
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;

	// CRUD

	// CREATE
	// metodso->capacaidades: guardar
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudianteTO) {
		this.estudianteService.guardar(estudianteTO);
	}

	// READ
	@GetMapping(path = "/completo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteTO> buscarTO(@PathVariable Integer id) {

		EstudianteTO estu = this.estudianteService.buscarTO(id);

		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).conusltarMateriasPorId(estu.getId()))
				.withRel("materias");

		estu.add(link);

		return ResponseEntity.status(HttpStatus.OK).body(estu);

	}

	// READ - ALL

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscarTodosHateoas() {

		List<EstudianteTO> listEstu = this.estudianteService.buscarTodosTO();

		for (EstudianteTO estTo : listEstu) {

			Link link = linkTo(methodOn(EstudianteControllerRestFul.class).conusltarMateriasPorId(estTo.getId()))
					.withRel("materias");
			estTo.add(link);

		}

		return ResponseEntity.status(HttpStatus.OK).body(listEstu);

	}

	// UPDATE

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody EstudianteTO estudianteTO, @PathVariable Integer id) {

		estudianteTO.setId(id);

		this.estudianteService.actualizar(estudianteTO);
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);

	}

	// --------------------------------------------------------
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> conusltarMateriasPorId(@PathVariable Integer id) {

		List<MateriaTO> listMaterias = this.materiaService.buscarPorIdEstudinate(id);

		return ResponseEntity.status(HttpStatus.OK).body(listMaterias);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteLigeroTO> buscarLigeroTO(@PathVariable Integer id) {

		EstudianteLigeroTO estu = this.estudianteService.buscarEstudianteLigeroTO(id);

		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).buscarTO(estu.getId())).withSelfRel();

		estu.add(link);

		return ResponseEntity.status(HttpStatus.OK).body(estu);

	}
}
