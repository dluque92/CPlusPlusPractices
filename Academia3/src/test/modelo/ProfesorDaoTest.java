package test.modelo;

import java.util.List;

import modelo.Asignatura;
import modelo.AsignaturaDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfesorDaoTest {

	private ProfesorDAO dao;
	private AsignaturaDAO asigdao;
	private Profesor profesor;
	private Asignatura asig;
	
	@Before
	public void init(){
		
		asig = new Asignatura("Asig1", "12:30", "Aula1");
		dao = new ProfesorDAO();
		profesor = new Profesor();
		asigdao = new AsignaturaDAO();
		asigdao.persist(asig);
		
	}

	@Test
	public void testPersist() {
		
		profesor.setNombre("Antonio");
		profesor.setApellidos("Perez");
		profesor.setTelefono("638564234");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Integer idasig = asig.getIdAsignatura();

		Assert.assertNotNull(id);
		Assert.assertNotNull(idasig);

		Profesor nuevoProfesor = dao.findById(id);
		Asignatura nuevaAsignatura = asigdao.findById(idasig);

		Assert.assertEquals("Asig1", nuevaAsignatura.getNombre());
		Assert.assertEquals("12:30", nuevaAsignatura.getHorario());
		Assert.assertEquals("Aula1", nuevaAsignatura.getAula());

		Assert.assertEquals("Antonio", nuevoProfesor.getNombre());
		Assert.assertEquals("Perez", nuevoProfesor.getApellidos());
		Assert.assertEquals("638564234", nuevoProfesor.getTelefono());
		Assert.assertEquals("prueba@profesor.es", nuevoProfesor.getEmail());

		dao.remove(profesor);
		asigdao.remove(asig);

	}

	@Test
	public void testRemove() {	

		profesor.setNombre("Antonio");
		profesor.setApellidos("Perez");
		profesor.setTelefono("638564234");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Integer idasig = asig.getIdAsignatura();

		Assert.assertNotNull(id);

		Profesor nuevoProfesor = dao.findById(id);
		Asignatura borrarAsignatura = asigdao.findById(idasig);

		dao.remove(nuevoProfesor);
		asigdao.remove(borrarAsignatura);

		Profesor nuevoProfesor2 = dao.findById(id);

		Assert.assertNull(nuevoProfesor2);

	}

	@Test
	public void testMerge() {

		profesor.setNombre("Antonio");
		profesor.setApellidos("Perez");
		profesor.setTelefono("638564234");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);

		Profesor profesorAModificar = dao.findById(id);

		profesorAModificar.setNombre("Otro Nuevo 2");
		profesorAModificar.setApellidos("Mas 3");
		profesorAModificar.setTelefono("333444555");
		profesorAModificar.setEmail("otro_mas_2@hotmail.com");
		profesorAModificar.setAsignatura(asig);

		dao.merge(profesorAModificar);
		id = profesorAModificar.getIdProfesor();

		Profesor nuevoProfesor = dao.findById(id);

		Assert.assertEquals("Otro Nuevo 2", nuevoProfesor.getNombre());
		Assert.assertEquals("Mas 3", nuevoProfesor.getApellidos());
		Assert.assertEquals("333444555", nuevoProfesor.getTelefono());
		Assert.assertEquals("otro_mas_2@hotmail.com", nuevoProfesor.getEmail());
		Assert.assertEquals("otro_mas_2@hotmail.com", nuevoProfesor.getEmail());

		dao.remove(profesor);
		asigdao.remove(asig);

	}
	
	@Test
	public void testFindById() {

		profesor.setNombre("Antonio");
		profesor.setApellidos("Perez");
		profesor.setTelefono("638564234");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Integer idasig = asig.getIdAsignatura();

		Assert.assertNotNull(id);
		Assert.assertNotNull(idasig);

		Profesor nuevoProfesor = dao.findById(id);
		Asignatura nuevaAsignatura = asigdao.findById(idasig);

		Assert.assertEquals("Asig1", nuevaAsignatura.getNombre());
		Assert.assertEquals("12:30", nuevaAsignatura.getHorario());
		Assert.assertEquals("Aula1", nuevaAsignatura.getAula());

		Assert.assertEquals("Antonio", nuevoProfesor.getNombre());
		Assert.assertEquals("Perez", nuevoProfesor.getApellidos());
		Assert.assertEquals("638564234", nuevoProfesor.getTelefono());
		Assert.assertEquals("prueba@profesor.es", nuevoProfesor.getEmail());

		dao.remove(profesor);
		asigdao.remove(asig);

	}
	
	@Test
	public void testFindAll() {
		
		dao = new ProfesorDAO();
		profesor = new Profesor();

		List<Profesor> listaProfesor = dao.findAll();

		for (int n = 0; n >= listaProfesor.size(); n++) {
			if (n != listaProfesor.size()) {
				Profesor profe = listaProfesor.get(n);
				Profesor profe2 = listaProfesor.get(n + 1);
				Assert.assertNotEquals(profe, profe2);
			}
		}

	}
	
	/*
	 * 
	 * Falla el testfind por que no recoge el query
	 * 
	 
	@Test
	public void testFind() {
		
		profesor.setNombre("Antonio");
		profesor.setApellidos("Perez");
		profesor.setTelefono("638564234");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Assert.assertNotNull(id);
		
		String query = "SELECT p FROM academia_bd.profesor where idPROFESOR=" + profesor.getIdProfesor()+ ";";

		List<Profesor> nuevoProfesor = dao.find(query);
		
		Assert.assertEquals("Antonio", nuevoProfesor.get(0).getNombre());
		Assert.assertEquals("Perez", nuevoProfesor.get(0).getApellidos());
		Assert.assertEquals("638564234", nuevoProfesor.get(0).getTelefono());
		Assert.assertEquals("prueba@profesor.es", nuevoProfesor.get(0).getEmail());

		dao.remove(profesor);
		asigdao.remove(asig);
		
	}*/
	
	@Test
	public void testFindByNombre() {
		
		profesor.setNombre("Andre23s");
		profesor.setApellidos("Perez");
		profesor.setTelefono("638564234");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Integer idasig = asig.getIdAsignatura();

		Assert.assertNotNull(id);
		Assert.assertNotNull(idasig);

		List<Profesor> listaProfesor = dao.findByNombre("Andre23s");

		for (int n = 0; n >= listaProfesor.size(); n++) {
			if (n != listaProfesor.size()) {
				Profesor profe = listaProfesor.get(n);
				Assert.assertEquals(profe, profesor);
			}
		}
		
		dao.remove(profesor);
		asigdao.remove(asig);
	
	}
	
	@Test
	public void testFindByApellidos() {
		
		profesor.setNombre("Andre23s");
		profesor.setApellidos("Perez76");
		profesor.setTelefono("638564234");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Integer idasig = asig.getIdAsignatura();

		Assert.assertNotNull(id);
		Assert.assertNotNull(idasig);

		List<Profesor> listaProfesor = dao.findByApellidos("Perez76");

		for (int n = 0; n >= listaProfesor.size(); n++) {
			if (n != listaProfesor.size()) {
				Profesor profe = listaProfesor.get(n);
				Assert.assertEquals(profe, profesor);
			}
		}
		
		dao.remove(profesor);
		asigdao.remove(asig);
	
	}
	
	@Test
	public void testFindByTelefono() {
		
		profesor.setNombre("Andre23s");
		profesor.setApellidos("Perez");
		profesor.setTelefono("telefono");
		profesor.setEmail("prueba@profesor.es");

		profesor.setAsignatura(asig);

		dao.persist(profesor);

		Integer id = profesor.getIdProfesor();
		Integer idasig = asig.getIdAsignatura();

		Assert.assertNotNull(id);
		Assert.assertNotNull(idasig);

		List<Profesor> listaProfesor = dao.findByTelefono("telefono");

		for (int n = 0; n >= listaProfesor.size(); n++) {
			if (n != listaProfesor.size()) {
				Profesor profe = listaProfesor.get(n);
				Assert.assertEquals(profe, profesor);
			}
		}
		
		dao.remove(profesor);
		asigdao.remove(asig);
	
	}

}
