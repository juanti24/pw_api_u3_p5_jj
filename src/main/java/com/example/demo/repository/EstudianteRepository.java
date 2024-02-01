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
public class EstudianteRepository implements IEstudianteRepository {
	
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.persist(estudiante);
    }
    @Override
    public void actualizar(Estudiante estu) {
        // TODO Auto-generated method stub
        this.entityManager.merge(estu);
    }
    @Override
    public void actualizarParcial(String apellido, String nombre, Integer id) {
        Query query = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre =: valor1, e.apellido =:valor2 WHERE e.id =: valor3");
        query.setParameter("valor1", nombre);
        query.setParameter("valor2", apellido);
        query.setParameter("valor3", id);
        query.executeUpdate();
        
    }
    @Override
    public Estudiante seleccionar(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Estudiante.class, id);
    }
    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.seleccionar(id));
    }



    @Override
    public List<Estudiante> buscarTodos(String genero) {
        // TODO Auto-generated method stub

        var query = this.entityManager.createQuery("SELECT e Estudiante FROM Estudiante e WHERE e.genero =: valorGenero", Estudiante.class);
        query.setParameter("valorGenero", genero);


        return query.getResultList();


    }




}




