package com.comp.tasker.service;

import java.util.Date;

/**
 * Base interface for operations involving retrieving database date and time..
 * 
 * @author Vincent Montesclaros
 *
 */
public interface DateTimeService {

	/**
	 * Returns the current date of the database.
	 * 
	 * @return the current date of the database.
	 */
	public Date getSystemDate();
}
