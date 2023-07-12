package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface IHotelService {

	public List<Hotel> seleccionarInnerJoin();

	// RIGHT JOIN
	public List<Hotel> buscarOuterRightJoin();

	// left join
	public List<Hotel> buscarOuterLeftJoin();

	// left join habitaciones
	public List<Habitacion> buscarHabitacionOuterLeftJoin();

	// full join
	public List<Hotel> buscarFullOuterJoin();

	// where join
	public List<Hotel> buscarWhereJoin();
}
