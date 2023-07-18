package com.example.demo.universidad.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.universidad.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public Materia SeleccionarPorCodigo(String codigo) {
		Query myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo=:datoCodigo");
		myQuery.setParameter("datoCodigo", codigo);
		return (Materia) myQuery.getSingleResult();
	}

}
