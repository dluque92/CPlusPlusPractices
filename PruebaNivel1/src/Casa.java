public class Casa {

	// DEFINIMOS LAS PROPIEDAS
	private int numHabitaciones;
	private int numCuartosBanyo;
	private float precio;
	private String direccion;
	private boolean comprada;

	// GENERAMOS LOS M�TODOS SETTER Y GETTER
	// MEN� - SOURCE - GENERATE GETTERS AND SETTERS
	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public int getNumCuartosBanyo() {
		return numCuartosBanyo;
	}

	public void setNumCuartosBanyo(int numCuartosBanyo) {
		this.numCuartosBanyo = numCuartosBanyo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isComprada() {
		return comprada;
	}

	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}

	// GENERAMOS CONSTRUCTOR SIN PAR�METROS
	// MEN� - SOURCE - GENERATE CONSTRUCTORS FROM SUPERCLASS
	public Casa() {
		super();

	}

	// GENERAMOS CONSTRUCTOR CON PAR�METROS
	// MEN� - SOURCE - GENERATE CONSTRUCTORS USING FIELDS
	public Casa(int numHabitaciones, int numCuartosBanyo, float precio,
			String direccion, boolean comprada) {
		super();
		this.numHabitaciones = numHabitaciones;
		this.numCuartosBanyo = numCuartosBanyo;
		this.precio = precio;
		this.direccion = direccion;
		this.comprada = comprada;
	}

	// GENERAMOS METODO TOSTRING()
	// MEN� - SOURCE - GENERATE TO STRING()
	@Override
	public String toString() {
		return "Casa [numHabitaciones=" + numHabitaciones
				+ ", numCuartosBanyo=" + numCuartosBanyo + ", precio=" + precio
				+ ", direccion=" + direccion + ", comprada=" + comprada + "]";
	}

	// CREAMOS UN M�TODO PARA AUMENTAR EL N�MERO DE HABITACIONES A PARTIR
	// DE UN PAR�METRO DE ENTRADA
	public void aumentarNumeroHabitaciones(int num) {
		this.numHabitaciones = this.numHabitaciones + num;
	}

	// CREO UN METODO QUE DEVUELVE QUE TIPO DE OBJETO TENEMOS
	public String getTipo() {
		return ("Casa");
	}

}
