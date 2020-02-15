package com.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.dao.UserDao;
import com.vehicle.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public Boolean createUser(User user) {


		 Boolean insertStatus = userDao.createUser(user);
		 if(insertStatus==true)
		 {
			 return true;
		 }
		 else
			 return false;


	}
	
	@Override
	@Transactional
	public Boolean getUserObject(User user) {


		 Boolean checkStatus = userDao.getUserObject(user);
		 if(checkStatus==true)
		 {
			 return true;
		 }
		 else
			 return false;


	}

}