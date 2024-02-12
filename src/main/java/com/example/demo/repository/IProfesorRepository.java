package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorRepository {

	// CREATE
	public void insertar(Profesor profesor);

	// UPDATE
	public void actualizar(Profesor profesor);
	
	public void actualizarParcial(String direccion, String nivelEducacion, String correo, Integer id);

	// READ
	public Profesor seleccionar(Integer id);
	
	public List<Profesor> seleccionarTodos();

	public List<Profesor> seleccionarFiltro(String nivelEducacion, String apellido);

	//DELETE
	public void eliminar(Integer id);
	

}
