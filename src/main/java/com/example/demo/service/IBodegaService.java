package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Bodega;
import com.example.demo.repository.modelo.Producto;

public interface IBodegaService {

	public void crear(Bodega bodega);

	public int cambiarUbicacion(String numeroBodega, String nuevaUbicacion);

	// INNER JOIN
	public List<Bodega> buscarInnerJoin();

	// RightJoin
	public List<Bodega> buscarOuterRightJoin();

	// LeftJoin
	public List<Bodega> buscarOuterLeftJoin();

	public List<Producto> buscarProductoOuterLeftJoin();

	// Full JOIN
	public List<Bodega> buscarFulltJoin();

	// JOIN WHERE
	public List<Bodega> buscarWhereJoin();

	// FETCH JOIN
	public List<Bodega> buscarFetchJoin();
}
