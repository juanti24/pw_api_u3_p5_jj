package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Profesor;

public interface IProfesorRepository {
	
	public void guardar (Profesor profesor);
    public void actualizar(Profesor profesor);
    public void actualizarParcial(String apellido, String nombre, Integer id);
    public Profesor buscar(Integer id);
    public void borrar(Integer id);
    public List<Profesor> buscarTodos(String genero);

}
