package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class ProfesorRepository implements IProfesorRepository {
	
	@PersistenceContext
	private EntityManager en;

	@Override
	public void guardar(Profesor profesor) {
		this.en.persist(profesor);
		
	}

	@Override
	public void actualizar(Profesor profesor) {
		this.en.merge(profesor);
		
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		Query query = this.en.createQuery("UPDATE Profesor p SET p.nombre =: valor1, p.apellido =:valor2 WHERE p.id =: valor3");
        query.setParameter("valor1", nombre);
        query.setParameter("valor2", apellido);
        query.setParameter("valor3", id);
        query.executeUpdate();
		
	}

	@Override
	public Profesor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.en.find(Profesor.class, id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method 
		this.en.remove(this.buscar(id));
		
	}

	@Override
	public List<Profesor> buscarTodos(String genero) {
		 var query = this.en.createQuery("SELECT p Profesor FROM Profesor p WHERE p.genero =: valorGenero", Profesor.class);
	        query.setParameter("valorGenero", genero);

	        return query.getResultList();
	}

}
