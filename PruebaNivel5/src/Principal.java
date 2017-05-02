import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		// CREAMOS O INSTACIAMOS LA LISTA
		List listaNotasParciales = new ArrayList<Double>();
		// AÑADIMOS LOS ELEMENTOS O NOTAS A LA LISTA
		listaNotasParciales.add(7.3);
		listaNotasParciales.add(5.5d);
		listaNotasParciales.add(8d);

		// CREAMOS LA CLASE QUE IMPLEMENTA LA INTERFAZ
		Matematicas m = new Matematicas();

		// CALCULAMOS LA NOTA MEDIA Y LA IMPRIMIMOS POR PANTALLA
		System.out.println("La nota media de los " + listaNotasParciales.size()
				+ " es " + m.obtenerNotaMedia(listaNotasParciales));

	}

}
