package es.java.sample3;

public class Cliente {

	private String nombre;
	private int[] carroCompra;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}

	public Cliente() {
		super();
	}

	public Cliente(String nombre, int[] carroCompra) {
		super();
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}

}
