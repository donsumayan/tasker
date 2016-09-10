package com.comp.todo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.comp.todo.constants.Constants;
import com.comp.todo.dao.UserDao;
import com.comp.todo.model.Role;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		try {
			com.comp.todo.model.User user = getUserDetail(username);
			Role role = user.getRole();
			return new User(user.getEmail(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
					accountNonLocked, getAuthorities(role));
		} catch (Exception ex) {
			throw new UsernameNotFoundException(Constants.INVALID_CREDENTIALS);
		}
	}

	private com.comp.todo.model.User getUserDetail(String email) throws Exception {
		com.comp.todo.model.User user = userDao.findByEmail(email);
		if (user == null) {
			throw new Exception(Constants.AUTH_USER_NOT_FOUND);
		} else {
			return user;
		}
	}

	/**
	 * Returns the list of granted authorities a specific user has.
	 * 
	 * @param role
	 *            the user role as defined in the database
	 * @return a List of GrantedAuthority objects based on the given user's role
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		String userRole = "ROLE_USER";

		if (role.getName().equals(Constants.ADMIN)) {
			userRole = Constants.ROLE_ADMIN;
		} else if (role.getName().equals(Constants.USER)) {
			userRole = Constants.ROLE_USER;
		}

		authList.add(new SimpleGrantedAuthority(userRole));
		return authList;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
