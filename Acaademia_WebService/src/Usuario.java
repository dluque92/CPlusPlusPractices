import java.util.Date;

public class Usuario {

	private int id;
	private String user;
	private String password;
	private Date fechaUltimoLogin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getFechaUltimoLogin() {
		return fechaUltimoLogin;
	}

	public void setFechaUltimoLogin(Date fechaUltimoLogin) {
		this.fechaUltimoLogin = fechaUltimoLogin;
	}

}
