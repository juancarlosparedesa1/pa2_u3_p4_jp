package com.example.demo.universidad.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "semestre")
public class Semestre {
	// no visto por el usuario
	@Id
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Column(name = "smst_id")
	private Integer id;
	@Column(name = "smst_numero")
	private String numero;
	@Column(name = "smst_carrera")
	private String carrera;
	@Column(name = "smst_area_educacion")
	private String areaEducacion;
	@Column(name = "smst_promocion")
	private String promocion;

//	relacion(padre)-materia
	@OneToMany(mappedBy = "semestre")
	private List<Materia> materias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getAreaEducacion() {
		return areaEducacion;
	}

	public void setAreaEducacion(String areaEducacion) {
		this.areaEducacion = areaEducacion;
	}

	public String getPromocion() {
		return promocion;
	}

	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

}
