package modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RelAlumnoAsignaturaDAO {

	private static final Log log = LogFactory
			.getLog(RelAlumnoAsignaturaDAO.class);
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	public RelAlumnoAsignaturaDAO() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("manager");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
	}

	public void persist(RelAlumnoAsignatura transientInstance) {
		log.debug("persisting RelAlumnoAsignatura instance");
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

	public void remove(RelAlumnoAsignatura persistentInstance) {
		log.debug("removing RelAlumnoAsignatura instance");
		try {
			entityManager.remove(persistentInstance);
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

	public void close() {
		try {
			if (transaction.isActive()) {
				transaction.commit();
			}
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			log.error("close", e);
			throw e;
		}
	}

	public List<RelAlumnoAsignatura> findAll() {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager
				.createQuery("SELECT r FROM RelAlumnoAsignatura r");
		return (List<RelAlumnoAsignatura>) query.getResultList();
	}

	public List<RelAlumnoAsignatura> find(Query query) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		return (List<RelAlumnoAsignatura>) query.getResultList();
	}

	public boolean esAsignaturaRelacionada(int idAsignatura) {
		boolean ok = false;

		if (!transaction.isActive()) {
			transaction.begin();
		}

		String queryStr = "SELECT r FROM RelAlumnoAsignatura r WHERE r.asignatura.idAsignatura = :idAsignatura";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("idAsignatura", idAsignatura);

		List<RelAlumnoAsignatura> lista = find(query);

		if (lista.size() > 0) {
			ok = true;
		}
		return ok;
	}

}
