package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UsuariosDAO {

	private static final Log log = LogFactory.getLog(AlumnoDAO.class);
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	public UsuariosDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("login");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
	}

	public void persist(Usuarios transientInstance) {
		log.debug("persisting Usuarios instance");
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

	public void remove(Usuarios persistentInstance) {
		log.debug("removing Usuarios instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usuarios merge(Usuarios detachedInstance) {
		log.debug("merging Usuarios instance");
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Usuarios result = entityManager.merge(detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usuarios findById(Integer id) {
		log.debug("getting Usuarios instance with id: " + id);
		try {
			if (!transaction.isActive()) {
				transaction.begin();
			}
			Usuarios instance = entityManager.find(Usuarios.class, id);
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

	public List<Usuarios> findAll() {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		Query query = entityManager.createQuery("SELECT u FROM Usuarios u");
		return (List<Usuarios>) query.getResultList();
	}

	public List<Usuarios> find(Query query) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		return (List<Usuarios>) query.getResultList();
	}

	public Usuarios findByUserAndPassword(String user, String password) {
		Usuarios usuario = null;
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String queryStr = "SELECT u FROM Usuarios u WHERE u.user = :user AND u.password = :password";
		Query query = entityManager.createQuery(queryStr);
		query.setParameter("user", user);
		query.setParameter("password", password);

		List<Usuarios> listado = query.getResultList();
		if (listado != null && listado.size() > 0) {
			usuario = listado.get(0);
		}
		return usuario;
	}

	public Usuarios login(String user, String password) {
		Usuarios usuario = findByUserAndPassword(user, password);

		if (usuario != null) {
			usuario.setFechaUltimoLogin(new Date(System.currentTimeMillis()));
			UsuariosDAO dao = new UsuariosDAO();
			dao.merge(usuario);
			transaction.commit();
			usuario.setPassword("******");
		}
		return usuario;
	}

}
