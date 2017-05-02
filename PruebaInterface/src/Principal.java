
public class Principal {

	public static void main(String[] args) {
		
		Perro perro = new Perro();
		Gato gato = new Gato();
		
		perro.dormir();
		gato.dormir();
		
		perro.ladrar();
		gato.maullar();
		
		Bulldog bulldog = new Bulldog();
		bulldog.ladrar();
		bulldog.getRaza();

	}

}
