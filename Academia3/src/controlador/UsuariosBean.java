package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import modelo.Usuarios;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import vista.LoginAdapter;

import com.google.gson.Gson;
import common.Constantes;

@ManagedBean
public class UsuariosBean {

	private LoginAdapter login;

	public UsuariosBean() {
		super();
		login = new LoginAdapter();
	}

	public LoginAdapter getLogin() {
		return login;
	}

	public void setLogin(LoginAdapter login) {
		this.login = login;
	}

	public void login() {
		boolean ok = true;
		try {


			ClientRequest req = new ClientRequest(
					Constantes.URL_BASE_APP + "webservice/login");

			req.formParameter("user", login.getUser());
			req.formParameter("password", login.getPassword());
			ClientResponse<String> res = req.post(String.class);
			String u = res.getEntity();
			if ((u != null && u.equals("null") || (u == null))) {
				ok = false;
			} else {
				Gson gson = new Gson();
				login.createFromUsuarios(gson.fromJson(u, Usuarios.class));
			}

			FacesContext fc = FacesContext.getCurrentInstance();

			if (ok) {
				String url = Constantes.URL_BASE_APP + "jsf/index.jsf";
				HttpServletRequest httpServletRequest = (HttpServletRequest) fc
						.getExternalContext().getRequest();
				httpServletRequest.getSession().setAttribute("session", login);
				fc.getExternalContext().redirect(url);

			} else {
				String url = Constantes.URL_BASE_APP + "jsf/error.jsf";
				fc.getExternalContext().redirect(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logout() {
		try {
			System.out.println("ENTRA EN LOGOUT");
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletRequest httpServletRequest = (HttpServletRequest) fc
					.getExternalContext().getRequest();
			httpServletRequest.getSession().removeAttribute("session");
			String url = Constantes.URL_BASE_APP;
			fc.getExternalContext().redirect(url);
			System.out.println("SALE DEL LOGOUT BIEN");

		} catch (Exception e) {
			System.out.println("SALE DEL LOGOUT POR EL CATCH");
			e.printStackTrace();
		}
	}

	public LoginAdapter existeSesion() {
		LoginAdapter usuario = null;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletRequest httpServletRequest = (HttpServletRequest) fc
					.getExternalContext().getRequest();
			usuario = (LoginAdapter) httpServletRequest.getSession()
					.getAttribute("session");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
