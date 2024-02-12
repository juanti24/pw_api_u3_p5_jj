package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteLigeroTO extends RepresentationModel<EstudianteLigeroTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String apellido;

	private String carrera;

	private Boolean gratuidad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

