package com.comp.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.comp.todo.dao.BaseDao;
import com.comp.todo.service.BaseService;

/**
 * Base implementation for calling data access objects to perform CRUD
 * operations.
 * 
 * @author Vincent Montesclaros
 *
 * @param <E>
 *            the entity type.
 * @param <K>
 *            the key type.
 */
@Service
public abstract class BaseServiceImpl<E, K> implements BaseService<E, K> {

	private BaseDao<E, K> baseDao;

	public BaseServiceImpl(BaseDao<E, K> baseDao) {
		this.baseDao = baseDao;
	}

	public BaseServiceImpl() {
	}

	/**
	 * Calls the data access object and tells it to perform a save operation on
	 * the given entity.
	 * 
	 * @param entity
	 *            item to be saved.
	 * @return 1 if the operation was successful.
	 */
	@Override
	@Transactional
	public long add(E entity) {
		return baseDao.save(entity);
	}

	/**
	 * Calls the data access object and tells it to perform an update operation
	 * on the given entity.
	 * 
	 * @param entity
	 *            item to be updated.
	 * @return 1 if the operation was successful.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long update(E entity) {
		return baseDao.saveOrUpdate(entity);
	}

	/**
	 * Calls the data access object and tells it to perform a delete operation
	 * on the given entity.
	 * 
	 * @param entity
	 *            item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long remove(E entity) {
		return baseDao.delete(entity);
	}

	/**
	 * Calls the data access object and tells it to perform a delete operation
	 * on an entity with the given key.
	 * 
	 * @param key
	 *            key of the item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long removeByKey(K key) {
		E entity = get(key);
		return remove(entity);
	}

	/**
	 * Calls the data access object and tells it to perform a retrieve operation
	 * on the given key.
	 * 
	 * @param key
	 *            key of the item to be retrieved.
	 * @return found entity or null if no entity is found.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public E get(K key) {
		return baseDao.get(key);
	}

	/**
	 * Calls the data access object and tells it to perform a retrieve operation
	 * on all items of the given type.
	 * 
	 * @return list of all items of the given entity type.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<E> listAll() {
		return baseDao.list();
	}

}
