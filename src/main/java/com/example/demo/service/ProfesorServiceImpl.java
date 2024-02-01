package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProfesorRepository;
import com.example.demo.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService{
	
	 @Autowired
	 private IProfesorRepository iProfesorRepository;

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.guardar(profesor);
		
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.actualizar(profesor);
	
		
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.actualizarParcial(apellido, nombre, id);
	
		
	}

	@Override
	public Profesor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iProfesorRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.borrar(id);
		
	}

	@Override
	public List<Profesor> buscarTodos(String genero) {
		// TODO Auto-generated method stub
		return this.iProfesorRepository.buscarTodos(genero);
	}

}
