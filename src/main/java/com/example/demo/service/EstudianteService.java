package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	private IEstudianteRepository ep;

	@Override
	public void guardar(Estudiante estudiante) {
		this.ep.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.ep.actualizar(estudiante);

	}

	@Override
	public void actulizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.ep.actulizarParcial(apellido, nombre, id);

	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ep.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.ep.eliminar(id);
	}

}
