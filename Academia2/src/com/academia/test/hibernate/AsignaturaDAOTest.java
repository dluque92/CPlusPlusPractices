package com.academia.test.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.academia.hibernate.Alumno;
import com.academia.hibernate.AlumnoDAO;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;

public class AsignaturaDAOTest {

	private AsignaturaDAO dao;

	@Test
	public void testPersist() {

		dao = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();

		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");

		dao.persist(asignatura);
		Integer id = asignatura.getIdAsignatura();
		Assert.assertNotNull(id);

		Asignatura nuevoAsignatura = dao.findById(id);

		Assert.assertEquals("Nueva", nuevoAsignatura.getNombre());
		Assert.assertEquals("1A", nuevoAsignatura.getAula());
		Assert.assertEquals("De 3 a 5", nuevoAsignatura.getHorario());

	}

	@Test
	public void testRemove() {

		dao = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();

		asignatura.setNombre("Nueva Dos");
		asignatura.setAula("1B");
		asignatura.setHorario("De 5 a 7");

		dao.persist(asignatura);
		Integer id = asignatura.getIdAsignatura();
		Assert.assertNotNull(id);

		Asignatura nuevoAsignatura = dao.findById(id);

		dao.remove(nuevoAsignatura);

		Asignatura nuevoAsignatura2 = dao.findById(id);

		Assert.assertNull(nuevoAsignatura2);

	}

	@Test
	public void testMerge() {

		dao = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();

		asignatura.setNombre("Nueva Tres");
		asignatura.setAula("1C");
		asignatura.setHorario("De 7 a 9");

		dao.persist(asignatura);
		Integer id = asignatura.getIdAsignatura();
		Assert.assertNotNull(id);

		Asignatura asignaturaAModificar = dao.findById(id);

		asignaturaAModificar.setNombre("Nueva Tres Modificada");
		asignaturaAModificar.setAula("1D");
		asignaturaAModificar.setHorario("De 7 a 9:30");

		dao.merge(asignaturaAModificar);
		id = asignaturaAModificar.getIdAsignatura();

		Asignatura nuevoAsignatura = dao.findById(id);

		Assert.assertEquals("Nueva Tres Modificada",
				nuevoAsignatura.getNombre());
		Assert.assertEquals("1D", nuevoAsignatura.getAula());
		Assert.assertEquals("De 7 a 9:30", nuevoAsignatura.getHorario());

	}

	@Test
	public void testFindById() {

		dao = new AsignaturaDAO();
		// La asignatura que hemos insertado en el test del metodo persist tiene
		// id
		// = 14
		Asignatura asignatura = dao.findById(14);

		Assert.assertNotNull(asignatura);

	}

	@Test
	public void testFindAll() {

		dao = new AsignaturaDAO();
		List<Asignatura> lista = dao.findAll();
		// Comprobamos que la lista sea distinta de nula
		Assert.assertNotNull(lista);
		// Comrpobamos que el tamaño de la lista sea mayor que cero
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByNombre() {

		dao = new AsignaturaDAO();
		List<Asignatura> lista = dao.findByNombre("Nueva");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByAula() {

		dao = new AsignaturaDAO();
		List<Asignatura> lista = dao.findByAula("1A");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

	@Test
	public void testFindByHorario() {

		dao = new AsignaturaDAO();
		List<Asignatura> lista = dao.findByHorario("De 3 a 5");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);

	}

}
