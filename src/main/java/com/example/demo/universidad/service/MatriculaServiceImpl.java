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
	public void matricula(String cedula, List<String> codigosMateria) {
		// TODO Auto-generated method stub

		Estudiante estudianteBd = this.estudianteRepository.seleccionarPorCedula(cedula);

//		List<Matricula> matriculas = new ArrayList<>();
		for (String codigoLista : codigosMateria) {
			List<Materia> materiaBd = this.materiaRepository.SeleccionarPorCodigo(codigoLista);
			for (Materia materiaLista : materiaBd) {
				Matricula matricula = new Matricula();
				matricula.setEstudiante(estudianteBd);
				matricula.setFecha(LocalDateTime.now());
				matricula.setMateria(materiaLista);
				matricula.setPeriodo("ACM-1");
				matricula.setSede("Quito");
				matricula.setNumero("M-000" + estudianteBd.getId());
				this.matriculaRepository.insertar(matricula);

			}

		}
	}

}
