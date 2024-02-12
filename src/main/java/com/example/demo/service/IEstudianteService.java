package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	

	//CREATE
	public void guardar (Estudiante estudiante);
	
	//UPDATE
	public void actualizar (Estudiante estudiante);
	
	public void actualizarParcial (String apellido, String nombre, Integer id);
	
	//READ
	public Estudiante buscar (Integer id);
	
	public List<Estudiante> buscarTodos (String genero);
	
	public List<EstudianteTO> buscarTodosTO ();
	
	public EstudianteTO buscarTO (Integer id);
	
	
	public void borrar (Integer id);
	
	
	public EstudianteLigeroTO buscarEstudianteLigeroTO (Integer id);
	
	
	
}
