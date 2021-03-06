package modelo;
// default package
// Generated 23-jul-2014 19:46:11 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelAlumnoAsignatura generated by hbm2java
 */
@Entity
@Table(name = "rel_alumno_asignatura", catalog = "academia_bd")
public class RelAlumnoAsignatura implements java.io.Serializable {

	private Integer idRelacion;
	private Asignatura asignatura;
	private Alumno alumno;

	public RelAlumnoAsignatura() {
	}

	public RelAlumnoAsignatura(Asignatura asignatura, Alumno alumno) {
		this.asignatura = asignatura;
		this.alumno = alumno;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRELACION", unique = true, nullable = false)
	public Integer getIdRelacion() {
		return this.idRelacion;
	}

	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idASIGNATURA", nullable = false)
	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idALUMNO", nullable = false)
	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}
