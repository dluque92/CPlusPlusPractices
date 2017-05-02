package modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProfesorDAO {

	private static final Log log = LogFactory.getLog(ProfesorDAO.class);
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	public ProfesorDAO() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("manager");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
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
			log.debug("remove successful");
			transaction.commit();
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

	public List<Profesor> findAll() {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager.createQuery("SELECT p FROM Profesor p");
		return (List<Profesor>) query.getResultList();
	}

	public List<Profesor> find(Query query) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		return (List<Profesor>) query.getResultList();
	}
	
	public List<Profesor> find(String queryStr) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager.createQuery(queryStr);
		return (List<Profesor>) query.getResultList();
	}

	public List<Profesor> findByNombre(String nombre) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT p FROM Profesor p WHERE p.nombre LIKE :nombre";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("nombre", "%" + nombre + "%");

		return find(query);
	}

	public List<Profesor> findByApellidos(String apellidos) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT p FROM Profesor p WHERE p.apellidos LIKE :apellidos";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("apellidos", "%" + apellidos + "%");

		return find(query);
	}

	public List<Profesor> findByTelefono(String telefono) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT p FROM Profesor p WHERE p.telefono LIKE :telefono";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("telefono", "%" + telefono + "%");

		return find(query);
	}

	public List<Profesor> findByEmail(String email) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT p FROM Profesor p WHERE p.email LIKE :email";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("email", "%" + email + "%");

		return find(query);
	}

	public boolean isActivo(int idAsignatura) {
		boolean ok = false;
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT p FROM Profesor p WHERE p.asignatura.idAsignatura = :idAsignatura";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("idAsignatura", idAsignatura);

		List<Profesor> lista = find(query);

		if (lista.size() > 0) {
			ok = true;
		}

		return ok;
	}

}
