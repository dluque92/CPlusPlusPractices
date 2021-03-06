package com.academia.hibernate;

// default package
// Generated 05-ago-2014 19:58:23 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Asignatura generated by hbm2java
 */
@Entity
@Table(name = "asignatura", catalog = "academia_bd")
public class Asignatura implements java.io.Serializable {

	private Integer idAsignatura;
	private String nombre;
	private String horario;
	private String aula;
	private Set<Profesor> profesors = new HashSet<Profesor>(0);
	private Set<RelAlumnoAsignatura> relAlumnoAsignaturas = new HashSet<RelAlumnoAsignatura>(
			0);

	public Asignatura() {
	}

	public Asignatura(String nombre, String horario, String aula) {
		this.nombre = nombre;
		this.horario = horario;
		this.aula = aula;
	}

	public Asignatura(String nombre, String horario, String aula,
			Set<Profesor> profesors,
			Set<RelAlumnoAsignatura> relAlumnoAsignaturas) {
		this.nombre = nombre;
		this.horario = horario;
		this.aula = aula;
		this.profesors = profesors;
		this.relAlumnoAsignaturas = relAlumnoAsignaturas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idASIGNATURA", unique = true, nullable = false)
	public Integer getIdAsignatura() {
		return this.idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "HORARIO", nullable = false, length = 45)
	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Column(name = "AULA", nullable = false, length = 20)
	public String getAula() {
		return this.aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "asignatura")
	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "asignatura")
	public Set<RelAlumnoAsignatura> getRelAlumnoAsignaturas() {
		return this.relAlumnoAsignaturas;
	}

	public void setRelAlumnoAsignaturas(
			Set<RelAlumnoAsignatura> relAlumnoAsignaturas) {
		this.relAlumnoAsignaturas = relAlumnoAsignaturas;
	}

}
