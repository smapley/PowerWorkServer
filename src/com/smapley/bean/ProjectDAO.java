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
 * Project entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.smapley.bean.Project
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ProjectDAO {
	private static final Logger log = LoggerFactory.getLogger(ProjectDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PIC_URL = "picUrl";
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

	public void save(Project transientInstance) {
		log.debug("saving Project instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Project persistentInstance) {
		log.debug("deleting Project instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Project findById(java.lang.Integer id) {
		log.debug("getting Project instance with id: " + id);
		try {
			Project instance = (Project) getCurrentSession().get(
					"com.smapley.bean.Project", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Project> findByExample(Project instance) {
		log.debug("finding Project instance by example");
		try {
			List<Project> results = (List<Project>) getCurrentSession()
					.createCriteria("com.smapley.bean.Project")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findExample( Object value) {
		log.debug("finding Project instance with property: " + NAME
				+ ", value: " + value);
		try {
			String queryString = "from Project as model where model."
					+ NAME + " like ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Project instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Project as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Project> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Project> findByPicUrl(Object picUrl) {
		return findByProperty(PIC_URL, picUrl);
	}

	public List<Project> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Project instances");
		try {
			String queryString = "from Project";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Project merge(Project detachedInstance) {
		log.debug("merging Project instance");
		try {
			Project result = (Project) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Project instance) {
		log.debug("attaching dirty Project instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Project instance) {
		log.debug("attaching clean Project instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProjectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProjectDAO) ctx.getBean("ProjectDAO");
	}
}