package modelo;
// default package
// Generated 23-jul-2014 19:46:11 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Profesor generated by hbm2java
 */
@Entity
@Table(name = "profesor", catalog = "academia_bd", uniqueConstraints = @UniqueConstraint(columnNames = "idASIGNATURA"))
public class Profesor implements java.io.Serializable {

	private Integer idProfesor;
	private Asignatura asignatura;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Profesor() {
	}


	public Profesor(Asignatura asignatura, String nombre, String apellidos,
			String telefono, String email) {
		this.asignatura = asignatura;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Profesor(Asignatura asignatura, String nombre, String apellidos,
			String telefono, String email, Integer idProfesor) {
		this.asignatura = asignatura;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.idProfesor = idProfesor;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPROFESOR", unique = true, nullable = false)
	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idASIGNATURA", unique = true, nullable = false)
	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
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
	

}
