package com.comp.tasker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.tasker.constants.Views;
import com.comp.tasker.dao.BaseDao;
import com.comp.tasker.dao.UserDao;
import com.comp.tasker.model.User;
import com.comp.tasker.service.UserService;
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
		if (userDao.findByEmail(user.getEmail().trim()) != null) {
			return new Long(0);
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userDao.save(user);

			return new Long(1);
		}
	}

	@Override
	public String getUsers() {
		List<User> users = userDao.list();
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter viewWriter = mapper.writerWithView(Views.User.class);
		try {
			return viewWriter.writeValueAsString(users);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	@Override
	public Long updateUser(User user) {
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			User originalUser = userDao.get(user.getId());
			user.setPassword(originalUser.getPassword());
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}

		return userDao.saveOrUpdate(user);
	}

}
