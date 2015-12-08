package com.smapley.bean;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dynamic entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.Dynamic
 * @author MyEclipse Persistence Tools
 */
public class DynamicDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DynamicDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String PIC_URL = "picUrl";

	public void save(Dynamic transientInstance) {
		log.debug("saving Dynamic instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dynamic persistentInstance) {
		log.debug("deleting Dynamic instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dynamic findById(java.lang.Integer id) {
		log.debug("getting Dynamic instance with id: " + id);
		try {
			Dynamic instance = (Dynamic) getSession().get(
					"com.smapley.bean.Dynamic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dynamic instance) {
		log.debug("finding Dynamic instance by example");
		try {
			List results = getSession()
					.createCriteria("com.smapley.bean.Dynamic")
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
		log.debug("finding Dynamic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dynamic as model where model."
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

	public List findByPicUrl(Object picUrl) {
		return findByProperty(PIC_URL, picUrl);
	}

	public List findAll() {
		log.debug("finding all Dynamic instances");
		try {
			String queryString = "from Dynamic";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dynamic merge(Dynamic detachedInstance) {
		log.debug("merging Dynamic instance");
		try {
			Dynamic result = (Dynamic) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dynamic instance) {
		log.debug("attaching dirty Dynamic instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dynamic instance) {
		log.debug("attaching clean Dynamic instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}