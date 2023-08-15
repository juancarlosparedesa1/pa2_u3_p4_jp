package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class Tarea18Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Tarea18Application.class);

	@Autowired
	private IEstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Tarea18Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<Integer>> edades = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			int year = ((int) (Math.random() * 100)) + 1923; // genera edades entre 1923 yS 2022
			int month = ((int) (Math.random() * 12)) + 1;
			int day = ((int) (Math.random() * 28)) + 1;

			LocalDate birthDate = LocalDate.of(year, month, day);
			edades.add(estudianteService.calcularEdad(birthDate));
		}

		CompletableFuture<Void> allFutures = CompletableFuture.allOf(edades.toArray(new CompletableFuture[0]));
		allFutures.join(); // Wait for all futures to complete

		float suma = 0;
		for (CompletableFuture<Integer> completableFuture : edades) {
			LOG.info("EDAD: " + completableFuture.get());
			suma += completableFuture.get();
		}

		float promedio = suma / edades.size();
		LOG.info("El promedio de las 10 edades es: " + promedio);

		long tiempoFinal = System.currentTimeMillis();
		LOG.info("Tiempo transcurido (ms): " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurido (s): " + (tiempoFinal - tiempoInicial) / 1000);

	}
}
