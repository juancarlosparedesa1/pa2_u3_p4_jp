package com.example.demo.Funcional2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		IPersona persona1 = new PersonaImpl();
//		persona1.caminar();
////		1.SUPPLIER
//		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
//		LOG.info("Supplier clase: " + supplier1.getId());
//
//		// Lambdas
//		IPersonaSupplier<String> supplier2 = () -> "1726890000";
//		LOG.info("Supplier clase: " + supplier2.getId());
//
//		IPersonaSupplier<String> supplier3 = () -> {
//			String cedula = "17268900000";
//			cedula = cedula + "zzzz";
//			return cedula;
//		};
//		LOG.info("Supplier clase: " + supplier3.getId());
//
////		Metodos referenciados
//
//		MetodosReferenciados metodos = new MetodosReferenciados();
//		// creo la interfaz
//		// aqui hago la implementación
//		IPersonaSupplier<Integer> supplier4 = metodos::getId;
//		LOG.info("Supplier Metodo referenciado: " + supplier4.getId());
//
//		// 2.CONSUMER
//		// Clases
//		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
//		LOG.info("Consumer clase: ");
//		consumer1.accept("Juan Carlos");
//
//		// LAMBDAS
//		IPersonaConsumer<String> consumer2 = cadena -> LOG.info(cadena);
//		LOG.info("Consumer Lambda: ");
//		consumer2.accept("Juan Carlos2");
//
//		// Métodos referenciados
//
//		IPersonaConsumer<String> consumer3 = metodos::aceptar;
//		LOG.info("Consumer metodos referenciados: ");
//		consumer3.accept("A");
////		3.PREDICEATE
////		Lambdas
//		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
//		LOG.info("Predicate Lambda: " + predicate1.evaluar(4));
//
//		IPersonaPredicate<Integer> predicate2 = valor -> {
//			Integer valor2 = 10;
//			valor = valor + valor2;
//			if (valor.compareTo(100) > 0) {
//				return true;
//
//			} else {
//				return false;
//			}
//
//		};
//
//		LOG.info("Predicate Lambda2: " + predicate2.evaluar(95));
//
//		// metodos referenciados
//		IPersonaPredicate<Integer> predicate5 = metodos::evaluarMetodoReferenciado;
//		LOG.info("Predicate Metodo referenciado: " + predicate5.evaluar(5));
//
//		// EXPRESIÓN LAMBDA QUE ME PERMITA SABER
////		SI EL NOMBRE QUEMADO TIENEN UN CARACTER
////		IPersonaPredicate<String> predicate3 = character -> {
////
////			if (cadena.contains(cadena)) {
////				return true;
////
////			} else {
////				return false;
////			}
////			LOG.info("Predicate Lambda3: " + predicate3.);
////
////		};
//
//		IPersonaPredicate<String> predicate3 = letra -> "Juan".contains(letra);
//		LOG.info("Predicate Lambda3: " + predicate3.evaluar("j"));
//
////		El nombre como la letra sean parametros(Bi-Predicate)
//
//		IPersonaBiPredicate<String, String> predicate4 = (letra, cadena) -> cadena.contains(letra);
//		LOG.info("Predicate Lambda4: " + predicate4.evaluar("j", "juan"));
//
////		4.Function
////		T retorno R recibe
//		IPersonaFunction<String, Integer> function = numero -> numero.toString();
//		LOG.info("Function Lambda: " + function.aplicar(8));
//
//		IPersonaFunction<String, Integer> function1 = numero -> {
//			String valorFinal = numero.toString().concat("valor");
//			return valorFinal;
//
//		};
//		LOG.info("Function Lambda 1: " + function.aplicar(10));
//
//		// 5.UnaryOperator
//		IPersonaUnaryOperator<Integer> unary1 = numero -> numero + (numero * 2);
//		LOG.info("Unary Lambda1 : " + unary1.aplicar(3));
//		IPersonaUnaryOperatorFunction<Integer> unary2 = numero -> numero + (numero * 2);
//		LOG.info("Unary Lambda2 : " + unary2.aplicar(3));

//		metodos high order
		MetodosHighOrder highOrder = new MetodosHighOrder();
//		
//		supplier
//		1.clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		highOrder.metodo(supplierHO);
//		2.lambdas
		highOrder.metodo(() -> "172600000");
//		3.Metodos referenciados
		highOrder.metodo(MetodosReferenciados::getIdHO);

//		consumer
		// Consumer
		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "Clase Consumer");
		MetodosHighOrder.metodoConsumer(cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		}, "Lambdas Consumer");
//		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar,"MetodosReferenciados Consumer");
//		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar, "Metodos referenciados");

//		MetodosHighOrder.metodoConsumer("", null);

		/*
		 * Interfaces funcionales java
		 */
//		1.supplier
		// me genera un arreglo de tipo stream con estos valores
		Stream<String> lista = Stream.generate(() -> "172600000").limit(10);
		lista.forEach(cadena -> LOG.info(cadena));
//		LOG.info("Prueba: " + lista);

//		2.Consmer
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		listaNumeros.forEach(cadena -> {
			LOG.info("Prueba2:" + cadena);
		});// metodo highorder

//		3.Predicate
//		filtre los numeros mayores a 5
//		filtra los tru
		Stream<Integer> listaFinal = listaNumeros.stream().filter(numero -> numero >= 5);
		listaFinal.forEach(numero -> LOG.info("Valor: " + numero));
//		4.function
		Stream<String> listaCambidad = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return "N:" + num;
		});
		listaCambidad.forEach(cadena -> LOG.info(cadena));

//		5.unaryoperatos
		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return num;
		});
		listaCambidad.forEach(cadena -> LOG.info(cadena.toString()));
	}

	
}
