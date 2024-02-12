package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	
	@Id
	@GeneratedValue(generator = "seq_profesor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_profesor", sequenceName = "seq_profesor", allocationSize = 1)
	@Column(name = "prof_id")
	private Integer id;
	
	
	@Column(name = "prof_nombre")
	private String nombre;
	
	@Column(name = "prof_apellido")
	private String apellido;
	
	@Column(name = "prof_fecha_contratacion")
	private LocalDateTime fechaContratacion;
	
	@Column(name = "prof_nivel_educacion")
	private String nivelEducacion;
	
	@Column(name = "prof_correo")
	private String correo;
	
	@Column(name = "prof_direccion")
	private String direccion;

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

	public LocalDateTime getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDateTime fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public String getNivelEducacion() {
		return nivelEducacion;
	}

	public void setNivelEducacion(String nivelEducacion) {
		this.nivelEducacion = nivelEducacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	

}
