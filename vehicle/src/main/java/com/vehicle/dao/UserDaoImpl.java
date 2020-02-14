package com.vehicle.dao;

import com.vehicle.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public Boolean createUser(User user) {
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
