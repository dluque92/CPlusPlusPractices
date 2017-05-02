package controlador;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.Asignatura;
import modelo.AsignaturaDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;
import modelo.RelAlumnoAsignatura;
import modelo.RelAlumnoAsignaturaDAO;
import vista.AlumnoAdapter;
import vista.AsignaturaAdapter;
import vista.BusquedaAdapter;
import vista.LoginAdapter;
import vista.ProfesorAdapter;

@ManagedBean
public class AcademiaBean {

	private AsignaturaAdapter asignaturaAdapter;
	private ProfesorAdapter profesorAdapter;
	private AlumnoAdapter alumnoAdapter;
	private BusquedaAdapter busquedaAdapter;
	
	private ArrayList<AsignaturaAdapter> alaag ;
	private ArrayList<AlumnoAdapter> listAlumnos ;

	public AcademiaBean() {
		super();
		alumnoAdapter = new AlumnoAdapter();
		asignaturaAdapter = new AsignaturaAdapter();
		profesorAdapter = new ProfesorAdapter();
		busquedaAdapter = new BusquedaAdapter();
		alaag = new ArrayList<AsignaturaAdapter>();
		listAlumnos = new ArrayList<AlumnoAdapter>();

	}

	
	public ArrayList<AsignaturaAdapter> getAlaag() {
		return alaag;
	}

	public void setAlaag(ArrayList<AsignaturaAdapter> alaag) {
		this.alaag = alaag;
	}
	
	public ArrayList<AlumnoAdapter> getListaAlumnos() {
		return listAlumnos;
	}

	public void setListaAlumnos(ArrayList<AlumnoAdapter> listAlumnos) {
		this.listAlumnos = listAlumnos;
	}

	public AsignaturaAdapter getAsignaturaAdapter() {
		return asignaturaAdapter;
	}

	public void setAsignaturaAdapter(AsignaturaAdapter asignaturaAdapter) {
		this.asignaturaAdapter = asignaturaAdapter;
	}

	public AlumnoAdapter getAlumnoAdapter() {
		return alumnoAdapter;
	}

	public void setAlumnoAdapter(AlumnoAdapter alumnoAdapter) {
		this.alumnoAdapter = alumnoAdapter;
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

	public void init() {
		alumnoAdapter = new AlumnoAdapter();
		/*Codigo para ver si existe sesion
		UsuariosBean b= new UsuariosBean();
		LoginAdapter l = b.existeSesion();
		System.out.println("......");
		System.out.println("......" + l.getUser());
		*/
		System.out.println("-------aasasas------------------");
	}

	public String conectar() {
		System.out.println("-------------------------conectar");

		// insertarProfesorYAsignaturaNuevos();
		// insertarAlumnoYAsignaturaNuevos();
		// obtenerProfesor(1);
		obtenerAsignatura(2);

		return "resultado";
	}

	private void obtenerAsignatura(int id) {
		try {
			AsignaturaDAO dao = new AsignaturaDAO();
			Asignatura a = dao.findById(id);

			Profesor p = a.getProfesor();

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
	
	
	public String obtenerAsignatura() 
	{
		AsignaturaDAO dao = new AsignaturaDAO ();
		
		AsignaturaAdapter aa = new AsignaturaAdapter ();
		
		Asignatura a = new Asignatura();
		
		ArrayList<AsignaturaAdapter> llaa = new ArrayList<AsignaturaAdapter>();
		
		List<Asignatura> laa = new ArrayList<Asignatura>();
		
		Iterator<Asignatura> it ;
		
		switch(busquedaAdapter.getSeleccionado())
		{
			case 1: 	a = dao.findById(Integer.parseInt(busquedaAdapter.getTexto()));
						aa.setIdAsignatura(a.getIdAsignatura());
						aa.setNombre(a.getNombre());
						aa.setHorario(a.getHorario());
						aa.setAula(a.getAula());
						asignaturaAdapter = aa;
						
			
			case 2:		laa = dao.findByNombre(busquedaAdapter.getTexto()) ;
						it = laa.iterator();
						while(it.hasNext())
						{
							a = it.next();
							aa.setIdAsignatura(a.getIdAsignatura());
							aa.setNombre(a.getNombre());
							aa.setHorario(a.getHorario());
							aa.setAula(a.getAula());
							llaa.add(aa);
						}
						alaag = llaa ;
						
			
			case 3:		laa = dao.findByHorario(busquedaAdapter.getTexto());
						it = laa.iterator();
						while(it.hasNext())
						{
							a = it.next();
							aa.setIdAsignatura(a.getIdAsignatura());
							aa.setNombre(a.getNombre());
							aa.setHorario(a.getHorario());
							aa.setAula(a.getAula());
							llaa.add(aa);
						}
						alaag = llaa ;
						
						
			default:	laa = dao.findByAula(busquedaAdapter.getTexto());	
						it = laa.iterator();
						while(it.hasNext())
						{
							a = it.next();
							aa.setIdAsignatura(a.getIdAsignatura());
							aa.setNombre(a.getNombre());
							aa.setHorario(a.getHorario());
							aa.setAula(a.getAula());
							llaa.add(aa);
						}
						alaag = llaa ;
		}
		
		return "buscarAsignatura";
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
			e.printStackTrace();
		}
	}

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
		}
	}

	public String obtenerAlumno() {
		System.out.println("--------------------->");
		AlumnoDAO dao = new AlumnoDAO();
		Alumno al = new Alumno();
		AlumnoAdapter aladapter;
		System.out.println("--------------------->");
		
		switch(busquedaAdapter.getSeleccionado()){
			case 1:
				Integer id = Integer.parseInt(busquedaAdapter.getTexto());
				al = dao.findById(id);
				aladapter = new AlumnoAdapter(al.getIdAlumno(), al.getNombre(), al.getApellidos(), al.getTelefono(), al.getEmail());
				listAlumnos.add(aladapter);
				System.out.println("--------------------->");
				return "buscarAlumnos";
			case 2:
				System.out.println("Nombre");
				dao.findByNombre(busquedaAdapter.getTexto());
				return "buscarAlumnos";
			case 3:
				System.out.println("Apellido");
				dao.findByApellidos(busquedaAdapter.getTexto());
				return "buscarAlumnos";
			case 4:
				System.out.println("Telefono");
				dao.findByTelefono(busquedaAdapter.getTexto());
				return "buscarAlumnos";
			case 5:
				System.out.println("Email");
//				dao.findByEmail(busquedaAdapter.getTexto());
				return "buscarAlumnos";
			default:
				System.out.println("Email");
				dao.findAll();
				return "buscarAlumnos";
		}
	}

	public String insertarAsignatura() {
		System.out.println("--------------------->");
		Asignatura a = new Asignatura();
		a.setNombre(asignaturaAdapter.getNombre());
		a.setHorario(asignaturaAdapter.getHorario());
		a.setAula(asignaturaAdapter.getAula());
		AsignaturaDAO dao = new AsignaturaDAO();
		dao.persist(a);

		return "index";
	}

	private void insertarAsignatura(Asignatura a) {
		try {
			AsignaturaDAO dao = new AsignaturaDAO();
			dao.persist(a);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String insertarProfesor() {
		System.out.println("--------------------->");
		Profesor p = new Profesor();
		p.setNombre(profesorAdapter.getNombre());
		p.setApellidos(profesorAdapter.getApellidos());
		p.setTelefono(profesorAdapter.getTelefono());
		
		//consultamos y nos traemos la asignatura completa
		AsignaturaDAO aDao = new AsignaturaDAO();
		Asignatura a = new Asignatura();
		a = aDao.findById(profesorAdapter.getSeleccionado());		
		p.setAsignatura(a);
		
		p.setTelefono(profesorAdapter.getTelefono());
		ProfesorDAO dao = new ProfesorDAO();
		dao.persist(p);

		return "index";
	}

	private void insertarProfesor(Profesor p) {
		try {
			ProfesorDAO dao = new ProfesorDAO();
			dao.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String insertarAlumno() {
		System.out.println("--------------------->");
		Alumno a = new Alumno();
		a.setNombre(alumnoAdapter.getNombre());
		a.setApellidos(alumnoAdapter.getApellidos());
		a.setEmail(alumnoAdapter.getEmail());
		a.setTelefono(alumnoAdapter.getTelefono());
		AlumnoDAO dao = new AlumnoDAO();
		dao.persist(a);

		return "index";
	}

	private void insertarAlumno(Alumno a) {
		try {
			AlumnoDAO dao = new AlumnoDAO();
			dao.persist(a);

		} catch (Exception e) {

		}
	}

	private void insertarRelAlumnoAsignatura(RelAlumnoAsignatura r) {
		try {
			RelAlumnoAsignaturaDAO dao = new RelAlumnoAsignaturaDAO();
			dao.persist(r);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertarProfesorYAsignaturaNuevos() {

		Profesor p = new Profesor();
		p.setNombre("Dolores");
		p.setApellidos("Rondo Cencerro");
		p.setTelefono("656767688");
		p.setEmail("dolores.rondo@gmail.com");

		Asignatura a = new Asignatura();
		a.setNombre("Dibujo Tecnico");
		a.setHorario("10 a 14");
		a.setAula("E");
		insertarAsignatura(a);

		p.setAsignatura(a);
		insertarProfesor(p);
	}

	private void insertarAlumnoYAsignaturaNuevos() {

		Alumno al = new Alumno();
		al.setNombre("Jaime");
		al.setApellidos("Cansino Delto");
		al.setTelefono("611223344");
		al.setEmail("cansino@gmail.com");
		insertarAlumno(al);

		Asignatura a = new Asignatura();
		a.setNombre("Latin");
		a.setHorario("15 a 17");
		a.setAula("F");
		insertarAsignatura(a);

		RelAlumnoAsignatura rel = new RelAlumnoAsignatura();
		rel.setAlumno(al);
		rel.setAsignatura(a);
		insertarRelAlumnoAsignatura(rel);
	}

}
