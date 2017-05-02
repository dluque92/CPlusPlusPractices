package test.modelo;

import java.util.List;

import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.Profesor;

import org.junit.Assert;
import org.junit.Test;

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
	public void testFindById(){
		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();
		
		alumno.setNombre("Joaquin");
		alumno.setApellidos("Moyano Álvarez");
		alumno.setTelefono("999111222");
		alumno.setEmail("joaquin@gmail.com");
		
		dao.persist(alumno);
		
		Integer id = alumno.getIdAlumno();
		
		Assert.assertNotNull(id);
		
		Alumno nuevoAlumno = dao.findById(id);
		
		Assert.assertEquals("Joaquin", nuevoAlumno.getNombre());
		Assert.assertEquals("Moyano Álvarez",  nuevoAlumno.getApellidos());
		Assert.assertEquals("999111222", nuevoAlumno.getTelefono());
		Assert.assertEquals("joaquin@gmail.com", nuevoAlumno.getEmail());
		
		dao.remove(alumno);		
	
	}
	
	@Test
	public void testFindAll(){
		
		dao = new AlumnoDAO();
		
		List<Alumno> listaAlumno = dao.findAll();
		
		for(int n = 0; n >= listaAlumno.size(); n++){
			if(n != listaAlumno.size()){
				Alumno alu1 = listaAlumno.get(n);
				Alumno alu2 = listaAlumno.get(n + 1);
				Assert.assertNotEquals(alu1, alu2);
			}
		}
		
	}
	
	/*@Test
	public void testFind(){
		
		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();
		
		alumno.setNombre("Joaquin");
		alumno.setApellidos("Moyano Álvarez");
		alumno.setTelefono("999111222");
		alumno.setEmail("joaquin@gmail.com");
		
		dao.persist(alumno);
		
		Integer id = alumno.getIdAlumno();		
		Assert.assertNotNull(id);
		
		String query = "SELECT alum FROM academia_bd.alumno alum where idALUMNO=" + alumno.getIdAlumno() + ";";
		
		List<Alumno> nuevoAlumno = dao.find(query);
		
		Assert.assertEquals("Joaquin", nuevoAlumno.get(1).getNombre());
		Assert.assertEquals("Moyano Álvarez",  nuevoAlumno.get(1).getApellidos());
		Assert.assertEquals("999111222", nuevoAlumno.get(1).getTelefono());
		Assert.assertEquals("joaquin@gmail.com", nuevoAlumno.get(1).getEmail());
	
		dao.remove(alumno);	
	}	*/

	@Test
	public void testFindByNombre() {
		
		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();
		
		alumno.setNombre("Joaquin");
		alumno.setApellidos("Moyano Álvarez");
		alumno.setTelefono("999111222");
		alumno.setEmail("joaquin@gmail.com");
		
		dao.persist(alumno);

		Integer id = alumno.getIdAlumno();		
		Assert.assertNotNull(id);

		List<Alumno> listaAlumno = dao.findByNombre("Joaquin");

		for (int n = 0; n >= listaAlumno.size(); n++) {
			if (n != listaAlumno.size()) {
				Alumno alum = listaAlumno.get(n);
				Assert.assertEquals(alum, alumno);
			}
		}
	
	}
	
	@Test
	public void testFindByApellidos() {
		
		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();
		
		alumno.setNombre("Joaquin");
		alumno.setApellidos("Moyano Álvarez");
		alumno.setTelefono("999111222");
		alumno.setEmail("joaquin@gmail.com");
		
		dao.persist(alumno);

		Integer id = alumno.getIdAlumno();		
		Assert.assertNotNull(id);

		List<Alumno> listaAlumno = dao.findByApellidos("Moyano Álvarez");

		for (int n = 0; n >= listaAlumno.size(); n++) {
			if (n != listaAlumno.size()) {
				Alumno alum = listaAlumno.get(n);
				Assert.assertEquals(alum, alumno);
			}
		}
	
	}
	
	@Test
	public void testFindByTelefono() {
		
		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();
		
		alumno.setNombre("Joaquin");
		alumno.setApellidos("Moyano Álvarez");
		alumno.setTelefono("999111222");
		alumno.setEmail("joaquin@gmail.com");
		
		dao.persist(alumno);

		Integer id = alumno.getIdAlumno();		
		Assert.assertNotNull(id);

		List<Alumno> listaAlumno = dao.findByTelefono("999111222");

		for (int n = 0; n >= listaAlumno.size(); n++) {
			if (n != listaAlumno.size()) {
				Alumno alum = listaAlumno.get(n);
				Assert.assertEquals(alum, alumno);
			}
		}
	
	}

	@Test
	public void testFindByEmail() {
		
		dao = new AlumnoDAO();
		Alumno alumno = new Alumno();
		
		alumno.setNombre("Joaquin");
		alumno.setApellidos("Moyano Álvarez");
		alumno.setTelefono("999111222");
		alumno.setEmail("joaquin@gmail.com");
		
		dao.persist(alumno);

		Integer id = alumno.getIdAlumno();		
		Assert.assertNotNull(id);

		List<Alumno> listaAlumno = dao.findByEmail("joaquin@gmail.com");

		for (int n = 0; n >= listaAlumno.size(); n++) {
			if (n != listaAlumno.size()) {
				Alumno alum = listaAlumno.get(n);
				Assert.assertEquals(alum, alumno);
			}
		}
	
	}
}
