package com.smapley.bean;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProUse entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.ProUse
 * @author MyEclipse Persistence Tools
 */
public class ProUseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProUseDAO.class);
	// property constants
	public static final String RANK = "rank";

	public void save(ProUse transientInstance) {
		log.debug("saving ProUse instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProUse persistentInstance) {
		log.debug("deleting ProUse instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProUse findById(com.smapley.bean.ProUseId id) {
		log.debug("getting ProUse instance with id: " + id);
		try {
			ProUse instance = (ProUse) getSession().get(
					"com.smapley.bean.ProUse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProUse instance) {
		log.debug("finding ProUse instance by example");
		try {
			List results = getSession()
					.createCriteria("com.smapley.bean.ProUse")
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
		log.debug("finding ProUse instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ProUse as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List findAll() {
		log.debug("finding all ProUse instances");
		try {
			String queryString = "from ProUse";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProUse merge(ProUse detachedInstance) {
		log.debug("merging ProUse instance");
		try {
			ProUse result = (ProUse) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProUse instance) {
		log.debug("attaching dirty ProUse instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProUse instance) {
		log.debug("attaching clean ProUse instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}