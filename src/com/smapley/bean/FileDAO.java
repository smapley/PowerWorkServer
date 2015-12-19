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
 * A data access object (DAO) providing persistence and search support for File
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.smapley.bean.File
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FileDAO {
	private static final Logger log = LoggerFactory.getLogger(FileDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String URL = "url";
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

	public void save(File transientInstance) {
		log.debug("saving File instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(File persistentInstance) {
		log.debug("deleting File instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public File findById(java.lang.Integer id) {
		log.debug("getting File instance with id: " + id);
		try {
			File instance = (File) getCurrentSession().get(
					"com.smapley.bean.File", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<File> findByExample(File instance) {
		log.debug("finding File instance by example");
		try {
			List<File> results = (List<File>) getCurrentSession()
					.createCriteria("com.smapley.bean.File")
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
		log.debug("finding File instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from File as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<File> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<File> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<File> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List<File> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all File instances");
		try {
			String queryString = "from File";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public File merge(File detachedInstance) {
		log.debug("merging File instance");
		try {
			File result = (File) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(File instance) {
		log.debug("attaching dirty File instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(File instance) {
		log.debug("attaching clean File instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FileDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FileDAO) ctx.getBean("FileDAO");
	}
}