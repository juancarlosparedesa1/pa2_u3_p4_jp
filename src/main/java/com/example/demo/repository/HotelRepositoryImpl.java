package com.example.demo.repository;
//package com.example.demo.hotel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hot = this.buscar(id);
		this.entityManager.remove(hot);
	}

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// sql
		// select * from hotel h inner join habitacion ha on h.hotl_id=ha.habi_id_hotel
//		jpql
//		SELECT h(alias) FROM Hotel(clase) h(alias) JOIN Habitacion(clase) relacion que hace referencia a las habitaciones h.habitaciones ha
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

}
