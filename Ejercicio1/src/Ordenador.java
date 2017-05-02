public class Ordenador extends Maquina {

	private float precio;

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String getTipoMaquina() {
		return ("Ordenador");
	}

}
