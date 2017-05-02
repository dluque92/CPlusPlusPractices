package modelo;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AsignaturaDAO {

	private static final Log log = LogFactory.getLog(AsignaturaDAO.class);
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	public AsignaturaDAO() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("manager");
		entityManager = entityManagerFactory.createEntityManager();
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
			log.debug("remove successful");
			transaction.commit();
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
	public Integer count() {
		log.debug("count all Asignaturas");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Integer rowCnt= (Integer) entityManager.createNativeQuery("SELECT count(*) FROM asignatura").getSingleResult();
			log.debug("count successful");
			transaction.commit();
			return rowCnt;
		} catch (RuntimeException re) {
			log.error("count failed", re);
			throw re;
		}
	}
	
	public Integer count2() {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT COUNT(a) FROM Asignatura a";
		Integer count = (Integer)entityManager.createQuery(queryStr).getSingleResult();

		return count;
	}

	public Asignatura merge(Asignatura detachedInstance) {
		log.debug("merging Asignatura instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Asignatura result = entityManager.merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Asignatura findById(Integer id) {
		log.debug("getting Asignatura instance with id: " + id);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Asignatura instance = entityManager.find(Asignatura.class, id);
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

	public List<Asignatura> findAll() {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager.createQuery("SELECT a FROM Asignatura a");
		return (List<Asignatura>) query.getResultList();
	}

	public List<Asignatura> find(Query query) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		return (List<Asignatura>) query.getResultList();
	}

	public List<Asignatura> findByNombre(String nombre) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT a FROM Asignatura a WHERE a.nombre LIKE :nombre";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("nombre", "%" + nombre + "%");

		return find(query);
	}

	public List<Asignatura> findByHorario(String horario) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT a FROM Asignatura a WHERE a.horario LIKE :horario";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("horario", "%" + horario + "%");

		return find(query);
	}

	public List<Asignatura> findByAula(String aula) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT a FROM Asignatura a WHERE a.aula LIKE :aula";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("aula", "%" + aula + "%");

		return find(query);
	}

}
