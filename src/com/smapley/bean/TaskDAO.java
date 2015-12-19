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
@Transactional
public class TaskDAO {
	private static final Logger log = LoggerFactory.getLogger(TaskDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PROGRESS = "progress";
	public static final String PRIORITY = "priority";
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

	public void save(Task transientInstance) {
		log.debug("saving Task instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Task persistentInstance) {
		log.debug("deleting Task instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Task findById(java.lang.Integer id) {
		log.debug("getting Task instance with id: " + id);
		try {
			Task instance = (Task) getCurrentSession().get(
					"com.smapley.bean.Task", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Task> findByExample(Task instance) {
		log.debug("finding Task instance by example");
		try {
			List<Task> results = (List<Task>) getCurrentSession()
					.createCriteria("com.smapley.bean.Task")
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
		log.debug("finding Task instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Task as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Task> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Task> findByProgress(Object progress) {
		return findByProperty(PROGRESS, progress);
	}

	public List<Task> findByPriority(Object priority) {
		return findByProperty(PRIORITY, priority);
	}

	public List<Task> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Task instances");
		try {
			String queryString = "from Task";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Task merge(Task detachedInstance) {
		log.debug("merging Task instance");
		try {
			Task result = (Task) getCurrentSession().merge(detachedInstance);
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
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Task instance) {
		log.debug("attaching clean Task instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TaskDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TaskDAO) ctx.getBean("TaskDAO");
	}
}