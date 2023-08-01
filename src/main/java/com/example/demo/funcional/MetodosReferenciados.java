package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

//	supplier
	// tengo un metodo que esta cumpliendo el
//	contrato
	public Integer getId() {
		return 8;
	}

	public void aceptar(String arg) {
		String cadena = "juan carlos";
		LOG.info(cadena + "" + arg);
	}

	public boolean evaluarMetodoReferenciado(Integer arg) {
		if (arg > 0) {
			return true;
		}
		return false;
	}

}
