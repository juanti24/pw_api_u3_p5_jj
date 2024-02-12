package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "estudiante")
@JsonIgnoreProperties(value = "materias")
public class Estudiante {
	
	@Id
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@Column(name = "estu_id")			
	private Integer id;
	
	@Column(name = "estu_nombre")
	private String nombre;
	
	@Column(name = "estu_apellido")
	private String aepllido;
	
	@Column(name = "estu_genero")
	private String genero;
	
	@Column(name = "estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	
	@Column(name = "estu_cedula")
	private  String cedula;
	
	@Column(name = "estu_rango_economico")
	private String rangoEconomico;
	
	@Column(name = "estu_facultad")
	private String facultad;
	
	@Column(name = "estu_carrera")
	private String carrera;
	
	@Column(name = "estu_gratuidad")
	private Boolean gratuidad;
	
	
	@OneToMany(mappedBy = "estudiante")
	private List<Materia> materias;
	

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

	public String getAepllido() {
		return aepllido;
	}

	public void setAepllido(String aepllido) {
		this.aepllido = aepllido;
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

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	
	
	
}
