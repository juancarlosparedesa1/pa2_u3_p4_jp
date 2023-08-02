//package com.example.demo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.example.demo.universidad.repository.modelo.Estudiante;
//import com.example.demo.universidad.repository.modelo.Materia;
//import com.example.demo.universidad.repository.modelo.Provincia;
//import com.example.demo.universidad.repository.modelo.Semestre;
//import com.example.demo.universidad.service.IEstudianteService;
//import com.example.demo.universidad.service.IMateriaService;
//import com.example.demo.universidad.service.IMatriculaService;
//
//@SpringBootApplication
//public class Pa2U3P4JpApplication implements CommandLineRunner {
//
//	@Autowired
//	private IEstudianteService estudianteService;
//	@Autowired
//	private IMateriaService materiaService;
//	@Autowired
//	private IMatriculaService matriculaService;
//
//	public static void main(String[] args) {
//		SpringApplication.run(Pa2U3P4JpApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
////		1.ingreso de estudiante y materias, provincia y semestre
//		Provincia provincia1 = new Provincia();
//		provincia1.setCodigoProvincia("17");
//		provincia1.setNombre("Pichincha");
//		provincia1.setNumeroHabitantes("3500000");
//		provincia1.setRegion("Sierra");
//
//		Estudiante estudiante1 = new Estudiante();
//		estudiante1.setApellido("Paredes");
//		estudiante1.setCedula("1726000000");
//		estudiante1.setEdad("27");
//		estudiante1.setNombre("Juan Carlos");
//		estudiante1.setProvincia(provincia1);
//
//		Semestre semestre1 = new Semestre();
//		semestre1.setAreaEducacion("Ciencias Aplicadas");
//		semestre1.setCarrera("Ingenieria en Computacion");
//		semestre1.setNumero("septimo");
//		semestre1.setPromocion("2023-2023");
//
//		Materia materia1 = new Materia();
//		materia1.setCodigo("0001");
//		materia1.setNombre("Programacion Avanzada I");
//		materia1.setNumeroCreditos("10");
//		materia1.setSemestre(semestre1);
//
////		Materia materia2 = new Materia();
////		materia2.setCodigo("0001");
////		materia2.setNombre("Programacion Avanzada II");
////		materia2.setNumeroCreditos("20");
////		materia2.setSemestre(semestre1);
////
////		Materia materia3 = new Materia();
////		materia3.setCodigo("0003");
////		materia3.setNombre("Programacion Avanzada III");
////		materia3.setNumeroCreditos("30");
////		materia3.setSemestre(semestre1);
//
////		ingreso estudiantes y materias a la base de datos
//		this.estudianteService.ingresar(estudiante1);
//		this.materiaService.ingresar(materia1);
////		this.materiaService.ingresar(materia2);
////		this.materiaService.ingresar(materia3);
//
//		// creo una lista de materias
//		List<Materia> listaMaterias = new ArrayList<>();
////		añado las materias a la lista
//		listaMaterias.add(materia1);
////		listaMaterias.add(materia2);
////		listaMaterias.add(materia3);
//
//		// Creo una lista de codigos de materias
//		List<String> codigosMateria = new ArrayList<>();
//
////		recorro la lista de materias y obtengo los codigos y los
////		añado a la lista de codigosMateria
//		for (Materia materiaLista : listaMaterias) {
//			codigosMateria.add(materiaLista.getCodigo());
//		}
//
////		realizo la matricula
//		this.matriculaService.matricula(estudiante1.getCedula(), codigosMateria);
//
//	}
//}
