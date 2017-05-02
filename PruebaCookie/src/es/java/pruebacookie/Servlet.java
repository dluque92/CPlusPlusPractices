package es.java.pruebacookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// RECOGEMOS LOS PARÁMETROS QUE NOS LLEGAN POR LA REQUEST Y QUE NOS
		// ENVIAN DESDE EL FORMULARIO
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String oculto = request.getParameter("oculto");

		if (oculto != null && oculto.equals("oculto")) {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals("nombre")) {
					System.out.println("Valor de la cookie: " + c.getValue());
				}
			}

		}

		// COMPROBAMOS SI EL NOMBRE Y PASSWORD SON UNOS CONCRETOS
		if (nombre != null && password != null) {
			if (nombre.equals("Cesar") && (password.equals("12345"))) {
				// COMO EL PASSWORD Y EL NOMBRE SI SON LOS ESPERADOS, METEMOS EL
				// NOMBRE
				// DE USUARIO EN UNA COOKIE

				Cookie cookie = new Cookie("nombre", nombre);
				// ESTABLECEMOS LA CADUCIDAD DE LA COOKIE A 5 SEGUNDOS
				cookie.setMaxAge(5);
				// AÑADIMOS LA COOKIE A LA RESPUESTA DEL SERVLET
				response.addCookie(cookie);
				response.sendRedirect("jsp/bienvenido.jsp");

			} else {
				// COMO EL PASSWORD Y EL NOMBRE NO SON LOS ESPERADOS,
				// REDIRECCIONAMOS
				// A UNA PAGINA DE ERROR
				response.sendRedirect("jsp/error.jsp");
			}
		}
	}

}
