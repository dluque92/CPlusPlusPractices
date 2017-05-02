package es.ejemplo.java;

public class AlumnoInstituto extends Alumno {

	private String horario;

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + this.getNombre() + ", apellidos="
				+ this.getApellidos() + ", edad=" + this.getEdad()
				+ ", horario=" + horario + "]";
	}

}
