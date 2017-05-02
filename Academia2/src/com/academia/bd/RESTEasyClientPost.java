package com.academia.bd;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.google.gson.Gson;
 
public class RESTEasyClientPost {

	private boolean estado;
	private String user;
	private String password;
	private String Json;
	
	
	static Logger LOGGER = Logger.getLogger(BDAccess.class.getName());
	
	public void conectar() {
	  try {

		ClientRequest clientCreateRequest = new ClientRequest("http://localhost:8080/Academia_WebService/webservice/login");
        MultivaluedMap<String, String> formParameters = clientCreateRequest.getFormParameters();
        
        formParameters.putSingle("user", user);
        formParameters.putSingle("password", password);
        ClientResponse<String> clientCreateResponse = clientCreateRequest.post(String.class);
        
        String json = clientCreateResponse.getEntity();
		
		if (clientCreateResponse.getStatus() != 200) {
			this.estado=false;
		}else{
			this.estado=true;
			//Json = clientCreateRequest.postTarget( String.class);
			
			LOGGER.info("Json: " + json);
		}
 
		
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  } catch (Exception e) {
 
		e.printStackTrace();
 
	  }
 
	}
	public Boolean getEstado() {
		return this.estado;
	}
	public void setDatos(String usuario, String password) {
		this.user=usuario;
		this.password=password;
	}
	public void JSONEnUnObjeto() {
	    String json = "{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}";
	    Gson gson = new Gson();
	    Usuario usuario = gson.fromJson(json, Usuario.class);
	    //assertEquals(46, usuario.getId());
	    //assertEquals("Miguel", usuario.getNombre());
	    //assertEquals("Autentia", usuario.getEmpresa());
	}
	

 
}