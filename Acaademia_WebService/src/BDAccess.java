import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDAccess {
	static final Logger LOGGER = Logger.getLogger(BDAccess.class.getName());

	private Connection conexion = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	private PreparedStatement preparedStatement = null;

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

	public Usuario login(String user, String password) {
		Usuario u = null;

		try {

			String query = "SELECT * FROM USUARIOS WHERE USER = '" + user
					+ "' AND PASSWORD = '" + password + "'";

			statement = conexion.createStatement();
			resultset = statement.executeQuery(query);

			while (resultset.next()) {
				int id = resultset.getInt("idUSUARIO");
				String nombre = resultset.getString("USER");
				String pwd = resultset.getString("PASSWORD");
				Date fecha =resultset.getTimestamp("FECHA_ULTIMO_LOGIN");


				u = new Usuario();
				u.setId(id);
				u.setUser(nombre);
				u.setPassword(pwd);
				u.setFechaUltimoLogin(fecha);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;

	}
	
	public void actualizar(Usuario usuario) {

		try {
			//Formateamos fecha para que la acepte mysql
			DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String query = "UPDATE USUARIOS SET FECHA_ULTIMO_LOGIN = \""+fecha.format(usuario.getFechaUltimoLogin())
					+"\" WHERE idUSUARIO = "+usuario.getId()+ ";";

			System.out.println(query);
			
			statement = conexion.createStatement();
			statement.executeUpdate(query);

			System.out.println("lo ejecuta");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
