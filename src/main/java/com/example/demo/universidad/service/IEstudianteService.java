package com.example.demo.universidad.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.universidad.repository.modelo.Estudiante;

public interface IEstudianteService {

	// crud
	public void ingresar(Estudiante estudiante);

	public Estudiante buscarPorCedula(String cedula);

	public String agregar2(Estudiante estudiante);

	public void agregarAsincrono(Estudiante estudiante);

	public CompletableFuture<String> agregarAsincrono2(Estudiante estudiante);

}
