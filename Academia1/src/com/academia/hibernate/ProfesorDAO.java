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
		factory = Persistence.createEntityManagerFactory("Academia1");
		entityManager = factory.createEntityManager();
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
			log.debug("merge successful");
			transaction.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Profesor findById(Integer id) {
		log.debug("getting Profesor instance with id: " + id);
		try {
			Profesor instance = entityManager.find(Profesor.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	//Busqueda por ID
	public List<Profesor> findAll() {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			System.out.println("----------------------->");
			Query query = entityManager
					.createQuery("SELECT a FROM Profesor a");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	
	//Busqueda por nombre
	public List<Profesor> findByNombre(String nombreProfesor) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Profesor a WHERE a.nombre LIKE :nombre");
			query.setParameter("nombre", "%" + nombreProfesor + "%");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	//Busqueda por apellido
	
	public List<Profesor> findByApellidos(String apellidosProfesor) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Profesor  a WHERE a.apellidos LIKE :apellidos");
			query.setParameter("apellidos", "%" + apellidosProfesor + "%");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	//Busqueda por telefono
	
	public List<Profesor> findByTelefono(String telefonoProfesor) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Profesor a WHERE a.telefono LIKE :telefono");
			query.setParameter("telefono", "%" + telefonoProfesor + "%");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	
	//Busqueda por email
	public List<Profesor> findByEmail(String emailProfesor) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT a FROM Profesor a WHERE a.email LIKE :email");
			query.setParameter("email", "%" + emailProfesor + "%");
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	//Busqueda id asignatura
	
	public List<Profesor> findByIdAsignatura(int idAsignatura) {
		List<Profesor> lista = null;
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Query query = entityManager
					.createQuery("SELECT p FROM Profesor p WHERE p.asignatura.idAsignatura = :idAsignatura");
			query.setParameter("idAsignatura", idAsignatura);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
