package com.vehicle.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.model.Login;
import com.vehicle.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	private static final Logger log4j = Logger.getLogger(UserDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean createUser(User user) {
		Boolean isSuccess = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			if (user != null) {
				session.save(user);
				isSuccess = true;
			}
		} catch (Exception e) {
			log4j.error("Exception in createUser" + e);
			isSuccess = false;
		}
		return isSuccess;
	}

	@Override
	public Boolean getUserObject(Login loginDetails) {
		Boolean isValid = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			// Query using Hibernate Query Language
			String SQL_QUERY = " from User as o where o.email=? and o.password=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0, loginDetails.getUsername());
			query.setParameter(1, loginDetails.getPassword());
			if ((query.list() != null) && (query.list().size() > 0)) {
				isValid = true;
			}
		} catch (Exception e) {
			log4j.error("Exception in getUserObject" + e);
		}
		return isValid;
	}
}