/**
 * 	ESTA CLASE SE ENCARGA DE IMPLEMENTAR EL CODIGO DE TODOS LOS METODOS A LOS QUE LLAMAMOS
 * 	DESDE EL FORMULARIO. ADEMÁS SIRVE DE PUENTE CON EL DAO QUE CREAMOS CON EL HIBERNATE Y QUE
 * 	CONTIENE TODOS LOS METODOS QUE REALIZAN ACCIONES SOBRE LA BASE DE DATOS.
 */

/**
 * 	PAQUETES E IMPORTACIONES
 */

package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import common.Constantes;
import modelo.Asignatura;
import modelo.AsignaturaDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;
import vista.AlumnoAdapter;
import vista.AsignaturaAdapter;
import vista.BusquedaAdapter;
import vista.LoginAdapter;
import vista.ProfesorAdapter;

/**
 * 
 * ESTA ES LA CLASE EN SI. LAS ANOTACIONES SON LAS SIGUIENTES:
 *
 * @ViewScoped: El bean administrado se creará al recibirse una petición HTTP y
 *              se destruirá al cambiar de vista.
 *
 * @ManagedBean(name="asignaturasBean"): el name de la anotación ManagedBean
 *                                       define el nombre con que se podra
 *                                       invocar al bean administrado desde las
 *                                       página JSF
 *
 */

@ManagedBean(name = "asignaturasBean")
@ViewScoped
public class AsignaturasBean implements Serializable {
	/**
	 * VARIABLES
	 */

	private AsignaturaAdapter aa = new AsignaturaAdapter();
	private AsignaturaAdapter asignaturaAdapter = new AsignaturaAdapter();

	private BusquedaAdapter busquedaAdapter = new BusquedaAdapter();

	private ArrayList<AsignaturaAdapter> listAsignatura = new ArrayList<AsignaturaAdapter>();
	private List<Asignatura> asignaturas = new ArrayList<Asignatura>();
	private LinkedList<AsignaturaAdapter> llaa = null;

	public Asignatura asignaturaSeleccionada = new Asignatura();

	private String idAsignaturaSeleccionada;

	/**
	 * GETS Y SETS
	 */

	public String getIdAsignaturaSeleccionada() {
		return idAsignaturaSeleccionada;
	}

	public void setIdAsignaturaSeleccionada(String idAsignaturaSeleccionada) {
		this.idAsignaturaSeleccionada = idAsignaturaSeleccionada;
	}

	public LinkedList<AsignaturaAdapter> getLlaa() {
		return llaa;
	}

	public void setLlaa(LinkedList<AsignaturaAdapter> llaa) {
		this.llaa = llaa;
	}

	public AsignaturaAdapter getAsignaturaAdapter() {
		return asignaturaAdapter;
	}

	public void setAsignaturaAdapter(AsignaturaAdapter asignaturaAdapter) {
		this.asignaturaAdapter = asignaturaAdapter;
	}

	public BusquedaAdapter getBusquedaAdapter() {
		return busquedaAdapter;
	}

	public void setBusquedaAdapter(BusquedaAdapter busquedaAdapter) {
		this.busquedaAdapter = busquedaAdapter;
	}

	public Asignatura getAsignaturaSeleccionada() {
		return asignaturaSeleccionada;
	}

	public void setAsignaturaSeleccionada(Asignatura asignaturaSeleccionada) {
		this.asignaturaSeleccionada = asignaturaSeleccionada;
	}

	public ArrayList<AsignaturaAdapter> getListAsignatura() {
		return listAsignatura;
	}

	public void setListAsignatura(ArrayList<AsignaturaAdapter> listAsignatura) {
		this.listAsignatura = listAsignatura;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * CONSTRUCTORES
	 */

	public AsignaturasBean(AsignaturaAdapter asignaturaAdapter,
			BusquedaAdapter busquedaAdapter,
			ArrayList<AsignaturaAdapter> listAsignatura,
			List<Asignatura> asignaturas, Asignatura asignaturaSeleccionada) {
		super();
		this.asignaturaAdapter = asignaturaAdapter;
		this.busquedaAdapter = busquedaAdapter;
		this.listAsignatura = listAsignatura;
		this.asignaturas = asignaturas;
		this.asignaturaSeleccionada = asignaturaSeleccionada;
	}

	public AsignaturasBean() {

	}

	/**
	 * METODOS
	 */

	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		asignaturaAdapter = new AsignaturaAdapter();
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
		AsignaturaDAO dao = new AsignaturaDAO();
		asignaturas = dao.findAll();
	}

	public String altaProfesor() {
		AsignaturaDAO dao = new AsignaturaDAO();
		asignaturas = dao.findAll();
		return "altaProfesor";
	}

	public String conectar() {
		System.out.println("-------------------------conectar");
		AsignaturaDAO dao = new AsignaturaDAO();
		Asignatura a = dao.findById(1);

		System.out.println("----Asignatura: " + a.getNombre());
		a.setNombre("nuevo nombre");

		dao.merge(a);

		List<Asignatura> list = dao.findByNombre("ue");

		for (int i = 0; i < list.size(); i++) {
			Asignatura as = list.get(i);
			System.out.println("----" + as.getNombre() + "-" + a.getAula());
		}

		System.out.println("Size: " + list.size());

		obtenerProfesor(1);
		return "resultado";
	}

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

		}
	}

	/*
	 * METODO DEPRECADO private void obtenerAsignatura(int id) { try {
	 * AsignaturaDAO dao = new AsignaturaDAO(); Asignatura a = dao.findById(id);
	 * 
	 * Profesor p = a.getProfesor();
	 * 
	 * System.out.println("************DATOS PROFESOR************");
	 * System.out.println(p.getNombre() + ", " + p.getApellidos());
	 * System.out.println("**************************************");
	 * System.out.println("************DATOS ASIGNATURA************");
	 * System.out.println(a.getNombre() + ", " + a.getHorario());
	 * System.out.println("**************************************"); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * 
	 * @return RETORNAMOS LA LISTA DE LOS ALUMNOS OBETENIDOS
	 */

	public LinkedList<AsignaturaAdapter> obtenerAsignatura() {
		AsignaturaDAO dao = new AsignaturaDAO();

		Asignatura a = new Asignatura();

		List<Asignatura> laa = new ArrayList<Asignatura>();

		Iterator<Asignatura> it;

		llaa = new LinkedList<AsignaturaAdapter>();

		System.out.println("GetSeleccionado que llega desde Busqueda Adapter: "
				+ busquedaAdapter.getSeleccionado());

		switch (busquedaAdapter.getSeleccionado()) 
		{
			case 1:
					
					String abuscar = busquedaAdapter.getTexto();
					
					if(abuscar.equals(""))
					{
						laa = dao.findAll();
						it = laa.iterator();
						int z = 0;
						while (it.hasNext()) 
						{
							aa = new AsignaturaAdapter(laa.get(z).getIdAsignatura(), laa
									.get(z).getNombre(), laa.get(z).getHorario(), laa
									.get(z).getAula());
							llaa.add(aa);
			
							z++;
			
							it.next();
						}
					}
					else
					{
						try
						{
							a = dao.findById(Integer.parseInt(busquedaAdapter.getTexto()));
							aa.setIdAsignatura(a.getIdAsignatura());
							aa.setNombre(a.getNombre());
							aa.setHorario(a.getHorario());
							aa.setAula(a.getAula());
							llaa.add(aa);
						}
						catch (Exception ex) 
						{
							System.out.println("-------> Id de profesor inexistente");
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
											"Error", "Id de Asignatura inexistente"));
						}	
					}
					break;
	
			case 2:
					laa = dao.findByNombre(busquedaAdapter.getTexto());
		
					it = laa.iterator();
		
					int x = 0;
		
					while (it.hasNext()) {
						aa = new AsignaturaAdapter(laa.get(x).getIdAsignatura(), laa
								.get(x).getNombre(), laa.get(x).getHorario(), laa
								.get(x).getAula());
		
						llaa.add(aa);
		
						x++;
		
						it.next();
					}
		
					break;
	
			case 3:
					laa = dao.findByHorario(busquedaAdapter.getTexto());
		
					it = laa.iterator();
		
					int y = 0;
		
					while (it.hasNext()) {
						aa = new AsignaturaAdapter(laa.get(y).getIdAsignatura(), laa
								.get(y).getNombre(), laa.get(y).getHorario(), laa
								.get(y).getAula());
		
						llaa.add(aa);
		
						y++;
		
						it.next();
					}
		
					break;
	
			case 4:
					laa = dao.findByAula(busquedaAdapter.getTexto());
					it = laa.iterator();
		
					int n = 0;
		
					while (it.hasNext()) {
						aa = new AsignaturaAdapter(laa.get(n).getIdAsignatura(), laa
								.get(n).getNombre(), laa.get(n).getHorario(), laa
								.get(n).getAula());
		
						llaa.add(aa);
		
						n++;
		
						it.next();
					}
					break;
			default:
					laa = dao.findAll();
					it = laa.iterator();
					int z = 0;
					while (it.hasNext()) {
						aa = new AsignaturaAdapter(laa.get(z).getIdAsignatura(), laa
								.get(z).getNombre(), laa.get(z).getHorario(), laa
								.get(z).getAula());
						llaa.add(aa);
		
						z++;
		
						it.next();
					}
		}

		return llaa;
	}

	// METODO PARA INSERTAR ASIGNATURA (ANTONIO)
	public void insertarAsignatura() {
		System.out
				.println("-------------------> ENTRAMOS EN INSERTAR ASIGNATURA");

		Asignatura a = new Asignatura();
		a.setNombre(asignaturaAdapter.getNombre());
		a.setHorario(asignaturaAdapter.getHorario());
		a.setAula(asignaturaAdapter.getAula());

		AsignaturaDAO dao = new AsignaturaDAO();
		dao.persist(a);

		System.out.println(" ");
		System.out.println("Nombre: " + asignaturaAdapter.getNombre());
		System.out.println("Horario: " + asignaturaAdapter.getHorario());
		System.out.println("Aula: " + asignaturaAdapter.getAula());
		System.out.println(" ");
		System.out
				.println("------------------->SALIMOS DE INSERTAR ASIGNATURA");

		try {
			FacesContext contex = FacesContext.getCurrentInstance();
			contex.getExternalContext().redirect(
					Constantes.URL_BASE_APP + "jsf/listarAsignaturas.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("Alta NO válida. Asignatura ya creada anteriormente");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Alta no válida: La Asignatura ya esta creada."));
		}
	}
	
	// METODO PARA INSERTAR ASIGNATURA (ANTONIO)
		public void insertarAsignaturaenProfesor() {
			
			Asignatura a = new Asignatura();
			a.setNombre(asignaturaAdapter.getNombre());
			a.setHorario(asignaturaAdapter.getHorario());
			a.setAula(asignaturaAdapter.getAula());

			AsignaturaDAO dao = new AsignaturaDAO();
			dao.persist(a);

			System.out.println(" ");
			System.out.println("Nombre: " + asignaturaAdapter.getNombre());
			System.out.println("Horario: " + asignaturaAdapter.getHorario());
			System.out.println("Aula: " + asignaturaAdapter.getAula());
			System.out.println(" ");
			System.out
					.println("------------------->SALIMOS DE INSERTAR ASIGNATURA");

			try {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(
						Constantes.URL_BASE_APP + "jsf/altaProfesor.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
										"Error",
										"Alta no válida: La Asignatura ya esta creada."));
			}
		}
	

	// METODO PARA INSERTAR ASIGNATURA(PRUEBA)
	private void insertarAsignatura(Asignatura a) {
		try {
			AsignaturaDAO dao = new AsignaturaDAO();
			dao.persist(a);

		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Alta NO válida. Asignatura ya creada anteriormente");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Alta no válida: La Asignatura ya esta creada."));
		}
	}

	public void modificar(AsignaturaAdapter asig) {
		System.out.println("---------------------> MODIFICACION");
		try {
			// ProfesorDAO para hacer el merge y Profesor para enviarselo como
			// parametro al merge
			AsignaturaDAO a = new AsignaturaDAO();
			Asignatura asi = new Asignatura();

			System.out.println("Id Asignatura: " + asig.getIdAsignatura());

			System.out.println("Nombre asignatura: " + asig.getNombre());

			// Asignatura a eliminar, con todos los campos

			asi.setIdAsignatura(asig.getIdAsignatura());
			asi.setNombre(asig.getNombre());
			asi.setHorario(asig.getHorario());
			asi.setAula(asig.getAula());

			a.merge(asi);

		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Modificacion NO válida. Asignatura ya creada anteriormente");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Modificacion no válida: La Asignatura ya esta creada anteriormente."));
		}

		System.out.println("---------------------> FIN DE MODIFICACION");
	}

	public void eliminarAsignatura() {
		System.out.println("---------------------> INICIO DE LA ELIMINACION");

		AsignaturaDAO dao = new AsignaturaDAO();

		System.out.println("Asignatura a eliminar: "
				+ Integer.valueOf(idAsignaturaSeleccionada));

		System.out.println("---------- ELIMINANDO ---------->");

		dao.remove(dao.findById(Integer.valueOf(idAsignaturaSeleccionada)));

		obtenerAsignatura();

		System.out.println("---------------------> FIN DE LA ELIMINACION");

	}

	public void onRowEdit(RowEditEvent event) {
		System.out.println("---------------------> ENTRAMOS EN ROW EDIT");
		try{
		FacesMessage msg = new FacesMessage("Asignatura Editado",
				String.valueOf(((AsignaturaAdapter) event.getObject())
						.getIdAsignatura()));
		FacesContext.getCurrentInstance().addMessage(null, msg);

		AsignaturaAdapter asig = new AsignaturaAdapter();

		asig.setIdAsignatura(((AsignaturaAdapter) event.getObject())
				.getIdAsignatura());
		asig.setNombre(((AsignaturaAdapter) event.getObject()).getNombre());
		asig.setHorario(((AsignaturaAdapter) event.getObject()).getHorario());
		asig.setAula(((AsignaturaAdapter) event.getObject()).getAula());

		modificar(asig);
		}catch (Exception e){
			e.printStackTrace();
			System.out
					.println("Modificacion NO válida. Asignatura ya creada anteriormente");
			System.out.println("--------------------->");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error",
									"Modificacion no válida: La Asignatura ya esta creada anteriormente."));
		}
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Editar cancelado",
				String.valueOf(((AsignaturaAdapter) event.getObject())
						.getIdAsignatura()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public LinkedList<AsignaturaAdapter> listarAsignatura() {
		AsignaturaDAO dao = new AsignaturaDAO();

		List<Asignatura> laa = new ArrayList<Asignatura>();

		Iterator<Asignatura> it;

		llaa = new LinkedList<AsignaturaAdapter>();

		laa = dao.findAll();
		it = laa.iterator();
		int z = 0;

		while (it.hasNext()) {
			aa = new AsignaturaAdapter(laa.get(z).getIdAsignatura(), laa.get(z)
					.getNombre(), laa.get(z).getHorario(), laa.get(z).getAula());
			llaa.add(aa);

			z++;

			it.next();

		}

		return llaa;
	}
}
