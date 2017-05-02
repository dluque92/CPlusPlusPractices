package com.academia.bd;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MiHttpPost {
	private boolean estado;
	private String user;
	private String password;
	private String Json;

	static Logger LOGGER = Logger.getLogger(BDAccess.class.getName());

	public void conectar() {

		try {
			String urlParameters = "user=" + user + "&password=" + password;
			String request = "http://localhost:8080/Academia_WebService/webservice/login";
			URL url = new URL(request);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Length",
					"" + Integer.toString(urlParameters.getBytes().length));
			connection.setUseCaches(false);

			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			String json = wr.toString();
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();

			if (connection.getResponseCode() != 200) {
				this.estado = false;
			} else {
				this.estado = true;
				this.Json = response.toString();
				LOGGER.info("Json: " + response.toString());
			}

			connection.disconnect();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.estado = false;
		}

	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setDatos(String usuario, String password) {
		this.user = usuario;
		this.password = password;
	}

	public Usuario getUsuario() {
		Usuario usuario = null;
		try {
			Gson gson = new GsonBuilder().setDateFormat(
					"EEE, dd MMM yyyy HH:mm:ss zzz").create();

			usuario = gson.fromJson(this.Json, Usuario.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/*
	 * public void actualizar(Usuario usuario) {
	 * 
	 * try { //String urlParameters = "idusuario=" + usuario.getId() +
	 * "&fecha=\"" + usuario.getFechaUltimoLogin()+"\""; String urlParameters =
	 * "idusuario=" + usuario.getId(); System.out.println(urlParameters); String
	 * request =
	 * "http://localhost:8080/Academia_WebService/webservice/actualizar"; URL
	 * url = new URL(request);
	 * 
	 * HttpURLConnection connection = (HttpURLConnection) url .openConnection();
	 * connection.setDoOutput(true); connection.setDoInput(true);
	 * connection.setInstanceFollowRedirects(false);
	 * connection.setRequestMethod("GET");
	 * connection.setRequestProperty("Content-Type",
	 * "application/x-www-form-urlencoded");
	 * connection.setRequestProperty("charset", "utf-8");
	 * connection.setRequestProperty("Content-Length", "" +
	 * Integer.toString(urlParameters.getBytes().length));
	 * connection.setUseCaches(false);
	 * 
	 * 
	 * if (connection.getResponseCode() != 200) { this.estado = false; } else {
	 * this.estado = true; }
	 * 
	 * connection.disconnect();
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); this.estado = false; }
	 * 
	 * }
	 */

	public void actualizar(Usuario usuario) {

		try {

			String url = "http://localhost:8080/Academia_WebService/webservice/actualizar";

			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);

			// add header
			post.setHeader("User-Agent", "Mozilla/5.0");

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("idusuario", Integer
					.toString(usuario.getId())));
			
			//pasamos la fecha a json para enviarla al webservice
			Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String json;
			json = gson.toJson(usuario.getFechaUltimoLogin());
	
			
			urlParameters.add(new BasicNameValuePair("fecha", json));
			
			

			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = client.execute(post);
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : "
					+ response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println(result.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
