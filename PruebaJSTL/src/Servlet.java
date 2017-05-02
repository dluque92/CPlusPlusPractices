

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List listaAlumnos = new ArrayList<Alumno>();
		
		Alumno a1 = new Alumno();
		a1.setNombre("Pepe");
		a1.setApellidos("Pérez García");
		a1.setEdad(24);
		
		Alumno a2 = new Alumno();
		a2.setNombre("María");
		a2.setApellidos("Santos Ramírez");
		a2.setEdad(19);
		
		Alumno a3 = new Alumno();
		a3.setNombre("Juan");
		a3.setApellidos("Rubio González");
		a3.setEdad(33);
		
		Alumno a4 = new Alumno();
		a4.setNombre("Carlos");
		a4.setApellidos("Martínez Robles");
		a4.setEdad(28);
		
		listaAlumnos.add(a1);
		listaAlumnos.add(a2);
		listaAlumnos.add(a3);
		listaAlumnos.add(a4);
		
		request.setAttribute("listaAlumnos", listaAlumnos);
		RequestDispatcher rd = request.getRequestDispatcher("/listadoAlumnos.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
