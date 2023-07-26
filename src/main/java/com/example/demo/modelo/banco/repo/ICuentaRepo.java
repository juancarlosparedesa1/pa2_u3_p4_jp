package com.example.demo.modelo.banco.repo;

import com.example.demo.modelo.banco.Cuenta;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

public interface ICuentaRepo {

//	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(Cuenta cuentaBancaria);

	public Cuenta seleccionarPorId(Integer id);

//	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Cuenta cuentaBancaria);
}
