package com.comp.tasker.dao;

import java.util.Date;

/**
 * Base interface for operations on database date and time.
 * 
 * @author Vincent Montesclaros
 *
 */
public interface DateTimeDao {
	/**
	 * Returns the current date from the database.
	 * 
	 * @return the current date from the database.
	 */
	public Date getSystemDate();
}
