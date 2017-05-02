public class Gato implements IAnimal {

	@Override
	public void respirar() {
		System.out.println("El Gato respira");

	}

	@Override
	public void comer() {
		System.out.println("El Gato come");

	}

	@Override
	public void dormir() {
		System.out.println("El Gato duerme");

	}
	
	public void maullar() {
		System.out.println("El Gato maulla");

	}

}
