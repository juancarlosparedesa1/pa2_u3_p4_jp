package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Bodega;
import com.example.demo.repository.modelo.Producto;

public interface IBodegaService {

	public void crear(Bodega bodega);

	public int cambiarUbicacion(String numeroBodega, String nuevaUbicacion);

	// INNER JOIN
	public List<Bodega> BuscarInnerJoin();

	// RightJoin
	public List<Bodega> BuscarOuterRightJoin();

	// LeftJoin
	public List<Bodega> BuscarOuterLeftJoin();

	public List<Producto> BuscarProductoOuterLeftJoin();

	// Full JOIN
	public List<Bodega> BuscarFulltJoin();

	// JOIN WHERE
	public List<Bodega> BuscarWhereJoin();

}
