package com.academia.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	private PreparedStatement preparedStatement = null;

	private List<Profesor> listadoProfesores = null;
	private List<Alumno> listadoAlumnos = null;
	private List<Asignatura> listadoAsignaturas = null;

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
	public void cerrar() {
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

	public List<Asignatura> obtenerListadoAsignaturas() throws Exception {
		LOGGER.info("Entra en obtenerListadoAsignaturas()");
		List<Asignatura> lista = new ArrayList<Asignatura>();
		String query = "SELECT * FROM ASIGNATURA";

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

				// CREAMOS UNA ALUMNO POR REGISTRO RECUPERADO DE BD
				Alumno alumno = new Alumno();
				alumno.setIdAlumno(id);
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

	public List<Profesor> obtenerListadoProfesores() throws Exception {
		LOGGER.info("Entra en obtenerListadoProfesores()");
		List<Profesor> lista = new ArrayList<Profesor>();
		String query = "SELECT * FROM PROFESOR";

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
				String idasignatura = resultset.getString("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				Profesor profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(Integer.parseInt(idasignatura));

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

	// INSERTA ASIGNATURA EN BD
	public int insertaAsignatura(Asignatura asignatura) {
		LOGGER.info("Entra en insertaAsignatura()");
		int id = 0;
		try {
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO ");
			query.append(Constantes.ASIGNATURA_TABLE);
			query.append("(");
			query.append("NOMBRE");
			query.append(", ");
			query.append("HORARIO");
			query.append(", ");
			query.append("AULA");
			query.append(")");
			query.append(" VALUES (?, ?, ?)");

			preparedStatement = conexion.prepareStatement(query.toString(),
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, asignatura.getNombre());
			preparedStatement.setString(2, asignatura.getHorario());
			preparedStatement.setString(3, asignatura.getAula());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

			LOGGER.info("Sale de insertaAsignatura()");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en insertaAsignatura()");
			LOGGER.log(Level.SEVERE, e.getClass() + "." + e.getMessage());
		} finally {
			try {
				cerrar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return id;
	}

	// INSERTA ALUMNO EN BD
	public int insertaAlumno(Alumno alumno) {
		LOGGER.info("Entra en insertaAlumno()");
		int id = 0;
		try {
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO ");
			query.append(Constantes.ALUMNO_TABLE);
			query.append("(");
			query.append("NOMBRE");
			query.append(", ");
			query.append("APELLIDOS");
			query.append(", ");
			query.append("TELEFONO");
			query.append(", ");
			query.append("EMAIL");
			query.append(")");
			query.append(" VALUES (?, ?, ?, ?)");

			preparedStatement = conexion.prepareStatement(query.toString(),
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, alumno.getNombre());
			preparedStatement.setString(2, alumno.getApellidos());
			preparedStatement.setString(3, alumno.getTelefono());
			preparedStatement.setString(4, alumno.getEmail());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			LOGGER.info("ID insertada: " + id);
			LOGGER.info("Sale de insertaAlumno()");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en insertaAlumno()");
			LOGGER.log(Level.SEVERE, e.getClass() + "." + e.getMessage());
		}

		return id;
	}

	// INSERTA PROFESOR EN BD
	public int insertaProfesor(Profesor profesor) {
		LOGGER.info("Entra en insertaProfesor()");
		int id = 0;
		try {
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO ");
			query.append(Constantes.PROFESOR_TABLE);
			query.append("(");
			query.append("NOMBRE");
			query.append(", ");
			query.append("APELLIDOS");
			query.append(", ");
			query.append("TELEFONO");
			query.append(", ");
			query.append("EMAIL");
			query.append(", ");
			query.append("idASIGNATURA");
			query.append(")");
			query.append(" VALUES (?, ?, ?, ?, ?)");

			preparedStatement = conexion.prepareStatement(query.toString(),
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, profesor.getNombre());
			preparedStatement.setString(2, profesor.getApellidos());
			preparedStatement.setString(3, profesor.getTelefono());
			preparedStatement.setString(4, profesor.getEmail());
			preparedStatement.setInt(5, profesor.getIdAsignatura());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

			LOGGER.info("Sale de insertaProfesor()");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en insertaProfesor()");
			LOGGER.log(Level.SEVERE, e.getClass() + "." + e.getMessage());
		}

		return id;
	}

	// INSERTA EN BD LA RELACIÓN ALUMNOASIGNATURA
	public int insertaRelacionAlumnoAsignatura(
			RelacionAlumnoAsignatura relacionalumnoasignatura) {
		LOGGER.info("Entra en insertaRelacionAlumnoAsignatura()");
		int id = 0;
		try {
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO ");
			query.append(Constantes.REL_ALUMNO_ASIGNATURA_TABLE);
			query.append(" (");
			query.append("idALUMNO");
			query.append(", ");
			query.append("idASIGNATURA");
			query.append(") ");
			query.append(" VALUES (?, ?)");

			preparedStatement = conexion.prepareStatement(query.toString(),
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, relacionalumnoasignatura.getIdAlumno());
			preparedStatement.setInt(2, relacionalumnoasignatura.getIdAsignatura());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

			LOGGER.info("Sale de insertaProfesor()");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en insertaRelacionAlumnoAsignatura()");
			LOGGER.log(Level.SEVERE, e.getClass() + "." + e.getMessage());
		}

		return id;
	}

	// METODOS EDITAR

	// MOSTRAR PROFESOR

	public Profesor mostrarProfesor(String idProfesor) throws Exception {
		LOGGER.info("Entra en obtenerListadoProfesores()");
		String query = "SELECT * FROM PROFESOR WHERE idPROFESOR =" + idProfesor;
		LOGGER.info("SQL: " + query);
		Profesor profesor = new Profesor();
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
				String idAsignatura = resultset.getString("idASIGNATURA");

				// CREAMOS UN PROFESOR POR REGISTRO RECUPERADO DE BD

				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(Integer.parseInt(idAsignatura));

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error en obtenerListadoProfesores(): "
					+ e.getMessage());
		}

		LOGGER.info("Sale de obtenerListadoProfesores()");
		return profesor;

	}

	// MOSTRAR ALUMNO

	public Alumno mostrarAlumno(String idAlumno) throws Exception {
		LOGGER.info("Entra en mostrarAlumno()");
		String query = "SELECT * FROM ALUMNO WHERE idALUMNO =" + idAlumno;

		Alumno alumno = new Alumno();
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

				// CREAMOS UNA ALUMNO POR REGISTRO RECUPERADO DE BD

				alumno.setIdAlumno(id);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);
				alumno.setTelefono(telefono);
				alumno.setEmail(email);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en mostrarAlumno(): " + e.getMessage());
		}

		LOGGER.info("Sale de mostrarAlumno()");
		return alumno;

	}

	// MOSTRAR ASIGNATURA

	public Asignatura mostrarAsignatura(String idAsignatura) throws Exception {
		LOGGER.info("Entra en mostrarAsignatura()");
		String query = "SELECT * FROM ASIGNATURA WHERE idASIGNATURA ="
				+ idAsignatura;

		Asignatura asignatura = new Asignatura();
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

				asignatura.setIdAsignatura(id);
				asignatura.setNombre(nombre);
				asignatura.setHorario(horario);
				asignatura.setAula(aula);

			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Error en mostrarAsignatura(): " + e.getMessage());
		}

		LOGGER.info("Sale de mostrarAsignatura()");
		return asignatura;

	}

	// MODIFICAR PROFESOR

	public void modificarProfesor(Profesor profesor) {

		String q, nombre, apellidos, telefono, email;
		int idProfesor,idAsignatura;

		try {

			idProfesor = profesor.getIdProfesor();
			nombre = profesor.getNombre();
			apellidos = profesor.getApellidos();
			telefono = profesor.getTelefono();
			email = profesor.getEmail();
			idAsignatura = profesor.getIdAsignatura();

			q = "UPDATE PROFESOR SET NOMBRE='" + nombre + "', APELLIDOS='"
					+ apellidos + "', TELEFONO='" + telefono + "', EMAIL='" + email
					+ "', idASIGNATURA = "+idAsignatura+" WHERE idPROFESOR = " + idProfesor + ";";
			LOGGER.info("SQL: "+q);
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			statement.executeUpdate(q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// MODIFICAR ALUMNO
	public void modificarAlumno(Alumno alumno, List<RelacionAlumnoAsignatura> listaRel) {

		try {
			String q, nombre, apellidos, telefono, email;
			int idAlumno;

			idAlumno = alumno.getIdAlumno();
			nombre = alumno.getNombre();
			apellidos = alumno.getApellidos();
			telefono = alumno.getTelefono();
			email = alumno.getEmail();

			q = "UPDATE ALUMNO SET NOMBRE='" + nombre + "', APELLIDOS='"
					+ apellidos + "', TELEFONO='" + telefono + "', EMAIL='" + email
					+ "' WHERE idALUMNO = " + idAlumno + ";";
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			statement.executeUpdate(q);
			
			//ACTUALIZO SUS ASIGNATURAS
			//BORRO LAS QUE TENIA Y AÑADO LAS NUEVAS
			q = "DELETE FROM "+Constantes.REL_ALUMNO_ASIGNATURA_TABLE+" WHERE idALUMNO = "+idAlumno+";";
			statement.executeUpdate(q);
			//falla aqui llega mal la lista.....
			for(int i=0; i < listaRel.size(); i++){
				insertaRelacionAlumnoAsignatura(listaRel.get(i));
				LOGGER.info("AsignaturaId: "+listaRel.get(i).getIdAsignatura()
						+ " Idalumno: "+listaRel.get(i).getIdAlumno());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// MODIFICAR ASIGNATURA
	public void modificarAsignatura(Asignatura asignatura) {
		
		try {
			String q, nombre, horario, aula;
			int idAsignatura;
			
			idAsignatura = asignatura.getIdAsignatura();
			nombre = asignatura.getNombre() ;
			horario = asignatura.getHorario();
			aula = asignatura.getAula();
			
			q = "UPDATE ASIGNATURA SET NOMBRE=\""+ nombre+"\", HORARIO=\""+ horario+"\", AULA=\"" + aula +"\" WHERE idASIGNATURA = "+ idAsignatura +";";
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			
			statement.executeUpdate(q);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	// BORRAR ASIGNATURA

	public void borrarAsignatura(Asignatura asignatura) {

		try {
			String q;

			q = "DELETE FROM ASIGNATURA" + " WHERE idASIGNATURA = "
					+ asignatura.getIdAsignatura() + ";";
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			statement.executeUpdate(q);

			q = "DELETE FROM REL_ALUMNO_ASIGNATURA" + " WHERE idASIGNATURA = "
					+ asignatura.getIdAsignatura() + ";";
			statement.executeUpdate(q);

			q = "UPDATE PROFESOR SET idASIGNATURA=0 WHERE idASIGNATURA="
					+ asignatura.getIdAsignatura();
			statement.executeUpdate(q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// BORRAR PROFESOR

	public void borrarProfesor(Profesor profesor) {

		try {
			String q;

			q = "DELETE FROM PROFESOR" + " WHERE idPROFESOR = "
					+ profesor.getIdProfesor() + ";";
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			statement.executeUpdate(q);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// BORRAR ALUMNO

	public void borrarAlumno(Alumno alumno) {

		try {
			String q;

			q = "DELETE FROM ALUMNO" + " WHERE idALUMNO = "
					+ alumno.getIdAlumno() + ";";
			// CREAMOS EL OBJETO STATEMENT
			statement = conexion.createStatement();
			// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
			// BD
			statement.executeUpdate(q);

			q = "DELETE FROM REL_ALUMNO_ASIGNATURA" + " WHERE idALUMNO = "
					+ alumno.getIdAlumno() + ";";
			statement.executeUpdate(q);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<RelacionAlumnoAsignatura> mostrarRelacionAlumnoAsignatura(String idAlumno) throws Exception {
			LOGGER.info("Entra en mostrarRelacionAlumnoAsignatura()");
			String query = "SELECT * FROM REL_ALUMNO_ASIGNATURA WHERE idALUMNO =" + idAlumno;
			List<RelacionAlumnoAsignatura> lista = new ArrayList<RelacionAlumnoAsignatura>();
			
			try {
				// CREAMOS EL OBJETO STATEMENT
				statement = conexion.createStatement();
				// OBTENEMOS EL RESULTSET A PARTIR DE LA EJECUCIÓN DE LA CONSULTA A
				// BD
				resultset = statement.executeQuery(query);
				while (resultset.next()) {
					int idrel = resultset.getInt("idRELACION");
					int idalu = resultset.getInt("idALUMNO");
					int idasig = resultset.getInt("idASIGNATURA");
					
					RelacionAlumnoAsignatura rel = new RelacionAlumnoAsignatura();
					
					rel.setIdRelacion(idrel);
					rel.setIdAlumno(idalu);
					rel.setIdAsignatura(idasig);
					
					lista.add(rel);
				}
			
			
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE,
						"Error en mostrarRelacionAlumnoAsignatura(): " + e.getMessage());
			}

			LOGGER.info("Sale de mostrarRelacionAlumnoAsignatura()");
			return lista;

		}
	// METODO PARA MOSTRAR LO BUSCADO
	

	public List buscar(int iclase, int icampo, String t1) throws Exception {
	
	LOGGER.info("Entra en buscar()");
	List lista = null;
	String query = "";
	try {

		// Switch que recoge datos y lleva a la funcion correspondiente
		// o al archivo .jsp

		// Creacion del logger para mostrar datos en consola
		Logger LOGGER = Logger.getLogger(BDAccess.class.getName());

		switch (iclase) {

		// CASE PROFESOR
		case 0:
			switch (icampo) {

			case 0:
				query = "SELECT * FROM PROFESOR WHERE NOMBRE LIKE '%" + t1
						+ "%'";
				break;
			case 1:
				query = "SELECT * FROM PROFESOR WHERE APELLIDOS LIKE '%" + t1
						+ "%'";
				break;
			case 2:
				query = "SELECT * FROM PROFESOR WHERE TELEFONO LIKE '%" + t1
						+ "%'";
				break;
			case 3:
				query = "SELECT * FROM PROFESOR WHERE EMAIL LIKE '%" + t1 + "%'";
				break;
			case 4:
				query = "select PROFESOR.* From PROFESOR Inner Join ASIGNATURA on PROFESOR.idASIGNATURA = ASIGNATURA.idASIGNATURA "+
							"Where ASIGNATURA.NOMBRE LIKE '%" + t1 + "%'";
				break;
				
			}
			break;
		// CASE ASIGNATURA
		case 1:
			switch (icampo) {

			case 0:
				query = "SELECT * FROM ASIGNATURA WHERE NOMBRE LIKE '%" + t1
						+ "%'";
				break;
			case 1:
				query = "SELECT * FROM ASIGNATURA WHERE HORARIO LIKE '%" + t1
						+ "%'";
				break;
			case 2:
				query = "SELECT * FROM ASIGNATURA WHERE AULA LIKE '%" + t1
						+ "%'";
				break;
			}
			break;

		// CASE ALUMNO
		case 2:
			switch (icampo) {

			case 0:
				query = "SELECT * FROM ALUMNO WHERE NOMBRE LIKE '%" + t1 + "%'";
				break;
			case 1:
				query = "SELECT * FROM ALUMNO WHERE APELLIDOS LIKE '%" + t1
						+ "%'";
				break;
			case 2:
				query = "SELECT * FROM ALUMNO WHERE TELEFONO LIKE '%" + t1
						+ "%'";
				break;
			case 3:
				query = "SELECT * FROM ALUMNO WHERE EMAIL LIKE '%" + t1 + "%'";
				break;
			}
			break;

		}
		statement = conexion.createStatement();
		resultset = statement.executeQuery(query);
		
		LOGGER.info("Ejecuta la busqueda");
		
		switch (iclase) {
		case 0:
			lista = new ArrayList<Profesor>();
			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idPROFESOR");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");
				String idasignatura = resultset.getString("idASIGNATURA");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				Profesor profesor = new Profesor();
				profesor.setIdProfesor(id);
				profesor.setNombre(nombre);
				profesor.setApellidos(apellidos);
				profesor.setTelefono(telefono);
				profesor.setEmail(email);
				profesor.setIdAsignatura(Integer.parseInt(idasignatura));

				// AÑADIMOS EL PROFESOR A LA LISTA
				lista.add(profesor);
			}
			break;
		case 1:
			lista = new ArrayList<Asignatura>();
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

				// AÑADIMOS EL PROFESOR A LA LISTA
				lista.add(asignatura);
			}
			break;
		case 2:
			lista = new ArrayList<Alumno>();
			while (resultset.next()) {
				// RECUPERAMOS LOS DATOS DE BD
				int id = resultset.getInt("idALUMNO");
				String nombre = resultset.getString("NOMBRE");
				String apellidos = resultset.getString("APELLIDOS");
				String telefono = resultset.getString("TELEFONO");
				String email = resultset.getString("EMAIL");

				// CREAMOS UNA ASIGNATURA POR REGISTRO RECUPERADO DE BD
				Alumno alumno = new Alumno();
				alumno.setIdAlumno(id);
				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);
				alumno.setTelefono(telefono);
				alumno.setEmail(email);

				// AÑADIMOS EL PROFESOR A LA LISTA
				lista.add(alumno);
			}
			break;
		}

	} catch (Exception e) {
		LOGGER.log(Level.SEVERE,
				"Error en buscar(): " + e.getMessage());
		LOGGER.info("SQL: "+query);
	}
	LOGGER.info("Devolvemos la lista()");
	return lista;
	

}
}



