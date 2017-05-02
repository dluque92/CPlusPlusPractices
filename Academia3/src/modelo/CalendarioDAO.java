package modelo;

// default package
// Generated 12-ago-2014 20:17:01 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
 * Home object for domain model class Calendario.
 * 
 * @see .Calendario
 * @author Hibernate Tools
 */
public class CalendarioDAO {

	private static final Log log = LogFactory.getLog(CalendarioDAO.class);

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction transaction;

	public CalendarioDAO() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("manager");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
	}

	public void persist(Calendario transientInstance) {
		log.debug("persisting Calendario instance");
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

	public void remove(Calendario persistentInstance) {
		log.debug("removing Calendario instance");
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

	public Calendario merge(Calendario detachedInstance) {
		log.debug("merging Calendario instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Calendario result = entityManager.merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Calendario findById(Integer id) {
		log.debug("getting Calendario instance with id: " + id);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Calendario instance = entityManager.find(Calendario.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Calendario findByIdEvent(String idEvent) {
		log.debug("getting Calendario instance with id: " + idEvent);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT c FROM Calendario c WHERE c.idEvento = :idEvento");
			query.setParameter("idEvento", idEvent);
			Calendario instance = (Calendario) query.getSingleResult();
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Calendario findEvent(String nombre, Date startDate, Date endDate) {
		log.debug("getting Calendario instance with nombre: " + nombre
				+ ", startDate: " + startDate + ", endDate: " + endDate);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT c FROM Calendario c WHERE c.id.nombre = :nombre AND c.id.startDate = :startDate AND c.id.endDate = :endDate");
			query.setParameter("nombre", nombre);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			Calendario instance = (Calendario) query.getSingleResult();
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Calendario> findAll() {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager.createQuery("SELECT c FROM Calendario c");
		return (List<Calendario>) query.getResultList();
	}

}
