package com.academia.common;

public class ValoresTablas {

	private int indice;
	private String nombre;
	
	public ValoresTablas(int indice, String nombre){
		this.indice = indice;
		this.nombre = nombre;
	}
	
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
