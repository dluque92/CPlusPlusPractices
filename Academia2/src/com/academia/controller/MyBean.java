package com.academia.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name = "MyBean")
public class MyBean {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void metodoPrueba() {
		System.out.println("Pasamos por el bean");
		System.out.println("Nombre introducido: " + nombre);
		
		nombre = "Hemos cambiado el nombre";
	}

	public void metodoConRedireccion() {
		try {
			String url = "http://localhost:8080/Academia2/jsf/page.jsf";
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getExternalContext().redirect(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
