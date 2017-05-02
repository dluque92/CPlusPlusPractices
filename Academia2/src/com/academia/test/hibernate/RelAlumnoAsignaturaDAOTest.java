package com.academia.test.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.academia.hibernate.Alumno;
import com.academia.hibernate.AlumnoDAO;
import com.academia.hibernate.Asignatura;
import com.academia.hibernate.AsignaturaDAO;
import com.academia.hibernate.RelAlumnoAsignatura;
import com.academia.hibernate.RelAlumnoAsignaturaDAO;



public class RelAlumnoAsignaturaDAOTest {

	private RelAlumnoAsignaturaDAO dao;
	
	@Test
	public void testPersist() {

		dao = new RelAlumnoAsignaturaDAO();
		RelAlumnoAsignatura relacion = new RelAlumnoAsignatura();
		
		//como es una relacion y hace falta un alumno y una asignatura, primero las creo
		Asignatura asignatura = new Asignatura();
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		daoAsig.persist(asignatura);
		
		Alumno alumn = new Alumno();
		alumn.setNombre("Pepe");
		alumn.setApellidos("perez");
		alumn.setEmail("a@b.com");
		alumn.setTelefono("555555555");
		
		AlumnoDAO daoAlum = new AlumnoDAO();
		daoAlum.persist(alumn);
		//una vez creado el alumno y la asignatura, creo la relación
		
		relacion.setAlumno(alumn);
		relacion.setAsignatura(asignatura);

		dao.persist(relacion);
		Integer id = relacion.getIdRelacion();
		Assert.assertNotNull(id);

		RelAlumnoAsignatura nuevaRelacion = dao.findById(id);

		Assert.assertEquals(alumn, nuevaRelacion.getAlumno());
		Assert.assertEquals(asignatura, nuevaRelacion.getAsignatura());

		//borro al alumno, asignatura y relacion
		dao.remove(relacion);
		daoAsig.remove(asignatura);
		daoAlum.remove(alumn);
		
	}

	@Test
	public void testRemove() {
		dao = new RelAlumnoAsignaturaDAO();
		RelAlumnoAsignatura relacion = new RelAlumnoAsignatura();
		
		//como es una relacion y hace falta un alumno y una asignatura, primero las creo
		Asignatura asignatura = new Asignatura();
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		daoAsig.persist(asignatura);
		
		Alumno alumn = new Alumno();
		alumn.setNombre("Pepe");
		alumn.setApellidos("perez");
		alumn.setEmail("a@b.com");
		alumn.setTelefono("555555555");
		
		AlumnoDAO daoAlum = new AlumnoDAO();
		daoAlum.persist(alumn);
		//una vez creado el alumno y la asignatura, creo la relación
		
		relacion.setAlumno(alumn);
		relacion.setAsignatura(asignatura);

		dao.persist(relacion);
		Integer id = relacion.getIdRelacion();
		Assert.assertNotNull(id);

		//ahora la recojo en un nuevo objeto
		RelAlumnoAsignatura nuevaRelacion = dao.findById(id);
		//y la borro
		dao.remove(nuevaRelacion);
		//vuelvo a intentar recogerla
		RelAlumnoAsignatura nuevaRelacion2 = dao.findById(id);
		//debe devolver NULL
		Assert.assertNull(nuevaRelacion2);
		
		//borro la asignatura creada y el alumno tmb
		daoAsig.remove(asignatura);
		daoAlum.remove(alumn);
	}

	@Test
	public void testMerge() {
		dao = new RelAlumnoAsignaturaDAO();
		RelAlumnoAsignatura relacion = new RelAlumnoAsignatura();
		
		//como es una relacion y hace falta un alumno y una asignatura, primero las creo
		Asignatura asignatura = new Asignatura();
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		daoAsig.persist(asignatura);
		//creo una segunda asignatura
		Asignatura asignatura2 = new Asignatura();
		asignatura2.setNombre("Otra");
		asignatura2.setAula("1B");
		asignatura2.setHorario("De 5 a 8");
		
		daoAsig.persist(asignatura2);
		//creo un alumno
		Alumno alumn = new Alumno();
		alumn.setNombre("Pepe");
		alumn.setApellidos("perez");
		alumn.setEmail("a@b.com");
		alumn.setTelefono("555555555");
		
		AlumnoDAO daoAlum = new AlumnoDAO();
		daoAlum.persist(alumn);
		//creo otro alumno
		Alumno alumn2 = new Alumno();
		alumn2.setNombre("Juan");
		alumn2.setApellidos("albarez");
		alumn2.setEmail("b@c.com");
		alumn2.setTelefono("666666666");
		
		daoAlum.persist(alumn2);
		//una vez creado el alumno y la asignatura, creo la relación
		
		relacion.setAlumno(alumn);
		relacion.setAsignatura(asignatura);

		dao.persist(relacion);
		Integer id = relacion.getIdRelacion();
		Assert.assertNotNull(id);
		
		//recojo la relacion creada y la modifico
		RelAlumnoAsignatura relacionAModificar = dao.findById(id);

		relacionAModificar.setAlumno(alumn2);
		relacionAModificar.setAsignatura(asignatura2);

		dao.merge(relacionAModificar);
		id = relacionAModificar.getIdRelacion();
		//la vuelvo a recoger
		RelAlumnoAsignatura nuevaRelacion = dao.findById(id);
		
		//compruebo que los datos se han cambiado
		Assert.assertEquals(alumn2,nuevaRelacion.getAlumno());
		Assert.assertEquals(asignatura2,nuevaRelacion.getAsignatura());

		//ahora borro todo
		dao.remove(nuevaRelacion);
		daoAsig.remove(asignatura);
		daoAlum.remove(alumn);
		daoAsig.remove(asignatura2);
		daoAlum.remove(alumn2);
	}
	
	@Test
	public void testFindById() {
		dao = new RelAlumnoAsignaturaDAO();
		RelAlumnoAsignatura relacion = new RelAlumnoAsignatura();
		
		//como es una relacion y hace falta un alumno y una asignatura, primero las creo
		Asignatura asignatura = new Asignatura();
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		daoAsig.persist(asignatura);
		
		Alumno alumn = new Alumno();
		alumn.setNombre("Pepe");
		alumn.setApellidos("perez");
		alumn.setEmail("a@b.com");
		alumn.setTelefono("555555555");
		
		AlumnoDAO daoAlum = new AlumnoDAO();
		daoAlum.persist(alumn);
		//una vez creado el alumno y la asignatura, creo la relación
		
		relacion.setAlumno(alumn);
		relacion.setAsignatura(asignatura);

		dao.persist(relacion);
		Integer id = relacion.getIdRelacion();
		Assert.assertNotNull(id);
		
		//ahora intento recoger el por el id la relacion
		RelAlumnoAsignatura nuevaRelacion = dao.findById(id);
		//debe encontrarla y no ser null
		Assert.assertNotNull(nuevaRelacion);
		
		//borro todo
		dao.remove(relacion);
		daoAsig.remove(asignatura);
		daoAlum.remove(alumn);

	}

	@Test
	public void testListIdAlumno() {
		dao = new RelAlumnoAsignaturaDAO();
		RelAlumnoAsignatura relacion = new RelAlumnoAsignatura();
		
		//como es una relacion y hace falta un alumno y una asignatura, primero las creo
		Asignatura asignatura = new Asignatura();
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		daoAsig.persist(asignatura);
		
		Alumno alumn = new Alumno();
		alumn.setNombre("Pepe");
		alumn.setApellidos("perez");
		alumn.setEmail("a@b.com");
		alumn.setTelefono("555555555");
		
		AlumnoDAO daoAlum = new AlumnoDAO();
		daoAlum.persist(alumn);
		//una vez creado el alumno y la asignatura, creo la relación
		
		relacion.setAlumno(alumn);
		relacion.setAsignatura(asignatura);

		dao.persist(relacion);
		
		//ahora intento recoger el por el id del alumno su relacion
		List<RelAlumnoAsignatura> nuevaListaRelacion;
		nuevaListaRelacion = dao.listIdAlumno(alumn.getIdAlumno());
		
		//debe encontrarla y no ser null
		Assert.assertNotNull(nuevaListaRelacion);
		//la relacion devuelta debe ser la creada
		Assert.assertEquals(alumn,nuevaListaRelacion.get(0).getAlumno());
		Assert.assertEquals(asignatura,nuevaListaRelacion.get(0).getAsignatura());
		//sólo debe devolver un valor
		Assert.assertEquals(1, nuevaListaRelacion.size());
		
		//borro todo
		dao.remove(relacion);
		daoAsig.remove(asignatura);
		daoAlum.remove(alumn);

	}

	@Test
	public void testListIdAsignatura() {
		dao = new RelAlumnoAsignaturaDAO();
		RelAlumnoAsignatura relacion = new RelAlumnoAsignatura();
		
		//como es una relacion y hace falta un alumno y una asignatura, primero las creo
		Asignatura asignatura = new Asignatura();
		asignatura.setNombre("Nueva");
		asignatura.setAula("1A");
		asignatura.setHorario("De 3 a 5");
		
		AsignaturaDAO daoAsig = new AsignaturaDAO();
		daoAsig.persist(asignatura);
		
		Alumno alumn = new Alumno();
		alumn.setNombre("Pepe");
		alumn.setApellidos("perez");
		alumn.setEmail("a@b.com");
		alumn.setTelefono("555555555");
		
		AlumnoDAO daoAlum = new AlumnoDAO();
		daoAlum.persist(alumn);
		//una vez creado el alumno y la asignatura, creo la relación
		
		relacion.setAlumno(alumn);
		relacion.setAsignatura(asignatura);

		dao.persist(relacion);
		
		//ahora intento recoger el por el id de asignatura su relacion
		List<RelAlumnoAsignatura> nuevaListaRelacion;
		nuevaListaRelacion = dao.listIdAsignatura(asignatura.getIdAsignatura());
		
		//debe encontrarla y no ser null
		Assert.assertNotNull(nuevaListaRelacion);
		//la relacion devuelta debe ser la creada
		Assert.assertEquals(alumn,nuevaListaRelacion.get(0).getAlumno());
		Assert.assertEquals(asignatura,nuevaListaRelacion.get(0).getAsignatura());
		//sólo debe devolver un valor
		Assert.assertEquals(1, nuevaListaRelacion.size());
		
		//borro todo
		dao.remove(relacion);
		daoAsig.remove(asignatura);
		daoAlum.remove(alumn);
		
	}

}
