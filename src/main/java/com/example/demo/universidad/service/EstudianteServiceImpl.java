package com.example.demo.universidad.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.example.demo.universidad.repository.IEstudianteRepository;
import com.example.demo.universidad.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteServiceImpl implements IEstudianteService {

	private static final Logger LOG = LoggerFactory.getLogger(EstudianteServiceImpl.class);

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void ingresar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		LOG.info("Hilo Service:" + Thread.currentThread().getName());
		// sumar restar multiplicar:logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public String agregar2(Estudiante estudiante) {
		// TODO Auto-generated method stub
		LOG.info("Hilo Service:" + Thread.currentThread().getName());
		// sumar restar multiplicar:logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.estudianteRepository.insertar(estudiante);
		return estudiante.getNumero();
	}

	@Override
	@Async
	public void agregarAsincrono(Estudiante estudiante) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		LOG.info("Hilo Service:" + Thread.currentThread().getName());
		// sumar restar multiplicar:logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.estudianteRepository.insertar(estudiante);
//		return estudiante.getNumero();

	}

	@Override
	@Async
	public CompletableFuture<String> agregarAsincrono2(Estudiante estudiante) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		LOG.info("Hilo Service:" + Thread.currentThread().getName());
		// sumar restar multiplicar:logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.estudianteRepository.insertar(estudiante);
		return CompletableFuture.completedFuture(estudiante.getNumero());

	}

}
