package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class); // slf4j

	
	public static void metodoSupplier(IPersonaSupplier<String> funcion) {
		LOG.info("HighOrder Supplier "+funcion.getId());
		
	}
	
	public static void metodoConsumer(IPersonaConsumer<String> funcion,String hola) {
		funcion.accept("D y Y HO"+hola);
		
	}
	
	public static void metodoPredicate(IPersonaPredicate<Integer> funcion,Integer numero) {
		
		
		LOG.info(funcion.evaluar(numero)+"HO");
		
	}
	
	public static void metodoFunction(IPersonaFunction<Integer,String> funcion, String cadena) {
		
		LOG.info(funcion.aplicar(cadena)*1000+"HO");
	}
	
	public static void metodoUnaryOperator(IPersonaUnaryOperator<String> funcion,String cadena) {
		LOG.info(funcion.aplicar(cadena));
	}
	
	
}
