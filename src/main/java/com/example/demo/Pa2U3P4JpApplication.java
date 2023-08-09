package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.universidad.repository.modelo.Estudiante;
import com.example.demo.universidad.service.IEstudianteService;
import com.example.demo.universidad.service.IMateriaService;
import com.example.demo.universidad.service.IMatriculaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4JpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4JpApplication.class);

	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IMateriaService materiaService;
	@Autowired
	private IMatriculaService matriculaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		asincrono sin respuesta
//		// TODO Auto-generated method stub
//		LOG.info("Hilo:" + Thread.currentThread().getName());
//
//		// inicio
//		long tiempoInicial = System.currentTimeMillis();
//		// creo una lista de estudiantes
//		List<Estudiante> lista = new ArrayList<>();
//
//		for (int i = 0; i < 10; i++) {
//			Estudiante estudiante1 = new Estudiante();
//			estudiante1.setApellido("Paredes");
//			estudiante1.setNumero(String.valueOf(i));
//			estudiante1.setCedula("1726000000");
//			estudiante1.setEdad("27");
//			estudiante1.setNombre("Juan Carlos");
//			lista.add(estudiante1);
//			this.estudianteService.agregarAsincrono(estudiante1);
//		}
//
//////		lista.stream().forEach(estudiante -> this.estudianteService.ingresar(estudiante));
////		List<String> listaFinal = lista.parallelStream().map(estudiante -> this.estudianteService.agregar2(estudiante))
////				.collect(colectors);
////		LOG.info("Se guardaron las siguiente cuentas: ");
////		listaFinal.forEach(cadena -> LOG.info(cadena));
//
//		// fin
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		LOG.info("Tiemp transcurrido: " + (tiempoFinal - tiempoInicial));
//		LOG.info("Tiemp transcurrido: " + tiempoTranscurrido);
//		LOG.info("Se termino de procesar todo.");

//		Asincrono futuro con respuesta
		// TODO Auto-generated method stub
		LOG.info("Hilo:" + Thread.currentThread().getName());

		// inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuestas = new ArrayList<>();
		// creo una lista de estudiantes
		List<Estudiante> lista = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Estudiante estudiante1 = new Estudiante();
			estudiante1.setApellido("Paredes");
			estudiante1.setNumero(String.valueOf(i));
			estudiante1.setCedula("1726000000");
			estudiante1.setEdad("27");
			estudiante1.setNombre("Juan Carlos");
			lista.add(estudiante1);
//			this.estudianteService.agregarAsincrono2(estudiante1);
			CompletableFuture<String> respuesta = this.estudianteService.agregarAsincrono2(estudiante1);
			listaRespuestas.add(respuesta);

		}
//		sentencia que termina que esperen de procesarce todos los hilos para obtener la respuest
		CompletableFuture.allOf(listaRespuestas.get(0), listaRespuestas.get(1), listaRespuestas.get(2),
				listaRespuestas.get(3), listaRespuestas.get(4), listaRespuestas.get(5), listaRespuestas.get(6),
				listaRespuestas.get(7), listaRespuestas.get(8), listaRespuestas.get(9));

		LOG.info("Respuesta 0 " + listaRespuestas.get(0).get());// me retorna un string

////		lista.stream().forEach(estudiante -> this.estudianteService.ingresar(estudiante));
//		List<String> listaFinal = lista.parallelStream().map(estudiante -> this.estudianteService.agregar2(estudiante))
//				.collect(colectors);
//		LOG.info("Se guardaron las siguiente cuentas: ");
//		listaFinal.forEach(cadena -> LOG.info(cadena));

		// fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiemp transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiemp transcurrido: " + tiempoTranscurrido);
		LOG.info("Se termino de procesar todo.");
	}
}
