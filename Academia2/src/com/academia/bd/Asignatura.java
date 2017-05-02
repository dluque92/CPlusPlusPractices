package com.academia.bd;

public class Asignatura {

	private int idAsignatura;
	private String nombre;
	private String horario;
	private String aula;

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "Asignatura [idAsignatura=" + idAsignatura + ", nombre="
				+ nombre + ", horario=" + horario + ", aula=" + aula + "]";
	}

}
