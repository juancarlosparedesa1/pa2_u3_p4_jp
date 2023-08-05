package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.universidad.repository.modelo.Estudiante;
import com.example.demo.universidad.service.IEstudianteService;
import com.example.demo.universidad.service.IMateriaService;
import com.example.demo.universidad.service.IMatriculaService;

@SpringBootApplication
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
		// TODO Auto-generated method stub
		LOG.info("Hilo:" + Thread.currentThread().getName());
		/*
		 * ***************tradicional**************** // inicio long tiempoInicial =
		 * System.currentTimeMillis(); for (int i = 0; i < 30; i++) { Estudiante
		 * estudiante1 = new Estudiante(); estudiante1.setApellido("Paredes");
		 * estudiante1.setNumero(String.valueOf(i));
		 * estudiante1.setCedula("1726000000"); estudiante1.setEdad("27");
		 * estudiante1.setNombre("Juan Carlos");
		 * this.estudianteService.ingresar(estudiante1); } // fin long tiempoFinal =
		 * System.currentTimeMillis(); long tiempoTranscurrido = (tiempoFinal -
		 * tiempoInicial) / 1000; LOG.info("Tiemp transcurrido: " + (tiempoFinal -
		 * tiempoInicial)); LOG.info("Tiemp transcurrido: " + tiempoTranscurrido);
		 */

//		***************multihilo***********
		// inicio
		long tiempoInicial = System.currentTimeMillis();
		List<Estudiante> lista = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Estudiante estudiante1 = new Estudiante();
			estudiante1.setApellido("Paredes");
			estudiante1.setNumero(String.valueOf(i));
			estudiante1.setCedula("1726000000");
			estudiante1.setEdad("27");
			estudiante1.setNombre("Juan Carlos");
			lista.add(estudiante1);
		}

//		lista.stream().forEach(estudiante -> this.estudianteService.ingresar(estudiante));
		Stream<String> listaFinal = lista.parallelStream()
				.map(estudiante -> this.estudianteService.agregar2(estudiante));
		LOG.info("Se guardaron las siguiente cuentas: ");
		listaFinal.forEach(cadena -> LOG.info(cadena));
		// fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiemp transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiemp transcurrido: " + tiempoTranscurrido);

	}
}
