package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class EstudianteRepository implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager en;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.en.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.en.merge(estudiante);
	}


	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.en.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.en.remove(this.seleccionar(id));
	}

	@Override
	public void actulizarParcial(String apellido, String nombre, Integer id) {
		Query query = this.en.createQuery("UPDATE Estudiante e SET e.nombre =:valor1, e.apellido =:valor2 WHERE e.id =:valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		query.executeUpdate();
	
	}

	@Override
	public List<Estudiante> seleccionarTodos(String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.en.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		
		myQuery.setParameter("variable", genero);
		return myQuery.getResultList();
	}

}
