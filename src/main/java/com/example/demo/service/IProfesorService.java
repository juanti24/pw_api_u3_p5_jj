package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorService {

	
	public void guardar(Profesor profesor);


	public void actualizar(Profesor profesor);
	
	public void actualizarParcial(String direccion, String nivelEducacion, String correo, Integer id);


	public Profesor buscar(Integer id);
	
	public List<Profesor> buscarTodos();

	public List<Profesor> buscarFiltro(String nivelEducacion, String apellido);

	
	public void borrar(Integer id);
}
