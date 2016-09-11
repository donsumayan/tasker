package com.comp.tasker.constants;

/**
 * Class containing all the view levels (for @JsonViews) to be used to filter
 * out certain fields when returning JSON.
 * 
 * @author Vincent Montesclaros
 *
 */
public class Views {
	public static class User {

	}

	public static class Admin extends User {

	}

	public static class Secret extends Admin {

	}

}
