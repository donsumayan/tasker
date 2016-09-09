package com.comp.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.todo.dao.BaseDao;
import com.comp.todo.dao.UserDao;
import com.comp.todo.model.User;
import com.comp.todo.service.UserService;

/**
 * Base implementation for calling data access objects to perform CRUD
 * operations on users.
 * 
 * @author Vincent Montesclaros
 *
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	/**
	 * Data access object for users.
	 */
	@Autowired
	private UserDao userDao;

	public UserServiceImpl() {

	}

	@Autowired
	public UserServiceImpl(@Qualifier("userDaoImpl") BaseDao<User, Long> baseDao) {
		super(baseDao);
	}

	@Override
	public Long deleteAllUsers() {
		return userDao.deleteAll();
	}

}
