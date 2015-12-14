package com.smapley.dao;

import java.sql.Time;
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

import com.smapley.bean.TaskDetails;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskDetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.smapley.bean.TaskDetails
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TaskDetailsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TaskDetailsDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String TEXT = "text";
	public static final String PATH = "path";

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

	public void save(TaskDetails transientInstance) {
		log.debug("saving TaskDetails instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaskDetails persistentInstance) {
		log.debug("deleting TaskDetails instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskDetails findById(java.lang.Integer id) {
		log.debug("getting TaskDetails instance with id: " + id);
		try {
			TaskDetails instance = (TaskDetails) getCurrentSession().get(
					"com.smapley.bean.TaskDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TaskDetails> findByExample(TaskDetails instance) {
		log.debug("finding TaskDetails instance by example");
		try {
			List<TaskDetails> results = (List<TaskDetails>) getCurrentSession()
					.createCriteria("com.smapley.bean.TaskDetails")
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
		log.debug("finding TaskDetails instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TaskDetails as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TaskDetails> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<TaskDetails> findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List<TaskDetails> findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List findAll() {
		log.debug("finding all TaskDetails instances");
		try {
			String queryString = "from TaskDetails";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaskDetails merge(TaskDetails detachedInstance) {
		log.debug("merging TaskDetails instance");
		try {
			TaskDetails result = (TaskDetails) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskDetails instance) {
		log.debug("attaching dirty TaskDetails instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskDetails instance) {
		log.debug("attaching clean TaskDetails instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TaskDetailsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TaskDetailsDAO) ctx.getBean("TaskDetailsDAO");
	}
}