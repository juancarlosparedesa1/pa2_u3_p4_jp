package com.example.demo.universidad.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.universidad.repository.IEstudianteRepository;
import com.example.demo.universidad.repository.IMateriaRepository;
import com.example.demo.universidad.repository.IMatriculaRepository;
import com.example.demo.universidad.repository.modelo.Estudiante;
import com.example.demo.universidad.repository.modelo.Materia;
import com.example.demo.universidad.repository.modelo.Matricula;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository matriculaRepository;
	@Autowired
	private IEstudianteRepository estudianteRepository;
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public void ingresar(Matricula matricula) {
		// TODO Auto-generated method stub

	}

	@Override
	public void matricula(String cedula, List<Materia> codigosMateria) {
		// TODO Auto-generated method stub

		Estudiante estudianteBd = this.estudianteRepository.seleccionarPorCedula(cedula);

		List<Matricula> matriculas = new ArrayList<>();
		for (Materia materia : codigosMateria) {

//			materia.setCodigo(this.materiaRepository.SeleccionarPorCodigo(materia.getCodigo()));

		}
//		Matricula matricula1 = new Matricula();
//		matricula1.setEstudiante(estudianteBd);
//		matricula1.setFecha(LocalDateTime.now());
//		matricula1.setNumero("matr-000 " + estudianteBd.getId());

	}

}
