package com.example.demo.universidad.repository;

import com.example.demo.universidad.repository.modelo.Materia;

public interface IMateriaRepository {

	public void insertar(Materia materia);

	public Materia SeleccionarPorCodigo(String codigo);

}
