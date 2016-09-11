package com.comp.tasker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.tasker.dao.BaseDao;
import com.comp.tasker.model.Role;
import com.comp.tasker.service.RoleService;

/**
 * Base implementation for calling data access objects to perform CRUD
 * operations on user roles.
 * 
 * @author Vincent Montesclaros
 *
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {
	public RoleServiceImpl() {

	}

	@Autowired
	public RoleServiceImpl(@Qualifier("roleDaoImpl") BaseDao<Role, Long> baseDao) {
		super(baseDao);
	}
}
