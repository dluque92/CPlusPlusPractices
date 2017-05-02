import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

		// OBTENEMOS LOS PARÁMETROS QUE NOS ENVIAN DESDE EL FORMULARIO DE
		// INDEX.JSP
		// EL PRIMERO ES EL NOMBRE, QUE SE RECOGE DE UN CAMPO TEXTO
		// EL SEGUNDO ES UN CAMPO OCULTO PARA ESPECIFICAR EL TIPO DE EJECUCIÓN
		String nombre = request.getParameter("nombre");
		String modo = request.getParameter("modo");

		// COMPROBAMOS QUE LOS PARÁMETROS SEA NO NULOS
		if (modo != null) {
			if (nombre != null) {
				// SI ES MODO 1, REDIRECCIONAREMOS Y PASAREMOS EL VALOR
				// A TRAVÉS DE LA REQUEST
				if (modo.equals("1")) {
					// COLOCAMOS EL ATRIBUTO EN LA REQUEST PARA PODER
					// OBTENERLO LUEGO EN LA JSP A LA QUE REDIRECCIONAMOS
					request.setAttribute("nombreObtenido", nombre);
					// REDIRECCIONAMOS A OTRA JSP
					getServletConfig().getServletContext()
							.getRequestDispatcher("/welcome.jsp")
							.forward(request, response);

					// SI ES MODO 2, CREAMOS LA RESPUESTA DINÁMICAMENTE
				} else if (modo.equals("2")) {
					// INDICAMOS QUE VAMOS A CONSTRUIR UNA RESPUESTA EN FORMA DE
					// HTML
					response.setContentType("text/html");
					// OBJENEMOS EL OBJETO PARA ESCRIBIR ESE HTML DINAMICAMENTE
					PrintWriter pw = response.getWriter();
					// VAMOS CREANDO EL HTML LÍNEA A LÍNEA
					pw.println("<html><body>");
					pw.println("Usando PrintWritter para generar una pagina dinamicamente:<br>");
					// AÑADIMOS EL CAMPO QUE NOS ENVIARON POR EL FORMULARIO
					pw.println("Bienvenido usuario " + nombre);
					pw.println("</body></html>");
					// IMPORTANTE: CERRAR EL OBJETO PRINTWRITTER
					pw.close();
				}
			}
		}
	}

}
