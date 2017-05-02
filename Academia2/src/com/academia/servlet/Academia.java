package com.academia.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academia.bd.Alumno;
import com.academia.bd.BDAccess;
import com.academia.bd.MiHttpPost;
import com.academia.bd.Profesor;
import com.academia.bd.RelacionAlumnoAsignatura;
import com.academia.bd.Usuario;
import com.academia.hibernate.AlumnoDAO;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.ProfesorDAO;
import com.academia.hibernate.RelAlumnoAsignatura;
import com.academia.hibernate.RelAlumnoAsignaturaDAO;

/**
 * Servlet implementation class Academia
 */
@WebServlet("/Academia")
public class Academia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Academia() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
			login(request, response);
			break;
		case "desconectar":
			// borramos la variable session y redirigimos
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

		// Obtenemos el listado de asignaturas usando Hibernate
		AsignaturaDAO dao = new AsignaturaDAO();
		List<Asignatura> lista = dao.findAll();

		request.setAttribute("listadoAsignatura", lista);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/listadoAsignaturas.jsp");
		rd.forward(request, response);

	}

	// METODO PARA OBTENER LISTADO DE ALUMNOS

	protected void listarAlumnos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Obtenemos el listado de alumnos usando Hibernate
		AlumnoDAO dao = new AlumnoDAO();
		List<com.academia.hibernate.Alumno> lista = dao.findAll();

		request.setAttribute("listadoAlumnos", lista);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/listadoAlumno.jsp");
		rd.forward(request, response);

	}

	// METODO PARA OBTENER LISTADO DE PROFESORES

	protected void listarProfesores(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Obtenemos el listado de profesor usando Hibernate
		ProfesorDAO dao = new ProfesorDAO();
		List<com.academia.hibernate.Profesor> lista = dao.findAll();

		request.setAttribute("listadoProfesores", lista);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/listadoProfesorHibernate.jsp");
		rd.forward(request, response);

	}

	// METODOS PARA AÑADIR DATOS A LA BD
	//
	// METOODO PARA AÑADIR ASIGNATURAS

	protected void addAsignaturas(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		com.academia.hibernate.Asignatura a = new Asignatura();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Nombre = request.getParameter("nombre");
		String Horario = request.getParameter("horario");
		String Aula = request.getParameter("aula");
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		a.setNombre(Nombre);
		a.setHorario(Horario);
		a.setAula(Aula);

		AsignaturaDAO dao = new AsignaturaDAO();
		try {
			dao.persist(a);
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha añadido correctamente la asignatura.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		com.academia.hibernate.Alumno alu = new com.academia.hibernate.Alumno();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		alu.setNombre(Nombre);
		alu.setApellidos(Apellidos);
		alu.setTelefono(Telefono);
		alu.setEmail(Email);

		AlumnoDAO dao = new AlumnoDAO();
		try {
			// INSERTAMOS EL NUEVO ALUMNO
			dao.persist(alu);
			String[] asignaturasSelect = request
					.getParameterValues("asignaturas");
			// RECORREMOS LAS ASIGNATURAS QUE SE LE VAN A ASOCIAR
			if (asignaturasSelect != null && asignaturasSelect.length > 0) {
				RelAlumnoAsignaturaDAO relDAO = null;
				AsignaturaDAO asigDAO = null;
				for (int i = 0; i < asignaturasSelect.length; i++) {
					String idAsignatura = asignaturasSelect[i];
					asigDAO = new AsignaturaDAO();
					// OBTENEMOS ASIGNATURA A PARTIR DE SU ID
					Asignatura a = asigDAO.findById(Integer
							.parseInt(idAsignatura));
					RelAlumnoAsignatura rel = new RelAlumnoAsignatura();
					rel.setAsignatura(a);
					rel.setAlumno(alu);
					relDAO = new RelAlumnoAsignaturaDAO();
					// INSERTAMOS RELACIÓN ENTRE ALUMNO Y ASIGNATURA
					relDAO.persist(rel);
				}
			}

			                             request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha añadido correctamente al alumno.");
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

		// CREAMOS INSTANCIA DE CLASE PROFESORES

		com.academia.hibernate.Profesor pro = new com.academia.hibernate.Profesor();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		pro.setNombre(Nombre);
		pro.setApellidos(Apellidos);
		pro.setTelefono(Telefono);
		pro.setEmail(Email);
		Integer idAsignatura = Integer.parseInt(request
				.getParameter("idasignatura"));
		AsignaturaDAO asigdao = new AsignaturaDAO();

		com.academia.hibernate.Asignatura asignatura = new Asignatura();
		asignatura = asigdao.findById(idAsignatura);
		pro.setAsignatura(asignatura);

		ProfesorDAO dao = new ProfesorDAO();

		try {
			// INSERTAMOS EL NUEVO PROFESOR
			dao.persist(pro);
			// RECORREMOS LAS ASIGNATURAS QUE SE LE VAN A ASOCIAR

			request.setAttribute("tabla", "profesores");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha añadido correctamente al profesor.");
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

	// METODOS QUE SE ENCARGAN DE RECOGER DATOS DE LA BD PARA MOSTRARLOS
	// EN LOS FORMULARIOS DE AÑADIR PROFESOR Y ALUMNO.

	protected void listarAsignaturasFormularioProfesor(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AsignaturaDAO dao = new AsignaturaDAO();
		List<Asignatura> lista = dao.findAll();

		request.setAttribute("asignaturas", lista);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/addProfesor.jsp");
		rd.forward(request, response);

	}

	protected void listarAsignaturasFormularioAlumno(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AsignaturaDAO dao = new AsignaturaDAO();
		List<Asignatura> lista = dao.findAll();

		request.setAttribute("asignaturas", lista);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/addAlumno.jsp");
		rd.forward(request, response);

	}

	// METODOS EDITAR LISTADOS

	// METODO EDITAR ALUMNO
	protected void editarAlumnos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		com.academia.hibernate.Alumno alumno = null;
		AlumnoDAO aluDAO = new AlumnoDAO();
		AsignaturaDAO asigDAO = new AsignaturaDAO();
		int idAlumno;
		RelAlumnoAsignaturaDAO rel = new RelAlumnoAsignaturaDAO();
		List<Asignatura> listaAsignaturas = null;
		List<RelAlumnoAsignatura> listaRelacion = null;

		try {

			// OBTENEMOS LA ID DEL ALUMNO DE LA TABLA EN LA JSP
			idAlumno = Integer.parseInt(request.getParameter("idalumno"));
			// LOCALIZAMOS AL ALUMNO EN BD GRACIAS A LA ID PROPORCIONADA
			alumno = aluDAO.findById(idAlumno);

			// OBTENEMOS UN LISTADO DE ASIGNATURAS CON EL METODO DAO
			listaAsignaturas = asigDAO.findAll();
			// RECOGEMOS LAS ASIGNATURAS RELACIONADAS CON EL ALUMNO

			listaRelacion = rel.listIdAlumno(idAlumno);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("alumno", alumno);
		request.setAttribute("relacion", listaRelacion);
		request.setAttribute("asignaturas", listaAsignaturas);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/editarAlumnoHibernate.jsp");
		rd.forward(request, response);

	}

	// METODO EDITAR PROFESOR

	protected void editarProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
		LOGGER.info("ID de profesor: " + request.getParameter("idprofesor"));

		com.academia.hibernate.Profesor pro = new com.academia.hibernate.Profesor();

		ProfesorDAO dao = new ProfesorDAO();
		List<com.academia.hibernate.Asignatura> listaAsignaturas = null;

		// request.getAttribute(arg0)
		try {

			pro = dao.findById(Integer.parseInt(request
					.getParameter("idprofesor")));
			AsignaturaDAO asigdao = new AsignaturaDAO();
			listaAsignaturas = asigdao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("asignaturas", listaAsignaturas);
		request.setAttribute("profesor", pro);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/editarProfesorHibernate.jsp");
		rd.forward(request, response);

	}

	// METODO EDITAR ASIGNATURA

	protected void editarAsignatura(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AsignaturaDAO dao = new AsignaturaDAO();
		com.academia.hibernate.Asignatura a = new Asignatura();
		try {
			a = dao.findById(Integer.parseInt(request
					.getParameter("idasignatura")));

			request.setAttribute("asignatura", a);

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/editarAsignatura.jsp");
			rd.forward(request, response);
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}

	}

	// METODOS PARA ACTUALIZAR EN LA BASE DE DATOS LAS TABLAS

	// METODO PARA ACTUALIZAR LA ASIGNATURA QUE ENTRA DEL FORM
	protected void actualizarAsignatura(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		com.academia.hibernate.Asignatura a = new Asignatura();
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

		AsignaturaDAO dao = new AsignaturaDAO();
		try {
			dao.merge(a);
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha actualizado correctamente la asignatura.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al insertar datos.");
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}

	}

	// METODO PARA ACTUALIZAR EL ALUMNO QUE ENTRA DEL FORM
	protected void actualizarAlumno(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// CREAMOS INSTANCIA DE CLASE ALUMNO
		com.academia.hibernate.Alumno al = null;
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Id = request.getParameter("idalumno");
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS

		try {
			AlumnoDAO aluDAO = new AlumnoDAO();
			al = aluDAO.findById(Integer.parseInt(Id));

			if (al != null) {
				al.setNombre(Nombre);
				al.setApellidos(Apellidos);
				al.setTelefono(Telefono);
				al.setEmail(Email);

				Set<com.academia.hibernate.RelAlumnoAsignatura> relacionesAntiguas = al
						.getRelAlumnoAsignaturas();

				aluDAO.merge(al);

				if (relacionesAntiguas != null) {
					Iterator it = relacionesAntiguas.iterator();
					RelAlumnoAsignaturaDAO dao = new RelAlumnoAsignaturaDAO();
					while (it.hasNext()) {
						com.academia.hibernate.RelAlumnoAsignatura relacion = (com.academia.hibernate.RelAlumnoAsignatura) it
								.next();
						dao.remove(relacion);
					}

					dao = null;
				}

				String[] asignaturasSelect = request
						.getParameterValues("asignaturas");

				if (asignaturasSelect != null && asignaturasSelect.length > 0) {
					RelAlumnoAsignaturaDAO dao = new RelAlumnoAsignaturaDAO();
					AsignaturaDAO asigDAO = null;
					for (int i = 0; i < asignaturasSelect.length; i++) {
						String idAsignatura = asignaturasSelect[i];
						asigDAO = new AsignaturaDAO();
						// OBTENEMOS ASIGNATURA A PARTIR DE SU ID
						Asignatura a = asigDAO.findById(Integer
								.parseInt(idAsignatura));
						RelAlumnoAsignatura rel = new RelAlumnoAsignatura();
						rel.setAsignatura(a);
						rel.setAlumno(al);
						dao = new RelAlumnoAsignaturaDAO();
						// INSERTAMOS RELACIÓN ENTRE ALUMNO Y ASIGNATURA
						dao.persist(rel);
					}
				}

			}

			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha editado correctamente al alumno.");

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

	// METODO PARA ACTUALIZAR EL ALUMNO QUE ENTRA DEL FORM
	protected void actualizarProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// CREAMOS INSTANCIA DE CLASE PROFESOR
		com.academia.hibernate.Profesor pro = new com.academia.hibernate.Profesor();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP
		String Id = request.getParameter("idprofesor");
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");
		String idAsignatura = request.getParameter("idasignatura");

		Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
		LOGGER.info("AsignaturaId: " + idAsignatura);
		// RELLENAMOS LA INSTANCIA CON LOS DATOS OBTENIDOS
		pro.setIdProfesor(Integer.parseInt(Id));
		pro.setNombre(Nombre);
		pro.setApellidos(Apellidos);
		pro.setTelefono(Telefono);
		pro.setEmail(Email);

		Integer idAsignatura1 = Integer.parseInt(idAsignatura);
		AsignaturaDAO asigdao = new AsignaturaDAO();

		com.academia.hibernate.Asignatura asignatura = new Asignatura();
		asignatura = asigdao.findById(idAsignatura1);
		pro.setAsignatura(asignatura);
		// p.setIdAsignatura(Integer.parseInt(Id));

		ProfesorDAO dao = new ProfesorDAO();
		try {

			dao.merge(pro);

			request.setAttribute("tabla", "profesores");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha editado correctamente al profesor.");

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

	// METODOS PARA BORRAR REGISTROS-----------------------------------
	// BORRAR ASIGNATURAS
	protected void borrarAsignatura(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			String Id = request.getParameter("idasignatura");
			AsignaturaDAO dao = new AsignaturaDAO();
			com.academia.hibernate.Asignatura a = dao.findById(Integer
					.parseInt(Id));

			Set<com.academia.hibernate.RelAlumnoAsignatura> relaciones = a
					.getRelAlumnoAsignaturas();

			if (relaciones != null) {
				Iterator it = relaciones.iterator();
				com.academia.hibernate.RelAlumnoAsignaturaDAO relDAO = new RelAlumnoAsignaturaDAO();
				while (it.hasNext()) {
					com.academia.hibernate.RelAlumnoAsignatura relacion = (com.academia.hibernate.RelAlumnoAsignatura) it
							.next();
					relDAO.remove(relacion);
				}
			}

			List<com.academia.hibernate.Profesor> listaProfesores = null;
			com.academia.hibernate.ProfesorDAO daoProf = new ProfesorDAO();
			listaProfesores = daoProf.listIdAsignatura(Integer.parseInt(Id));

			if (listaProfesores != null && listaProfesores.size() > 0) {
				// una vez teniendo la lista, para cada profesor actualizo su
				// asignatura
				com.academia.hibernate.Asignatura AsignaturaNinguna = new Asignatura();
				// primero recojo los datos de la asig ninguna
				AsignaturaNinguna = dao.findById(0);

				// Ahora recorro la lista de profesores y la actualizo
				for (int i = 0; i < listaProfesores.size(); i++) {
					listaProfesores.get(i).setAsignatura(AsignaturaNinguna);
					daoProf.merge(listaProfesores.get(i));
				}

			}

			// Ahora lo que queda es borrar la asignatura que queriamos borrar

			dao.remove(a);

			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha borrado correctamente la asignatura.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("tabla", "asignaturas");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al borrar datos.");
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}
	}

	// BORRAR PROFESOR
	protected void borrarProfesor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		com.academia.hibernate.Profesor pro = new com.academia.hibernate.Profesor();
		// OBTENEMOS LOS DATOS ENVIADOS POR POST DE LA JSP

		try {

			// CREAMOS LA VARIABLE DE PROFESOR Y LA LLAMAMOS POR EJ, PROFE

			// PASAMOS LA VARIABLE DE TIPO STRING A INT USANDO LA FUNCION
			// INTEGER.PARSEINT

			ProfesorDAO dao = new ProfesorDAO();
			pro = dao.findById(Integer.parseInt(request
					.getParameter("idprofesor")));
			dao.remove(pro);

			request.setAttribute("tabla", "profesores");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto",
					"Se ha borrado correctamente el profesor.");

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

	// BORRAR ALUMNO
	protected void borrarAlumno(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		com.academia.hibernate.Alumno alu = null;
		try {
		AlumnoDAO aluDAO = new AlumnoDAO();
		String Id = request.getParameter("idalumno");
		
		alu = aluDAO.findById(Integer.parseInt(Id));
		
				Set<com.academia.hibernate.RelAlumnoAsignatura> relacionesAntiguas = alu
				.getRelAlumnoAsignaturas();
				
		
		
		if (relacionesAntiguas != null) {
			Iterator it = relacionesAntiguas.iterator();
			RelAlumnoAsignaturaDAO dao = new RelAlumnoAsignaturaDAO();
			while (it.hasNext()) {
				com.academia.hibernate.RelAlumnoAsignatura relacion = (com.academia.hibernate.RelAlumnoAsignatura) it
						.next();
				dao.remove(relacion);
				}
			aluDAO.remove(alu);
		}
		request.setAttribute("tabla", "alumnos");
		request.setAttribute("accion", "listar");
		request.setAttribute("texto", "Se ha borrado correctamente al alumno.");

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/textoDinamico.jsp");
		rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("tabla", "alumnos");
			request.setAttribute("accion", "listar");
			request.setAttribute("texto", "Error al borrar datos.");
		}
	}

	// FUNCION QUE SE ENCARGA DE ANALIZAR LA BUSQUEDA
	protected void buscar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//Recogemos los parametros de la busqueda
		String t1=request.getParameter("T1");
		int iclase = Integer.parseInt(request.getParameter("clasesB"));
		int icampos = Integer.parseInt(request.getParameter("camposB"));
		RequestDispatcher rd = null;
		try {
			switch (iclase){
			case 0: //Profesor
				//creo objeto lista de tipo profesor y creo el dao
				List<com.academia.hibernate.Profesor> listaProf = null;
				ProfesorDAO daoProf = new ProfesorDAO();
				
				switch (icampos){
				case 0: //nombre
					//recogemos los datos de la busqueda
					listaProf = daoProf.findByNombre(t1);
					break;
				case 1: //apellidos
					listaProf = daoProf.findByApellidos(t1);
					break;
				case 2: //telefono
					listaProf = daoProf.findByTelefono(t1);
					break;
				case 3: //email
					listaProf = daoProf.findByEmail(t1);
					break;
				case 4: //asignatura
					listaProf = daoProf.findByAsignatura(t1);
					break;
				}
				if(listaProf != null && listaProf.size() > 0){
					request.setAttribute("listadoProfesores", listaProf);
					
					//paso de variables para mostrar en el buscador
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);					
					
					rd = request
							.getRequestDispatcher("/jsp/listadoProfesorHibernate.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);	
					request.setAttribute("texto", "No se han encontrado resultados.");
					
					rd = request
							.getRequestDispatcher("/jsp/textoDinamico.jsp");
					rd.forward(request, response);
				}
				
				break;
			case 1: //Asignatura
				//creo objeto lista de tipo asignatura y creo el dao
				List<com.academia.hibernate.Asignatura> listaAsig = null;
				AsignaturaDAO daoAsig = new AsignaturaDAO();
				
				switch (icampos){
				case 0: //nombre
					listaAsig = daoAsig.findByNombre(t1);
					break;
				case 1: //horario
					listaAsig = daoAsig.findByHorario(t1);
					break;
				case 2: //aula
					listaAsig = daoAsig.findByAula(t1);
					break;
				}
				if(listaAsig != null && listaAsig.size() > 0){
					request.setAttribute("listadoAsignatura", listaAsig);
					
					//paso de variables para mostrar en el buscador
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);	
	
					rd = request
							.getRequestDispatcher("/jsp/listadoAsignaturas.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);	
					request.setAttribute("texto", "No se han encontrado resultados.");
					
					rd = request
							.getRequestDispatcher("/jsp/textoDinamico.jsp");
					rd.forward(request, response);
				}
				break;
			case 2: //alumno
				//creo objeto lista de tipo asignatura y creo el dao
				List<com.academia.hibernate.Alumno> listaAlu = null;
				AlumnoDAO daoAlu = new AlumnoDAO();
				
				switch (icampos){
				case 0: //nombre
					listaAlu = daoAlu.findByNombre(t1);
					break;
				case 1: //apellidos
					listaAlu = daoAlu.findByApellidos(t1);
					break;
				case 2: //telefono
					listaAlu = daoAlu.findByTelefono(t1);
					break;
				case 3: //email
					listaAlu = daoAlu.findByEmail(t1);
					break;
				}
				if(listaAlu != null && listaAlu.size() > 0){
				request.setAttribute("listadoAlumnos", listaAlu);
				
				//paso de variables para mostrar en el buscador
				request.setAttribute("T1", t1);
				request.setAttribute("clasesB", iclase);
				request.setAttribute("camposB", icampos);	

				rd = request
						.getRequestDispatcher("/jsp/listadoAlumno.jsp");
				rd.forward(request, response);
				}else{
					request.setAttribute("T1", t1);
					request.setAttribute("clasesB", iclase);
					request.setAttribute("camposB", icampos);	
					request.setAttribute("texto", "No se han encontrado resultados.");
					
					rd = request
							.getRequestDispatcher("/jsp/textoDinamico.jsp");
					rd.forward(request, response);
				}
				
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// FUNCION PARA CONECTAR CON EL WEBSERVICE
	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("nombre");
		String password = request.getParameter("password");

		// Metodo usando RESTEasyClienPost
		// RESTEasyClientPost cliente = new RESTEasyClientPost();
		// Metodo usando HTTP request
		MiHttpPost cliente = new MiHttpPost();

		cliente.setDatos(usuario, password);

		cliente.conectar();

		if (cliente.getEstado()) {
			// entramos aqui si el servidor devuelve codigo 200, todo correcto.
			Usuario usuarioLogueado = cliente.getUsuario();

			Usuario user = new Usuario();
			user.setId(usuarioLogueado.getId());
			user.setFechaUltimoLogin(usuarioLogueado.getFechaUltimoLogin());

			// CREAMOS UNA VARIABLE SESSION
			HttpSession session = request.getSession(true);

			session.setAttribute("UsuarioLogueado", usuarioLogueado);

			// actualizamos la fecha de logueo a la actual
			Date a = new Date();
			user.setFechaUltimoLogin(a);
			// enviamos la peticion de actualizar

			cliente.actualizar(user);

			if (!cliente.getEstado()) {
				System.out.println("Error actualizando fecha");
			}

			// Lo siguiente comentado es como recogeriamos la variable para
			// usarla.
			// Usuario usuario2 = (Usuario)
			// session.getAttribute("UsuarioLogueado");

			// redirigimos al indice
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/index.jsp");
			rd.forward(request, response);
		} else {
			// si el usuario es incorrecto, mostramos error
			request.setAttribute("tabla", "");
			request.setAttribute("texto", "Usuario incorrecto.");

			RequestDispatcher rd = request
					.getRequestDispatcher("/jsp/textoDinamico.jsp");
			rd.forward(request, response);
		}

	}

}
