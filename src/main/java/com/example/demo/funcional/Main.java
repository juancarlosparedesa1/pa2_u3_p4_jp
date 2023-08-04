package com.example.demo.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // slf4j

	public static void main(String[] args) {

		// *****************************Metodos High Order*****************************
		LOG.info("*****************************Metodos High Order*****************************");
		// Supplier
		LOG.info("Supplier");
		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		MetodosHighOrder.metodoSupplier(supplierHO);

		// 2. Lambda

		MetodosHighOrder.metodoSupplier(() -> "17268900000--HO");

		// 3. metodos referenciados
		LOG.info("Metodo referenciado>>");
		MetodosHighOrder.metodoSupplier(MetodosReferenciados::getIdHO);

		// Consumer
		LOG.info("Consumer");
		// 1. Clase
		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "test2");

		// 2. Lambda
		MetodosHighOrder.metodoConsumer((str) -> LOG.info("lambda " + str), "test3");

		// 3. metodos referenciados
		LOG.info("Metodo referenciado>>");
		MetodosHighOrder.metodoConsumer(MetodosReferenciados::acceptar, "test4");

		// Predicate
		LOG.info("Predicate");
		// 1.- Clase
		MetodosHighOrder.metodoPredicate(new PersonaPredicateImpl(), 23);

		// 2.- Lambda
		MetodosHighOrder.metodoPredicate((numero) -> {
			LOG.info("Lambda HO");
			return numero.compareTo(0) >= 0;
		}, -8);
		LOG.info("Metodo referenciado>>");
		// 3.- Metodos referenciados
		MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, -7);

		// Function
		LOG.info("Function");
		// 1.- Clase
		MetodosHighOrder.metodoFunction(new PersonaFunctionImpl(), "12345");

		// 2.- Lambda
		MetodosHighOrder.metodoFunction((arg) -> Integer.valueOf(arg) * 1000, "56789");
		LOG.info("Metodo referenciado>>");
		// 3.- Metodos referenciados
		MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicar, "00000");

		// Unary operator
		LOG.info("Unary operator");
		// 1.- Clase
		MetodosHighOrder.metodoUnaryOperator(new PersonaUnaryOperatorImpl(), "main HO UO");

		// 2.- Lambda
		MetodosHighOrder.metodoUnaryOperator((cadena) -> cadena + "Lambda HO", "Juna Carlos main UO");
		LOG.info("Metodo referenciado>>");
		// 3.- Metodos referenciados
		MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::aplicarStrStr, "unaryO");

		
	}

}
