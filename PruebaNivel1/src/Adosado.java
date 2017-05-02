public class Adosado extends Casa {

	private String nombreUrbanizacion;

	public String getNombreUrbanizacion() {
		return nombreUrbanizacion;
	}

	public void setNombreUrbanizacion(String nombreUrbanizacion) {
		this.nombreUrbanizacion = nombreUrbanizacion;
	}

	public Adosado() {
		super();
	}

	public Adosado(int numHabitaciones, int numCuartosBanyo, float precio,
			String direccion, boolean comprada) {
		super(numHabitaciones, numCuartosBanyo, precio, direccion, comprada);
	}

	public Adosado(String nombreUrbanizacion) {
		super();
		this.nombreUrbanizacion = nombreUrbanizacion;
	}

	public Adosado(int numHabitaciones, int numCuartosBanyo, float precio,
			String direccion, boolean comprada, String nombreUrbanizacion) {
		super(numHabitaciones, numCuartosBanyo, precio, direccion, comprada);
		this.nombreUrbanizacion = nombreUrbanizacion;
	}

	@Override
	public String toString() {
		return "Adosado [nombreUrbanizacion=" + nombreUrbanizacion
				+ ", getNumHabitaciones()=" + getNumHabitaciones()
				+ ", getNumCuartosBanyo()=" + getNumCuartosBanyo()
				+ ", getPrecio()=" + getPrecio() + ", getDireccion()="
				+ getDireccion() + ", isComprada()=" + isComprada() + "]";
	}

	@Override
	public String getTipo() {
		return ("Adosado");
	}

}
