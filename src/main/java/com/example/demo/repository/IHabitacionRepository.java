package com.example.demo.repository;
//package com.example.demo.hotel.repository;

import com.example.demo.repository.modelo.Habitacion;

public interface IHabitacionRepository {
	public void insertar(Habitacion habitacion);

	public Habitacion buscar(Integer id);

	public void actualizar(Habitacion habitacion);

	public void eliminar(Integer id);
}