import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Principal {

	// MÉTODO CON ARRAYLIST (PERMITE DUPLICADOS)
	public static void metodo1() {

		try {
			// CREAMOS UNA LISTA QUE VA A CONTENER NOMBRES
			List listaNombres = new ArrayList<String>();
			// VAMOS AÑADIENDO LOS NOMBRES UNO A UNO
			listaNombres.add("Jose");
			listaNombres.add("Antonio");
			listaNombres.add("Carlos");
			listaNombres.add("Fran");

			// RECORREMOS LA LISTA ENTERA, DE UNO EN UNO, COMENZANDO EN LA
			// POSICION
			// CERO Y TERMINANDO EN EL ULTIMO ELEMENTO DE LA LISTA, DEFINIDO POR
			// EL TAMAÑO DE LA LISTA (LISTA.SIZE())
			for (int i = 0; i < listaNombres.size(); i++) {
				// OBTENEMOS CADA ELEMENTO DE LA LISTA
				String nombre = (String) listaNombres.get(i);
				// IMPRIMIMOS POR PANTALLA ESE ELEMENTO
				System.out.println("Nombre " + i + ": " + nombre);
			}
		} catch (Exception e) {
			// SI SE PRODUCE UN ERROR, LO CAPTURAMOS
			// LA EJECUCIÓN DEBE PASAR POR AQUI EN CASO DE ERROR
			System.out.println("Falloooooooo");
			e.printStackTrace();
		}

	}

	// VAMOS A TRABAJAR CON HASHMAP
	public static void metodo2() {
		// CREAMOS UN OBJETO DE LA CLASE HASHMAP PARA ALMACENAR DATOS
		// LA CLAVE SERÁ DE TIPO INTEGER Y EL VALOR DE TIPO STRING
		Map<Integer, String> map = new HashMap<Integer, String>();

		// METEMOS CADA UNO DE LOS ELEMENTOS
		// EL PRIMER ELEMENTO, LA CLAVE TIENE QUE SER ÚNICO
		// EL SEGUNDO ELEMENTO, EL VALOR, NO TIENE PORQUE SER ÚNICO
		map.put(new Integer(1), "Uno");
		map.put(new Integer(2), "Dos");
		map.put(new Integer(3), "Tres");

		// OBTENEMOS UNA ENUMERACION CON LAS CLAVES
		Enumeration e1 = Collections.enumeration(map.keySet());
		// RECORREMOS LA ENUMERACIÓN ENTERA PREGUNTANDO SI HAY MAS ELEMENTOS
		while (e1.hasMoreElements()) {
			// IMPRIMO POR PANTALLA LA CLAVE
			System.out.println(e1.nextElement());
		}

		// OBTENEMOS UNA ENUMERACION CON LOS VALOR
		Enumeration e2 = Collections.enumeration(map.values());
		// RECORREMOS LA ENUMERACIÓN ENTERA PREGUNTANDO SI HAY MAS ELEMENTOS
		while (e2.hasMoreElements()) {
			// IMPRIMO POR PANTALLA EL VALOR
			System.out.println(e2.nextElement());
		}

	}

	// VAMOS A TRABAJAR CON HASHSET (NO PERMITE DUPLICADOS)
	public static void metodo3() {
		// CREAMOS EL HASHSET
		HashSet hash = new HashSet<>();
		// DEFINIMOS CADA UNO DE LOS ELEMENTOS
		String str1 = "Yellow";
		String str2 = "White";
		String str3 = "Green";
		String str4 = "Blue";

		// VAMOS AÑADIENDO CADA UNO DE LOS ELEMENTOS
		hash.add(str1);
		hash.add(str2);
		hash.add(str3);
		hash.add(str4);

		// OBTENEMOS LOS ELEMENTOS EN UN ITERADOR
		Iterator iterator = hash.iterator();
		// RECORREMOS LA ITERACIÓN ENTERA PREGUNTANDO SI HAY MAS ELEMENTOS, SI
		// HAY
		// SIGUIENTE
		while (iterator.hasNext()) {
			// OBTENEMOS CADA UNO DE LOS ELEMENTOS Y LOS IMPRIMIMOS POR PANTALLA
			System.out.println(iterator.next() + " ");
		}
	}

	public static void main(String[] args) {

		metodo3();

	}

}
