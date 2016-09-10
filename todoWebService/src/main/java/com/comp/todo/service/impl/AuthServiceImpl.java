package com.comp.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.todo.dao.UserDao;
import com.comp.todo.model.User;
import com.comp.todo.service.AuthService;

/**
 * Base implementation for performing authorization and authentication
 * operations for users.
 * 
 * @author Vincent Montesclaros
 *
 */
@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	/**
	 * Data access object for users.
	 */
	@Autowired
	private UserDao userDao;

	@Override
	public User login(String email, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = userDao.findByEmail(email);

		if (encoder.matches(password, user.getPassword())) {
			return user;
		} else {
			return null;
		}
	}

}
