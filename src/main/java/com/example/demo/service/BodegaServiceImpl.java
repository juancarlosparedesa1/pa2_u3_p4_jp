package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IBodegaRepository;
import com.example.demo.repository.modelo.Bodega;
import com.example.demo.repository.modelo.Producto;

@Service
public class BodegaServiceImpl implements IBodegaService {

	@Autowired
	private IBodegaRepository bodegaRepository;

	@Override
	public void crear(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaRepository.insetar(bodega);
	}

	@Override
	public int cambiarUbicacion(String numeroBodega, String nuevaUbicacion) {
		// TODO Auto-generated method stub
		System.out.println("Se actualizara la ubicacion de la bodega");
		System.out.println("Actualizando la ubicacion de la bodega.....");
		System.out.println("ubicacion actualizada!!");
		return this.bodegaRepository.actualizarUbicacion(numeroBodega, nuevaUbicacion);
	}

	@Override
	public List<Bodega> BuscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.bodegaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Bodega> BuscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.bodegaRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Bodega> BuscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.bodegaRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Producto> BuscarProductoOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.bodegaRepository.seleccionarProductoOuterLeftJoin();
	}

	@Override
	public List<Bodega> BuscarFulltJoin() {
		// TODO Auto-generated method stub
		return this.bodegaRepository.seleccionarFulltJoin();
	}

	@Override
	public List<Bodega> BuscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.bodegaRepository.seleccionarWhereJoin();
	}

}