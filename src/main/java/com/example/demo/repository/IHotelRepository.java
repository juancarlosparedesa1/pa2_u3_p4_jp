package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	public void insertar(Hotel hotel);

	public Hotel buscar(Integer id);

	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);

//	tipos de joins
//	se utiliza estos nombres de manera didactica
//	en las evaluaciones se utiliza nombres de programacion
	public List<Hotel> seleccionarInnerJoin();
}