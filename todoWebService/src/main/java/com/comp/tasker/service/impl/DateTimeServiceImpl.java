package com.comp.tasker.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comp.tasker.dao.DateTimeDao;
import com.comp.tasker.service.DateTimeService;

/**
 * Base implementation for retrieving database date and time.
 * 
 * @author Vincent Montesclaros
 *
 */
@Service
@Transactional
public class DateTimeServiceImpl implements DateTimeService {

	/**
	 * Data access object for database date and time.
	 */
	@Autowired
	private DateTimeDao dateTimeDao;

	@Override
	public Date getSystemDate() {
		return dateTimeDao.getSystemDate();
	}

}
