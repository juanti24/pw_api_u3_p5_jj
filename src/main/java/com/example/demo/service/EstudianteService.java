package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteService implements IEstudianteService{
    @Autowired
    private IEstudianteRepository iEstudianteRepository;
    @Override
    public void guardar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.insertar(estudiante);
    }
    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.actualizar(estudiante);
    }
    @Override
    public void actualizarParcial(String apellido, String nombre, Integer Id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.actualizarParcial(apellido, nombre, Id);
    }
    @Override
    public Estudiante buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.iEstudianteRepository.seleccionar(id);
    }
    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.iEstudianteRepository.eliminar(id);
    }

    @Override
    public List<Estudiante> buscarTodos(String genero) {
        // TODO Auto-generated method stub
        return this.iEstudianteRepository.buscarTodos(genero);
    }
	@Override
	public List<EstudianteTO> buscarTodosTO() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.iEstudianteRepository.buscarTodos("M");
		List<EstudianteTO> listaFinal = new ArrayList<>();
		for(Estudiante est:lista) {
			listaFinal.add(this.convertir(est));
		}
		
		return listaFinal;
	}
	
	
	private EstudianteTO convertir(Estudiante est) {
		EstudianteTO estuTo = new EstudianteTO();
		estuTo.setApellido(est.getApellido());
		estuTo.setGenero(est.getGenero());
		estuTo.setFechaNacimiento(est.getFechaNacimiento());
		estuTo.setId(est.getId());
		estuTo.setNombre(est.getNombre());
		return estuTo;
	}
	@Override
	public EstudianteTO buscarTO(Integer id) {
		// TODO Auto-generated method stub

		return this.convertir(this.iEstudianteRepository.seleccionar(id));
	}

}
