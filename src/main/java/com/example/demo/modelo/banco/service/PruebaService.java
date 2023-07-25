package com.example.demo.modelo.banco.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaService implements IPruebaService {

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba");
	}

	@Override
	@Transactional(value = TxType.MANDATORY)

	public void prueba2() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba 2");

	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupprts() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de supports");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2:" + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo Not supported");

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaRequired() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2:" + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo Required");

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2:" + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo requires New");
	}

}
