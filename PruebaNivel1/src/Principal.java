public class Principal {

	public static void main(String[] args) {

		Casa casa = new Casa();
		casa.setNumHabitaciones(3);
		casa.setNumCuartosBanyo(2);
		casa.setComprada(true);
		casa.setDireccion("Calle Curruca, 23");
		casa.setPrecio(200000f);

		Piso piso = new Piso();
		piso.setNumHabitaciones(2);
		piso.setNumCuartosBanyo(1);
		piso.setComprada(false);
		piso.setDireccion("Calle Samuel, 7");
		piso.setNumeroPiso("3ºA");
		piso.setPrecio(60000f);

		Adosado adosado = new Adosado();
		adosado.setNumHabitaciones(4);
		adosado.setNumCuartosBanyo(2);
		adosado.setComprada(true);
		adosado.setDireccion("Calle Samuel, 7");
		adosado.setNombreUrbanizacion("El Romeral");
		adosado.setPrecio(180000f);

		Chalet chalet = new Chalet();
		chalet.setNumHabitaciones(5);
		chalet.setNumCuartosBanyo(3);
		chalet.setComprada(true);
		chalet.setDireccion("Calle Federico, 42");
		chalet.setTienePiscina(true);
		chalet.setPrecio(300000f);

		System.out.println(casa.toString());
		System.out.println(piso.toString());
		System.out.println(adosado.toString());
		System.out.println(chalet.toString());

		casa.aumentarNumeroHabitaciones(3);
		piso.aumentarNumeroHabitaciones(2);

		System.out.println(casa.toString());
		System.out.println(piso.toString());

	}

}
