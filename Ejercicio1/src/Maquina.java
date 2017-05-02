import java.util.List;

public abstract class Maquina {

	private String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public abstract String getTipoMaquina();

}
