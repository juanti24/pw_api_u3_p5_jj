package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepository implements IMateriaRepository {

	
	@PersistenceContext
	private EntityManager et;
	
	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuey = this.et.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id = :id",Materia.class);
		myQuey.setParameter("id", id);
		return myQuey.getResultList();
	}

}
