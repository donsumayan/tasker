package com.comp.tasker.dao;

import java.util.List;

/**
 * Base interface for CRUD operations and common queries.
 * 
 * @author Vincent Montesclaros
 *
 * @param <E>
 *            the entity type.
 * @param <K>
 *            the key type.
 */
public interface BaseDao<E, K> {

	/**
	 * Returns all the items of the given entity type from the database.
	 * 
	 * @return list of all items of the given entity type.
	 */
	public List<E> list();

	/**
	 * Find an item from database based on its ID.
	 * 
	 * @param key
	 *            the ID to look for.
	 * @return found entity or null if no entity is found.
	 */
	public E get(K key);

	/**
	 * Persists the given entity into the database.
	 * 
	 * @param entity
	 *            the entity to be saved.
	 * @return 1 if the entity is successfully saved.
	 * 
	 */
	public long save(E entity);

	/**
	 * Calls either save() or update() on the basis of whether the entity exists
	 * or not.
	 * 
	 * @param entity
	 *            to be saved or updated.
	 * @return 1 if the operation was successful.
	 */
	public long saveOrUpdate(E entity);

	/**
	 * Deletes the item from database.
	 * 
	 * @param entity
	 *            the item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	public long delete(E entity);

	/**
	 * Deletes an item with the given key from the database.
	 * 
	 * @param key
	 *            the key of the item to be deleted.
	 * @return 1 if the operation was successful.
	 */
	public long deleteByKey(K key);

	/**
	 * Deletes all items with the given entity class.
	 * 
	 * @return the number of records deleted.
	 */
	public long deleteAll();

}
