package com.comp.tasker.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.comp.tasker.dao.BaseDao;

/**
 * Base implementation for common CRUD operations and queries.
 * 
 * @author Vincent Montesclaros
 *
 * @param <E>
 *            the entity type.
 * @param <K>
 *            the key type.
 */
@Repository
public abstract class BaseDaoImpl<E, K extends Serializable> implements BaseDao<E, K> {

	/**
	 * Class of the given entity.
	 */
	protected Class<E> entityClass;

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	protected BaseDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Returns all the items of the given entity type from the database.
	 * 
	 * @return list of all items of the given entity type.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<E> list() {
		List<E> elementList = (List<E>) sessionFactory.getCurrentSession().createCriteria(entityClass)
				.addOrder(Order.asc("id")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return elementList;
	}

	/**
	 * Find an item from database based on its ID.
	 * 
	 * @param key
	 *            the ID to look for.
	 * @return found entity or null if no entity is found.
	 */
	@Override
	public E get(K key) {
		return (E) sessionFactory.getCurrentSession().get(entityClass, key);
	}

	/**
	 * Persists the given entity into the database.
	 * 
	 * @param entity
	 *            the entity to be saved.
	 * @return 1 if the entity is successfully saved.
	 * 
	 */
	@Override
	public long save(E entity) {
		sessionFactory.getCurrentSession().save(entity);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
		return 1;
	}

	/**
	 * Calls either save() or update() on the basis of whether the entity exists
	 * or not.
	 * 
	 * @param entity
	 *            to be saved or updated.
	 * @return 1 if the operation was successful.
	 */
	@Override
	public long saveOrUpdate(E entity) {
		sessionFactory.getCurrentSession().merge(entity);
		return 1;
	}

	/**
	 * Delete the item from database.
	 * 
	 * @param entity
	 *            the item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	@Override
	public long delete(E entity) {
		sessionFactory.getCurrentSession().delete(entity);
		return 1;
	}

	/**
	 * Delete an item with the given key from the database.
	 * 
	 * @param key
	 *            the id of the item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	@Override
	public long deleteByKey(K key) {
		E entity = get(key);
		return delete(entity);
	}

	/**
	 * Deletes all items with the given entity class.
	 * 
	 * @return the number of records deleted.
	 */
	public long deleteAll() {
		return sessionFactory.getCurrentSession().createQuery("DELETE FROM " + this.entityClass.getName())
				.executeUpdate();
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to be set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
