package com.academia.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.academia.common.Constantes;

public class BDAccess {

	private static final Logger LOGGER = Logger.getLogger(BDAccess.class
			.getName());

	private Connection conexion = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	private List<Profesor> listadoProfesor = null;
	private List<Alumno> listadoAlumno = null;
	private List<Asignatura> listadoAsignatura = null;

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

	// LISTADO DE ASIGNATURAS
	public List<Asignatura> obtenerListadoAsignaturas() throws Exception {
		LOGGER.info("Entra en obtenerListadoAsignaturas()");
		List<Asignatura> lista = new ArrayList<Asignatura>();
		String query = "SELECT * FROM academia_bd.asignatura";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idASIGNATURA");
				String nombre = resultset.getString("NOMBRE");
				String horario = resultset.getString("HORARIO");
				String aula = resultset.getString("AULA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				Asignatura asignatura = new Asignatura();
				asignatura.setIdAsignatura(id);
				asignatura.setNombre(nombre);
				asignatura.setHorario(horario);
				asignatura.setAula(aula);

				// AÑADIMOS LA ASIGNATURA A LA LISTA
				lista.add(asignatura);
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en obtenerListadoAsignaturas(): "
					+ e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoAsignaturas()");
		return lista;

	}

	// AÑADIR ELEMENTOS
	public void anyadirAsignatura(Asignatura a) {
		String query = "INSERT INTO academia_bd.asignatura (nombre, horario, aula)  VALUES('"
				+ a.getNombre()
				+ "', '"
				+ a.getHorario()
				+ "', '"
				+ a.getAula() + "')";
		try {
			if (conexion.isClosed()) {
				connect();
			}
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en anyadirAsignatura(): " + e.getMessage());
		}
	}

	// BORRAR ELEMENTOS
	public void borrarAsignatura(Asignatura a) {
		String query = "DELETE FROM ASIGNATURA WHERE idASIGNATURA = "
				+ a.getIdAsignatura();

		try {

			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en borrarAsignatura(): " + e.getMessage());
		}
	}

	// BORRAR ELEMENTOS
	public void borrarAsignatura(int id) {
		String query = "DELETE FROM ASIGNATURA WHERE idASIGNATURA = " + id;

		try {
			if (conexion.isClosed()) {
				connect();
			}
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en borrarAsignatura(): " + e.getMessage());
		}
	}

	// EDITAR ASIGNATURA
	public void editarAsignatura(Asignatura a) {
		String query = "UPDATE academia_bd.asignatura a SET NOMBRE='"
				+ a.getNombre() + "', HORARIO='" + a.getHorario() + "', AULA='"
				+ a.getAula() + "' WHERE idASIGNATURA =" + a.getIdAsignatura();

		try {
			if (conexion.isClosed()) {
				connect();
			}
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "editarAsignatura(): " + e.getMessage());
		}
	}

	// OBTENER LA ASIGNATURA POR ID
	public List<Asignatura> obtenerAsignaturaPorId(int busqueda)
			throws Exception {
		LOGGER.info("Entra en obtenerListadoAsignaturas()");
		Asignatura asignatura = null;
		List<Asignatura> list = new ArrayList<Asignatura>();
		String query = "SELECT * FROM academia_bd.asignatura WHERE idASIGNATURA = "
				+ busqueda;

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idASIGNATURA");
				String nombre = resultset.getString("NOMBRE");
				String horario = resultset.getString("HORARIO");
				String aula = resultset.getString("AULA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				asignatura = new Asignatura();
				asignatura.setIdAsignatura(id);
				asignatura.setNombre(nombre);
				asignatura.setHorario(horario);
				asignatura.setAula(aula);
				list.add(asignatura);
				break;
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en obtenerListadoAsignaturas(): "
					+ e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoAsignaturas()");
		return list;

	}

	// OBTENER LA ASIGNATURA POR ID
	public Asignatura obtenerAsigPorId(int busqueda) throws Exception {
		LOGGER.info("Entra en obtenerListadoAsignaturas()");
		Asignatura asignatura = null;
		String query = "SELECT * FROM academia_bd.asignatura WHERE idASIGNATURA = "
				+ busqueda;

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idASIGNATURA");
				String nombre = resultset.getString("NOMBRE");
				String horario = resultset.getString("HORARIO");
				String aula = resultset.getString("AULA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				asignatura = new Asignatura();
				asignatura.setIdAsignatura(id);
				asignatura.setNombre(nombre);
				asignatura.setHorario(horario);
				asignatura.setAula(aula);
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en obtenerListadoAsignaturas(): "
					+ e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoAsignaturas()");
		return asignatura;

	}

	// OBTENER ASIGNATURA POR NOMBRE
	public List<Asignatura> obtenerAsignaturaPorNombre(String busqueda)
			throws Exception {
		LOGGER.info("Entra en obtenerAsignaturaPorNombre()");
		Asignatura asignatura = null;
		List<Asignatura> list = new ArrayList<Asignatura>();
		String query = "SELECT * FROM asignatura WHERE NOMBRE LIKE '"
				+ busqueda + "%'";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idASIGNATURA");
				String nombre = resultset.getString("NOMBRE");
				String horario = resultset.getString("HORARIO");
				String aula = resultset.getString("AULA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				asignatura = new Asignatura();
				asignatura.setIdAsignatura(id);
				asignatura.setNombre(nombre);
				asignatura.setHorario(horario);
				asignatura.setAula(aula);
				list.add(asignatura);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en obtenerListadoAsignaturas(): "
					+ e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoAsignaturas()");
		return list;

	}

	// OBTENER ASIGNATURA POR AULA
	public List<Asignatura> obtenerAsignaturaPorAula(String busqueda)
			throws Exception {
		LOGGER.info("Entra en  obtenerAsignaturaPorAula()");
		Asignatura asignatura = null;
		List<Asignatura> list = new ArrayList<Asignatura>();
		String query = "SELECT * FROM academia_bd.asignatura WHERE AULA = "
				+ busqueda;

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idASIGNATURA");
				String nombre = resultset.getString("NOMBRE");
				String horario = resultset.getString("HORARIO");
				String aula = resultset.getString("AULA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				asignatura = new Asignatura();
				asignatura.setIdAsignatura(id);
				asignatura.setNombre(nombre);
				asignatura.setHorario(horario);
				asignatura.setAula(aula);
				list.add(asignatura);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en  obtenerAsignaturaPorAula(): "
					+ e.getMessage());
		}

		LOGGER.info("Sale de  obtenerAsignaturaPorAula()");
		return list;

	}

	// OBTENER ASIGNATURA POR HORARIO
	public List<Asignatura> obtenerAsignaturaPorHorario(String busqueda)
			throws Exception {
		LOGGER.info("Entra en  obtenerAsignaturaPorHorario()");
		Asignatura asignatura = null;
		List<Asignatura> list = new ArrayList<Asignatura>();
		String query = "SELECT * FROM academia_bd.asignatura WHERE Horario = '"
				+ busqueda + "'";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idASIGNATURA");
				String nombre = resultset.getString("NOMBRE");
				String horario = resultset.getString("HORARIO");
				String aula = resultset.getString("AULA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				asignatura = new Asignatura();
				asignatura.setIdAsignatura(id);
				asignatura.setNombre(nombre);
				asignatura.setHorario(horario);
				asignatura.setAula(aula);
				list.add(asignatura);

			}

		} catch (Exception e) {
			LOGGER.log(
					Level.SEVERE,
					"Error en  obtenerAsignaturaPorHorario(): "
							+ e.getMessage());
		}

		LOGGER.info("Sale de  obtenerAsignaturaPorHorario()");
		return list;

	}

	// *********************************************************
	// **************** PARTE DE PROFESOR **********************
	// *********************************************************

	// LISTADO DE PROFESORES
	public List<Profesor> obtenerListadoProfesores() throws Exception {
		LOGGER.info("Entra en obtenerListadoProfesores()");
		List<Profesor> lista = new ArrayList<Profesor>();
		String query = "SELECT * FROM academia_bd.profesor";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UN PROFESOR POR REGISTRO RECUPERADO DE BD
				Profesor profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);

				// AÑADIMOS EL PROFESOR A LA LISTA
				lista.add(profesor);
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en obtenerListadoProfesores(): "
					+ e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesores()");
		return lista;

	}

	// AÑADIR ELEMENTOS
	public void anyadirProfesor(Profesor p) {
		String query = "INSERT INTO academia_bd.profesor (nombre, apellidos, telefono, email, idAsignatura)  VALUES('"
				+ p.getNombre()
				+ "', '"
				+ p.getApellidos()
				+ "', '"
				+ p.getTelefono()
				+ "', '"
				+ p.getEmail()
				+ "', '"
				+ p.getIdAsignatura() + "')";
		try {
			if (conexion.isClosed()) {
				connect();
			}
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en anyadirProfesor(): " + e.getMessage());
		}
	}

	// BORRAR ELEMENTOS
	public void borrarProfesor(Profesor p) {
		String query = "DELETE FROM PROFESOR WHERE idProfesor = "
				+ p.getIdProfesor();

		try {

			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en borrarProfesor(): " + e.getMessage());
		}
	}

	// BORRAR ELEMENTOS
	public void borrarProfesor(int id) {
		String query = "DELETE FROM PROFESOR WHERE idPROFESOR = " + id;

		try {
			if (conexion.isClosed()) {
				connect();
			}
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en borrarProfesor(): " + e.getMessage());
		}
	}

	// EDITAR ASIGNATURA
	public void editarProfesor(Profesor p) {
		String query = "UPDATE academia_bd.profesor p SET NOMBRE='"
				+ p.getNombre() + "', APELLIDOS='" + p.getApellidos()
				+ "', TELEFONO='" + p.getTelefono() + "', EMAIL='"
				+ p.getEmail() + "', idASIGNATURA='" + p.getIdAsignatura()
				+ "' WHERE idPROFESOR =" + p.getIdProfesor();

		try {
			if (conexion.isClosed()) {
				connect();
			}
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			conexion.close();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "editarProfesor(): " + e.getMessage());
		}
	}

	// OBTENER EL PROFESOR POR ID
	public List<Profesor> obtenerProfesorPorId(int busqueda) throws Exception {
		LOGGER.info("Entra en obtenerListadoProfesor()");
		Profesor profesor = null;
		List<Profesor> list = new ArrayList<Profesor>();
		String query = "SELECT * FROM academia_bd.profesor WHERE idPROFESOR = "
				+ busqueda;

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UN PROFESOR POR REGISTRO RECUPERADO DE BD
				profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);
				list.add(profesor);
				break;
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoProfesor(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesor()");
		return list;

	}

	// OBTENER EL PROFESOR POR ID
	public Profesor obtenerProfePorId(int busqueda) throws Exception {
		LOGGER.info("Entra en obtenerListadoProfesor()");
		Profesor profesor = null;
		String query = "SELECT * FROM academia_bd.profesor WHERE idPROFESOR = "
				+ busqueda;

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoProfesor(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesor()");
		return profesor;

	}

	// OBTENER PROFESOR POR NOMBRE
	public List<Profesor> obtenerProfesorPorNombre(String busqueda)
			throws Exception {
		LOGGER.info("Entra en obtenerProfesorPorNombre()");
		Profesor profesor = null;
		List<Profesor> list = new ArrayList<Profesor>();
		String query = "SELECT * FROM profesor WHERE NOMBRE LIKE '" + busqueda
				+ "%'";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);
				list.add(profesor);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoProfesor(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesor()");
		return list;

	}

	// OBTENER PROFESOR POR APELLIDOS
	public List<Profesor> obtenerProfesorPorApellidos(String busqueda)
			throws Exception {
		LOGGER.info("Entra en obtenerProfesorPorApellidos()");
		Profesor profesor = null;
		List<Profesor> list = new ArrayList<Profesor>();
		String query = "SELECT * FROM profesor WHERE APELLIDOS LIKE '"
				+ busqueda + "%'";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);
				list.add(profesor);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoProfesor(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesor()");
		return list;

	}

	// OBTENER PROFESOR POR TELEFONO
	public List<Profesor> obtenerProfesorPorTelefono(String busqueda)
			throws Exception {
		LOGGER.info("Entra en obtenerProfesorPorTelefono()");
		Profesor profesor = null;
		List<Profesor> list = new ArrayList<Profesor>();
		String query = "SELECT * FROM profesor WHERE TELEFONO LIKE '"
				+ busqueda + "%'";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);
				list.add(profesor);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoProfesor(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesor()");
		return list;

	}

	// OBTENER PROFESOR POR EMAIL
	public List<Profesor> obtenerProfesorPorEmail(String busqueda)
			throws Exception {
		LOGGER.info("Entra en obtenerProfesorPorEmail()");
		Profesor profesor = null;
		List<Profesor> list = new ArrayList<Profesor>();
		String query = "SELECT * FROM profesor WHERE EMAIL LIKE '" + busqueda
				+ "%'";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);
				list.add(profesor);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoProfesor(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesor()");
		return list;

	}

	// OBTENER PROFESOR POR idASIGNATURA
	public List<Profesor> obtenerProfesorPorIdAsignatura(String busqueda)
			throws Exception {
		LOGGER.info("Entra en obtenerProfesorPorIdAsignatura()");
		Profesor profesor = null;
		List<Profesor> list = new ArrayList<Profesor>();
		String query = "SELECT * FROM profesor WHERE idASIGNATURA LIKE '"
				+ busqueda + "%'";

		try {
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				int idAsignatura = resultset.getInt("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(idAsignatura);
				list.add(profesor);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en obtenerListadoProfesor(): " + e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesor()");
		return list;

	}
	
	//ALUMNO
	
	// LISTADO DE ALUMNO
		public List<Alumno> obtenerListadoAlumno() throws Exception {
			LOGGER.info("Entra en obtenerListadoAlumno()");
			List<Alumno> lista = new ArrayList<Alumno>();
			String query = "SELECT * FROM academia_bd.alumno";

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
					alumno.setIdAlumno(id);
					alumno.setNombre(nombre);
					alumno.setApellidos(apellidos);
					alumno.setTelefono(telefono);
					alumno.setEmail(email);

					// AÑADIMOS LA ASIGNATURA A LA LISTA
					lista.add(alumno);
				}

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Error en obtenerListadoAlumno(): "
						+ e.getMessage());
			}

			LOGGER.info("Sale de obtenerListadoAsignaturas()");
			return lista;

		}

		// AÑADIR ELEMENTOS
		public void anyadirAlumno(Alumno a) {
			String query = "INSERT INTO academia_bd.alumno (nombre, apellidos, telefono, email)  VALUES('"
					+ a.getNombre()
					+ "', '"
					+ a.getApellidos()
					+ "', '"
					+ a.getTelefono()
					+ "', '"
					+ a.getEmail() + "')";
			try {
				if (conexion.isClosed()) {
					connect();
				}
				// CREAMOS EL OBJETO STATEMENT
				statement = conexion.createStatement();
				statement.executeUpdate(query);

				conexion.close();

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE,
						"Error en anyadirAlumno(): " + e.getMessage());
			}
		}

		// BORRAR ELEMENTOS
		public void borrarAlumno(Alumno a) {
			String query = "DELETE FROM ALUMNO WHERE idALUMNO = "
					+ a.getIdAlumno();

			try {

				// CREAMOS EL OBJETO STATEMENT
				statement = conexion.createStatement();
				statement.executeUpdate(query);

				conexion.close();

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE,
						"Error en borrarAlumno(): " + e.getMessage());
			}
		}

		// BORRAR ELEMENTOS
		public void borrarAlumno(int id) {
			String query = "DELETE FROM ALUMNO WHERE idALUMNO = " + id;

			try {
				if (conexion.isClosed()) {
					connect();
				}
				// CREAMOS EL OBJETO STATEMENT
				statement = conexion.createStatement();
				statement.executeUpdate(query);

				conexion.close();

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE,
						"Error en borrarAlumno(): " + e.getMessage());
			}
		}

		// EDITAR ALUMNO
		public void editarAlumno(Alumno a) {
			String query = "UPDATE academia_bd.alumno a SET NOMBRE='"
					+ a.getNombre() + "', APELLIDOS='" + a.getApellidos() + "', TELEFONO='"
					+ a.getTelefono() + "', EMAIL='" + a.getEmail() + "' WHERE idALUMNO =" + a.getIdAlumno();

			try {
				if (conexion.isClosed()) {
					connect();
				}
				// CREAMOS EL OBJETO STATEMENT
				statement = conexion.createStatement();
				statement.executeUpdate(query);

				conexion.close();

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "editarAlumno(): " + e.getMessage());
			}
		}

		// OBTENER EL ALUMNO POR ID
		public List<Alumno> obtenerAlumnoPorId(int busqueda)
				throws Exception {
			LOGGER.info("Entra en obtenerListadoAlumno()");
			Alumno alumno = null;
			List<Alumno> list = new ArrayList<Alumno>();
			String query = "SELECT * FROM academia_bd.alumno WHERE idALUMNO = "
					+ busqueda;

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
					alumno.setIdAlumno(id);
					alumno.setNombre(nombre);
					alumno.setApellidos(apellidos);
					alumno.setTelefono(telefono);
					alumno.setEmail(email);
					list.add(alumno);
					break;
				}

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Error en obtenerListadoAlumno(): "
						+ e.getMessage());
			}

			LOGGER.info("Sale de obtenerListadoAlumno()");
			return list;

		}

		// OBTENER EL ALUMNO POR ID
		public Alumno obtenerAluPorId(int busqueda) throws Exception {
			LOGGER.info("Entra en obtenerListadoAlumno()");
			Alumno alumno = null;
			String query = "SELECT * FROM academia_bd.alumno WHERE idALUMNO = "
					+ busqueda;

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
					alumno.setIdAlumno(id);
					alumno.setNombre(nombre);
					alumno.setApellidos(apellidos);
					alumno.setTelefono(telefono);
					alumno.setEmail(email);
				}

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Error en obtenerListadoAlumno(): "
						+ e.getMessage());
			}

			LOGGER.info("Sale de obtenerListadoAlumno()");
			return alumno;

		}

		// OBTENER ALUMNO POR NOMBRE
		public List<Alumno> obtenerAlumnoPorNombre(String busqueda)
				throws Exception {
			LOGGER.info("Entra en obtenerAlumnoPorNombre()");
			Alumno alumno = null;
			List<Alumno> list = new ArrayList<Alumno>();
			String query = "SELECT * FROM alumno WHERE NOMBRE LIKE '"
					+ busqueda + "%'";

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
					alumno.setIdAlumno(id);
					alumno.setNombre(nombre);
					alumno.setApellidos(apellidos);
					alumno.setTelefono(telefono);
					alumno.setEmail(email);
					list.add(alumno);

				}

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Error en obtenerListadoAlumno(): "
						+ e.getMessage());
			}

			LOGGER.info("Sale de obtenerListadoAlumno()");
			return list;

		}

		// OBTENER ALUMNO POR APELLIDOS
		public List<Alumno> obtenerAlumnoPorApellidos(String busqueda)
				throws Exception {
			LOGGER.info("Entra en obtenerAlumnoPorApellidos()");
			Alumno alumno = null;
			List<Alumno> list = new ArrayList<Alumno>();
			String query = "SELECT * FROM alumno WHERE APELLIDOS LIKE '"
					+ busqueda + "%'";

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
					alumno.setIdAlumno(id);
					alumno.setNombre(nombre);
					alumno.setApellidos(apellidos);
					alumno.setTelefono(telefono);
					alumno.setEmail(email);
					list.add(alumno);

				}

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Error en obtenerListadoAlumno(): "
						+ e.getMessage());
			}

			LOGGER.info("Sale de obtenerListadoAlumno()");
			return list;

		}

		// OBTENER ALUMNO POR TELEFONO
		public List<Alumno> obtenerAlumnoPorTelefono(String busqueda)
				throws Exception {
			LOGGER.info("Entra en obtenerAlumnoPorTelefono()");
			Alumno alumno = null;
			List<Alumno> list = new ArrayList<Alumno>();
			String query = "SELECT * FROM alumno WHERE TELEFONO LIKE '"
					+ busqueda + "%'";

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
					alumno.setIdAlumno(id);
					alumno.setNombre(nombre);
					alumno.setApellidos(apellidos);
					alumno.setTelefono(telefono);
					alumno.setEmail(email);
					list.add(alumno);

				}

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Error en obtenerListadoAlumno(): "
						+ e.getMessage());
			}

			LOGGER.info("Sale de obtenerListadoAlumno()");
			return list;

		}
		
		//OBTENEMOS ALUMNO POR EMAIL
		public List<Alumno> obtenerAlumnoPorEmail(String busqueda)
				throws Exception {
			LOGGER.info("Entra en obtenerAlumnoPorEmail()");
			Alumno alumno = null;
			List<Alumno> list = new ArrayList<Alumno>();
			String query = "SELECT * FROM alumno WHERE EMAIL LIKE '"
					+ busqueda + "%'";

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
					alumno.setIdAlumno(id);
					alumno.setNombre(nombre);
					alumno.setApellidos(apellidos);
					alumno.setTelefono(telefono);
					alumno.setEmail(email);
					list.add(alumno);

				}

			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Error en obtenerListadoAlumno(): "
						+ e.getMessage());
			}

			LOGGER.info("Sale de obtenerListadoAlumno()");
			return list;

		}
}
