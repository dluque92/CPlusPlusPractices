package modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AlumnoDAO {

	private static final Log log = LogFactory.getLog(AlumnoDAO.class);
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	public AlumnoDAO() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("manager");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
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
	
	public List<Alumno> findAll() {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager.createQuery("SELECT a FROM Alumno a");
		return (List<Alumno>) query.getResultList();
	}
	
	public List<Alumno> find(Query query) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		return (List<Alumno>) query.getResultList();
	}
	
	public List<Alumno> find(String queryStr) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager.createQuery(queryStr);
		return (List<Alumno>) query.getResultList();
	}
	
	public List<Alumno> findByNombre(String nombre) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT a FROM Alumno a WHERE a.nombre LIKE :nombre";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("nombre", "%" + nombre + "%");
		
		return find(query);
	}
	
	public List<Alumno> findByApellidos(String apellidos) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT a FROM Alumno a WHERE a.apellidos LIKE :apellidos";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("apellidos", "%" + apellidos + "%");
		
		return find(query);
	}
	
	public List<Alumno> findByTelefono(String telefono) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT a FROM Alumno a WHERE a.telefono LIKE :telefono";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("telefono", "%" + telefono + "%");
		
		return find(query);
	}
	
	public List<Alumno> findByEmail(String email) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT a FROM Alumno a WHERE a.email LIKE :email";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("email", "%" + email + "%");
		
		return find(query);
	}

}
