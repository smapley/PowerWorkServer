package com.smapley.bean;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Feedbacks entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.Feedbacks
 * @author MyEclipse Persistence Tools
 */
public class FeedbacksDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FeedbacksDAO.class);
	// property constants
	public static final String DETAILS = "details";

	public void save(Feedbacks transientInstance) {
		log.debug("saving Feedbacks instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Feedbacks persistentInstance) {
		log.debug("deleting Feedbacks instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Feedbacks findById(java.lang.Integer id) {
		log.debug("getting Feedbacks instance with id: " + id);
		try {
			Feedbacks instance = (Feedbacks) getSession().get(
					"com.smapley.bean.Feedbacks", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Feedbacks instance) {
		log.debug("finding Feedbacks instance by example");
		try {
			List results = getSession()
					.createCriteria("com.smapley.bean.Feedbacks")
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
		log.debug("finding Feedbacks instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Feedbacks as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findAll() {
		log.debug("finding all Feedbacks instances");
		try {
			String queryString = "from Feedbacks";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Feedbacks merge(Feedbacks detachedInstance) {
		log.debug("merging Feedbacks instance");
		try {
			Feedbacks result = (Feedbacks) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Feedbacks instance) {
		log.debug("attaching dirty Feedbacks instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Feedbacks instance) {
		log.debug("attaching clean Feedbacks instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}