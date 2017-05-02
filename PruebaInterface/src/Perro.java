public class Perro implements IAnimal {

	@Override
	public void respirar() {
		System.out.println("El Perro respira");

	}

	@Override
	public void comer() {
		System.out.println("El Perro come");

	}

	@Override
	public void dormir() {
		System.out.println("El Perro duerme");

	}

	public void ladrar() {
		System.out.println("El Perro ladra");

	}

}
