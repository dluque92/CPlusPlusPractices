package com.academia.servlet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.academia.bd.Alumno;
import com.academia.bd.Asignatura;
import com.academia.bd.BDAccess;
import com.academia.bd.Profesor;
import com.academia.hibernate.AsignaturaDAO;

// COGEMOS EL IMPORT DE acaademia_WebService

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
		List listaAsignatura = null;
		Asignatura asignatura = null;

		List listaProfesor = null;
		Profesor profesor = null;

		// Creamos la lista de alumno
		List listaAlumno = null;
		Profesor alumno = null;

		RequestDispatcher rd = null;

		try {
			String modo = request.getParameter("modo");
			String busqueda = request.getParameter("busqueda");

			BDAccess db = new BDAccess();
			db.connect();
			// HACEMOS LOGIN
			if (modo.equals("0")) {
				// OBTENEMOS LISTA
				String url = "http://localhost:8080/Academia_WebService/webservice/login";
				String user = request.getParameter("user");
				String password = request.getParameter("password");

//				int responseCode = connectToWS(url, user, password);
				int responseCode = connectToWSWithApache(url, user, password);

				if (responseCode == 200) {
					rd = request.getRequestDispatcher("jsp/index.jsp");
				} else {
					rd = request.getRequestDispatcher("jsp/error.jsp");
				}

				// ASIGNATURAS
			} else if (modo.equals("1")) {
				// OBTENEMOS LISTA
				listaAsignatura = db.obtenerListadoAsignaturas();
				// OBTENEMOS LISTA
				listaAsignatura = db.obtenerListadoAsignaturas();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request.getRequestDispatcher("/jsp/asignaturaListado.jsp");
			} else if (modo.equals("2")) {
				// OBTENEMOS ASIGNATURA POR ID
				listaAsignatura = db.obtenerAsignaturaPorId(Integer
						.valueOf(busqueda));
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request.getRequestDispatcher("/jsp/asignaturaListado.jsp");
			} else if (modo.equals("3")) {
				// OBTENEMOS ASIGNATURA POR NOMBRE
				listaAsignatura = db.obtenerAsignaturaPorNombre(String
						.valueOf(busqueda));
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request.getRequestDispatcher("/jsp/asignaturaListado.jsp");
			} else if (modo.equals("4")) {
				// OBTENEMOS ASIGNATURA POR HORARIO
				listaAsignatura = db.obtenerAsignaturaPorHorario(String
						.valueOf(busqueda));
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request.getRequestDispatcher("/jsp/asignaturaListado.jsp");
			} else if (modo.equals("5")) {
				// OBTENEMOS ASIGNATURA POR AULA
				listaAsignatura = db.obtenerAsignaturaPorAula(String
						.valueOf(busqueda));
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request.getRequestDispatcher("/jsp/asignaturaListado.jsp");
			} else if (modo.equals("6")) {
				// OBTENEMOS LISTA Y BORRAMOS
				String id = request.getParameter("idAsignatura");
				int idAsignatura = Integer.valueOf(id);
				System.out.print("------------>: " + idAsignatura);
				db.borrarAsignatura(idAsignatura);
				db.connect();
				listaAsignatura = db.obtenerListadoAsignaturas();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/asignaturaAdministrar.jsp");
			} else if (modo.equals("7")) {
				// OBTENEMOS LISTA Y EDITAMOS
				String idAsignatura = request.getParameter("idAsignatura");
				Asignatura asig = db.obtenerAsigPorId(Integer
						.valueOf(idAsignatura));
				listaAsignatura = db.obtenerListadoAsignaturas();
				request.setAttribute("listaAsignatura", listaAsignatura);
				request.setAttribute("asignaturaEditar", asig);
				rd = request.getRequestDispatcher("/jsp/asignaturaEditar.jsp");
			} else if (modo.equals("8")) {
				// OBTENEMOS LISTA Y AÑADIMOS
				String id = request.getParameter("idAsignatura");
				String nombre = request.getParameter("nombre");
				String horario = request.getParameter("horario");
				String aula = request.getParameter("aula");
				Asignatura a = new Asignatura();
				a.setNombre(nombre);
				a.setHorario(horario);
				a.setAula(aula);
				db.connect();
				db.anyadirAsignatura(a);
				db.connect();
				listaAsignatura = db.obtenerListadoAsignaturas();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/asignaturaAdministrar.jsp");
			} else if (modo.equals("9")) {
				// OBTENEMOS LISTA
				listaAsignatura = db.obtenerListadoAsignaturas();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/asignaturaAdministrar.jsp");
			} else if (modo.equals("10")) {
				// GUARDAR CAMBIOS DE EDITAR
				String id = request.getParameter("idAsignatura");
				String nombre = request.getParameter("nombre");
				String horario = request.getParameter("horario");
				String aula = request.getParameter("aula");
				Asignatura a = new Asignatura();
				a.setIdAsignatura(Integer.valueOf(id));
				a.setNombre(nombre);
				a.setHorario(horario);
				a.setAula(aula);
				db.connect();
				db.editarAsignatura(a);
				db.connect();
				listaAsignatura = db.obtenerListadoAsignaturas();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/asignaturaAdministrar.jsp");

				// PROFESORES
			} else if (modo.equals("11")) {
				// OBTENEMOS LISTA
				listaProfesor = db.obtenerListadoProfesores();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request.getRequestDispatcher("/jsp/profesorListado.jsp");
			} else if (modo.equals("12")) {
				// OBTENEMOS PROFESOR POR ID
				listaProfesor = db.obtenerProfesorPorId(Integer
						.valueOf(busqueda));
				request.setAttribute("listaProfesor", profesor);
				rd = request.getRequestDispatcher("/jsp/profesorBuscar.jsp");
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request.getRequestDispatcher("/jsp/profesorListado.jsp");
			} else if (modo.equals("13")) {
				// OBTENEMOS PROFESOR POR NOMBRE
				listaProfesor = db.obtenerProfesorPorNombre(String
						.valueOf(busqueda));
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request.getRequestDispatcher("/jsp/profesorListado.jsp");
			} else if (modo.equals("14")) {
				// OBTENEMOS PROFESOR POR APELLIDO
				listaProfesor = db.obtenerProfesorPorApellidos(String
						.valueOf(busqueda));
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request.getRequestDispatcher("/jsp/profesorListado.jsp");
			} else if (modo.equals("15")) {
				// OBTENEMOS PROFESOR POR TELEFONO
				listaProfesor = db.obtenerProfesorPorTelefono(String
						.valueOf(busqueda));
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request.getRequestDispatcher("/jsp/profesorListado.jsp");
			} else if (modo.equals("16")) {
				// OBTENEMOS LISTA Y BORRAMOS
				String idP = request.getParameter("idProfesor");
				int idProfesor = Integer.valueOf(idP);
				System.out.print("------------>: " + idProfesor);
				db.borrarProfesor(idProfesor);
				db.connect();
				listaProfesor = db.obtenerListadoProfesores();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/profesorAdministrar.jsp");
			} else if (modo.equals("17")) {
				// OBTENEMOS LISTA Y EDITAMOS
				String idProfesor = request.getParameter("idProfesor");
				Profesor profe = db.obtenerProfePorId(Integer
						.valueOf(idProfesor));
				listaProfesor = db.obtenerListadoProfesores();
				request.setAttribute("listaProfesor", listaProfesor);
				request.setAttribute("profesorEditar", profe);
				rd = request.getRequestDispatcher("/jsp/profesorEditar.jsp");
			} else if (modo.equals("18")) {
				// OBTENEMOS LISTA Y AÑADIMOS
				String id = request.getParameter("idProfesor");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				String idAsignatura = request.getParameter("idAsignatura");
				Profesor p = new Profesor();
				p.setNombre(nombre);
				p.setApellidos(apellidos);
				p.setTelefono(telefono);
				p.setEmail(email);
				p.setIdAsignatura(Integer.valueOf(idAsignatura));
				db.connect();
				db.anyadirProfesor(p);
				db.connect();
				listaProfesor = db.obtenerListadoProfesores();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/profesorAdministrar.jsp");
			} else if (modo.equals("19")) {
				// OBTENEMOS LISTA
				listaProfesor = db.obtenerListadoProfesores();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/profesorAdministrar.jsp");
			} else if (modo.equals("20")) {
				// GUARDAR CAMBIOS DE EDITAR
				String id = request.getParameter("idProfesor");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				String idAsignatura = request.getParameter("idAsignatura");
				Profesor p = new Profesor();
				p.setIdProfesor(Integer.valueOf(id));
				p.setNombre(nombre);
				p.setApellidos(apellidos);
				p.setTelefono(telefono);
				p.setEmail(email);
				p.setIdAsignatura(Integer.valueOf(idAsignatura));
				db.connect();
				db.editarProfesor(p);
				db.connect();
				listaProfesor = db.obtenerListadoProfesores();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/profesorAdministrar.jsp");
			} else if (modo.equals("21")) {
				// OBTENEMOS PROFESOR POR EMAIL
				listaProfesor = db.obtenerProfesorPorEmail(String
						.valueOf(busqueda));
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request.getRequestDispatcher("/jsp/profesorListado.jsp");
			} else if (modo.equals("22")) {
				// OBTENEMOS PROFESOR POR IDASIGNATURA
				listaProfesor = db.obtenerProfesorPorIdAsignatura(String
						.valueOf(busqueda));
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request.getRequestDispatcher("/jsp/profesorListado.jsp");

				// *********************************************************
				// ***************** PARTE DE ALUMNO ***********************
				// *********************************************************

			} else if (modo.equals("23")) {
				// OBTENEMOS LISTA
				listaAlumno = db.obtenerListadoAlumno();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoListado.jsp");
			} else if (modo.equals("24")) {
				// OBTENEMOS ALUMNO POR ID
				listaAlumno = db.obtenerAlumnoPorId(Integer.valueOf(busqueda));
				request.setAttribute("listaAlumno", alumno);
				rd = request.getRequestDispatcher("/jsp/alumnoBuscar.jsp");
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoListado.jsp");
			} else if (modo.equals("25")) {
				// OBTENEMOS ALUMNO POR NOMBRE
				listaAlumno = db.obtenerAlumnoPorNombre(String
						.valueOf(busqueda));
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoListado.jsp");
			} else if (modo.equals("26")) {
				// OBTENEMOS ALUMNO POR APELLIDO
				listaAlumno = db.obtenerAlumnoPorApellidos(String
						.valueOf(busqueda));
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoListado.jsp");
			} else if (modo.equals("27")) {
				// OBTENEMOS ALUMNO POR TELEFONO
				listaAlumno = db.obtenerAlumnoPorTelefono(String
						.valueOf(busqueda));
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoListado.jsp");
			} else if (modo.equals("28")) {
				// OBTENEMOS LISTA Y BORRAMOS
				String idP = request.getParameter("idAlumno");
				int idAlumno = Integer.valueOf(idP);
				System.out.print("------------>: " + idAlumno);
				db.borrarAlumno(idAlumno);
				db.connect();
				listaAlumno = db.obtenerListadoAlumno();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoAdministrar.jsp");
			} else if (modo.equals("29")) {
				// OBTENEMOS LISTA Y EDITAMOS
				String idAlumno = request.getParameter("idAlumno");
				Alumno alu = db.obtenerAluPorId(Integer.valueOf(idAlumno));
				listaAlumno = db.obtenerListadoAlumno();
				request.setAttribute("listaAlumno", listaAlumno);
				request.setAttribute("alumnoEditar", alu);
				rd = request.getRequestDispatcher("/jsp/alumnoEditar.jsp");
			} else if (modo.equals("30")) {
				// OBTENEMOS LISTA Y AÑADIMOS
				String id = request.getParameter("idAlumno");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				Alumno a = new Alumno();
				a.setNombre(nombre);
				a.setApellidos(apellidos);
				a.setTelefono(telefono);
				a.setEmail(email);
				db.connect();
				db.anyadirAlumno(a);
				db.connect();
				listaAlumno = db.obtenerListadoAlumno();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoAdministrar.jsp");
			} else if (modo.equals("31")) {
				// OBTENEMOS LISTA
				listaAlumno = db.obtenerListadoAlumno();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoAdministrar.jsp");
			} else if (modo.equals("32")) {
				// GUARDAR CAMBIOS DE EDITAR
				String id = request.getParameter("idAlumno");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				Alumno a = new Alumno();
				a.setIdAlumno(Integer.valueOf(id));
				a.setNombre(nombre);
				a.setApellidos(apellidos);
				a.setTelefono(telefono);
				a.setEmail(email);
				db.connect();
				db.editarAlumno(a);
				db.connect();
				listaAlumno = db.obtenerListadoAlumno();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoAdministrar.jsp");
			} else if (modo.equals("33")) {
				// OBTENEMOS ALUMNO POR EMAIL
				listaAlumno = db
						.obtenerAlumnoPorEmail(String.valueOf(busqueda));
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/alumnoListado.jsp");

				// Y AHORA CERRAMOS EL CORCHETE DEL ELSE IF
			}
			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int connectToWS(String url, String user, String password) {
		int responseCode = 0;
		try {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			String urlParameters = "user=" + user + "&password=" + password;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			responseCode = con.getResponseCode();

			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return responseCode;

	}

	private int connectToWSWithApache(String url, String user, String password) {
		int responseCode = 0;
		try {

			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);

			// add header
			post.setHeader("User-Agent", "Mozilla/5.0");

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("user", user));
			urlParameters.add(new BasicNameValuePair("password", password));

			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = client.execute(post);
			responseCode = response.getStatusLine().getStatusCode();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseCode;

	}
}