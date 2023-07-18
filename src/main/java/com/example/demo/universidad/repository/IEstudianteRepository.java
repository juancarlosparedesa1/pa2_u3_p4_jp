package com.example.demo.universidad.repository;

import com.example.demo.universidad.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	// crud
	public void insertar(Estudiante estudiante);

	public Estudiante seleccionarPorCedula(String cedula);

}
