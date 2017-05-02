import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.Alumno;

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
		List listaAlumnos = null;
		Alumno alumno = null;

		try {
			// OBTENEMOS LA LISTA DE BD
			// CREMOS EL OBJETO QUE GESTIONA EL ACCESO A BD
			DBAccess db = new DBAccess();
			// CONECTAMOS CON LA BD
			db.connect();

			// LANZAMOS LA CONSULTA A BD PARA OBTENER LA LISTA DE ALUMNOS
			// listaAlumnos = db.obtenerListadoAlumnos();

			alumno = db.obtenerAlumnosPorId(3);

			// CERRAMOS LA CONEXION CON LA BD
			db.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// request.setAttribute("listaAlumnos", listaAlumnos);

		request.setAttribute("alumno", alumno);
//		RequestDispatcher rd = request
//				.getRequestDispatcher("/listadoAlumnos.jsp");
		RequestDispatcher rd = request
				.getRequestDispatcher("/datosAlumno.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
