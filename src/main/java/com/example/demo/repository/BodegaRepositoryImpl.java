package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Bodega;
import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BodegaRepositoryImpl implements IBodegaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insetar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bodega);

	}

	@Override
	public int actualizarUbicacion(String numeroBodega, String nuevaUbicacion) {
		Query query = entityManager
				.createQuery("UPDATE Bodega b SET b.ubicacion = :nuevaUbicacion WHERE b.numero = :numeroBodega");
		query.setParameter("nuevaUbicacion", nuevaUbicacion);
		query.setParameter("numeroBodega", numeroBodega);

		return query.executeUpdate();
	}

	@Override
	public List<Bodega> seleccionarInnerJoin() {
		// select * from hotel h join habitacion ha on h.hote_id=ha.habitacion_id_hotel
		// hago referencia a donde tengo mi habitación
		// SELECT h from Hotel h JOIN h.habitaciones ha
		TypedQuery<Bodega> query = this.entityManager.createQuery("SELECT b from Bodega b INNER JOIN b.productos pd ",
				Bodega.class);
		return query.getResultList();
	}

	@Override
	public List<Bodega> seleccionarOuterRightJoin() {
		TypedQuery<Bodega> query = this.entityManager.createQuery("SELECT b from Bodega b RIGHT JOIN b.productos pd ",
				Bodega.class);
		return query.getResultList();
	}

	@Override
	public List<Bodega> seleccionarOuterLeftJoin() {
		TypedQuery<Bodega> query = this.entityManager.createQuery("SELECT b from Bodega b LEFT JOIN b.productos pd ",
				Bodega.class);
		return query.getResultList();
	}

	@Override
	public List<Producto> seleccionarProductoOuterLeftJoin() {
		TypedQuery<Producto> query = this.entityManager.createQuery("SELECT p from Producto p LEFT JOIN p.bodega b ",
				Producto.class);
		return query.getResultList();
	}

	@Override
	public List<Bodega> seleccionarFulltJoin() {
		TypedQuery<Bodega> query = this.entityManager
				.createQuery("SELECT b from Bodega b FULL OUTER JOIN b.productos pd ", Bodega.class);
		return query.getResultList();
	}

	@Override
	public List<Bodega> seleccionarWhereJoin() {
		// TODO Auto-generated method stub
		// SELECT b.* FROM bodega b, producto p WHERE b._id= pdct_id_bodega
		// SELECT b FROM Bodega b, Producto p WHERE b=p.bodega
		TypedQuery<Bodega> query = this.entityManager.createQuery("SELECT b FROM Bodega b, Producto p WHERE b=p.bodega",
				Bodega.class);
		return query.getResultList();
	}

}
