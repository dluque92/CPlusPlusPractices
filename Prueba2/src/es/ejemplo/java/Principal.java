package es.ejemplo.java;

public class Principal {

	public static void main(String[] args) {

		AlumnoInstituto aInsti = new AlumnoInstituto();

		aInsti.setNombre("Pepe");
		aInsti.setApellidos("P�rez");
		aInsti.setEdad(24);
		aInsti.setHorario("Todos los d�as");
		
		System.out.println(aInsti.toString());

	}

}
