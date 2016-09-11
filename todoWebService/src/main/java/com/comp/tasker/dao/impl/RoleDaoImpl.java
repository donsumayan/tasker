package com.comp.tasker.dao.impl;

import org.springframework.stereotype.Repository;

import com.comp.tasker.dao.RoleDao;
import com.comp.tasker.model.Role;

/**
 * Base implementation for common CRUD operations and queries on user roles.
 * 
 * @author Vincent Montesclaros
 *
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, Long> implements RoleDao {
	public RoleDaoImpl() {
		this(Role.class);
	}

	protected RoleDaoImpl(Class<Role> entityClass) {
		super(entityClass);
	}
}
