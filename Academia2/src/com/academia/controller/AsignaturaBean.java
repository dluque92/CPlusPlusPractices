package com.academia.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.academia.common.Constantes;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.Profesor;
import com.academia.hibernate.ProfesorDAO;
import com.academia.hibernate.RelAlumnoAsignatura;
import com.academia.hibernate.RelAlumnoAsignaturaDAO;



@ManagedBean(name = "AsignaturaBean")
@SessionScoped
//@ViewScoped -> Si queremos usar Flash Scope debemos usar viewscoped
public class AsignaturaBean {

	private Asignatura asignatura;
	private List<Asignatura> listaAsignatura;
	private Integer idAsignaturaSeleccionada;

	public void init() {
		findAllAsignaturas();
	}

	public void initVacio() {
		asignatura = new Asignatura();
	}

	// Funcion que devuelve la lista de asignaturas
	public List<Asignatura> findAllAsignaturas() {
		// Obtenemos el listado de asignaturas usando Hibernate
		AsignaturaDAO dao = new AsignaturaDAO();
		listaAsignatura = dao.findAll();
		listaAsignatura.remove(0);

		return listaAsignatura;
	}

	// metodo que recoge los datos a editar y lo redirige al formulario de
	// editar
	public void formularioEditar(Asignatura asig) {
		System.out.println("entra en formularioEditar");
		System.out.println("recoge: " + asig.getNombre());
		asignatura = asig;
		
		//pruebaRedirect(); -> Prueba para usar flash Scoped

		redireccion("editarAsignatura.jsf");
	}

	// metodo que recoge los datos del formulario y añade la asignatura
	// a la base de datos
	public void EditarBD() {
		System.out.println("entra en EditarBD");
		AsignaturaDAO dao = new AsignaturaDAO();
		dao.merge(asignatura);

		redireccion("listadoAsignatura.jsf");
	}

	// metodo para añadir en la BD
	public void persist() {
		AsignaturaDAO dao = new AsignaturaDAO();
		dao.persist(asignatura);

		redireccion("listadoAsignatura.jsf");
	}

	// Método para borrar la asignatura:
	public void Borrar(int id) {
		System.out.println("entra en Borrar");
		System.out.println("recoge: " + id);
		// Borrar la asignatura y quitarla de profesores...etc

		AsignaturaDAO daoAsig = new AsignaturaDAO();
		Asignatura asig = daoAsig.findById(id);
		try {
			System.out.println("llega0");
			Set<RelAlumnoAsignatura> relaciones = asig
					.getRelAlumnoAsignaturas();
			System.out.println("llega1");
			if (relaciones != null) {
				Iterator it = relaciones.iterator();
				RelAlumnoAsignaturaDAO relDAO = new RelAlumnoAsignaturaDAO();
				while (it.hasNext()) {
					com.academia.hibernate.RelAlumnoAsignatura relacion = (com.academia.hibernate.RelAlumnoAsignatura) it
							.next();
					relDAO.remove(relacion);
				}
			}
			System.out.println("llega2");

			Set<Profesor> profesores = asig.getProfesors();
			if (profesores != null && profesores.size() > 0) {
				Asignatura AsignaturaNinguna = daoAsig.findById(0);
				ProfesorDAO daoProf = new ProfesorDAO();
				// primero recojo los datos de la asig ninguna
				Iterator it = profesores.iterator();
				while (it.hasNext()) {
					Profesor prof = (Profesor) it.next();
					prof.setAsignatura(AsignaturaNinguna);
					daoProf.merge(prof);

				}
			}
			
			System.out.println("llega4");
			// Ahora lo que queda es borrar la asignatura que queriamos borrar

			daoAsig.remove(asig);

			redireccion("listadoAsignatura.jsf");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// metodo para redirigir
	public void redireccion(String jsf) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(Constantes.URLJSF + "/" + jsf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Integer getIdAsignaturaSeleccionada() {
		return idAsignaturaSeleccionada;
	}

	public void setIdAsignaturaSeleccionada(Integer idAsignaturaSeleccionada) {
		this.idAsignaturaSeleccionada = idAsignaturaSeleccionada;
	}

	public List<Asignatura> getListaAsignatura() {
		return listaAsignatura;
	}

	public void setListaAsignatura(List<Asignatura> listaAsignatura) {
		this.listaAsignatura = listaAsignatura;
	}
	public void borrarAsignaturaSession(){
		asignatura = null;
	}
	
	
	/*
	 * PRUEBA FLASH SCOPED
	 */
	
	public void pruebaRedirect (){

		//USANDO FLASH SCOPED PARRA REDIRIGIR
		try {
			JSFUtils.flashScope().put("AsignaturaBean", this);	
			String jsf = "editarAsignatura.jsf?faces-redirect=true";
			
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(Constantes.URLJSF + "/" + jsf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
