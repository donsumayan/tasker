package com.comp.todo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.comp.todo.dao.TodoDao;
import com.comp.todo.model.Todo;

/**
 * Base implementation for common CRUD operations and queries on todos.
 * 
 * @author Vincent Montesclaros
 *
 */
@Repository
public class TodoDaoImpl extends BaseDaoImpl<Todo, Long> implements TodoDao {
	public TodoDaoImpl() {
		this(Todo.class);
	}

	protected TodoDaoImpl(Class<Todo> entityClass) {
		super(entityClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Todo> findByUserId(Long userId) {
		Session session = getSessionFactory().getCurrentSession();
		return (List<Todo>) session.createCriteria(Todo.class).add(Restrictions.eq("user.id", userId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
}
