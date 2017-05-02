package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.sun.java.swing.plaf.windows.resources.windows;

import common.Constantes;
import modelo.Alumno;
import modelo.Profesor;
import modelo.AlumnoDAO;
import modelo.Asignatura;
import modelo.AsignaturaDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;
import vista.AsignaturaAdapter;
import vista.LoginAdapter;
import vista.ProfesorAdapter;
import vista.BusquedaAdapter;

@ManagedBean(name = "profesoresBean")
@ViewScoped
public class ProfesoresBean implements Serializable {

	private ProfesorAdapter profesorAdapter = new ProfesorAdapter();
	private ProfesorAdapter proadapter = new ProfesorAdapter();
	private BusquedaAdapter busquedaAdapter = new BusquedaAdapter();
	private ArrayList<ProfesorAdapter> listProfesores = null;

	private List<Profesor> profesores = new ArrayList<Profesor>();
	public Profesor profesorSeleccionado = new Profesor();

	private String idProfesorSeleccionado;

	public String getIdProfesorSeleccionado() {
		return idProfesorSeleccionado;
	}

	public void setIdAsignaturaSeleccionada(String idProfesorSeleccionado) {
		this.idProfesorSeleccionado = idProfesorSeleccionado;
	}

	// CONSTRUCTOR
	private String selecionado;
	private Map<Asignatura, String> asignaturaSele = new HashMap<Asignatura, String>();

	// CONSTRUCTOR
	public ProfesoresBean(ProfesorAdapter profesorAdapter,
			BusquedaAdapter busquedaAdapter,
			ArrayList<ProfesorAdapter> listProfesores,
			List<Profesor> profesores, Profesor profesorSeleccionado) {
		super();
		this.profesorAdapter = profesorAdapter;
		this.busquedaAdapter = busquedaAdapter;
		this.listProfesores = listProfesores;
		this.profesores = profesores;
		this.profesorSeleccionado = profesorSeleccionado;
	}

	public ProfesoresBean() {

	}

	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		profesorAdapter = new ProfesorAdapter();
		// System.out.println("-------aasasas------------------");
	
		 UsuariosBean b= new UsuariosBean();
		 LoginAdapter l = b.existeSesion();
		 
		 if(l == null){ 
			 String url = Constantes.URL_BASE_APP; 
			 try {
				fc.getExternalContext().redirect(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
		 }
		AsignaturaDAO asig = new AsignaturaDAO();
		Asignatura a = new Asignatura();

		/*
		 * Integer n= asig.count2();
		 * 
		 * asignaturaSele = new HashMap<Asignatura, String>(); for(Integer r =
		 * 1; r<n+1 ; r++){ a = asig.findById(r); asignaturaSele.put(a,
		 * r.toString()); }
		 */
	}

	public String getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}

	public Map<Asignatura, String> getAsignaturaSele() {
		return asignaturaSele;
	}

	public void setAsignaturaSele(Map<Asignatura, String> asignaturaSele) {
		this.asignaturaSele = asignaturaSele;
	}

	public ProfesorAdapter getProfesorAdapter() {
		return profesorAdapter;
	}

	public void setProfesorAdapter(ProfesorAdapter profesorAdapter) {
		this.profesorAdapter = profesorAdapter;
	}

	public BusquedaAdapter getBusquedaAdapter() {
		return busquedaAdapter;
	}

	public void setBusquedaAdapter(BusquedaAdapter busquedaAdapter) {
		this.busquedaAdapter = busquedaAdapter;
	}

	public ArrayList<ProfesorAdapter> getListProfesores() {
		return listProfesores;
	}

	public void setListProfesores(ArrayList<ProfesorAdapter> listProfesores) {
		this.listProfesores = listProfesores;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Profesor getProfesorSeleccionado() {
		return profesorSeleccionado;
	}

	public void setProfesorSeleccionado(Profesor profesorSeleccionado) {
		this.profesorSeleccionado = profesorSeleccionado;
	}

	// METODO PARA OBTENER PROFESOR(PRUEBA)
	private void obtenerProfesor(int id) {
		try {
			ProfesorDAO dao = new ProfesorDAO();
			Profesor p = dao.findById(1);

			Asignatura a = p.getAsignatura();

			System.out.println("************DATOS PROFESOR************");
			System.out.println(p.getNombre() + ", " + p.getApellidos());
			System.out.println("**************************************");
			System.out.println("************DATOS ASIGNATURA************");
			System.out.println(a.getNombre() + ", " + a.getHorario());
			System.out.println("**************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METODO PARA OBTENER ALUMNO(CREADO POR JOSE Y ANTONIO)
	public List<ProfesorAdapter> obtenerProfesor() {
		ProfesorDAO dao = new ProfesorDAO();
		Profesor profe = new Profesor();

		listProfesores = new ArrayList<>();
		Iterator<Profesor> iter;
		int n = 0;

		switch (busquedaAdapter.getSeleccionado()) {
		case 1:
			String abuscar = busquedaAdapter.getTexto();
			if(abuscar.equals("")){
				profesores = dao.findAll();
				iter = profesores.iterator();
				n = 0;
				while (iter.hasNext()) {
					proadapter = new ProfesorAdapter(profesores.get(n)
							.getIdProfesor(), profesores.get(n).getNombre(),
							profesores.get(n).getApellidos(), profesores.get(n)
									.getTelefono(), profesores.get(n).getEmail(),
							profesores.get(n).getAsignatura().getIdAsignatura());
					listProfesores.add(proadapter);
					n++;
					iter.next();
				}
				return listProfesores;
			}else{
				Integer id = Integer.parseInt(abuscar);
				try{
					profe = dao.findById(id);
					proadapter = new ProfesorAdapter(profe.getIdProfesor(),
							profe.getNombre(), profe.getApellidos(),
							profe.getTelefono(), profe.getEmail(), profe
									.getAsignatura().getIdAsignatura());
				listProfesores.add(proadapter);
				}catch (Exception ex) {
					System.out.println("-------> Id de profesor inexistente");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error", "Id de profesor inexistente"));
				}
				return listProfesores;	
			}
		case 2:
			System.out.println("Nombre");
			String nombre = busquedaAdapter.getTexto();
			profesores = dao.findByNombre(nombre);
			iter = profesores.iterator();
			n = 0;
			while (iter.hasNext()) {
				proadapter = new ProfesorAdapter(profesores.get(n)
						.getIdProfesor(), profesores.get(n).getNombre(),
						profesores.get(n).getApellidos(), profesores.get(n)
								.getTelefono(), profesores.get(n).getEmail(),
						profesores.get(n).getAsignatura().getIdAsignatura());
				listProfesores.add(proadapter);
				n++;
				iter.next();
			}
			return listProfesores;
		case 3:
			System.out.println("Apellido");
			String apellido = busquedaAdapter.getTexto();
			profesores = dao.findByApellidos(apellido);
			iter = profesores.iterator();
			n = 0;
			while (iter.hasNext()) {
				proadapter = new ProfesorAdapter(profesores.get(n)
						.getIdProfesor(), profesores.get(n).getNombre(),
						profesores.get(n).getApellidos(), profesores.get(n)
								.getTelefono(), profesores.get(n).getEmail(),
						profesores.get(n).getAsignatura().getIdAsignatura());
				listProfesores.add(proadapter);
				n++;
				iter.next();
			}
			return listProfesores;
		case 4:
			System.out.println("Telefono");
			String telefono = busquedaAdapter.getTexto();
			profesores = dao.findByTelefono(telefono);
			iter = profesores.listIterator();
			n = 0;
			while (iter.hasNext()) {
				proadapter = new ProfesorAdapter(profesores.get(n)
						.getIdProfesor(), profesores.get(n).getNombre(),
						profesores.get(n).getApellidos(), profesores.get(n)
								.getTelefono(), profesores.get(n).getEmail(),
						profesores.get(n).getAsignatura().getIdAsignatura());
				listProfesores.add(proadapter);
				n++;
				iter.next();
			}
			return listProfesores;
		case 5:
			System.out.println("Email");
			String email = busquedaAdapter.getTexto();
			profesores = dao.findByEmail(email);
			iter = profesores.iterator();
			n = 0;
			while (iter.hasNext()) {
				proadapter = new ProfesorAdapter(profesores.get(n)
						.getIdProfesor(), profesores.get(n).getNombre(),
						profesores.get(n).getApellidos(), profesores.get(n)
								.getTelefono(), profesores.get(n).getEmail(),
						profesores.get(n).getAsignatura().getIdAsignatura());
				listProfesores.add(proadapter);
				n++;
				iter.next();
			}
			return listProfesores;
		default:
			System.out.println("Busqueda de todos");
			profesores = dao.findAll();
			iter = profesores.iterator();
			n = 0;
			while (iter.hasNext()) {
				proadapter = new ProfesorAdapter(profesores.get(n)
						.getIdProfesor(), profesores.get(n).getNombre(),
						profesores.get(n).getApellidos(), profesores.get(n)
								.getTelefono(), profesores.get(n).getEmail(),
						profesores.get(n).getAsignatura().getIdAsignatura());
				listProfesores.add(proadapter);
				n++;
				iter.next();
			}
			return listProfesores;
		}
	}

	// METODO PARA INSERTAR PROFESOR(SONIA)
	public void insertarProfesor() {
		FacesContext msg = FacesContext.getCurrentInstance();
		System.out.println("--------------------->");
		Profesor p = new Profesor();
		p.setNombre(profesorAdapter.getNombre());
		p.setApellidos(profesorAdapter.getApellidos());
		p.setTelefono(profesorAdapter.getTelefono());
		p.setEmail(profesorAdapter.getEmail());

		System.out.println("Nombre profesor: " + p.getNombre());
		System.out.println("Apellidos profesor: " + p.getApellidos());
		System.out.println("Telefono profesor: " + p.getTelefono());
		System.out.println("Email profesor: " + p.getEmail());

		// consultamos y nos traemos la asignatura completa
		AsignaturaDAO aDao = new AsignaturaDAO();
		Asignatura a = new Asignatura();
		System.out.println(profesorAdapter.getSeleccionado());
		a = aDao.findById(profesorAdapter.getSeleccionado());
		p.setAsignatura(a);

		System.out.println("Nombre asignatura: " + a.getNombre());
		System.out.println("Id asignatura: "
				+ p.getAsignatura().getIdAsignatura() + " "
				+ p.getAsignatura().getNombre());
			ProfesorDAO dao = new ProfesorDAO();
			try {
				dao.persist(p);
				String url = Constantes.URL_BASE_APP + "jsf/listarProfesores.jsf";
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getExternalContext().redirect(url);
			} catch (Exception ex) {
				System.out
						.println("Alta NO válida. Asignatura ya asignada anteriormente");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Alta no válida: Asignatura ya asignada anteriormente"));
		}

	}

	public void eliminarProfesor() {
		System.out.println("--------------------->");
		System.out.println("idProfesorSeleccionado: "
				+ profesorAdapter.getSeleccionado());
		try {
			if (profesorAdapter.getSeleccionado() != null) {
				// ProfesorDAO para hacer el remove y Profesor para enviarselo
				// como
				// parametro al remove
				ProfesorDAO dao = new ProfesorDAO();
				Profesor pro = dao.findById(profesorAdapter.getSeleccionado());

				System.out.println("Nombre: " + pro.getNombre() + " Id: "
						+ pro.getIdProfesor() + " va a ser eliminado");
				dao.remove(pro);
				System.out.println("Eliminado!!");
			}
		} catch (Exception ex) {
			System.out.println("Ha fallado al eliminar la Asignatura");

			System.out.println("--------------------->");
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"A fallado al ELIMINAR la asignatura"));
		}
		System.out.println("--------------------->");
		obtenerProfesor();

	}

	public void modificar(ProfesorAdapter profe) {
		System.out.println("--------------------->");
		try {
			// ProfesorDAO para hacer el merge y Profesor para enviarselo como
			// parametro al merge
			ProfesorDAO p = new ProfesorDAO();
			Profesor pro;

			System.out.println("id profesor: " + profe.getIdProfesor());

			// AsignaturaDAO para buscar la asig por id, que obtenemos del
			// adapter
			AsignaturaDAO a = new AsignaturaDAO();
			Asignatura asig = a.findById(6);

			System.out.println("Nombre asignatura: " + asig.getNombre());

			// Profesor a eliminar, con todos los campos
			pro = new Profesor(asig, profe.getNombre(), profe.getApellidos(),
					profe.getTelefono(), profe.getEmail(),
					profe.getIdProfesor());
			System.out.println("Profesor Editado: " + pro.getIdProfesor()
					+ " Nombre: " + pro.getNombre());

			p.merge(pro);

		} catch (Exception ex) {
			System.out
					.println("Alta NO válida. Asignatura ya asignada anteriormente");

			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Alta no válida: Asignatura ya esta asignada."));
		}
		System.out.println("--------------------->");
	}

	public void onRowEdit(RowEditEvent event) {
		try {
			FacesMessage msg = new FacesMessage("Profesor Editado: ",
					String.valueOf(((ProfesorAdapter) event.getObject())
							.getIdProfesor()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
			System.out.println("Id: "
					+ String.valueOf(((ProfesorAdapter) event.getObject())
							.getIdProfesor()));

			ProfesorAdapter profe = new ProfesorAdapter();
			profe.setIdProfesor(((ProfesorAdapter) event.getObject())
					.getIdProfesor());
			profe.setNombre(((ProfesorAdapter) event.getObject()).getNombre());
			profe.setApellidos(((ProfesorAdapter) event.getObject())
					.getApellidos());
			profe.setTelefono(((ProfesorAdapter) event.getObject())
					.getTelefono());
			profe.setEmail(((ProfesorAdapter) event.getObject()).getEmail());
			modificar(profe);
		} catch (Exception ex) {
			System.out
					.println("Modificacion. Ha fallado al modificar la asignatura.");

			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Modificacion no válida: Fallo al modificar la Asignatura."));
		}

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
