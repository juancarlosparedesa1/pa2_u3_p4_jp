package com.example.demo.Funcional2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public void metodo(IPersonaSupplier<String> funcion) {

		LOG.info("Metodos high Order" + funcion.getId());

	}

//	public static void metodoConsumer(IPersonaConsumer<String> funcion, String valor) {
//		funcion.accept(valor);
//	}

	public static void metodoConsumer(IPersonaConsumer<String> funcion, String cadena) {
		// TODO Auto-generated method stub
		funcion.accept(cadena);
	}
}
