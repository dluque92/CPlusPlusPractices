import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import academia.modelo.Alumno;

public class DBAccess {

	private static final Logger LOGGER = Logger.getLogger(DBAccess.class
			.getName());

	private Connection conexion = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	private List<Alumno> listadoAlumno = null;

	// MÉTODO QUE SE ENCARGA DE ESTABLECER UNA CONEXIÓN CON LA BASE DE DATOS
	public void connect() throws Exception {
		LOGGER.info("Entra en connect()");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(Constantes.URL_BD,
					Constantes.USER_BD, Constantes.PASSWORD_BD);

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en connect(): " + e.getMessage());
		}

		LOGGER.info("Sale de connect()");
	}

	// MÉTODO QUE SE ENCARGA DE CERRAR UNA CONEXIÓN CON LA BASE DE DATOS
	public void cerrar() throws Exception {
		LOGGER.info("Entra en cerrar()");
		try {

			if (resultset != null) {
				resultset.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (conexion != null) {
				conexion.close();
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en cerrar(): " + e.getMessage());
		}

		LOGGER.info("Sale de cerrar()");
	}

	public List<Alumno> obtenerListadoAlumnos() throws Exception {
		LOGGER.info("Entra en obtenerListadoAlumnos()");
		List<Alumno> lista = new ArrayList<Alumno>();
		String query = "SELECT * FROM ALUMNO";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idALUMNO");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");

				// CREAMOS UN ALUMNO POR REGISTRO RECUPERADO DE BD
				Alumno alumno = new Alumno();
				alumno.setId(id);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);
				alumno.setTelefono(telefono);
				alumno.setEmail(email);

				// AÑADIMOS EL ALUMNO A LA LISTA
				lista.add(alumno);
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoAlumnos(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoAlumnos()");
		return lista;

	}

	public Alumno obtenerAlumnosPorId(int idAlumno) throws Exception {
		LOGGER.info("Entra en obtenerAlumnosPorId()");
		Alumno alumno = null;
		String query = "SELECT * FROM ALUMNO WHERE idALUMNO = " + idAlumno;

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idALUMNO");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");

				// CREAMOS UN ALUMNO POR REGISTRO RECUPERADO DE BD
				alumno = new Alumno();
				alumno.setId(id);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);
				alumno.setTelefono(telefono);
				alumno.setEmail(email);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerAlumnosPorId(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerAlumnosPorId()");
		return alumno;

	}
}
