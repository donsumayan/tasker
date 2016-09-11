package com.comp.tasker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.tasker.constants.Views;
import com.comp.tasker.dao.UserDao;
import com.comp.tasker.model.User;
import com.comp.tasker.service.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
	public String login(String email, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = userDao.findByEmail(email);

		if (encoder.matches(password, user.getPassword())) {
			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter viewWriter = mapper.writerWithView(Views.User.class);
			try {
				return viewWriter.writeValueAsString(user);
			} catch (JsonProcessingException e) {
				return "";
			}
		} else {
			return "";
		}
	}

}
