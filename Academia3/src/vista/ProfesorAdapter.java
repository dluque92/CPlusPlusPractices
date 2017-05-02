package vista;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import modelo.Asignatura;


public class ProfesorAdapter implements Serializable{
	
	private Integer idProfesor;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private Integer seleccionado;
	private List<Asignatura> listAsignatura;

	public ProfesorAdapter() {
	}
	public ProfesorAdapter(String nombre, String apellidos,
			String telefono, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
	}
	
	public ProfesorAdapter(Integer idProfesor, String nombre,
			int seleccionado, List<Asignatura> listAsignatura) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.seleccionado = seleccionado;
		this.listAsignatura = listAsignatura;
	}
	
	public ProfesorAdapter(String nombre, String apellidos,
			String telefono, String email,Integer seleccionado) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.seleccionado = seleccionado;
	}
	
	public ProfesorAdapter(Integer idProfesor, String nombre, String apellidos,
			String telefono, String email, Integer seleccionado) {
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.seleccionado = seleccionado;
	}

	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Integer seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public List<Asignatura> getListAsignatura() {
		return listAsignatura;
	}
	public void setListAsignatura(List<Asignatura> listAsignatura) {
		this.listAsignatura = listAsignatura;
	}

}
