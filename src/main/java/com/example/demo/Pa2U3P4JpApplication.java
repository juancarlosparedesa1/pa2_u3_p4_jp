package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4JpApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		List<Hotel> listaHotel3 = this.hotelService.buscarOuterRightJoin();

		for (Hotel hotel : listaHotel3) {
			if (hotel == null) {
				System.out.println("No Existe aun hotel");
			} else {
				System.out.println(hotel.getNombre());

			}
			// cambio
		}
		List<Hotel> listaHotel2 = this.hotelService.buscarOuterLeftJoin();

		for (Hotel hotel : listaHotel2) {
			if (hotel == null) {
				System.out.println("No Existe aun hotel");
			} else {
				System.out.println(hotel.getNombre());

			}
			// cambio
		}
		List<Hotel> listaHotel = this.hotelService.buscarFullOuterJoin();

		for (Hotel hotel : listaHotel) {
			if (hotel == null) {
				System.out.println("No Existe aun hotel");
			} else {
				System.out.println(hotel.getNombre());

			}
			// cambio
		}

		List<Hotel> listaHotel1 = this.hotelService.buscarWhereJoin();

		for (Hotel hotel : listaHotel1) {
			if (hotel == null) {
				System.out.println("No Existe aun hotel");
			} else {
				System.out.println(hotel.getNombre());

			}
			// cambio
		}

		List<Habitacion> listaHotel4 = this.hotelService.buscarHabitacionOuterLeftJoin();

		for (Habitacion hotel : listaHotel4) {

			System.out.println(hotel);

			// cambio
		}

	}
}
