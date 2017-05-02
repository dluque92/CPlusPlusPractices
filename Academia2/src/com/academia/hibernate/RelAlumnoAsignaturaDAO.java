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

import com.academia.common.Constantes;

/**
 * Home object for domain model class RelAlumnoAsignatura.
 * 
 * @see .RelAlumnoAsignatura
 * @author Hibernate Tools
 */
public class RelAlumnoAsignaturaDAO {

	private static final Log log = LogFactory
			.getLog(RelAlumnoAsignaturaDAO.class);

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;

	public RelAlumnoAsignaturaDAO() {
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

	public void persist(RelAlumnoAsignatura transientInstance) {
		log.debug("persisting RelAlumnoAsignatura instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			transaction.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RelAlumnoAsignatura persistentInstance) {
		log.debug("removing RelAlumnoAsignatura instance");
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

	public RelAlumnoAsignatura merge(RelAlumnoAsignatura detachedInstance) {
		log.debug("merging RelAlumnoAsignatura instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			RelAlumnoAsignatura result = entityManager.merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RelAlumnoAsignatura findById(Integer id) {
		log.debug("getting RelAlumnoAsignatura instance with id: " + id);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			RelAlumnoAsignatura instance = entityManager.find(
					RelAlumnoAsignatura.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<RelAlumnoAsignatura> listIdAlumno(Integer id) {
		List<RelAlumnoAsignatura> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("Select a from RelAlumnoAsignatura a where a.alumno.idAlumno = "
							+ id);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<RelAlumnoAsignatura> listIdAsignatura(Integer id) {
		List<RelAlumnoAsignatura> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM  RelAlumnoAsignatura a WHERE a.asignatura.idAsignatura ="
							+ id);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
