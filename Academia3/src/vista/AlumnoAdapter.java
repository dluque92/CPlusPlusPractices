package vista;

import java.io.Serializable;
import java.util.List;

import modelo.Alumno;


public class AlumnoAdapter implements Serializable{

	private Integer idAlumno;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	private List<Alumno> alumno;
	private List<AlumnoAdapter> aladapter;
	
	public AlumnoAdapter() {
		// TODO Auto-generated constructor stub
	}

	public AlumnoAdapter(Integer idAlumno, String nombre, String apellidos,
			String telefono, String email) {

		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
	}

	
	public AlumnoAdapter(Integer idAlumno, String nombre, String apellidos,
			String telefono, String email, List<Alumno> alumno,
			List<AlumnoAdapter> aladapter) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.alumno = alumno;
		this.aladapter = aladapter;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Alumno> getAlumno() {
		return alumno;
	}

	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}

	public List<AlumnoAdapter> getAladapter() {
		return aladapter;
	}

	public void setAladapter(List<AlumnoAdapter> aladapter) {
		this.aladapter = aladapter;
	}

	
}
