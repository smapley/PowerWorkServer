package com.smapley.dao;

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

import com.smapley.bean.Discuss;

/**
 * A data access object (DAO) providing persistence and search support for
 * Discuss entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.Discuss
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DiscussDAO {
	private static final Logger log = LoggerFactory.getLogger(DiscussDAO.class);
	// property constants
	public static final String DETAILS = "details";

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

	public void save(Discuss transientInstance) {
		log.debug("saving Discuss instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Discuss persistentInstance) {
		log.debug("deleting Discuss instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Discuss findById(java.lang.Integer id) {
		log.debug("getting Discuss instance with id: " + id);
		try {
			Discuss instance = (Discuss) getCurrentSession().get(
					"com.smapley.bean.Discuss", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Discuss> findByExample(Discuss instance) {
		log.debug("finding Discuss instance by example");
		try {
			List<Discuss> results = (List<Discuss>) getCurrentSession()
					.createCriteria("com.smapley.bean.Discuss")
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
		log.debug("finding Discuss instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Discuss as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Discuss> findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findAll() {
		log.debug("finding all Discuss instances");
		try {
			String queryString = "from Discuss";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Discuss merge(Discuss detachedInstance) {
		log.debug("merging Discuss instance");
		try {
			Discuss result = (Discuss) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Discuss instance) {
		log.debug("attaching dirty Discuss instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Discuss instance) {
		log.debug("attaching clean Discuss instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DiscussDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DiscussDAO) ctx.getBean("DiscussDAO");
	}
}