package com.academia.test.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.Profesor;
import com.academia.hibernate.ProfesorDAO;

public class ProfesorDAOTest {
	
	private ProfesorDAO dao;
	private AsignaturaDAO dao1;
	
	@Test
	public void testPersist() {

		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		
		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();
		
		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("663148697");
		profesor.setEmail("mmg@outlook.com");
		profesor.setAsignatura(asignatura1);
		
		dao.persist(profesor);
		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);

		Profesor nuevoProfesor = dao.findById(id);
		Assert.assertNotNull(nuevoProfesor);
		dao.remove(profesor);
		dao1.remove(asignatura1);
	}
	
	@Test
	public void testRemove() {

		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		
		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();

		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("663148697");
		profesor.setEmail("mmg@outlook.com");
		profesor.setAsignatura(asignatura1);

		dao.persist(profesor);
		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);

		Profesor nuevoProfesor = dao.findById(id);
		dao.remove(nuevoProfesor);
		
		Profesor nuevoProfesor2 = dao.findById(id);
		Assert.assertNull(nuevoProfesor2);
		
		dao1.remove(asignatura1);
	}
	
	@Test
	public void testMerge() {

		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		
		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();

		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Perez");
		profesor.setTelefono("623765433");
		profesor.setEmail("mmp@gmail.com");
		profesor.setAsignatura(asignatura1);
		
		dao.persist(profesor);
		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);

		Profesor profesorAModificar = dao.findById(id);
		
		profesorAModificar.setNombre("Maria");
		profesorAModificar.setApellidos("Martinez Perez");
		profesorAModificar.setTelefono("623765433");
		profesorAModificar.setEmail("mmp@gmail.com");
		
		
		dao.merge(profesorAModificar);
		id = profesorAModificar.getIdProfesor();
		
		Profesor nuevoProfesor = dao.findById(id);
		
		Assert.assertEquals("Maria", nuevoProfesor.getNombre());
		Assert.assertEquals("Martinez Perez", nuevoProfesor.getApellidos());
		Assert.assertEquals("623765433", nuevoProfesor.getTelefono());
		Assert.assertEquals("mmp@gmail.com", nuevoProfesor.getEmail());
		

		dao.remove(profesor);
		dao1.remove(asignatura1);
	}

	public void testfindById() {
		
		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		
		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();

		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("9750445");
		profesor.setEmail("mmg@gmail.com");
		profesor.setAsignatura(asignatura1);
		
		dao.persist(profesor);
		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);
		
		profesor = dao.findById(id);

		Assert.assertNotNull(profesor);
		dao.remove(profesor);
		dao1.remove(asignatura1);
	}

	public void testfindAll() {
		
		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		
		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();
		
		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("663148697");
		profesor.setEmail("mmg@outlook.com");
		profesor.setAsignatura(asignatura1);
		
		List<Profesor> lista = dao.findAll();
		Assert.assertNotNull(lista);
		
		dao.remove(profesor);
		dao1.remove(asignatura1);
	}

	@Test
	public void testFindByNombre() {
		
		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		
		
		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();
		
		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("663148697");
		profesor.setEmail("mmg@outlook.com");
		profesor.setAsignatura(asignatura1);

		dao.persist(profesor);
		List<Profesor> lista = dao.findByNombre("Maria");
		Assert.assertNotNull(lista);
		
		dao.remove(profesor);
		dao1.remove(asignatura1);

	}

	@Test
	public void testFindByApellidos() {
		
		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		
		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();

		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("9750445");
		profesor.setEmail("mmg@gmail.com");
		profesor.setAsignatura(asignatura1);
		
		dao.persist(profesor);
		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);
	
	
		List<Profesor> lista = dao.findByApellidos("Martinez Gallego");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);
		
		dao.remove(profesor);
		dao1.remove(asignatura1);

	}
	
	@Test
	public void testFindByTelefono() {
		
		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		

		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();

		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("60750445");
		profesor.setEmail("mmg@gmail.com");
		profesor.setAsignatura(asignatura1);
		
		dao.persist(profesor);
		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);

		Profesor nuevoProfesor = dao.findById(id);

	
		List<Profesor> lista = dao.findByTelefono("60750445");
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);
		
		dao.remove(nuevoProfesor);
		dao1.remove(asignatura1);
	}

	@Test
	public void testFindByEmail() {

		dao1 = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();
		Asignatura asignatura1 = new Asignatura();
		
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		dao1.persist(asignatura);
		asignatura1 = dao1.findById(asignatura.getIdAsignatura());
		

		dao = new ProfesorDAO();
		Profesor profesor = new Profesor();
		
		
		profesor.setNombre("Maria");
		profesor.setApellidos("Martinez Gallego");
		profesor.setTelefono("663148697");
		profesor.setEmail("mmg@outlook.com");
		profesor.setAsignatura(asignatura1);
		dao.persist(profesor);
		
		List<Profesor> lista = dao.findByEmail("mmg@gmail.com");
		Assert.assertNotNull(lista);
	
		
		dao.remove(profesor);
		dao1.remove(asignatura1);

	}

}

