package com.smapley.bean;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Task
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.smapley.bean.Task
 * @author MyEclipse Persistence Tools
 */
public class TaskDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TaskDAO.class);
	// property constants
	public static final String PRO_ID = "proId";
	public static final String NAME = "name";
	public static final String DETAILS = "details";
	public static final String PROGRESS = "progress";
	public static final String APPOINTEE = "appointee";
	public static final String ANNEX = "annex";
	public static final String PRIORITY = "priority";
	public static final String TYPE = "type";

	public void save(Task transientInstance) {
		log.debug("saving Task instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Task persistentInstance) {
		log.debug("deleting Task instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Task findById(java.lang.Integer id) {
		log.debug("getting Task instance with id: " + id);
		try {
			Task instance = (Task) getSession()
					.get("com.smapley.bean.Task", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Task instance) {
		log.debug("finding Task instance by example");
		try {
			List results = getSession().createCriteria("com.smapley.bean.Task")
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
		log.debug("finding Task instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Task as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProId(Object proId) {
		return findByProperty(PRO_ID, proId);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findByProgress(Object progress) {
		return findByProperty(PROGRESS, progress);
	}

	public List findByAppointee(Object appointee) {
		return findByProperty(APPOINTEE, appointee);
	}

	public List findByAnnex(Object annex) {
		return findByProperty(ANNEX, annex);
	}

	public List findByPriority(Object priority) {
		return findByProperty(PRIORITY, priority);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all Task instances");
		try {
			String queryString = "from Task";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Task merge(Task detachedInstance) {
		log.debug("merging Task instance");
		try {
			Task result = (Task) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Task instance) {
		log.debug("attaching dirty Task instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Task instance) {
		log.debug("attaching clean Task instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}