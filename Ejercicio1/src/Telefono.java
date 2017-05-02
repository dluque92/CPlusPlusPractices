
public class Telefono extends Maquina {

	@Override
	public String getTipoMaquina() {
		return ("Tel�fono");
	}

	@Override
	public boolean equals(Object object) {
		boolean equals = false;

		if (object != null && object instanceof Telefono) {
			equals = this.getMarca() == ((Telefono) object).getMarca();
		}

		return equals;
	}

}
