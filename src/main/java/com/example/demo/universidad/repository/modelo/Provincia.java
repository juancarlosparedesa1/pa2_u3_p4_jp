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
@Table(name = "provincia")
public class Provincia {
	// no visto por el usuario
	@Id
	@GeneratedValue(generator = "seq_provincia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1)
	@Column(name = "prov_id")
	private Integer id;

	@Column(name = "prov_nombre")
	private String nombre;
	@Column(name = "prov_region")
	private String region;
	@Column(name = "prov_num_habi")
	private String numeroHabitantes;
	@Column(name = "prov_codigo")
	private String codigoProvincia;

//	relacion(padre)-estudiante
	@OneToMany(mappedBy = "provincia")
	private List<Estudiante> estudiantes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(String numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
