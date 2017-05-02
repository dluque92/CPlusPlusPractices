public class Principal {

	public static void main(String[] args) {

		Alumno alumno1 = new Alumno();

		alumno1.setNombre("Pepe");
		alumno1.setApellidos("Pérez");
		alumno1.setEdad(24);

		Alumno alumno2 = new Alumno("Pepe", "Pérez", 24);

		System.out.println("Alumno numero 1: " + alumno1.toString());
		System.out.println("Alumno numero 2: " + alumno2.toString());

		if (alumno1.equals(alumno2)) {
			System.out.println("Los alumnos son iguales");
		} else {
			System.out.println("Los alumnos son distintos");
		}

	}

}
