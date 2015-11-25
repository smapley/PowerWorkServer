package com.smapley.bean;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TasUse entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.TasUse
 * @author MyEclipse Persistence Tools
 */
public class TasUseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TasUseDAO.class);

	// property constants

	public void save(TasUse transientInstance) {
		log.debug("saving TasUse instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TasUse persistentInstance) {
		log.debug("deleting TasUse instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TasUse findById(com.smapley.bean.TasUseId id) {
		log.debug("getting TasUse instance with id: " + id);
		try {
			TasUse instance = (TasUse) getSession().get(
					"com.smapley.bean.TasUse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TasUse instance) {
		log.debug("finding TasUse instance by example");
		try {
			List results = getSession()
					.createCriteria("com.smapley.bean.TasUse")
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
		log.debug("finding TasUse instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TasUse as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TasUse instances");
		try {
			String queryString = "from TasUse";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TasUse merge(TasUse detachedInstance) {
		log.debug("merging TasUse instance");
		try {
			TasUse result = (TasUse) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TasUse instance) {
		log.debug("attaching dirty TasUse instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TasUse instance) {
		log.debug("attaching clean TasUse instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}