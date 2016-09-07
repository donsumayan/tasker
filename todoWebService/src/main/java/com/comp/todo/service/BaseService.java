package com.comp.todo.service;

import java.util.List;

/**
 * Base interface for calling data access objects to perform CRUD operations.
 * 
 * @author Vincent Montesclaros
 *
 * @param <E>
 *            the entity type.
 * @param <K>
 *            the key type.
 */
public interface BaseService<E, K> {

	/**
	 * Calls the data access object and tells it to perform a save operation on
	 * the given entity.
	 * 
	 * @param entity
	 *            item to be saved.
	 * @return 1 if the operation was successful.
	 */
	public long add(E entity);

	/**
	 * Calls the data access object and tells it to perform an update operation
	 * on the given entity.
	 * 
	 * @param entity
	 *            item to be updated.
	 * @return 1 if the operation was successful.
	 */
	public long update(E entity);

	/**
	 * Calls the data access object and tells it to perform a delete operation
	 * on the given entity.
	 * 
	 * @param entity
	 *            item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	public long remove(E entity);

	/**
	 * Calls the data access object and tells it to perform a delete operation
	 * on an entity with the given key.
	 * 
	 * @param key
	 *            the key of the item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	public long removeByKey(K key);

	/**
	 * Calls the data access object and tells it to perform a retrieve operation
	 * on the given key.
	 * 
	 * @param key
	 *            key of the item to be retrieved.
	 * @return found entity or null if no entity is found.
	 */
	public E get(K key);

	/**
	 * Calls the data access object and tells it to perform a retrieve operation
	 * on all items of the given type.
	 * 
	 * @return list of all items of the given entity type.
	 */
	public List<E> listAll();

}
