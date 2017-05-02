import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/webservice")
public class LoginREST {

	// http://localhost:8080/Academia_WebService/webservice/login
	@Path("/login")
	@POST
	@Produces("application/json")
	public Response login(@FormParam("user")String user, @FormParam("password")String password) {
		String json = null;
		try {
			BDAccess bd = new BDAccess();
			bd.connect();
			Usuario u = bd.login(user, password);

			//Gson gson = new GsonBuilder().serializeNulls().create();
			Gson gson=  new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
			json = gson.toJson(u);


			if (u != null) {
				return Response.status(200).entity(json).build();
			} else {
				return Response.status(401).entity(json).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Path("/otroMetodo")
	@GET
	@Produces("application/json")
	public Response otroMetodo(@QueryParam("user")String user, @QueryParam("password")String password) {
		String json = null;
		try {
			BDAccess bd = new BDAccess();
			bd.connect();
			Usuario u = bd.login(user, password);

			Gson gson = new GsonBuilder().serializeNulls().create();
			json = gson.toJson(u);

			if (u != null) {
				return Response.status(200).entity(json).build();
			} else {
				return Response.status(401).entity(json).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Path("/actualizar")
	@POST
	public Response actualizar(@FormParam("idusuario")int idusuario, @FormParam("fecha")String fecha) {
		
		try {
			
			//recogemos la fecha en formato json y la pasamos a date

			Gson gson = new GsonBuilder().setDateFormat(
					"yyyy-MM-dd HH:mm:ss").create();

			Date date;
			
			date = gson.fromJson(fecha,Date.class);
			

	       
			
			BDAccess bd = new BDAccess();
			bd.connect();
			Usuario u = new Usuario();
			u.setId(idusuario);
			u.setFechaUltimoLogin(date);
			
			bd.actualizar(u);
			
			bd.cerrar();


			return Response.status(200).build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

	}
}
