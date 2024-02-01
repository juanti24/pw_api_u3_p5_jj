package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pofesor")
public class Profesor {

	
	@Id
	@GeneratedValue(generator = "seq_profesor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_profesor", sequenceName = "seq_profesor", allocationSize = 1 )
	@Column(name="prof_id")
	private Integer id;
	@Column(name="prof_nombre")
	private String nombre;
	@Column(name="prof_apellido")
	private String apellido;
	@Column(name="prof_genero")
	private String genero;
	@Column(name="prof_materia")
	private String materia;
	@Column(name="prof_correo")
	private String correo;
	@Column(name="prof_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	
	
	//GET Y SET

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

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	

	
	
	
	
	
}
