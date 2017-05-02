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
 * Home object for domain model class Asignatura.
 * 
 * @see .Asignatura
 * @author Hibernate Tools
 */
public class AsignaturaDAO {

	private static final Log log = LogFactory.getLog(AsignaturaDAO.class);

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;

	public AsignaturaDAO() {
		factory = Persistence.createEntityManagerFactory("Academia1");
		entityManager = factory.createEntityManager();
		transaction = entityManager.getTransaction();
	}

	public void persist(Asignatura transientInstance) {
		log.debug("persisting Asignatura instance");
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

	public void remove(Asignatura persistentInstance) {
		log.debug("removing Asignatura instance");
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

	public Asignatura merge(Asignatura detachedInstance) {
		log.debug("merging Asignatura instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Asignatura result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			transaction.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Asignatura findById(Integer id) {
		log.debug("getting Asignatura instance with id: " + id);
		try {
			Asignatura instance = entityManager.find(Asignatura.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Asignatura> findAll() {
		List<Asignatura> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Asignatura a");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Asignatura> findByNombre(String nombreAsignatura) {
		List<Asignatura> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Asignatura a WHERE a.nombre LIKE :nombre");
			query.setParameter("nombre", "%" + nombreAsignatura + "%");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Asignatura> findByHorario(String horarioAsignatura) {
		List<Asignatura> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Asignatura a WHERE a.horario LIKE :horario");
			query.setParameter("horario", "%" + horarioAsignatura + "%");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Asignatura> findByAula(String aulaAsignatura) {
		List<Asignatura> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Asignatura a WHERE a.aula LIKE :aula");
			query.setParameter("aula", "%" + aulaAsignatura + "%");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}