package com.vehicle.service;

import com.vehicle.model.Login;
import com.vehicle.model.User;

public interface UserService {
	Boolean createUser(User user);
	Boolean getUserObject(Login loginDetails);
}
