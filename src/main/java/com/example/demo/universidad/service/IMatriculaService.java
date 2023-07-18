package com.example.demo.universidad.service;

import java.util.List;

import com.example.demo.universidad.repository.modelo.Materia;
import com.example.demo.universidad.repository.modelo.Matricula;

public interface IMatriculaService {
	public void ingresar(Matricula matricula);

	public void matricula(String cedula, List<String> codigosMateria);
}
