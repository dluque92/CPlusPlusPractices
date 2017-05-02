package com.academia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.academia.common.Constantes;
import com.academia.common.ValoresTablas;
import com.academia.hibernate.Alumno;
import com.academia.hibernate.AlumnoDAO;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.Profesor;
import com.academia.hibernate.ProfesorDAO;




@ManagedBean(name = "BuscadorBean")
@SessionScoped
public class BuscadorBean {

	private List<ValoresTablas> listaNombreTablas;
	private int indiceTabla;
	private int indiceValorEnTabla;
	private String buscarString;
	private List<Profesor> listaProf;
	private List<Alumno> listaAlu;
	private List<Asignatura> listaAsig;
	
	public void initTablas(){
		listaNombreTablas = new ArrayList<ValoresTablas>();
		listaNombreTablas.add(new ValoresTablas(0,"Profesor"));
		listaNombreTablas.add(new ValoresTablas(1,"Asignatura"));
		listaNombreTablas.add(new ValoresTablas(2,"Alumno"));
		
	}
	
	public List<ValoresTablas> getListaValoresTablas(int tabla) 
    {
        List<ValoresTablas> ListaValores = new ArrayList<ValoresTablas>();

        //Añado a la lista los valores de las tablas de la BD segun valor de tabla
        //0 para profesor, 1 asignatura y 2 alumno
        switch(tabla){
        case 0:
        		if(ListaValores != null && ListaValores.size() > 0)
        			ListaValores.clear();
        		ListaValores.add(new ValoresTablas(0,"Nombre"));
        		ListaValores.add(new ValoresTablas(1,"Apellidos"));
        		ListaValores.add(new ValoresTablas(2,"Telefono"));
        		ListaValores.add(new ValoresTablas(3,"Email"));
        		ListaValores.add(new ValoresTablas(4,"Asignatura"));
        		break;
        case 1:
        		if(ListaValores != null && ListaValores.size() > 0)
        			ListaValores.clear();
	        	ListaValores.add(new ValoresTablas(0,"Nombre"));
	    		ListaValores.add(new ValoresTablas(1,"Horario"));
	    		ListaValores.add(new ValoresTablas(2,"Aula"));
	    		break;
        case 2:
	    		if(ListaValores != null && ListaValores.size() > 0)
	    			ListaValores.clear();
	        	ListaValores.add(new ValoresTablas(0,"Nombre"));
	    		ListaValores.add(new ValoresTablas(1,"Apellidos"));
	    		ListaValores.add(new ValoresTablas(2,"Telefono"));
	    		ListaValores.add(new ValoresTablas(3,"Email"));
	    		break;	
        }
        
        
        //Ahora que tengo la lista llena la devuelvo
        return ListaValores;
    }
	
	public void buscar(){
		if(listaProf != null && listaProf.size() > 0)
			listaProf.clear();
		if(listaAsig != null && listaAsig.size() > 0)
			listaAsig.clear();
		if(listaAlu != null && listaAlu.size() > 0)
			listaAlu.clear();
		
		
		System.out.println("Valor Tabla: "+indiceTabla);
		System.out.println("Valor 2 valoresTabla: "+indiceValorEnTabla);
		System.out.println("buscar: "+buscarString);
		
		switch(indiceTabla){
        case 0: //tabla profesor
        		ProfesorDAO daoProf = new ProfesorDAO();

        		switch(indiceValorEnTabla){
        		case 0: //nombre
        			listaProf = daoProf.findByNombre(buscarString);
        			break;
        		case 1: //apellidos
        			listaProf = daoProf.findByApellidos(buscarString);
        			break;
        		case 2: //telefono
        			listaProf = daoProf.findByTelefono(buscarString);
        			break;
        		case 3: //email
        			listaProf = daoProf.findByEmail(buscarString);
        			break;
        		case 4: //asignatura
        			listaProf = daoProf.findByAsignatura(buscarString);
        			break;
        		}
        		redireccion("resultadoBusquedaProf.jsf");
        		break;
        case 1: //tabla asignatura
        		AsignaturaDAO daoAsig = new AsignaturaDAO();
        		
	        	switch(indiceValorEnTabla){
	    		case 0: //nombre
	    			listaAsig = daoAsig.findByNombre(buscarString);
	    			break;
	    		case 1: //horario
	    			listaAsig = daoAsig.findByHorario(buscarString);
	    			break;
	    		case 2: //aula
	    			listaAsig = daoAsig.findByAula(buscarString);
	    			break;
	    		}
	        	
	        	if(listaAsig != null && listaAsig.size() > 0){
		        	for(int i=0; i < listaAsig.size(); i++){
		        		if(listaAsig.get(i).getIdAsignatura() == 0){
		        			System.out.println("entra if: "+i);
		        			listaAsig.remove(i);
		        		}
		        	}
	        	}
	        	
	        	redireccion("resultadoBusquedaAsig.jsf");
	    		break;
        case 2: //tabla alumno
	        	AlumnoDAO daoAlu = new AlumnoDAO();
	
	    		switch(indiceValorEnTabla){
	    		case 0: //nombre
	    			listaAlu = daoAlu.findByNombre(buscarString);
	    			break;
	    		case 1: //apellidos
	    			listaAlu = daoAlu.findByApellidos(buscarString);
	    			break;
	    		case 2: //telefono
	    			listaAlu = daoAlu.findByTelefono(buscarString);
	    			break;
	    		case 3: //email
	    			listaAlu = daoAlu.findByEmail(buscarString);
	    			break;
	    		}
	    		redireccion("resultadoBusquedaAlu.jsf");
	    		break;	
        }
		
		
	}

	public List<ValoresTablas> getListaNombreTablas() {
		return listaNombreTablas;
	}

	public void setListaNombreTablas(List<ValoresTablas> listaNombreTablas) {
		this.listaNombreTablas = listaNombreTablas;
	}

	public int getIndiceTabla() {
		return indiceTabla;
	}

	public void setIndiceTabla(int indiceTabla) {
		this.indiceTabla = indiceTabla;
	}

	public int getIndiceValorEnTabla() {
		return indiceValorEnTabla;
	}

	public void setIndiceValorEnTabla(int indiceValorEnTabla) {
		this.indiceValorEnTabla = indiceValorEnTabla;
	}

	public String getBuscarString() {
		return buscarString;
	}

	public void setBuscarString(String buscarString) {
		this.buscarString = buscarString;
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

	public List<Profesor> getListaProf() {
		return listaProf;
	}

	public void setListaProf(List<Profesor> listaProf) {
		this.listaProf = listaProf;
	}

	public List<Alumno> getListaAlu() {
		return listaAlu;
	}

	public void setListaAlu(List<Alumno> listaAlu) {
		this.listaAlu = listaAlu;
	}

	public List<Asignatura> getListaAsig() {
		return listaAsig;
	}

	public void setListaAsig(List<Asignatura> listaAsig) {
		this.listaAsig = listaAsig;
	}
	
	

}

