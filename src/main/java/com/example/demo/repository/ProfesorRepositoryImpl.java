package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(profesor);
	}

	@Override
	public void actualizarParcial(String direccion, String nivelEducacion, String correo, Integer id) {
		// TODO Auto-generated method stub

		Query query = this.entityManager.createQuery(
				"UPDATE Profesor p SET p.direccion= :valor1, p.nivelEducacion= :valor2, p.correo= :valor3 WHERE p.id= :valor4");

		query.setParameter("valor1", direccion);
		query.setParameter("valor2", nivelEducacion);
		query.setParameter("valor3", correo);
		query.setParameter("valor4", id);
		query.executeUpdate();
	}

	@Override
	public Profesor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public List<Profesor> seleccionarTodos() {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("SELECT p FROM Profesor p");

		return query.getResultList();
	}

	@Override
	public List<Profesor> seleccionarFiltro(String nivelEducacion, String apellido) {
		// TODO Auto-generated method stub

		Query query = this.entityManager
				.createQuery("SELECT p FROM Profesor p WHERE p.nivelEducacion= :valor1 OR p.apellido= :valor2");

		query.setParameter("valor1", nivelEducacion);
		query.setParameter("valor2", apellido);
		return query.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

}
