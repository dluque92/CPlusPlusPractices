package com.academia.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Alumno.
 * 
 * @see .Alumno
 * @author Hibernate Tools
 */
public class AlumnoDAO {

	private static final Log log = LogFactory.getLog(AlumnoDAO.class);

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;

	public AlumnoDAO() {
		conect();
	}

	private void conect() {
		try {
			factory = Persistence.createEntityManagerFactory("Academia2");
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void persist(Alumno transientInstance) {
		log.debug("persisting Alumno instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			entityManager.persist(transientInstance);
			transaction.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Alumno persistentInstance) {
		log.debug("removing Alumno instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			entityManager.remove(persistentInstance);
			transaction.commit();
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Alumno merge(Alumno detachedInstance) {
		log.debug("merging Alumno instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Alumno result = entityManager.merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	// METODOS DE BUSQUEDA
	// METODO ENCONTRAR POR ID
	public Alumno findById(Integer id) {
		log.debug("getting Alumno instance with id: " + id);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Alumno instance = entityManager.find(Alumno.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	// METODO ENCONTRAR TODOS LOS ALUMNOS EN BD
	public List<Alumno> findAll() {
		List<Alumno> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager.createQuery("SELECT a FROM Alumno a");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// METODO ENCONTRAR POR NOMBRE DEL ALUMNO
	public List<Alumno> findByNombre(String nombre) {
		List<Alumno> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Alumno a WHERE a.nombre LIKE '%"
							+ nombre + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	// METODO ENCONTRAR POR APELLIDOS DEL ALUMNO
	public List<Alumno> findByApellidos(String apellidos) {
		List<Alumno> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Alumno a WHERE a.apellidos LIKE '%"
							+ apellidos + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// METODO ENCONTRAR POR EL TELEFONO DEL ALUMNO
	public List<Alumno> findByTelefono(String telefono) {
		List<Alumno> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Alumno a WHERE a.telefono LIKE '%"
							+ telefono + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// METODO ENCONTRAR POR EMAIL DEL ALUMNO
	public List<Alumno> findByEmail(String email) {
		List<Alumno> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Alumno a WHERE a.email LIKE '%"
							+ email + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return lista;
	}

}
