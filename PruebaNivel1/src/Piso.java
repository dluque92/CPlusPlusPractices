public class Piso extends Casa {

	// PROPIEDAD UNICA PARA EL OBJETO PISO
	// TENEMOS TODAS LAS PROPIEDADES HEREDADAS DE CASA + ESTA PROPIEDAD
	private String numeroPiso;

	// SETTER Y GETTER
	public String getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(String numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	// CONSTRUCTORES

	public Piso() {
		super();
	}

	public Piso(int numHabitaciones, int numCuartosBanyo, float precio,
			String direccion, boolean comprada) {
		super(numHabitaciones, numCuartosBanyo, precio, direccion, comprada);
	}

	public Piso(String numeroPiso) {
		super();
		this.numeroPiso = numeroPiso;
	}

	public Piso(int numHabitaciones, int numCuartosBanyo, float precio,
			String direccion, boolean comprada, String numeroPiso) {
		super(numHabitaciones, numCuartosBanyo, precio, direccion, comprada);
		this.numeroPiso = numeroPiso;
	}

	@Override
	public String toString() {
		return "Piso [numeroPiso=" + numeroPiso + ", getNumHabitaciones()="
				+ getNumHabitaciones() + ", getNumCuartosBanyo()="
				+ getNumCuartosBanyo() + ", getPrecio()=" + getPrecio()
				+ ", getDireccion()=" + getDireccion() + ", isComprada()="
				+ isComprada() + "]";
	}

	// CREO UN METODO QUE DEVUELVE QUE TIPO DE OBJETO TENEMOS
	@Override
	public String getTipo() {
		return ("Piso");
	}

}
