package com.academia.hibernate;

// default package
// Generated 05-ago-2014 19:58:24 by Hibernate Tools 3.4.0.CR1

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
 * Home object for domain model class Profesor.
 * 
 * @see .Profesor
 * @author Hibernate Tools
 */
public class ProfesorDAO {

	private static final Log log = LogFactory.getLog(ProfesorDAO.class);

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;

	public ProfesorDAO() {
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

	public void persist(Profesor transientInstance) {
		log.debug("persisting Profesor instance");
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

	public void remove(Profesor persistentInstance) {
		log.debug("removing Profesor instance");
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

	public Profesor merge(Profesor detachedInstance) {
		log.debug("merging Profesor instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Profesor result = entityManager.merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Profesor findById(Integer id) {
		log.debug("getting Profesor instance with id: " + id);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Profesor instance = entityManager.find(Profesor.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Profesor> findAll() {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager.createQuery("SELECT a FROM Profesor a");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Profesor> listIdAsignatura(int IdAsignatura) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT p FROM Profesor p WHERE p.asignatura.idAsignatura = "
							+ IdAsignatura);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Profesor> findByNombre(String nombre) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT p FROM Profesor p WHERE p.nombre LIKE '%"
							+ nombre + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Profesor> findByApellidos(String apellidos) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT p FROM Profesor p WHERE p.apellidos LIKE '%"
							+ apellidos + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Profesor> findByTelefono(String telefono) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT p FROM Profesor p WHERE p.telefono LIKE '%"
							+ telefono + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Profesor> findByEmail(String email) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT p FROM Profesor p WHERE p.email LIKE '%"
							+ email + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Profesor> findByAsignatura(String asignatura) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT p FROM Profesor p WHERE p.asignatura.nombre LIKE '%"
							+ asignatura + "%'");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
