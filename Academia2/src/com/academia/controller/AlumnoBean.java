package com.academia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import com.academia.common.Constantes;
import com.academia.hibernate.Alumno;
import com.academia.hibernate.AlumnoDAO;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.RelAlumnoAsignatura;
import com.academia.hibernate.RelAlumnoAsignaturaDAO;

@ManagedBean(name = "alumnoBean")
@SessionScoped
public class AlumnoBean implements Serializable {
	// Atributos
	private Alumno alumno = new Alumno();
	private List<Alumno> alulist;
	private DualListModel<Asignatura> asignaturas;
	private List<Asignatura> asignaturasTarget;
	private List<Asignatura> borrasignaturas;

	private Asignatura asignatura = new Asignatura();

	// Metodos
	public List<Asignatura> getBorrasignaturas() {
		return borrasignaturas;
	}

	public void setBorrasignaturas(List<Asignatura> borrasignaturas) {
		this.borrasignaturas = borrasignaturas;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public List<Alumno> getAlulist() {
		return alulist;
	}

	public void setAlulist(List<Alumno> alulist) {
		this.alulist = alulist;
	}

	public void init() {
		getlistaAlu();
	}

	public List<Alumno> getlistaAlu() {
		System.out.println("entra en getlistaalu");
		AlumnoDAO dao = new AlumnoDAO();
		alulist = dao.findAll();
		System.out.println("entra en getlistaalu");
		return alulist;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	// METODO PARA REDIRIGIR
	public void redireccion(String jsf) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(Constantes.URLJSF + "/" + jsf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METODO PARA AÑADIR ALUMNO
	public void addAlumno() {
		// COMPRUEBA EL VALOR DE TODOS LOS PARAMETROS OBTENIDOS DEL ALUMNO
		System.out.println("Entra en addAlumno");
		System.out.println(alumno.getNombre());
		System.out.println(alumno.getApellidos());
		System.out.println(alumno.getTelefono());
		System.out.println(alumno.getEmail());
		System.out.println(asignaturas.getTarget().size());
		// GUARDA LA LISTA DE ASIGNATURAS SELECCIONADA
		List<Asignatura> asig;

		asig = asignaturas.getTarget();

		// INSTANCIA METODO DAO
		AlumnoDAO dao = new AlumnoDAO();
		// GUARDA AL ALUMNO EN BD
		try {
			dao.persist(alumno);

			RelAlumnoAsignaturaDAO relDAO = null;
			System.out.println("crea relDAO");
			AsignaturaDAO asigDAO = null;
			System.out.println("crea asigDAO");
			for (int i = 0; i < asig.size(); i++) {
				System.out.println("Entra en  el for");
				asigDAO = new AsignaturaDAO();

				Asignatura a = asigDAO.findById(asig.get(i).getIdAsignatura());
				RelAlumnoAsignatura rel = new RelAlumnoAsignatura();
				rel.setAsignatura(a);
				rel.setAlumno(alumno);
				relDAO = new RelAlumnoAsignaturaDAO();
				// INSERTAMOS RELACIÓN ENTRE ALUMNO Y ASIGNATURA
				relDAO.persist(rel);
				System.out.println(rel.getAlumno());
				System.out.println(rel.getAsignatura());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		redireccion("listadoAlumno.jsf");

	}

	// Método para borrar el alumno:
	public void Borrar(int id) {
		AlumnoDAO aluDAO = new AlumnoDAO();
		Alumno alu = aluDAO.findById(id);
		try {
			System.out.println("llega0");
			Set<RelAlumnoAsignatura> relaciones = alu.getRelAlumnoAsignaturas();
			System.out.println("llega1");
			if (relaciones != null) {
				Iterator<RelAlumnoAsignatura> it = relaciones.iterator();
				RelAlumnoAsignaturaDAO relDAO = new RelAlumnoAsignaturaDAO();
				while (it.hasNext()) {
					com.academia.hibernate.RelAlumnoAsignatura relacion = (com.academia.hibernate.RelAlumnoAsignatura) it
							.next();
					relDAO.remove(relacion);

				}

			}
			aluDAO.remove(alu);
			redireccion("listadoAlumno.jsf");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// metodo que recoge los datos a editar y lo redirige al formulario de
	// editar
	public void formularioEditar(Alumno alu) {
		System.out.println("entra en formularioEditar");
		System.out.println("recoge: " + alu.getNombre());
		alumno = alu;

		List<RelAlumnoAsignatura> listaRelacion = null;
		RelAlumnoAsignaturaDAO rel = new RelAlumnoAsignaturaDAO();
		
		int id = alu.getIdAlumno();
		listaRelacion = rel.listIdAlumno(id);
		if (listaRelacion != null) {
			asignaturasTarget = new ArrayList<Asignatura>();
			
			AsignaturaDAO asigDAO = new AsignaturaDAO();
			borrasignaturas = new ArrayList<Asignatura>();
			borrasignaturas = asigDAO.findAll();
			
			//Lista temporal donde meto las asignaturas
			List<Asignatura> listaTemp = new ArrayList<Asignatura>();
			
			//Borramos la asignatura con id = 0 que equivale a Ninguna
			if(borrasignaturas != null && borrasignaturas.size() > 0){
				int uno;
				for(int i=0; i < borrasignaturas.size(); i++){
					uno = borrasignaturas.get(i).getIdAsignatura();
					if(uno != 0){
						//meto todas las asignaturas menos la que su id vale 0
						listaTemp.add(borrasignaturas.get(i));
					}
				}
					
			}
			//copio la lista temporal
			borrasignaturas.clear();
			borrasignaturas = listaTemp;
			
			//para cada asignatura en la relación de alumno asignatura,
			//la copio en target y la borro de source
			for (int i = 0; i < listaRelacion.size(); i++) {

				asignaturasTarget.add(listaRelacion.get(i).getAsignatura());
				
				if(borrasignaturas!=null && borrasignaturas.size() > 0){
					int encontrado=-1;
					int dos = listaRelacion.get(i).getAsignatura().getIdAsignatura();
					for(int j=0; j < borrasignaturas.size(); j++){
						int uno=borrasignaturas.get(j).getIdAsignatura();
						
						if(uno == dos){		
							encontrado=j;
						}
					}
					if(encontrado != -1){
						borrasignaturas.remove(encontrado);
					}
				}
			}
			
			//llenamos la variable que muestra el picklist
			asignaturas.setSource(borrasignaturas);
			asignaturas.setTarget(asignaturasTarget);
		}
		
		redireccion("editarAlumno.jsf");
	}

	// metodo que recoge los datos del formulario y añade la asignatura
	// a la base de datos
	public void EditarBD() {
		System.out.println("entra en EditarBD");
		AlumnoDAO dao = new AlumnoDAO();

		dao.merge(alumno);
		
		RelAlumnoAsignatura rel = new RelAlumnoAsignatura();
		List <RelAlumnoAsignatura> listaRel = new ArrayList <RelAlumnoAsignatura>();
		RelAlumnoAsignaturaDAO relDAO = new RelAlumnoAsignaturaDAO();
		listaRel = relDAO.listIdAlumno(alumno.getIdAlumno());
		//borramos la relacion
		for(int i=0; i < listaRel.size(); i++){
			relDAO.remove(listaRel.get(i));
		}
		
	
		
		//creamos la relación nueva
		for(int i=0; i < asignaturas.getTarget().size(); i++){
			rel.setAlumno(alumno);
			rel.setAsignatura(asignaturas.getTarget().get(i));

			relDAO.persist(rel);
			rel = new RelAlumnoAsignatura();
		}
		

		redireccion("listadoAlumno.jsf");
	}

	// MANEJO DEL
	// PICKLIST-----------------------------------------------------------------
	@PostConstruct
	public void initPicklist() {
		// Cities
		
		List<Asignatura> asignaturasSource = new ArrayList<Asignatura>();
		List<Asignatura> asignaturasSource2 = new ArrayList<Asignatura>();
		List<Asignatura> asignaturasTarget = new ArrayList<Asignatura>();

		AsignaturaDAO dao = new AsignaturaDAO();

		asignaturasSource = dao.findAll();
		//Borramos la asignatura con id = 0 que equivale a Ninguna
		if(asignaturasSource != null && asignaturasSource.size() > 0){
			int uno;
			for(int i=0; i < asignaturasSource.size(); i++){
				uno = asignaturasSource.get(i).getIdAsignatura();
				if(uno != 0){
					asignaturasSource2.add(asignaturasSource.get(i));
				}
			}
				
		}
		
		if(borrasignaturas == null)
			asignaturas = new DualListModel<Asignatura>(asignaturasSource2,
					asignaturasTarget);
		

	}

	public List<Asignatura> getAsignaturasTarget() {
		return asignaturasTarget;
	}

	public void setAsignaturasTarget(List<Asignatura> asignaturasTarget) {
		this.asignaturasTarget = asignaturasTarget;
	}

	public DualListModel<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(DualListModel<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public void onTransfer(TransferEvent event) {

		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary("Items Transferred");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void borrarAlumnoSession(){
		alumno = new Alumno();
		borrasignaturas = null;
		asignaturasTarget = null;
		initPicklist();
	}
}
