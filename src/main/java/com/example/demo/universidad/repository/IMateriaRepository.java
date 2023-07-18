package com.example.demo.universidad.repository;

import java.util.List;

import com.example.demo.universidad.repository.modelo.Materia;

public interface IMateriaRepository {

	public void insertar(Materia materia);

	public List<Materia> SeleccionarPorCodigo(String codigo);

}
