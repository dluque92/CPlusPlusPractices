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

		alumno.setNombre("Cesar");
		alumno.setApellidos("Rubio");
		alumno.setTelefono("656");
		alumno.setEmail("cesar@hotmail.com");

		dao.persist(alumno);

		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);

		Alumno nuevoAlumno = dao.findById(id);

		Assert.assertEquals("Cesar", nuevoAlumno.getNombre());
		Assert.assertEquals("Rubio", nuevoAlumno.getApellidos());
		Assert.assertEquals("656", nuevoAlumno.getTelefono());
		Assert.assertEquals("cesar@hotmail.com", nuevoAlumno.getEmail());

	}

	@Test
	public void testRemove() {

		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();

		alumno.setNombre("Otro");
		alumno.setApellidos("Mas");
		alumno.setTelefono("333");
		alumno.setEmail("otro@hotmail.com");

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

		alumno.setNombre("Otro Nuevo");
		alumno.setApellidos("Mas 2");
		alumno.setTelefono("333444");
		alumno.setEmail("otro_mas@hotmail.com");

		dao.persist(alumno);
		Integer id = alumno.getIdAlumno();
		Assert.assertNotNull(id);

		Alumno alumnoAModificar = dao.findById(id);

		alumnoAModificar.setNombre("Otro Nuevo 2");
		alumnoAModificar.setApellidos("Mas 3");
		alumnoAModificar.setTelefono("333444555");
		alumnoAModificar.setEmail("otro_mas_2@hotmail.com");

		dao.merge(alumnoAModificar);
		id = alumnoAModificar.getIdAlumno();

		Alumno nuevoAlumno = dao.findById(id);

		Assert.assertEquals("Otro Nuevo 2", nuevoAlumno.getNombre());
		Assert.assertEquals("Mas 3", nuevoAlumno.getApellidos());
		Assert.assertEquals("333444555", nuevoAlumno.getTelefono());
		Assert.assertEquals("otro_mas_2@hotmail.com", nuevoAlumno.getEmail());

	}

	@Test
	public void testFindById() {

		dao = new AlumnoDAO();
		// El alumno que hemos insertado en el test del metodo persist tiene id
		// = 51
		Alumno alumno = dao.findById(51);

		Assert.assertNotNull(alumno);

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
		List<Alumno> lista = dao.findByNombre("Cesar");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByApellidos() {

		dao = new AlumnoDAO();
		List<Alumno> lista = dao.findByApellidos("Rubio");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByTelefono() {

		dao = new AlumnoDAO();
		List<Alumno> lista = dao.findByTelefono("656");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByEmail() {

		dao = new AlumnoDAO();
		List<Alumno> lista = dao.findByEmail("cesar@hotmail.com");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

}
