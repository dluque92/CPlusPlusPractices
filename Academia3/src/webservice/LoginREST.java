package webservice;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import modelo.Usuarios;
import modelo.UsuariosDAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// URL http://localhost:8080/Academia3/webservice/login
@Path("/webservice")
public class LoginREST {

	@POST
	@Path("/login")
	@Produces("application/json")
	public Response login(@FormParam("user") String user,
			@FormParam("password") String password) {

		UsuariosDAO dao = new UsuariosDAO();
		Usuarios u = dao.login(user, password);
		dao.close();

		Gson gson = new GsonBuilder().serializeNulls().create();
		String json = gson.toJson(u);

		return Response.status(200).entity(json).build();
	}

}
