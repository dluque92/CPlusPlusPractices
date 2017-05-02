public class Chalet extends Casa {

	private boolean tienePiscina;

	public boolean isTienePiscina() {
		return tienePiscina;
	}

	public void setTienePiscina(boolean tienePiscina) {
		this.tienePiscina = tienePiscina;
	}

	public Chalet() {
		super();
	}

	public Chalet(int numHabitaciones, int numCuartosBanyo, float precio,
			String direccion, boolean comprada) {
		super(numHabitaciones, numCuartosBanyo, precio, direccion, comprada);
	}

	public Chalet(boolean tienePiscina) {
		super();
		this.tienePiscina = tienePiscina;
	}

	public Chalet(int numHabitaciones, int numCuartosBanyo, float precio,
			String direccion, boolean comprada, boolean tienePiscina) {
		super(numHabitaciones, numCuartosBanyo, precio, direccion, comprada);
		this.tienePiscina = tienePiscina;
	}

	@Override
	public String getTipo() {
		return ("Chalet");
	}

	@Override
	public String toString() {
		return "Chalet [tienePiscina=" + tienePiscina
				+ ", getNumHabitaciones()=" + getNumHabitaciones()
				+ ", getNumCuartosBanyo()=" + getNumCuartosBanyo()
				+ ", getPrecio()=" + getPrecio() + ", getDireccion()="
				+ getDireccion() + ", isComprada()=" + isComprada() + "]";
	}

}
