package com.comp.tasker.dao.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comp.tasker.constants.SQLConstants;
import com.comp.tasker.dao.DateTimeDao;

/**
 * Base implementation for operations on database date and time.
 * 
 * @author Vincent Montesclaros
 *
 */
@Repository
public class DateTimeDaoImpl implements DateTimeDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Date getSystemDate() {
		Session session = sessionFactory.getCurrentSession();
		return (Date) session.createSQLQuery(SQLConstants.SQL_SELECT_NOW).uniqueResult();
	}

}
