package com.smapley.bean;

import java.sql.Time;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * NoteDetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.smapley.bean.NoteDetails
 * @author MyEclipse Persistence Tools
 */
public class NoteDetailsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NoteDetailsDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String TEXT = "text";
	public static final String PATH = "path";

	public void save(NoteDetails transientInstance) {
		log.debug("saving NoteDetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NoteDetails persistentInstance) {
		log.debug("deleting NoteDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NoteDetails findById(java.lang.Integer id) {
		log.debug("getting NoteDetails instance with id: " + id);
		try {
			NoteDetails instance = (NoteDetails) getSession().get(
					"com.smapley.bean.NoteDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NoteDetails instance) {
		log.debug("finding NoteDetails instance by example");
		try {
			List results = getSession()
					.createCriteria("com.smapley.bean.NoteDetails")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding NoteDetails instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from NoteDetails as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findAll() {
		log.debug("finding all NoteDetails instances");
		try {
			String queryString = "from NoteDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NoteDetails merge(NoteDetails detachedInstance) {
		log.debug("merging NoteDetails instance");
		try {
			NoteDetails result = (NoteDetails) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NoteDetails instance) {
		log.debug("attaching dirty NoteDetails instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NoteDetails instance) {
		log.debug("attaching clean NoteDetails instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}