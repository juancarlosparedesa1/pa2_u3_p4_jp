package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Bodega;
import com.example.demo.repository.modelo.Producto;

public interface IBodegaRepository {

	public void insetar(Bodega bodega);

	public int actualizarUbicacion(String numeroBodega, String nuevaUbicacion);

	// INNER JOIN
	public List<Bodega> seleccionarInnerJoin();

	// RightJoin
	public List<Bodega> seleccionarOuterRightJoin();

	// LeftJoin
	public List<Bodega> seleccionarOuterLeftJoin();

	public List<Producto> seleccionarProductoOuterLeftJoin();

	// Full JOIN
	public List<Bodega> seleccionarFulltJoin();

	// JOIN WHERE
	public List<Bodega> seleccionarWhereJoin();
}
