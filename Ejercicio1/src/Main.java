import java.util.ArrayList;
import java.util.List;

public class Main {

	public final static int TIPO_TELEFONO = 1;
	public final static int TIPO_ORDENADOR = 2;
	public final static int TIPO_ORDENADOR_BOLSILLO = 3;

	public static List<Telefono> listaTelefonos;
	public static List<Ordenador> listaOrdenadores;
	public static List<OrdenadorBolsillo> listaOrdenadoresBolsillo;

	private static void inicializaListaTelefonos() {

		listaTelefonos = new ArrayList<Telefono>();

		Telefono t1 = new Telefono();
		t1.setMarca("Samsung");
		Telefono t2 = new Telefono();
		t2.setMarca("LG");
		Telefono t3 = new Telefono();
		t3.setMarca("Motorola");

		listaTelefonos.add(t1);
		listaTelefonos.add(t2);
		listaTelefonos.add(t3);

	}

	private static void inicializaListaOrdenadores() {

		listaOrdenadores = new ArrayList<Ordenador>();

		Ordenador o1 = new Ordenador();
		o1.setMarca("Asus");
		o1.setPrecio(625.50f);

		Ordenador o2 = new Ordenador();
		o2.setMarca("Acer");
		o2.setPrecio(785.70f);

		Ordenador o3 = new Ordenador();
		o3.setMarca("Lenovo");
		o3.setPrecio(550f);

		Ordenador o4 = new Ordenador();
		o4.setMarca("HP");
		o4.setPrecio(664.43f);

		listaOrdenadores.add(o1);
		listaOrdenadores.add(o2);
		listaOrdenadores.add(o3);
		listaOrdenadores.add(o4);

	}

	private static void inicializaListaOrdenadoresBolsillo() {

		listaOrdenadoresBolsillo = new ArrayList<OrdenadorBolsillo>();

		OrdenadorBolsillo ob1 = new OrdenadorBolsillo();
		ob1.setMarca("Adidas");
		ob1.setPrecio(112.50f);

		OrdenadorBolsillo ob2 = new OrdenadorBolsillo();
		ob2.setMarca("Nike");
		ob2.setPrecio(173.54f);

		listaOrdenadoresBolsillo.add(ob1);
		listaOrdenadoresBolsillo.add(ob2);

	}

	private static void listarTelefonos() {

		for (int i = 0; i < listaTelefonos.size(); i++) {
			Telefono t = listaTelefonos.get(i);
			System.out.println(t.getTipoMaquina());
			System.out.println(t.getMarca());
		}

	}

	private static void listarOrdenadores() {

		for (int i = 0; i < listaOrdenadores.size(); i++) {
			Ordenador o = listaOrdenadores.get(i);
			System.out.println(o.getTipoMaquina());
			System.out.println(o.getMarca());
			System.out.println(o.getPrecio());
		}

	}

	private static void listarOrdenadoresBolsillo() {

		for (int i = 0; i < listaOrdenadoresBolsillo.size(); i++) {
			OrdenadorBolsillo ob = listaOrdenadoresBolsillo.get(i);
			System.out.println(ob.getTipoMaquina());
			System.out.println(ob.getMarca());
			System.out.println(ob.getPrecio());
		}

	}

	private static boolean existeElemento(int tipoElemento, Object obj) {
		boolean existe = false;

		switch (tipoElemento) {
		case TIPO_TELEFONO:
			Telefono t = (Telefono) obj;
			existe = listaTelefonos.contains(t);
			break;
		case TIPO_ORDENADOR:
			Ordenador o = (Ordenador) obj;
			existe = listaOrdenadores.contains(o);
			break;
		case TIPO_ORDENADOR_BOLSILLO:
			OrdenadorBolsillo ob = (OrdenadorBolsillo) obj;
			existe = listaOrdenadoresBolsillo.contains(ob);
			break;
		}

		return existe;

	}

	private static void addElemento(Object elemento) {

		if (elemento instanceof Telefono) {

			Telefono t = (Telefono) elemento;
			listaTelefonos.add(t);

		} else if (elemento instanceof Ordenador) {

			Ordenador o = (Ordenador) elemento;
			listaOrdenadores.add(o);

		} else {

			OrdenadorBolsillo ob = (OrdenadorBolsillo) elemento;
			listaOrdenadoresBolsillo.add(ob);
		}

	}

	public static void main(String[] args) {

		inicializaListaTelefonos();
		inicializaListaOrdenadores();
		inicializaListaOrdenadoresBolsillo();

		listarTelefonos();
		listarOrdenadores();
		listarOrdenadoresBolsillo();

		Telefono tNuevo = new Telefono();
		tNuevo.setMarca("LG");

		if (existeElemento(TIPO_TELEFONO, tNuevo)) {
			System.out.println("Existe el telefono " + tNuevo.getMarca());
		} else {
			System.out.println("No existe el telefono " + tNuevo.getMarca());
			addElemento(tNuevo);
			System.out.println("Hemos añadido el teléfono: "
					+ tNuevo.getMarca());
		}

		Telefono tNuevo2 = new Telefono();
		tNuevo2.setMarca("Alcatel");

		if (existeElemento(TIPO_TELEFONO, tNuevo2)) {
			System.out.println("Existe el telefono " + tNuevo2.getMarca());
		} else {
			System.out.println("No existe el telefono " + tNuevo2.getMarca());
			addElemento(tNuevo2);
			System.out.println("Hemos añadido el teléfono: "
					+ tNuevo2.getMarca());
		}
		
		listarTelefonos();

	}

}
