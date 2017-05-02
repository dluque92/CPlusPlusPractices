package com.academia.hibernate;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Alumno generated by hbm2java
 */
@Entity
@Table(name = "alumno", catalog = "academia_bd")
public class Alumno implements java.io.Serializable {

	private Integer idAlumno;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private Set<RelAlumnoAsignatura> relAlumnoAsignaturas = new HashSet<RelAlumnoAsignatura>(
			0);

	public Alumno() {
	}

	public Alumno(String nombre, String apellidos, String telefono, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
	}

	public Alumno(String nombre, String apellidos, String telefono,
			String email, Set<RelAlumnoAsignatura> relAlumnoAsignaturas) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.relAlumnoAsignaturas = relAlumnoAsignaturas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idALUMNO", unique = true, nullable = false)
	public Integer getIdAlumno() {
		return this.idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "APELLIDOS", nullable = false, length = 100)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "TELEFONO", nullable = false, length = 10)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "EMAIL", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "alumno")
	public Set<RelAlumnoAsignatura> getRelAlumnoAsignaturas() {
		return this.relAlumnoAsignaturas;
	}

	public void setRelAlumnoAsignaturas(
			Set<RelAlumnoAsignatura> relAlumnoAsignaturas) {
		this.relAlumnoAsignaturas = relAlumnoAsignaturas;
	}

}
