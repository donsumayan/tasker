package com.comp.tasker.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.comp.tasker.dao.UserDao;
import com.comp.tasker.model.User;

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

	@Override
	public User findByEmail(String email) {
		Session session = getSessionFactory().getCurrentSession();
		return (User) session.createCriteria(User.class).add(Restrictions.eq("email", email))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).uniqueResult();
	}

}
