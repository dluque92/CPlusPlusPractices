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

import com.academia.bd.BDAccess;
import com.academia.hibernate.Alumno;
import com.academia.hibernate.AlumnoDAO;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.Profesor;
import com.academia.hibernate.ProfesorDAO;

// COGEMOS EL IMPORT DE acaademia_WebService

/**
 * Servlet implementation class Academia
 */

@WebServlet("/AcademiaHibernate")
public class AcademiaHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademiaHibernate() {
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
				String user = request.getParameter("c");
				String password = request.getParameter("1");

				// int responseCode = connectToWS(url, user, password);
				int responseCode = connectToWSWithApache(url, user, password);

				if (responseCode == 200) {
					request.setAttribute("user", user);
					rd = request
							.getRequestDispatcher("jsp/hibernate/hibernateIndex.jsp");
				} else {
					rd = request
							.getRequestDispatcher("jsp/hibernate/hibernateError.jsp");
				}

				// ASIGNATURAS
			} else if (modo.equals("1")) {
				// OBTENEMOS LISTA
				AsignaturaDAO dao = new AsignaturaDAO();
				listaAsignatura = dao.findAll();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaListado.jsp");
			} else if (modo.equals("2")) {
				// OBTENEMOS ASIGNATURA POR ID
				AsignaturaDAO dao = new AsignaturaDAO();
				com.academia.hibernate.Asignatura asig = dao.findById(Integer
						.parseInt(busqueda));
				List<com.academia.hibernate.Asignatura> lista = new ArrayList<com.academia.hibernate.Asignatura>();
				lista.add(asig);
				request.setAttribute("listaAsignatura", lista);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaListado.jsp");
			} else if (modo.equals("3")) {
				// OBTENEMOS ASIGNATURA POR NOMBRE
				AsignaturaDAO dao = new AsignaturaDAO();
				listaAsignatura = dao.findByNombre(busqueda);
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaListado.jsp");
			} else if (modo.equals("4")) {
				// OBTENEMOS ASIGNATURA POR HORARIO
				AsignaturaDAO dao = new AsignaturaDAO();
				listaAsignatura = dao.findByHorario(busqueda);
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaListado.jsp");
			} else if (modo.equals("5")) {
				// OBTENEMOS ASIGNATURA POR AULA
				AsignaturaDAO dao = new AsignaturaDAO();
				listaAsignatura = dao.findByAula(busqueda);
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaListado.jsp");
			} else if (modo.equals("6")) {
				// OBTENEMOS LISTA Y BORRAMOS
				String id = request.getParameter("idAsignatura");
				int idAsignatura = Integer.valueOf(id);
				System.out.print("------------>: " + idAsignatura);
				AsignaturaDAO dao = new AsignaturaDAO();
				com.academia.hibernate.Asignatura asig = dao.findById(Integer
						.parseInt(id));
				dao.remove(asig);
				listaAsignatura = dao.findAll();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaAdministrar.jsp");
			} else if (modo.equals("7")) {
				// OBTENEMOS LISTA Y EDITAMOS
				String id = request.getParameter("idAsignatura");
				int idAsignatura = Integer.valueOf(id);
				System.out.print("------------>: " + idAsignatura);
				AsignaturaDAO dao = new AsignaturaDAO();
				com.academia.hibernate.Asignatura asig = dao.findById(Integer
						.parseInt(id));
				listaAsignatura = dao.findAll();
				request.setAttribute("listaAsignatura", listaAsignatura);
				request.setAttribute("asignaturaEditar", asig);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaEditar.jsp");
			} else if (modo.equals("8")) {
				// OBTENEMOS LISTA Y AÑADIMOS
				AsignaturaDAO dao = new AsignaturaDAO();
				String id = request.getParameter("idAsignatura");
				String nombre = request.getParameter("nombre");
				String horario = request.getParameter("horario");
				String aula = request.getParameter("aula");
				com.academia.hibernate.Asignatura asig = new com.academia.hibernate.Asignatura();
				asig.setNombre(nombre);
				asig.setHorario(horario);
				asig.setAula(aula);
				dao.merge(asig);
				listaAsignatura = dao.findAll();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaAdministrar.jsp");
			} else if (modo.equals("9")) {
				// OBTENEMOS LISTA
				AsignaturaDAO dao = new AsignaturaDAO();
				listaAsignatura = dao.findAll();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaAdministrar.jsp");
			} else if (modo.equals("10")) {
				// GUARDAR CAMBIOS DE EDITAR
				AsignaturaDAO dao = new AsignaturaDAO();
				String id = request.getParameter("idAsignatura");
				String nombre = request.getParameter("nombre");
				String horario = request.getParameter("horario");
				String aula = request.getParameter("aula");
				com.academia.hibernate.Asignatura asig = dao.findById(Integer
						.parseInt(id));
				asig.setIdAsignatura(Integer.valueOf(id));
				asig.setNombre(nombre);
				asig.setHorario(horario);
				asig.setAula(aula);
				dao.merge(asig);
				listaAsignatura = dao.findAll();
				request.setAttribute("listaAsignatura", listaAsignatura);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAsignaturaAdministrar.jsp");

				// PROFESORES

			} else if (modo.equals("11")) {
				// OBTENEMOS LISTA
				ProfesorDAO dao = new ProfesorDAO();
				listaProfesor = dao.findAll();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorListado.jsp");
			} else if (modo.equals("12")) {
				// OBTENEMOS PROFESOR POR ID
				ProfesorDAO dao = new ProfesorDAO();
				com.academia.hibernate.Profesor profe = dao.findById(Integer
						.parseInt(busqueda));
				List<com.academia.hibernate.Profesor> lista = new ArrayList<com.academia.hibernate.Profesor>();
				lista.add(profe);
				request.setAttribute("listaProfesor", lista);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorListado.jsp");
			} else if (modo.equals("13")) {
				// OBTENEMOS PROFESOR POR NOMBRE
				ProfesorDAO dao = new ProfesorDAO();
				listaProfesor = dao.findByNombre(busqueda);
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorListado.jsp");
			} else if (modo.equals("14")) {
				// OBTENEMOS PROFESOR POR APELLIDOS
				ProfesorDAO dao = new ProfesorDAO();
				listaProfesor = dao.findByApellidos(busqueda);
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorListado.jsp");
			} else if (modo.equals("15")) {
				// OBTENEMOS PROFESOR POR TELEFONO
				ProfesorDAO dao = new ProfesorDAO();
				listaProfesor = dao.findByTelefono(busqueda);
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorListado.jsp");
			} else if (modo.equals("16")) {
				// OBTENEMOS LISTA Y BORRAMOS
				String id = request.getParameter("idProfesor");
				int idProfesor = Integer.valueOf(id);
				System.out.print("------------>: " + idProfesor);
				ProfesorDAO dao = new ProfesorDAO();
				com.academia.hibernate.Profesor profe = dao.findById(Integer
						.parseInt(id));
				dao.remove(profe);
				listaProfesor = dao.findAll();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorAdministrar.jsp");
			} else if (modo.equals("17")) {
				// OBTENEMOS LISTA Y EDITAMOS
				String id = request.getParameter("idProfesor");
				int idProfesor = Integer.valueOf(id);
				System.out.print("------------>: " + idProfesor);
				ProfesorDAO dao = new ProfesorDAO();
				com.academia.hibernate.Profesor profe = dao.findById(Integer
						.parseInt(id));
				listaProfesor = dao.findAll();
				request.setAttribute("listaProfesor", listaProfesor);
				request.setAttribute("profesorEditar", profe);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorEditar.jsp");
			} else if (modo.equals("18")) {
				// OBTENEMOS LISTA Y AÑADIMOS
				ProfesorDAO dao = new ProfesorDAO();
				String id = request.getParameter("idProfesor");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				String idasignatura = request.getParameter("idAsignatura");
				com.academia.hibernate.Profesor p = new com.academia.hibernate.Profesor();
				p.setNombre(nombre);
				p.setApellidos(apellidos);
				p.setTelefono(telefono);
				p.setEmail(email);
				AsignaturaDAO asigDAO = new AsignaturaDAO();
				com.academia.hibernate.Asignatura a = asigDAO.findById(Integer
						.valueOf(idasignatura));
				p.setAsignatura(a);
				dao.merge(p);
				listaProfesor = dao.findAll();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorAdministrar.jsp");
			} else if (modo.equals("19")) {
				// OBTENEMOS LISTA
				ProfesorDAO dao = new ProfesorDAO();
				listaProfesor = dao.findAll();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorAdministrar.jsp");
			} else if (modo.equals("20")) {
				// GUARDAR CAMBIOS DE EDITAR
				ProfesorDAO dao = new ProfesorDAO();
				String id = request.getParameter("idProfesor");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String email = request.getParameter("email");
				String idasignatura = request.getParameter("idAsignatura");
				com.academia.hibernate.Profesor p = dao.findById(Integer.parseInt(id));
				p.setIdProfesor(Integer.valueOf(id));
				p.setNombre(nombre);
				p.setApellidos(apellidos);
				p.setEmail(email);
				AsignaturaDAO asigDAO = new AsignaturaDAO();
				com.academia.hibernate.Asignatura a = asigDAO.findById(Integer.valueOf(idasignatura));
				p.setAsignatura(a);
				dao.merge(p);
				listaProfesor = dao.findAll();
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorAdministrar.jsp");

			} else if (modo.equals("21")) {
				// OBTENEMOS PROFESOR POR EMAIL
				ProfesorDAO dao = new ProfesorDAO();
				listaProfesor = dao.findByEmail(busqueda);
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorListado.jsp");
			} else if (modo.equals("22")) {
				// OBTENEMOS PROFESOR POR IDASIGNATURA
				ProfesorDAO dao = new ProfesorDAO();
				listaProfesor = dao.findByIdAsignatura(Integer
						.parseInt(busqueda));
				request.setAttribute("listaProfesor", listaProfesor);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateProfesorListado.jsp");

				// *********************************************************
				// ***************** PARTE DE ALUMNO ***********************
				// *********************************************************

			} else if (modo.equals("23")) {
				// OBTENEMOS LISTA
				AlumnoDAO dao = new AlumnoDAO();
				listaAlumno = dao.findAll();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoListado.jsp");
			} else if (modo.equals("24")) {
				// OBTENEMOS ALUMNO POR ID
				AlumnoDAO dao = new AlumnoDAO();
				com.academia.hibernate.Alumno alu = dao.findById(Integer
						.parseInt(busqueda));
				List<com.academia.hibernate.Alumno> lista = new ArrayList<com.academia.hibernate.Alumno>();
				lista.add(alu);
				request.setAttribute("listaAlumno", lista);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoListado.jsp");
			} else if (modo.equals("25")) {
				// OBTENEMOS ALUMNO POR NOMBRE
				AlumnoDAO dao = new AlumnoDAO();
				listaAlumno = dao.findByNombre(busqueda);
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoListado.jsp");
			} else if (modo.equals("26")) {
				// OBTENEMOS ALUMNO POR APELLIDOS
				AlumnoDAO dao = new AlumnoDAO();
				listaAlumno = dao.findByApellidos(busqueda);
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoListado.jsp");
			} else if (modo.equals("27")) {
				// OBTENEMOS ALUMNO POR TELEFONO
				AlumnoDAO dao = new AlumnoDAO();
				listaAlumno = dao.findByTelefono(busqueda);
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoListado.jsp");
			} else if (modo.equals("28")) {
				// OBTENEMOS LISTA Y BORRAMOS
				String id = request.getParameter("idAlumno");
				int idAlumno = Integer.valueOf(id);
				System.out.print("------------>: " + idAlumno);
				AlumnoDAO dao = new AlumnoDAO();
				com.academia.hibernate.Alumno alu = dao.findById(Integer.parseInt(id));
				dao.remove(alu);
				listaAlumno = dao.findAll();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoAdministrar.jsp");
			} else if (modo.equals("29")) {
				// OBTENEMOS LISTA Y EDITAMOS
				String id = request.getParameter("idAlumno");
				int idAlumno = Integer.valueOf(id);
				System.out.print("------------>: " + idAlumno);
				AlumnoDAO dao = new AlumnoDAO();
				listaAlumno = dao.findAll();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoAdministrar.jsp");
				com.academia.hibernate.Alumno alu = dao.findById(Integer.parseInt(id));
				listaAlumno = dao.findAll();
				request.setAttribute("listaAlumno", listaAlumno);
				request.setAttribute("alumnoEditar", alu);
				rd = request.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoEditar.jsp");
			} else if (modo.equals("30")) {
				// OBTENEMOS LISTA Y AÑADIMOS
				AlumnoDAO dao = new AlumnoDAO();
				String id = request.getParameter("idAlumno");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				com.academia.hibernate.Alumno a = new com.academia.hibernate.Alumno();
				a.setNombre(nombre);
				a.setApellidos(apellidos);
				a.setTelefono(telefono);
				a.setEmail(email);
				dao.merge(a);
				listaAlumno = dao.findAll();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoAdministrar.jsp");
			} else if (modo.equals("31")) {
				// OBTENEMOS LISTA
				AlumnoDAO dao = new AlumnoDAO();
				listaAlumno = dao.findAll();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoAdministrar.jsp");
			} else if (modo.equals("32")) {
				// GUARDAR CAMBIOS DE EDITAR
				AlumnoDAO dao = new AlumnoDAO();
				String id = request.getParameter("idAlumno");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				com.academia.hibernate.Alumno a = dao.findById(Integer
						.parseInt(id));
				a.setIdAlumno(Integer.valueOf(id));
				a.setNombre(nombre);
				a.setApellidos(apellidos);
				a.setTelefono(telefono);
				a.setEmail(email);
				dao.merge(a);
				listaAlumno = dao.findAll();
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoAdministrar.jsp");
			} else if (modo.equals("33")) {
				// OBTENEMOS ALUMNO POR EMAIL
				AlumnoDAO dao = new AlumnoDAO();
				listaAlumno = dao.findByEmail(busqueda);
				request.setAttribute("listaAlumno", listaAlumno);
				rd = request
						.getRequestDispatcher("/jsp/hibernate/hibernateAlumnoListado.jsp");
				// Y AHORA CERRAMOS EL CORCHETE DEL ELSE IF
			}
			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Asignatura asig() {
		// TODO Auto-generated method stub
		return null;
	}

	private String String(String busqueda) {
		// TODO Auto-generated method stub
		return null;
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