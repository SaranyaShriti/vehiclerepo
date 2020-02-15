package com.vehicle.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean createUser(User user) {


		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer id = null;

		try {
			tx = session.beginTransaction();
			User user1 = new User(user.getEmployeeId(),user.getFirstName(),user.getLastName(),user.getAge(), user.getGender(), user.getContactNumber(),user.getEmail(),
					user.getPassword(),user.getBranch());
			id = (Integer) session.save(user1); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close();

		}
		return true;

	}

	@Override
	public Boolean getUserObject(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from User as o where o.email=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,user.getEmail());
		query.setParameter(1,user.getPassword());
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		return userFound;  	

	}
}