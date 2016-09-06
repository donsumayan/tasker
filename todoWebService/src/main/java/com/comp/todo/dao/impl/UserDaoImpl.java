package com.comp.todo.dao.impl;

import org.springframework.stereotype.Repository;

import com.comp.todo.dao.UserDao;
import com.comp.todo.model.User;

/**
 * Base implementation for common CRUD operations and queries on users.
 * 
 * @author Vincent Montesclaros
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {
	public UserDaoImpl() {
		this(User.class);
	}

	protected UserDaoImpl(Class<User> entityClass) {
		super(entityClass);
	}
}
