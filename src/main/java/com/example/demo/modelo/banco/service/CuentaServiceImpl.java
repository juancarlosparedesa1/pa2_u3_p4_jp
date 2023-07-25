package com.example.demo.modelo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.repo.ICuentaRepo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaRepo cuentaRepo;

	@Autowired
	private IPruebaService pruebaService;

	@Override
//	@Transactional
//	@Transactional(value=TxType.REQUIRED)
	public void agregar(Cuenta cuentaBancaria) {
		// TODO Auto-generated method stub
		System.out.println("servce:" + TransactionSynchronizationManager.isActualTransactionActive());
//		this.cuentaRepo.insertar(cuentaBancaria);
//		this.prueba();
//		this.pruebaService.prueba();
//		this.pruebaService.prueba2();
//		this.pruebaService.pruebaSupprts();
//		this.pruebaService.pruebaNotSupported();
//		this.pruebaService.pruebaRequired();
		this.pruebaService.pruebaRequiresNew();
	}

	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba");

	}

	@Override
	public Cuenta encontrarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.seleccionarPorId(id);
	}

	@Override
	public void modificar(Cuenta cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepo.actualizar(cuentaBancaria);
	}

}
