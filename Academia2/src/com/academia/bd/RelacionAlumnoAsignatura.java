package com.academia.bd;

public class RelacionAlumnoAsignatura {

	private int idRelacion;
	private int idAlumno;
	private int idAsignatura;

	public int getIdRelacion() {
		return idRelacion;
	}

	public void setIdRelacion(int idRelacion) {
		this.idRelacion = idRelacion;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	@Override
	public String toString() {
		return "RelacionAlumnoAsignatura [idRelacion=" + idRelacion
				+ ", idAlumno=" + idAlumno + ", idAsignatura=" + idAsignatura
				+ "]";
	}

}
