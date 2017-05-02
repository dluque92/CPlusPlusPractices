package com.academia.controller;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.academia.common.Constantes;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.Profesor;
import com.academia.hibernate.ProfesorDAO;

@ManagedBean(name="ProfesorBean")
@SessionScoped
public class ProfesorBean{ 
	private List<com.academia.hibernate.Profesor> prolist;
	private Profesor profesor;
	private Asignatura asignatura;
	private int idAsignaturaSelect;
	
	public void init(){
		ProfesorDAO dao = new ProfesorDAO ();
		prolist = dao.findAll();
		
	}
	public void initVacio(){
		profesor = new Profesor();
		
	}
    public List<com.academia.hibernate.Profesor> getlistaPro() {
        init();
    	return prolist;
    }
    public void addProfesor() {

		//recojo la asignatura seleccionada, la añado al profesor y lo creamos
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		Asignatura asig = new Asignatura();
		asig=daoAsig.findById(idAsignaturaSelect);
		
		profesor.setAsignatura(asig);
		
		ProfesorDAO dao = new ProfesorDAO();
		dao.persist(profesor);

		redireccion("listadoProfesor.jsf");

	}
    
    public void formularioEditar(Profesor pro) {
		System.out.println("entra en formularioEditar");
		System.out.println("recoge: " + pro.getNombre());
		profesor = pro;
		idAsignaturaSelect = profesor.getAsignatura().getIdAsignatura();
		System.out.println("recoge idasig: " + idAsignaturaSelect);

		redireccion("editarProfesor.jsf");
	}
	
	public void EditarBD() {
		System.out.println("entra en EditarBD");
		ProfesorDAO dao = new ProfesorDAO();
		
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		Asignatura asig = new Asignatura();
		asig=daoAsig.findById(idAsignaturaSelect);
		profesor.setAsignatura(asig);
		dao.merge(profesor);

		redireccion("listadoProfesor.jsf");
	}
	public void Borrar(int id) {
		System.out.println("entra en Borrar");
		System.out.println("Id: "+id);
		
		ProfesorDAO daoProf = new ProfesorDAO();
		Profesor pro = daoProf.findById(id);
		
		try {
			
			daoProf.remove(pro);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		redireccion("listadoProfesor.jsf");
	}

	public void redireccion(String jsf) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(Constantes.URLJSF + "/" + jsf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<com.academia.hibernate.Profesor> getProlist() {
		return prolist;
	}
	public void setProlist(List<com.academia.hibernate.Profesor> prolist) {
		this.prolist = prolist;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public int getIdAsignaturaSelect() {
		return idAsignaturaSelect;
	}
	public void setIdAsignaturaSelect(int idAsignaturaSelect) {
		this.idAsignaturaSelect = idAsignaturaSelect;
	}
	public void borrarProfesorSession(){
		profesor = null;
	}

	
}


