package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	private static final Logger LOG = LoggerFactory.getLogger(EstudianteServiceImpl.class);

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void agregar(Estudiante estudiante) {
		int i = 1;
		// TODO Auto-generated method stub
		LOG.info("HILO: " + Thread.currentThread().getName());

		try {
			TimeUnit.SECONDS.sleep(1);
			this.estudianteRepository.insertar(estudiante);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i = 0;
		}

	}

	@Override
	public CompletableFuture<Integer> calcularEdad(LocalDate localDate) {
		Period peridoFecha = Period.between(localDate, localDate.now());
		try {
			TimeUnit.SECONDS.sleep(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(peridoFecha.getYears());

	}

}
