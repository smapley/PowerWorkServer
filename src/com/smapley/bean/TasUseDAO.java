package com.smapley.bean;

import java.sql.Timestamp;
import java.util.List;
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
@Transactional
public class TasUseDAO {
	private static final Logger log = LoggerFactory.getLogger(TasUseDAO.class);
	// property constants
	public static final String RANK = "rank";
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

	public void save(TasUse transientInstance) {
		log.debug("saving TasUse instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TasUse persistentInstance) {
		log.debug("deleting TasUse instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TasUse findById(java.lang.Integer id) {
		log.debug("getting TasUse instance with id: " + id);
		try {
			TasUse instance = (TasUse) getCurrentSession().get(
					"com.smapley.bean.TasUse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TasUse> findByExample(TasUse instance) {
		log.debug("finding TasUse instance by example");
		try {
			List<TasUse> results = (List<TasUse>) getCurrentSession()
					.createCriteria("com.smapley.bean.TasUse")
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
		log.debug("finding TasUse instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TasUse as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TasUse> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<TasUse> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all TasUse instances");
		try {
			String queryString = "from TasUse";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TasUse merge(TasUse detachedInstance) {
		log.debug("merging TasUse instance");
		try {
			TasUse result = (TasUse) getCurrentSession()
					.merge(detachedInstance);
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
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TasUse instance) {
		log.debug("attaching clean TasUse instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TasUseDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TasUseDAO) ctx.getBean("TasUseDAO");
	}
}