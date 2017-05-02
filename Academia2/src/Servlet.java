import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academia.bd.Alumno;
import com.academia.bd.Asignatura;
import com.academia.bd.BDAccess;
import com.academia.bd.MiHttpPost;
import com.academia.bd.Profesor;
import com.academia.bd.RelacionAlumnoAsignatura;
import com.academia.bd.Usuario;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Switch que recoge datos y lleva a la funcion correspondiente
		// o al archivo .jsp

		switch (request.getParameter("tabla")) {

		// CASE ASIGNATURAS
		case "asignaturas":
			switch (request.getParameter("accion")) {

			case "listar":
				listarAsignaturas(request, response);
				break;
			case "addFormulario":
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/addAsignatura.jsp");
				rd.forward(request, response);
				break;
			case "add":
				addAsignaturas(request, response);
				break;
			case "editar":
				editarAsignatura(request, response);
				break;
			case "editarenbd": 
				actualizarAsignatura(request, response);
				break;
			case "borrar":
				borrarAsignatura(request, response);
				break;
			}
			break;
		// CASE ALUMNOS
		case "alumnos":
			switch (request.getParameter("accion")) {

			case "listar":
				listarAlumnos(request, response);
				break;
			case "addFormulario":
				listarAsignaturasFormularioAlumno(request, response);
				break;
			case "add":			
				addAlumno(request, response);
				break;
			case "editar":
				editarAlumnos(request, response);
				break;
			case "editarenbd": 
				actualizarAlumno(request, response);
				break;
			case "borrar":
				borrarAlumno(request, response);
				break;
			}
			break;
		// CASE PROFESORES
		case "profesores":
			switch (request.getParameter("accion")) {

			case "listar":
				listarProfesores(request, response);
				break;
			case "addFormulario":
				listarAsignaturasFormularioProfesor(request, response);
				break;
			case "add":
				addProfesor(request, response);
				break;
			case "editar":
				editarProfesor(request, response);
				break;
			case "editarenbd": 
				actualizarProfesor(request, response);
				break;
			case "borrar":
				borrarProfesor(request, response);
				break;
			}
			break;
			
		case "buscar":
			buscar(request, response);
			break;
		case "login":
			login(request,response);
			break;
		case "desconectar":
			//borramos la variable session y redirigimos
			HttpSession sesion = request.getSession();
			sesion.invalidate();
			
			
			RequestDispatcher rq = request
			.getRequestDispatcher("/jsp/index.jsp");
			rq.forward(request, response);
			break;
		default:
			RequestDispatcher rd = request
			.getRequestDispatcher("/jsp/index.jsp");
			rd.forward(request, response);
			break;
		}

	}
	// METODOS PARA OBTENER LISTADOS

	// METODO PARA LISTADO DE ASIGNATURAS

	protected void listarAsignaturas(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Asignatura> listaAsignaturas = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ASIGNATURAS
			// listaAsignatura = db.obtenerListadoAsignatura();

			listaAsignaturas = db.obtenerListadoAsignaturas();

			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// request.setAttribute("listaAsignatura", listaAsignatura);

		request.setAttribute("listadoAsignatura", listaAsignaturas);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/listadoAsignaturas.jsp");
		rd.forward(request, response);
	}

	// METODO PARA OBTENER LISTADO DE ALUMNOS

	protected void listarAlumnos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Alumno> listaAlumnos = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ALUMNOS
			// listaAlumnos = db.obtenerListadoAlumnos();

			listaAlumnos = db.obtenerListadoAlumnos();

			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listadoAlumnos", listaAlumnos);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/listadoAlumno.jsp");
		rd.forward(request, response);

	}

	// METODO PARA OBTENER LISTADO DE PROFESORES

	protected void listarProfesores(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Profesor> listaProfesor = null;
		List<Asignatura> listaAsignatura = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			listaProfesor = db.obtenerListadoProfesores();
			
			listaAsignatura = db.obtenerListadoAsignaturas();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE PROFESOR
			// listaProfesor = db.obtenerListadoProfesor();

			listaProfesor = db.obtenerListadoProfesores();
			Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
			LOGGER.info("profesor " + listaProfesor.get(0).getNombre());
			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listadoProfesores", listaProfesor);
		request.setAttribute("listadoAsignaturas", listaAsignatura);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/listadoProfesor.jsp");
		rd.forward(request, response);
	}

	// METODOS PARA AÑADIR DATOS A LA BD
	//
	// METOODO PARA AÑADIR ASIGNATURAS

	protected void addAsignaturas(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// CREAMOS INSTANCIA DE CLASE ASIGNATURA
		Asignatura a = new Asignatura();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Nombre = request.getParameter("nombre");
		String Horario = request.getParameter("horario");
		String Aula = request.getParameter("aula");
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		a.setNombre(Nombre);
		a.setHorario(Horario);
		a.setAula(Aula);
		try {
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE INGRESA LA ASIGNATURA
			db.insertaAsignatura(a);
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha añadido correctamente la asignatura.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al insertar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}

	}

	// METOODO PARA AÑADIR ALUMNOS

	protected void addAlumno(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// CREAMOS INSTANCIA DE CLASE ALUMNO
		Alumno al = new Alumno();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");		
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		al.setNombre(Nombre);
		al.setApellidos(Apellidos);
		al.setTelefono(Telefono);
		al.setEmail(Email);
		
		String[] asignaturasSelect = request.getParameterValues("asignaturas");

		try {
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE INGRESA EL ALUMNO
			int idAlumno;
			idAlumno=db.insertaAlumno(al);
			Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
			
			
			RelacionAlumnoAsignatura relacion = new RelacionAlumnoAsignatura();
			for(int i=0; i < asignaturasSelect.length; i++){	
				relacion.setIdAlumno(idAlumno);	
				relacion.setIdAsignatura(Integer.parseInt(asignaturasSelect[i]));
				LOGGER.info("Id de asignatura: "+Integer.parseInt(asignaturasSelect[i]));
				db.insertaRelacionAlumnoAsignatura(relacion);
			}
			//UNA VEZ INSERTADO EL ALUMNO, INSERTAMOS SUS ASIGNATURAS
			
			
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha añadido correctamente al alumno.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al insertar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}

	}

	// METOODO PARA AÑADIR PROFESORES

	protected void addProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// CREAMOS INSTANCIA DE CLASE PROFESOR
		Profesor p = new Profesor();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");
		Integer idAsignatura = Integer.parseInt(request
				.getParameter("idasignatura"));
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		p.setNombre(Nombre);
		p.setApellidos(Apellidos);
		p.setTelefono(Telefono);
		p.setEmail(Email);
		p.setIdAsignatura(idAsignatura);

		try {
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE INGRESA EL ALUMNO
			db.insertaProfesor(p);
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "profesores");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha añadido correctamente al profesor.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "profesores");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al insertar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}

	}
	
	//METODOS QUE SE ENCARGAN DE RECOGER DATOS DE LA BD PARA MOSTRARLOS
	//EN LOS FORMULARIOS DE AÑADIR PROFESOR Y ALUMNO.
	
	protected void listarAsignaturasFormularioProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Asignatura> listaAsignaturas = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ASIGNATURAS
			// listaAsignatura = db.obtenerListadoAsignatura();

			listaAsignaturas = db.obtenerListadoAsignaturas();

			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// request.setAttribute("listaAsignatura", listaAsignatura);

		request.setAttribute("asignaturas", listaAsignaturas);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/addProfesor.jsp");
		rd.forward(request, response);
	}
	
	protected void listarAsignaturasFormularioAlumno(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Asignatura> listaAsignaturas = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ASIGNATURAS
			// listaAsignatura = db.obtenerListadoAsignatura();

			listaAsignaturas = db.obtenerListadoAsignaturas();

			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// request.setAttribute("listaAsignatura", listaAsignatura);

		request.setAttribute("asignaturas", listaAsignaturas);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/addAlumno.jsp");
		rd.forward(request, response);
	}
	// METODOS EDITAR LISTADOS
	
	// METODO EDITAR ALUMNO
	protected void editarAlumnos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Alumno alumno = null;
		List<Asignatura> listaAsignaturas = null;
		List<RelacionAlumnoAsignatura> listaRelacion = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER EL ALUMNOS
			alumno = db.mostrarAlumno(request.getParameter("idalumno"));
			//RECOGEMOS EL LISTADO DE LAS ASIGNATURAS
			listaAsignaturas = db.obtenerListadoAsignaturas();
			//RECOGEMOS LAS ASIGNATURAS RELACIONADAS CON EL ALUMNO
			listaRelacion = db.mostrarRelacionAlumnoAsignatura(request.getParameter("idalumno"));
		

			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("alumno", alumno);
		request.setAttribute("relacion", listaRelacion);
		request.setAttribute("asignaturas", listaAsignaturas);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/editarAlumno.jsp");
		rd.forward(request, response);

	}
	//METODO EDITAR PROFESOR
	
	protected void editarProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
		LOGGER.info("ID de profesor: "+request.getParameter("idprofesor"));
		
		Profesor profesor = null;
		
		List<Asignatura> listaAsignaturas = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ALUMNOS
			// listaAlumnos = db.obtenerListadoProfesor();

			profesor = db.mostrarProfesor(request.getParameter("idprofesor"));
			
			
			

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ASIGNATURAS
			// listaAsignatura = db.obtenerListadoAsignatura();

			listaAsignaturas = db.obtenerListadoAsignaturas();

			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("asignaturas", listaAsignaturas);
		request.setAttribute("profesor", profesor);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/editarProfesor.jsp");
		rd.forward(request, response);

	}

	//METODO EDITAR ASIGNATURA
	
	protected void editarAsignatura(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Asignatura asignatura = null;

		// request.getAttribute(arg0)
		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ALUMNOS
			// listaAlumnos = db.obtenerListadoAsignatura();

			asignatura = db.mostrarAsignatura(request.getParameter("idasignatura"));
			
		
			Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
			LOGGER.info("ID de asignatura: "+asignatura.getIdAsignatura());
			
			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("asignatura", asignatura);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/editarAsignatura.jsp");
		rd.forward(request, response);

	}
	
	//METODOS PARA ACTUALIZAR EN LA BASE DE DATOS LAS TABLAS
	
	//METODO PARA ACTUALIZAR LA ASIGNATURA QUE ENTRA DEL FORM
	protected void actualizarAsignatura(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
		LOGGER.info("Entra en actualizarAsignatura()");
		// CREAMOS INSTANCIA DE CLASE ASIGNATURA
		Asignatura a = new Asignatura();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Nombre = request.getParameter("nombre");
		String Horario = request.getParameter("horario");
		String Aula = request.getParameter("aula");
		String Id = request.getParameter("idasignatura");
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		a.setNombre(Nombre);
		a.setHorario(Horario);
		a.setAula(Aula);
		a.setIdAsignatura(Integer.parseInt(Id));
		try {
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE INGRESA LA ASIGNATURA
			db.modificarAsignatura(a);
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha editado correctamente la asignatura.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al actualizar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}
	}
	
	//METODO PARA ACTUALIZAR EL ALUMNO QUE ENTRA DEL FORM
	protected void actualizarAlumno(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// CREAMOS INSTANCIA DE CLASE ALUMNO
		Alumno al = new Alumno();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Id = request.getParameter("idalumno");
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");		
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		al.setIdAlumno(Integer.parseInt(Id));
		al.setNombre(Nombre);
		al.setApellidos(Apellidos);
		al.setTelefono(Telefono);
		al.setEmail(Email);
		
		String[] asignaturasSelect = request.getParameterValues("asignaturas");

		try {
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			
			//CREO UNA LISTA DE RELACIONES Y METO LAS ASIGNATURAS SELECCIONADAS	
			List<RelacionAlumnoAsignatura> lista = new ArrayList<RelacionAlumnoAsignatura>();
			
			RelacionAlumnoAsignatura relacion = new RelacionAlumnoAsignatura();
			if(asignaturasSelect != null)
				for(int i=0; i < asignaturasSelect.length; i++){
					relacion.setIdAlumno(Integer.parseInt(Id));	
					relacion.setIdAsignatura(Integer.parseInt(asignaturasSelect[i]));
					lista.add(relacion);
					//VACIO LA VARIABLE PARA UTILIZARLA NUEVAMENTE
					relacion = null;
					relacion = new RelacionAlumnoAsignatura();
				}
			
			db.modificarAlumno(al,lista);
					
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha editado correctamente al alumno.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al actualizar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}
	}
	
	//METODO PARA ACTUALIZAR EL ALUMNO QUE ENTRA DEL FORM
	protected void actualizarProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	// CREAMOS INSTANCIA DE CLASE PROFESOR
	Profesor profesor = new Profesor();
	// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
	String Id = request.getParameter("idprofesor");
	String Nombre = request.getParameter("nombre");
	String Apellidos = request.getParameter("apellidos");
	String Telefono = request.getParameter("telefono");
	String Email = request.getParameter("email");
	String idAsignatura = request.getParameter("idasignatura");
	
	Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
	LOGGER.info("AsignaturaId: "+idAsignatura);
	// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
	profesor.setIdProfesor(Integer.parseInt(Id));
	profesor.setNombre(Nombre);
	profesor.setApellidos(Apellidos);
	profesor.setTelefono(Telefono);
	profesor.setEmail(Email);
	profesor.setIdAsignatura(Integer.parseInt(idAsignatura));

	try {
		// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
		BDAccess db = new BDAccess();
		// CONECTAMOS CON LA BD
		db.connect();
		
		
		db.modificarProfesor(profesor);
				
		// CERRAMOS LA CONEXION A BD
		db.cerrar();
		
		request.setAttribute("tabla", "profesores");
		request.setAttribute("accion", "listar");
		request.setAttribute("texto", "Se ha editado correctamente al profesor.");

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/textoDinamico.jsp");
		rd.forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("tabla", "profesores");
		request.setAttribute("accion", "listar");
		request.setAttribute("texto", "Error al actualizar datos.");

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/textoDinamico.jsp");
		rd.forward(request, response);
	}
}
	
	//METODOS PARA BORRAR REGISTROS-----------------------------------
	//BORRAR ASIGNATURAS
	protected void borrarAsignatura(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
				String idasignatura = request.getParameter("idasignatura");
		try {
			//CREAMOS LA VARIABLE DE ASIGNATURA Y LA LLAMAMOS POR EJ, ASIG
			Asignatura asig = new Asignatura();
			//PASAMOS LA VARIABLE DE TIPO STRING A INT USANDO LA FUNCION
			//INTEGER.PARSEINT
			asig.setIdAsignatura(Integer.parseInt(idasignatura));
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE INGRESA LA ASIGNATURA
			db.borrarAsignatura(asig);
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha borrado correctamente la asignatura.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al borrar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}
	}
	
	
	//BORRAR PROFESOR
	protected void borrarProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		
		String idprofesor = request.getParameter("idprofesor");
		
		try {
			//CREAMOS LA VARIABLE DE PROFESOR Y LA LLAMAMOS POR EJ, PROFE
			Profesor profe = new Profesor();
			//PASAMOS LA VARIABLE DE TIPO STRING A INT USANDO LA FUNCION
			//INTEGER.PARSEINT

			profe.setIdProfesor(Integer.parseInt(idprofesor));

			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE INGRESA LA ASIGNATURA
			db.borrarProfesor(profe);
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "profesores");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha borrado correctamente el profesor.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "profesores");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al borrar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}
	}

	
	//BORRAR ALUMNO
	protected void borrarAlumno(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String idalumno = request.getParameter("idalumno");
		try {
			//CREAMOS LA VARIABLE DE ALUMNO Y LA LLAMAMOS POR EJ, ALUM
			Alumno alum = new Alumno();
			//PASAMOS LA VARIABLE DE TIPO STRING A INT USANDO LA FUNCION
			//INTEGER.PARSEINT
			alum.setIdAlumno(Integer.parseInt(idalumno));
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE INGRESA LA ASIGNATURA
			db.borrarAlumno(alum);
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			
			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Se ha borrado correctamente al alumno.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al borrar datos.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}
	
	}
	


	//FUNCION QUE SE ENCARGA DE ANALIZAR LA BUSQUEDA
	protected void buscar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
		
		List<Asignatura> listaAsignatura = null;
		String t1=request.getParameter("T1");
		int iclase = Integer.parseInt(request.getParameter("clasesB"));
		int icampos = Integer.parseInt(request.getParameter("camposB"));
		List li = null;
		try {
			BDAccess db = new BDAccess();
			// CONECTAMOS CON LA BD
			db.connect();
			// LLAMAMOS AL METODO QUE REALIZA LA BUSQUEDA
			li = db.buscar(iclase,icampos,t1);
			// CERRAMOS LA CONEXION A BD
			db.cerrar();
			if (li!=null){
			 if (li.size()>0){
				if (li.get(0) instanceof Profesor){
					db.connect();
					listaAsignatura = db.obtenerListadoAsignaturas();
					db.cerrar();
					
					request.setAttribute("listadoProfesores", li);
					request.setAttribute("listadoAsignaturas", listaAsignatura);
					
					//paso de variables para mostrar en el buscador
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);					
					
					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/listadoProfesor.jsp");
					rd.forward(request, response);
				}
			 
				else if (li.get(0) instanceof Alumno){
					request.setAttribute("listadoAlumnos", li);
					
					//paso de variables para mostrar en el buscador
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);	

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/listadoAlumno.jsp");
					rd.forward(request, response);
				}
			
				else if (li.get(0) instanceof Asignatura){
					request.setAttribute("listadoAsignatura", li);
					
					//paso de variables para mostrar en el buscador
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);	

					RequestDispatcher rd = request
							.getRequestDispatcher("/jsp/listadoAsignaturas.jsp");
					rd.forward(request, response);
					
				}
			 }else{
				 //AQUI ENTRA SI LA LISTA ESTÁ VACIA
				//paso de variables para mostrar en el buscador
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);	
					request.setAttribute("texto", "No se han encontrado resultados.");

				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/textoDinamico.jsp");
				rd.forward(request, response);
			 }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	//FUNCION PARA CONECTAR CON EL WEBSERVICE
	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		//Metodo usando RESTEasyClienPost
		//RESTEasyClientPost cliente = new RESTEasyClientPost();
		//Metodo usando HTTP request
		MiHttpPost cliente = new MiHttpPost();
		
		cliente.setDatos(usuario, password);
		
		cliente.conectar();
		
		
		if(cliente.getEstado()){
			//entramos aqui si el servidor devuelve codigo 200, todo correcto.
			Usuario usuarioLogueado = cliente.getUsuario();
			
			Usuario user = new Usuario();
			user.setId(usuarioLogueado.getId());
			user.setFechaUltimoLogin(usuarioLogueado.getFechaUltimoLogin());
			
			//CREAMOS UNA VARIABLE SESSION
			HttpSession session = request.getSession(true);
			
			session.setAttribute("UsuarioLogueado", usuarioLogueado);
		
			//actualizamos la fecha de logueo a la actual
			Date a = new Date();
			user.setFechaUltimoLogin(a);
			//enviamos la peticion de actualizar
			
			cliente.actualizar(user);
			
			if(!cliente.getEstado()){
				System.out.println("Error actualizando fecha");
			}
			
			//Lo siguiente comentado es como recogeriamos la variable para usarla.
			//Usuario usuario2 =  (Usuario) session.getAttribute("UsuarioLogueado");
			
			//redirigimos al indice
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/index.jsp");
			rd.forward(request, response);
		}else{
			//si el usuario es incorrecto, mostramos error
			request.setAttribute("tabla", "");
			request.setAttribute("texto", "Usuario incorrecto.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}
		
		
	}


}
