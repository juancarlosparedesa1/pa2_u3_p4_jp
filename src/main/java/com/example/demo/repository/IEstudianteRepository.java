package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	public void insertar(Estudiante estudiante);

	public Estudiante seleccionarPorId(Integer id);

	public void actualizar(Estudiante estudiante);
}
