package com.example.demo.repository;
//package com.example.demo.hotel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
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
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion> myQuery = this.entityManager
				.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha", Habitacion.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionaruterFulltJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// TODO Auto-generated method stub
		// select h.* from hotel h, habitacion ha where h.hotl_id=ha.habi_id_hotel
//		jpql
//		select h(solo datos de hotel)
//		WHERE QUE ESTAMOS COMPARANDO LA PK CON LA FK
//		CUANDO  HABLAMOS DE LA PK ESTAMOS HABLANDO DE OBJETOS CON UNA RELACION 1 A 1
//		h tengo el objeto hotel y si quiero comparar con habitacion ha
//		WHERE h(representa el hotel en objetos.
//		SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel
//		h.hotl_id=ha.habi_id_hotel

		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel", Hotel.class);
		return myQuery.getResultList();
	}

}
