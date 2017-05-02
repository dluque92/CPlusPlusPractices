package com.academia.test.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.academia.hibernate.Alumno;
import com.academia.hibernate.AlumnoDAO;

public class AlumnoDAOTest {

	private AlumnoDAO dao;

	@Test
	public void testPersist() {

		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();

		alumno.setNombre("Nueva");
		alumno.setApellidos("1ffffffA");
		alumno.setTelefono("60750445");
		alumno.setEmail("De 3 a 5");
		
		dao.persist(alumno);
		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);

		Alumno nuevoAlumno = dao.findById(id);
		Assert.assertNotNull(nuevoAlumno);
		dao.remove(nuevoAlumno);

	}

	@Test
	public void testRemove() {

		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();

		alumno.setNombre("Nueva Dos");
		alumno.setApellidos("1B");
		alumno.setTelefono("60750445");
		alumno.setEmail("De 5 a 7");

		dao.persist(alumno);
		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);

		Alumno nuevoAlumno = dao.findById(id);

		dao.remove(nuevoAlumno);

		Alumno nuevoAlumno2 = dao.findById(id);

		Assert.assertNull(nuevoAlumno2);

	}

	@Test
	public void testMerge() {

		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();

		alumno.setNombre("Nueva Tres");
		alumno.setApellidos("1C");
		alumno.setTelefono("9750445");
		alumno.setEmail("De 7 a 9");

		dao.persist(alumno);
		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);

		Alumno alumnoAModificar = dao.findById(id);

		alumnoAModificar.setNombre("Nueva Tres Modificada");
		alumnoAModificar.setApellidos("1D");
		alumnoAModificar.setEmail("De 7 a 9:30");
		alumnoAModificar.setTelefono("60750445");


		dao.merge(alumnoAModificar);
		id = alumnoAModificar.getIdAlumno();

		Alumno nuevoAlumno = dao.findById(id);

		Assert.assertEquals("Nueva Tres Modificada",
				nuevoAlumno.getNombre());
		Assert.assertEquals("1D", nuevoAlumno.getApellidos());
		Assert.assertEquals("60750445", nuevoAlumno.getTelefono());
		Assert.assertEquals("De 7 a 9:30", nuevoAlumno.getEmail());
		
	}

	@Test
	public void testFindById() {

		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();

		alumno.setNombre("Nueva Tres");
		alumno.setApellidos("1");
		alumno.setTelefono("9750445");
		alumno.setEmail("De 7 a 9");

		dao.persist(alumno);
		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);
		// La asignatura que hemos insertado en el test del metodo persist tiene
		// id
		// = 14
		alumno = dao.findById(id);

		Assert.assertNotNull(alumno);
		dao.remove(alumno);

	}

	@Test
	public void testFindAll() {

		dao = new AlumnoDAO();
		List<Alumno> lista = dao.findAll();
		// Comprobamos que la lista sea distinta de nula
		Assert.assertNotNull(lista);
		// Comrpobamos que el tamaño de la lista sea mayor que cero
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByNombre() {

		dao = new AlumnoDAO();
		List<Alumno> lista = dao.findByNombre("Nueva");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByApellidos() {
		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();

		alumno.setNombre("Nueva Tres");
		alumno.setApellidos("1");
		alumno.setTelefono("9750445");
		alumno.setEmail("De 7 a 9");

		dao.persist(alumno);
		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);
	
	
		List<Alumno> lista = dao.findByApellidos("1");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);
		dao.remove(alumno);

	}
	
	@Test
	public void testFindByTelefono() {

		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();

		alumno.setNombre("Nueva Dos");
		alumno.setApellidos("1B");
		alumno.setTelefono("60750445");
		alumno.setEmail("De 5 a 7");

		dao.persist(alumno);
		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);

		Alumno nuevoAlumno = dao.findById(id);

	
		List<Alumno> lista = dao.findByTelefono("60750445");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);
		dao.remove(nuevoAlumno);
	}

	@Test
	public void testFindByEmail() {

		dao = new AlumnoDAO();
		List<Alumno> lista = dao.findByEmail("De 3 a 5");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

}
