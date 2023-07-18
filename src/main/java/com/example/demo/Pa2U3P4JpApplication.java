package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.universidad.repository.modelo.Estudiante;
import com.example.demo.universidad.repository.modelo.Materia;
import com.example.demo.universidad.service.IEstudianteService;
import com.example.demo.universidad.service.IMateriaService;

@SpringBootApplication
public class Pa2U3P4JpApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IMateriaService materiaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante estudiante1 = new Estudiante();
		estudiante1.setApellido("Paredes");
		estudiante1.setCedula("1726000000");
		estudiante1.setEdad("27");
		estudiante1.setNombre("Juan Carlos");

//		List<Materia> listaMaterias = new ArrayList<>();

		Materia materia1 = new Materia();
		materia1.setCodigo("0001");
		materia1.setNombre("Programacion Avanzada I");
		materia1.setNumeroCreditos("10");

		Materia materia2 = new Materia();
		materia2.setCodigo("0001");
		materia2.setNombre("Programacion Avanzada II");
		materia2.setNumeroCreditos("20");

		Materia materia3 = new Materia();
		materia3.setCodigo("0003");
		materia3.setNombre("Programacion Avanzada III");
		materia3.setNumeroCreditos("30");
//
//		listaMaterias.add(materia1);
//		listaMaterias.add(materia2);
//		listaMaterias.add(materia3);

		this.estudianteService.ingresar(estudiante1);
		this.materiaService.ingresar(materia1);
		this.materiaService.ingresar(materia2);
		this.materiaService.ingresar(materia3);

	}
}
