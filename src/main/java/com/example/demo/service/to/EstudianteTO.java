package com.example.demo.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;

public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String genero;
	
	private LocalDateTime fechaNacimiento;

	private  String cedula;
	
	private String rangoEconomico;
	
	private String facultad;
	
	private String carrera;
	
	private Boolean gratuidad;
	
	
	//SET Y GET
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getRangoEconomico() {
		return rangoEconomico;
	}


	public void setRangoEconomico(String rangoEconomico) {
		this.rangoEconomico = rangoEconomico;
	}


	public String getFacultad() {
		return facultad;
	}


	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	public Boolean getGratuidad() {
		return gratuidad;
	}


	public void setGratuidad(Boolean gratuidad) {
		this.gratuidad = gratuidad;
	}
	
	
	

	
}
