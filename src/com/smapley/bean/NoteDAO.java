package com.smapley.bean;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for Note
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.smapley.bean.Note
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class NoteDAO {
	private static final Logger log = LoggerFactory.getLogger(NoteDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String STATE = "state";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Note transientInstance) {
		log.debug("saving Note instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Note persistentInstance) {
		log.debug("deleting Note instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Note findById(java.lang.Integer id) {
		log.debug("getting Note instance with id: " + id);
		try {
			Note instance = (Note) getCurrentSession().get(
					"com.smapley.bean.Note", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Note> findByExample(Note instance) {
		log.debug("finding Note instance by example");
		try {
			List<Note> results = (List<Note>) getCurrentSession()
					.createCriteria("com.smapley.bean.Note")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Note instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Note as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Note> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Note> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Note instances");
		try {
			String queryString = "from Note";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Note merge(Note detachedInstance) {
		log.debug("merging Note instance");
		try {
			Note result = (Note) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Note instance) {
		log.debug("attaching dirty Note instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Note instance) {
		log.debug("attaching clean Note instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NoteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NoteDAO) ctx.getBean("NoteDAO");
	}
}