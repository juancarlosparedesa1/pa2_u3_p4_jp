package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.banco.Cuenta;
import com.example.demo.modelo.banco.Propietario;
import com.example.demo.modelo.banco.Transferencia;
import com.example.demo.modelo.banco.service.ICuentaService;
import com.example.demo.modelo.banco.service.ITransferenciaService;

@SpringBootApplication
public class Tarea14Application implements CommandLineRunner {

	@Autowired
	private ICuentaService iCuentaBancariaService;

	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Tarea14Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Propietario propietario1 = new Propietario();
		propietario1.setNombre("Juan");
		propietario1.setApellido("Paredes");
		propietario1.setCedula("172600000");
		List<Cuenta> listaCuenta = new ArrayList<>();

		Cuenta cuentaOrigen = new Cuenta();
		cuentaOrigen.setNumero("0001");
		cuentaOrigen.setPropietario(propietario1);
		cuentaOrigen.setSaldo(new BigDecimal(5000));
		cuentaOrigen.setTipo("A");

		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setNumero("0002");
		cuentaDestino.setSaldo(new BigDecimal(1000));
		cuentaDestino.setTipo("C");
		cuentaDestino.setPropietario(propietario1);

		listaCuenta.add(cuentaOrigen);
		listaCuenta.add(cuentaDestino);
		propietario1.setCuentas(listaCuenta);

//		this.iCuentaBancariaService.agregar(cuentaOrigen);
//		this.iCuentaBancariaService.agregar(cuentaDestino);

		this.iTransferenciaService.transferir(1, 2, new BigDecimal(1000));

		List<Transferencia> reporte = this.iTransferenciaService.reporte();
		for (Transferencia transferencia : reporte) {
			System.out.println(transferencia);
		}

	}

}
