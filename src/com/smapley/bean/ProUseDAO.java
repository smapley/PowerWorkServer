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
 * ProUse entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.ProUse
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ProUseDAO {
	private static final Logger log = LoggerFactory.getLogger(ProUseDAO.class);
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

	public void save(ProUse transientInstance) {
		log.debug("saving ProUse instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProUse persistentInstance) {
		log.debug("deleting ProUse instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProUse findById(java.lang.Integer id) {
		log.debug("getting ProUse instance with id: " + id);
		try {
			ProUse instance = (ProUse) getCurrentSession().get(
					"com.smapley.bean.ProUse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ProUse> findByExample(ProUse instance) {
		log.debug("finding ProUse instance by example");
		try {
			List<ProUse> results = (List<ProUse>) getCurrentSession()
					.createCriteria("com.smapley.bean.ProUse")
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
		log.debug("finding ProUse instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ProUse as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ProUse> findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List<ProUse> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all ProUse instances");
		try {
			String queryString = "from ProUse";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProUse merge(ProUse detachedInstance) {
		log.debug("merging ProUse instance");
		try {
			ProUse result = (ProUse) getCurrentSession()
					.merge(detachedInstance);
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
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProUse instance) {
		log.debug("attaching clean ProUse instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProUseDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProUseDAO) ctx.getBean("ProUseDAO");
	}
}