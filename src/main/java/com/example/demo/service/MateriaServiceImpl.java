package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public List<MateriaTO> buscarPorIdEstudinate(Integer id) {
		// TODO Auto-generated method stub

		List<Materia> lista = this.iMateriaRepository.seleccionarPorIdEstudinate(id);

		List<MateriaTO> listaFinal = new ArrayList<>();

		for (Materia mat : lista) {

			listaFinal.add(this.convertir(mat));
		}

		return listaFinal;
	}

	private MateriaTO convertir(Materia materia) {
		MateriaTO mat = new MateriaTO();

		mat.setCreditos(materia.getCreditos());
		mat.setNombre(materia.getNombre());
		mat.setId(materia.getId());

		return mat;
	}

}
