import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerlvetPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPrueba() {
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

		// OBTENEMOS LOS PARÁMETROS QUE NOS ENVIAN POR LA REQUEST
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		// COMPROBAMOS QUE LOS VALORES DE LOS PARÁMETROS SEAN LOS ESPERADOS
		if (nombre.equals("Cesar") && password.equals("12345")) {
			// LOGIN CORRECTO
			// CREAMOS UNA RESPUESTA DINAMICAMENTE
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html><body>");
			pw.println("Bienvenido usuario " + nombre);
			pw.println("</body></html>");
			pw.close();
		} else {
			// LOGIN INCORRECTO
			// REDIRECCIONAMOS A UNA JSP QUE YA HABIAMOS CREADO ANTES
			response.sendRedirect("error.jsp");
		}

	}

}
