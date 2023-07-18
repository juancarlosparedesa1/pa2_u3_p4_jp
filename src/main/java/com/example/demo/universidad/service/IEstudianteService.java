package com.example.demo.universidad.service;

import com.example.demo.universidad.repository.modelo.Estudiante;

public interface IEstudianteService {

	// crud
	public void ingresar(Estudiante estudiante);

	public Estudiante buscarPorCedula(String cedula);


}
