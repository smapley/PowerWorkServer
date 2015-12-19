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
 * A data access object (DAO) providing persistence and search support for
 * UserBase entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.UserBase
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserBaseDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserBaseDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String SKEY = "skey";
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

	public void save(UserBase transientInstance) {
		log.debug("saving UserBase instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserBase persistentInstance) {
		log.debug("deleting UserBase instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserBase findById(java.lang.Integer id) {
		log.debug("getting UserBase instance with id: " + id);
		try {
			UserBase instance = (UserBase) getCurrentSession().get(
					"com.smapley.bean.UserBase", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<UserBase> findByExample(UserBase instance) {
		log.debug("finding UserBase instance by example");
		try {
			List<UserBase> results = (List<UserBase>) getCurrentSession()
					.createCriteria("com.smapley.bean.UserBase")
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
		log.debug("finding UserBase instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserBase as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<UserBase> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<UserBase> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<UserBase> findBySkey(Object skey) {
		return findByProperty(SKEY, skey);
	}

	public List<UserBase> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all UserBase instances");
		try {
			String queryString = "from UserBase";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserBase merge(UserBase detachedInstance) {
		log.debug("merging UserBase instance");
		try {
			UserBase result = (UserBase) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserBase instance) {
		log.debug("attaching dirty UserBase instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserBase instance) {
		log.debug("attaching clean UserBase instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserBaseDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserBaseDAO) ctx.getBean("UserBaseDAO");
	}
}