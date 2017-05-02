package vista;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.Usuarios;

public class LoginAdapter implements Serializable{

	private String user;
	private String password;
	private String lastAccess;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}

	public LoginAdapter(String user, String password, String lastAccess) {
		super();
		this.user = user;
		this.password = password;
		this.lastAccess = lastAccess;
	}

	public LoginAdapter() {
		super();
	}

	public void createFromUsuarios(Usuarios u) {
		this.user = u.getUser();
		this.password = u.getPassword();
		this.lastAccess = convertToString(u.getFechaUltimoLogin());
	}

	private static String convertToString(Date date) {

		if (date != null) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			return df.format(date);
		}
		return null;

	}

}
