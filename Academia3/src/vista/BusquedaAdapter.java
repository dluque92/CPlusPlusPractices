package vista;

import java.io.Serializable;

public class BusquedaAdapter implements Serializable{
	private String texto;
	private int seleccionado;

	public BusquedaAdapter() {

	}

	public BusquedaAdapter(String texto, int seleccionado) {
		super();
		this.texto = texto;
		this.seleccionado = seleccionado;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(int seleccionado) {
		this.seleccionado = seleccionado;
	}

}