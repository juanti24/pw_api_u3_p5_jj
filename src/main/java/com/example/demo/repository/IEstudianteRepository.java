package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.Query;

public interface IEstudianteRepository {
	
	//CREATE
	public void insertar (Estudiante estudiante);
	
	//UPDATE
	public void actualizar (Estudiante estudiante);
	
	public void actualizarParcial (String apellido, String nombre, Integer id);
	
	//READ
	public Estudiante seleccionar (Integer id);
	
	public List<Estudiante> seleccionarTodosGenero (String genero);
	
	public List<Estudiante> seleccionarTodos();
	
	public void eliminar (Integer id);
	
	
	
}
