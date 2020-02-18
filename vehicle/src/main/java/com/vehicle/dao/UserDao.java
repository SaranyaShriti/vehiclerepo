package com.vehicle.dao;

import com.vehicle.model.Login;
import com.vehicle.model.User;

public interface UserDao {
	/**
	 * This method is used to create user
	 * 
	 * @param user
	 * @return
	 */
	Boolean createUser(User user);

	/**
	 * This is used to validate the register user
	 * 
	 * @param loginDetails
	 * @return
	 */
	Boolean getUserObject(Login loginDetails);
}
