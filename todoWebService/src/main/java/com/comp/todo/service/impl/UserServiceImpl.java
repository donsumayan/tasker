package com.comp.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.todo.constants.Views;
import com.comp.todo.dao.BaseDao;
import com.comp.todo.dao.UserDao;
import com.comp.todo.model.User;
import com.comp.todo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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

	@Override
	public Long addUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(user);
		System.out.println(user.getPassword());
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDao.save(user);

		return new Long(1);
	}

	@Override
	public String getUsers() throws JsonProcessingException {
		List<User> users = userDao.list();
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter viewWriter = mapper.writerWithView(Views.User.class);
		return viewWriter.writeValueAsString(users);
	}

}
