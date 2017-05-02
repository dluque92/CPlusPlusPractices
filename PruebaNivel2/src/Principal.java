import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	// DECLARAMOS LISTA COMO PROPIEDAD GLOBAL, ASI ES ACCESIBLE DESDE CUALQUIER
	// M�TODO
	// DECLARAMOS LA LISTA Y LA INSTANCIAMOS
	static List lista = new ArrayList<Integer>();

	// METODO PRINCIPAL O MAIN. SIEMPRE ES EST�TICO, POR LO QUE SI DENTRO DE
	// ESTE M�TODO QUEREMOS LLAMAR A OTROS M�TODOS
	// DE ESTA CLASE PRINCIPAL, ESOS OTROS M�TODOS DEBEREMOS DECLARARLOS COMO
	// EST�TICOS
	public static void main(String[] args) {
		// A�ADIMOS LOS 20 ENTEROS A LA LISTA
		lista.add(new Integer(123));
		lista.add(new Integer(124));
		lista.add(new Integer(125));
		lista.add(new Integer(126));
		lista.add(new Integer(127));
		lista.add(new Integer(128));
		lista.add(new Integer(129));
		lista.add(new Integer(130));
		lista.add(new Integer(131));
		lista.add(new Integer(132));

		lista.add(new Integer(323));
		lista.add(new Integer(324));
		lista.add(new Integer(425));
		lista.add(new Integer(526));
		lista.add(new Integer(627));
		lista.add(new Integer(728));
		lista.add(new Integer(829));
		lista.add(new Integer(930));
		lista.add(new Integer(188));
		lista.add(new Integer(333));

		// ORDENAMOS LA LISTA
		Collections.sort(lista);

		// COMPROBAMOS SI EXISTE EL NUMERO 3333
		if (existeNumero(3333)) {
			System.out.println("Existe el numero");
		} else {
			System.out.println("No existe el numero");
		}

		// COMPROBAMOS SI EXISTE EL NUMERO 188
		if (existeNumero(188)) {
			System.out.println("Existe el numero");
		} else {
			System.out.println("No existe el numero");
		}

		// IMPRIMIMOS LISTA
		imprimirLista();

		// A�ADIMOS NUEVO ELEMENTO
		anyadeNumero(654);

		// IMPRIMIMOS LISTA DESPUES DE A�ADIR EL NUEVO ELEMENTO
		imprimirLista();
	}

	// M�TODO QUE SE ENCARGA DE RECORRER LA LISTA E IMPRIMIR CADA ELEMENTO POR
	// PANTALLA
	public static void imprimirLista() {
		if (lista != null) {
			System.out.println("La lista contiene los siguientes elementos: ");
			for (int i = 0; i < lista.size(); i++) {
				Integer elemento = (Integer) lista.get(i);
				System.out.println(elemento);
			}
		}
	}

	// M�TODO QUE COMPRUEBA SI UN NUMERO QUE PASAMOS POR PAR�METRO ESTA EN LA
	// LISTA O NO
	public static boolean existeNumero(Integer numero) {
		if (lista != null && lista.contains(numero)) {
			return true;
		} else {
			return false;
		}
	}

	// M�TODO QUE A�ADE A LA LISTA UN N�MERO PASADO COMO PAR�METRO
	// ANTES DE A�ADIR COMPRUEBA QUE NO EST� PARA AS� NO A�ADIR DUPLICADOS
	public static void anyadeNumero(Integer numero) {
		if (lista != null && !lista.contains(numero)) {
			lista.add(numero);
			// ORDENAMOS LA LISTA DESPUES DE QUE A�ADIR EL NUEVO ELEMENTO
			Collections.sort(lista);
		}

	}

}
