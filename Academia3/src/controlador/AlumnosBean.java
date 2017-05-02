package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import common.Constantes;
import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.Asignatura;
import modelo.AsignaturaDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;
import modelo.RelAlumnoAsignatura;
import modelo.RelAlumnoAsignaturaDAO;
import vista.AlumnoAdapter;
import vista.BusquedaAdapter;
import vista.LoginAdapter;
import vista.ProfesorAdapter;

@ManagedBean(name = "alumnosBean")
@ViewScoped
public class AlumnosBean implements Serializable {

	private AlumnoAdapter alumnoAdapter = new AlumnoAdapter();
	private BusquedaAdapter busquedaAdapter = new BusquedaAdapter();

	private ArrayList<AlumnoAdapter> listAlumnos = null;
	private List<Alumno> alumno = new ArrayList<Alumno>();
	public Alumno alumnoSeleccionado = new Alumno();
	private String idAlumnoSeleccionado;

	// CONSTRUCTOR
	public AlumnosBean(AlumnoAdapter alumnoAdapter,
			BusquedaAdapter busquedaAdapter,
			ArrayList<AlumnoAdapter> listAlumnos, List<Alumno> alumno,
			Alumno alumnoSeleccionado) {
		super();
		this.alumnoAdapter = alumnoAdapter;
		this.busquedaAdapter = busquedaAdapter;
		this.listAlumnos = listAlumnos;
		this.alumno = alumno;
		this.alumnoSeleccionado = alumnoSeleccionado;
	}

	public AlumnosBean() {
		super();
	}

	public void init() {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			alumnoAdapter = new AlumnoAdapter();
			// System.out.println("-------aasasas------------------");
		
			 UsuariosBean b= new UsuariosBean();
			 LoginAdapter l = b.existeSesion();
			 
			 if(l == null){ 
				 String url = Constantes.URL_BASE_APP; fc.getExternalContext().redirect(url);		 
			 }	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AlumnoAdapter getAlumnoAdapter() {
		return alumnoAdapter;
	}

	public String getIdAlumnoSeleccionado() {
		return idAlumnoSeleccionado;
	}

	public void setIdAlumnoSeleccionado(String idAlumnoSeleccionado) {
		this.idAlumnoSeleccionado = idAlumnoSeleccionado;
	}

	public void setAlumnoAdapter(AlumnoAdapter alumnoAdapter) {
		this.alumnoAdapter = alumnoAdapter;
	}

	public BusquedaAdapter getBusquedaAdapter() {
		return busquedaAdapter;
	}

	public void setBusquedaAdapter(BusquedaAdapter busquedaAdapter) {
		this.busquedaAdapter = busquedaAdapter;
	}

	public ArrayList<AlumnoAdapter> getListAlumnos() {
		return listAlumnos;
	}

	public void setListAlumnos(ArrayList<AlumnoAdapter> listAlumnos) {
		this.listAlumnos = listAlumnos;
	}

	public List<Alumno> getAlumno() {
		return alumno;
	}

	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}

	public Alumno getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}

	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
		this.alumnoSeleccionado = alumnoSeleccionado;
	}

	// METODO PARA OBTENER ALUMNO(PRUEBA)
	private void obtenerAlumno(int id) {
		try {
			AlumnoDAO dao = new AlumnoDAO();
			Alumno al = dao.findById(id);

			System.out.println("************DATOS ALUMNO************");
			System.out.println(al.getNombre() + ", " + al.getApellidos());
			System.out.println("**************************************");
			System.out.println("************DATOS ASIGNATURA************");

			Set<RelAlumnoAsignatura> a = al.getRelAlumnoAsignaturas();
			Iterator<RelAlumnoAsignatura> i = a.iterator();

			while (i.hasNext()) {
				RelAlumnoAsignatura rel = i.next();
				Asignatura as = rel.getAsignatura();
				System.out.println(as.getNombre() + ", " + as.getAula());

			}
			System.out.println("**************************************");
		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Listado NO válido. A fallado al listar Alumnos.");
			System.out.println("--------------------->");
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Listado NO válido. A fallado al listar Alumnos."));
		}
	}

	// METODO PARA OBTENER ALUMNO(CREADO POR JOSE Y ANTONIO)
	public List<AlumnoAdapter> obtenerAlumno() {

		listAlumnos = new ArrayList<AlumnoAdapter>();
		AlumnoDAO dao = new AlumnoDAO();
		Alumno al = new Alumno();
		Iterator<Alumno> iterador;
		int n = 0;

		switch (busquedaAdapter.getSeleccionado()) {
		case 1:
			String abuscar = busquedaAdapter.getTexto();
			if(abuscar.equals("")){
				alumno = dao.findAll();
				iterador = alumno.iterator();
				n = 0;
				while (iterador.hasNext()) {
					alumnoAdapter = new AlumnoAdapter(alumno.get(n).getIdAlumno(),
							alumno.get(n).getNombre(),
							alumno.get(n).getApellidos(), alumno.get(n)
									.getTelefono(), alumno.get(n).getEmail());
					listAlumnos.add(alumnoAdapter);
					n++;
					iterador.next();
				}
				return listAlumnos;
			}else{
				Integer id = Integer.parseInt(abuscar);
				try{					
					al = dao.findById(id);
					alumnoAdapter = new AlumnoAdapter(al.getIdAlumno(), al.getNombre(),
							al.getApellidos(), al.getTelefono(), al.getEmail());
					listAlumnos.add(alumnoAdapter);
				}catch (Exception ex) {
					System.out.println("-------> Id de alumno inexistente");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error", "Id de alumno inexistente"));
				}
				return listAlumnos;
			}
		case 2:
			String nombre = busquedaAdapter.getTexto();
			alumno = dao.findByNombre(nombre);
			iterador = alumno.iterator();
			n = 0;
			while (iterador.hasNext()) {
				alumnoAdapter = new AlumnoAdapter(alumno.get(n).getIdAlumno(),
						alumno.get(n).getNombre(),
						alumno.get(n).getApellidos(), alumno.get(n)
								.getTelefono(), alumno.get(n).getEmail());
				listAlumnos.add(alumnoAdapter);
				n++;
				iterador.next();
			}
			return listAlumnos;

		case 3:
			String apellidos = busquedaAdapter.getTexto();
			alumno = dao.findByApellidos(apellidos);
			iterador = alumno.iterator();
			n = 0;
			while (iterador.hasNext()) {
				alumnoAdapter = new AlumnoAdapter(alumno.get(n).getIdAlumno(),
						alumno.get(n).getNombre(),
						alumno.get(n).getApellidos(), alumno.get(n)
								.getTelefono(), alumno.get(n).getEmail());
				listAlumnos.add(alumnoAdapter);
				n++;
				iterador.next();
			}
			return listAlumnos;
		case 4:
			String telefono = busquedaAdapter.getTexto();
			alumno = dao.findByTelefono(telefono);
			iterador = alumno.iterator();
			n = 0;
			while (iterador.hasNext()) {
				alumnoAdapter = new AlumnoAdapter(alumno.get(n).getIdAlumno(),
						alumno.get(n).getNombre(),
						alumno.get(n).getApellidos(), alumno.get(n)
								.getTelefono(), alumno.get(n).getEmail());
				listAlumnos.add(alumnoAdapter);
				n++;
				iterador.next();
			}
			return listAlumnos;
		case 5:
			String email = busquedaAdapter.getTexto();
			alumno = dao.findByEmail(email);
			iterador = alumno.iterator();
			n = 0;
			while (iterador.hasNext()) {
				alumnoAdapter = new AlumnoAdapter(alumno.get(n).getIdAlumno(),
						alumno.get(n).getNombre(),
						alumno.get(n).getApellidos(), alumno.get(n)
								.getTelefono(), alumno.get(n).getEmail());
				listAlumnos.add(alumnoAdapter);
				n++;
				iterador.next();
			}
			return listAlumnos;
		default:
			alumno = dao.findAll();
			iterador = alumno.iterator();
			n = 0;
			while (iterador.hasNext()) {
				alumnoAdapter = new AlumnoAdapter(alumno.get(n).getIdAlumno(),
						alumno.get(n).getNombre(),
						alumno.get(n).getApellidos(), alumno.get(n)
								.getTelefono(), alumno.get(n).getEmail());
				listAlumnos.add(alumnoAdapter);
				n++;
				iterador.next();
			}
			return listAlumnos;
		}
	}

	// METODO PARA INSERTAR ALUMNO(RAFA)
	public void insertarAlumno() {
		System.out.println("--------------------->");
		Alumno a = new Alumno();
		a.setNombre(alumnoAdapter.getNombre());
		a.setApellidos(alumnoAdapter.getApellidos());
		a.setEmail(alumnoAdapter.getEmail());
		a.setTelefono(alumnoAdapter.getTelefono());
		AlumnoDAO dao = new AlumnoDAO();
		dao.persist(a);

		String url = Constantes.URL_BASE_APP + "jsf/listarAlumnos.jsf";
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			fc.getExternalContext().redirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("Añadir NO válido. A fallado al añadir el Alumno.");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Añadir NO válido. A fallado al añadir el Alumno."));
		}
	}

	// METODO PARA MODIFICAR ALUMNO(JOSE)
	public void modificar(AlumnoAdapter alumno) {
		try {
			// AlumnoDAO para hacer el merge y Alumno para enviarselo como
			// parametro al merge
			AlumnoDAO dao = new AlumnoDAO();
			Alumno al = new Alumno();

			System.out.println("id alumno: " + alumno.getIdAlumno());

			// Profesor a eliminar, con todos los campos
			al = new Alumno(alumno.getIdAlumno(), alumno.getNombre(),
					alumno.getApellidos(), alumno.getTelefono(),
					alumno.getEmail());
			// System.out.println("Profesor Editado: " + al.getIdAlumno() +
			// " Nombre: " + al.getNombre());
			dao.merge(al);

		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Modificar NO válido. A fallado al modificar el Alumno.");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Modificar NO válido. A fallado al modificar el Alumno."));

		}
	}

	// METODO PARA ELIMINAR ALUMNO(JOSE)
	public void eliminar() {
		// System.out.println("--------------------->");
		AlumnoDAO dao = new AlumnoDAO();
		// System.out.println(Integer.valueOf(idAlumnoSeleccionado));
		// System.out.println("--------Aqui elimino------------>");
		dao.remove(dao.findById(Integer.valueOf(idAlumnoSeleccionado)));
		obtenerAlumno();
		// System.out.println("---------Ya he eliminado----------->");

	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Alumno Editado",
				String.valueOf(((AlumnoAdapter) event.getObject())
						.getIdAlumno()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			AlumnoAdapter alumno = new AlumnoAdapter();
			alumno.setIdAlumno(((AlumnoAdapter) event.getObject())
					.getIdAlumno());
			alumno.setNombre(((AlumnoAdapter) event.getObject()).getNombre());
			alumno.setApellidos(((AlumnoAdapter) event.getObject())
					.getApellidos());
			alumno.setTelefono(((AlumnoAdapter) event.getObject())
					.getTelefono());
			alumno.setEmail(((AlumnoAdapter) event.getObject()).getEmail());

			modificar(alumno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Modificar NO válido. A fallado al modificar el Alumno.");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Modificar NO válido. A fallado al modificar el Alumno."));

		}
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Editar cancelado",
				String.valueOf(((AlumnoAdapter) event.getObject())
						.getIdAlumno()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
