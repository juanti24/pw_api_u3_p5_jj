package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	

	@Override
	public void guardar(EstudianteTO estudianteTO) {
		// TODO Auto-generated method stub
		
		
		this.estudianteRepository.insertar(this.convertirAEstudiante(estudianteTO));
	}

	@Override
	public void actualizar(EstudianteTO estudianteTO) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(this.convertirAEstudiante(estudianteTO));
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> buscarTodosGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarTodosGenero(genero);
	}

	@Override
	public List<EstudianteTO> buscarTodosTO() {
		// TODO Auto-generated method stub
		List<Estudiante> list = this.estudianteRepository.seleccionarTodos();

		List<EstudianteTO> listaFinal = new ArrayList<>();

		for (Estudiante est : list) {
			listaFinal.add(this.convertir(est));
		}
		return listaFinal;
	}
	
	
	private Estudiante convertirAEstudiante(EstudianteTO estuTO) {

		Estudiante estu = new Estudiante();
		estu.setAepllido(estuTO.getApellido());
		estu.setFechaNacimiento(estuTO.getFechaNacimiento());
		estu.setGenero(estuTO.getGenero());
		estu.setId(estuTO.getId());
		estu.setNombre(estuTO.getNombre());

		estu.setCedula(estuTO.getCedula());
		estu.setRangoEconomico(estuTO.getRangoEconomico());
		estu.setFacultad(estuTO.getFacultad());
		estu.setCarrera(estuTO.getCarrera());
		estu.setGratuidad(estuTO.getGratuidad());

		return estu;
	}

	private EstudianteTO convertir(Estudiante estu) {

		EstudianteTO estuTO = new EstudianteTO();
		estuTO.setApellido(estu.getAepllido());
		estuTO.setFechaNacimiento(estu.getFechaNacimiento());
		estuTO.setGenero(estu.getGenero());
		estuTO.setId(estu.getId());
		estuTO.setNombre(estu.getNombre());

		estuTO.setCedula(estu.getCedula());
		estuTO.setRangoEconomico(estu.getRangoEconomico());
		estuTO.setFacultad(estu.getFacultad());
		estuTO.setCarrera(estu.getCarrera());
		estuTO.setGratuidad(estu.getGratuidad());

		return estuTO;
	}

	private EstudianteLigeroTO convertirLigero(Estudiante estu) {

		EstudianteLigeroTO estuLigeroTO = new EstudianteLigeroTO();
		estuLigeroTO.setApellido(estu.getAepllido());
		estuLigeroTO.setId(estu.getId());
		estuLigeroTO.setCarrera(estu.getCarrera());
		estuLigeroTO.setGratuidad(estu.getGratuidad());

		return estuLigeroTO;
	}

	@Override
	public EstudianteTO buscarTO(Integer id) {
		// TODO Auto-generated method stub

		return this.convertir(this.estudianteRepository.seleccionar(id));
	}

	@Override
	public EstudianteLigeroTO buscarEstudianteLigeroTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convertirLigero(this.estudianteRepository.seleccionar(id));
	}

}
