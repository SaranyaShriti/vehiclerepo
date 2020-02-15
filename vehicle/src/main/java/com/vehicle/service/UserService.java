package com.vehicle.service;

import com.vehicle.model.User;

public interface UserService {
	Boolean createUser(User user);
	Boolean getUserObject(User user);
}
