package es.ejemplo.java;
public class Alumno {

	private String nombre;
	private String apellidos;
	private int edad;

	public Alumno() {
		super();
	}

	public Alumno(String nombre, String apellidos, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", edad=" + edad + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;

		if (obj != null) {

			if (obj instanceof Alumno) {

				Alumno al = (Alumno) obj;

				if (this.getNombre().equals(al.getNombre())
						&& this.getApellidos().equals(al.getApellidos())
						&& (this.getEdad() == al.getEdad())) {
					ok = true;
				}

			}

		}

		return ok;

	}

}
