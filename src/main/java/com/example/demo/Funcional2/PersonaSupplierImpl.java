package com.example.demo.Funcional2;

public class PersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "17268900000";
		cedula = cedula + "zzzz";
		return cedula;
	}
//T puede ser un objeto creado o que ya exista en java
}
