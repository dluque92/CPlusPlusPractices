package test.modelo;

import modelo.Asignatura;
import modelo.AsignaturaDAO;

import org.junit.Assert;
import org.junit.Test;

public class AsignaturaDAOTest {

	private AsignaturaDAO dao;

	@Test
	public void testPersist() {

		dao = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();

		asignatura.setNombre("Historia");
		asignatura.setHorario("15:00-17:00");
		asignatura.setAula("D");

		dao.persist(asignatura);
		Integer id = asignatura.getIdAsignatura();
		Assert.assertNotNull(id);

		Asignatura nuevaAsignatura = dao.findById(id);

		Assert.assertEquals("Historia", nuevaAsignatura.getNombre());
		Assert.assertEquals("15:00-17:00", nuevaAsignatura.getHorario());
		Assert.assertEquals("D", nuevaAsignatura.getAula());

	}
	
	@Test
	public void testRemove() {

		dao = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();

		asignatura.setNombre("Historia2");
		asignatura.setHorario("16:00-17:00");
		asignatura.setAula("E");

		dao.persist(asignatura);
		Integer id = asignatura.getIdAsignatura();
		Assert.assertNotNull(id);

		Asignatura nuevaAsignatura = dao.findById(id);
		
		dao.remove(nuevaAsignatura);
		
		Asignatura nuevaAsignatura2 = dao.findById(id);
		
		Assert.assertNull(nuevaAsignatura2);

	}
	
	@Test
	public void testMerge() {

		dao = new AsignaturaDAO();
		Asignatura asignatura = new Asignatura();

		asignatura.setNombre("Historia3");
		asignatura.setHorario("15:00-17:00");
		asignatura.setAula("D");
		
		dao.persist(asignatura);
		Integer id = asignatura.getIdAsignatura();
		Assert.assertNotNull(id);

		Asignatura asignaturaAModificar = dao.findById(id);
		
		asignaturaAModificar.setNombre("Historia4");
		asignaturaAModificar.setHorario("15:00-17:00");
		asignaturaAModificar.setAula("D");
		
		
		dao.merge(asignaturaAModificar);
		id = asignaturaAModificar.getIdAsignatura();
		
		Asignatura nuevaAsignatura = dao.findById(id);
		
		Assert.assertEquals("Historia4", nuevaAsignatura.getNombre());
		Assert.assertEquals("15:00-17:00", nuevaAsignatura.getHorario());
		Assert.assertEquals("D", nuevaAsignatura.getAula());
	}
	
}
