package com.vehicle.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.model.User;
import com.vehicle.model.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean createVehicle(Vehicle vehicle) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = null;

		try {
			id = (Integer) session.save(vehicle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Boolean updateVehicle(Vehicle vehicle) {
		try {
			sessionFactory.getCurrentSession().update(vehicle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> vehicle = null;
		Session session = sessionFactory.openSession();
		try {
			vehicle = session.createQuery("from Vehicle").list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehicle;
	}

	@Override
	public Vehicle getVehicle(int vehicleId) {
		Vehicle vehicle = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			vehicle = (Vehicle) session.get(Vehicle.class, vehicleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}

	@Override
	public List<Vehicle> searchVehicle(Vehicle Vehicle) {
		String query = "from Vehicle as v where ";
		List<Vehicle> vehicleList = new ArrayList<>();
		try {
			if (!Vehicle.getBranch().isEmpty()) {
				query = query + " v.branch = '" + Vehicle.getBranch() + "' and ";
			}
			if (!Vehicle.getInsuranceExpiryDate().isEmpty()) {
				query = query + " v.insuranceExpiryDate = '" + Vehicle.getInsuranceExpiryDate() + "' and ";
			}
			if (!Vehicle.getLastServiceDate().isEmpty()) {
				query = query + " v.lastServiceDate ='" + Vehicle.getLastServiceDate() + "' and ";
			}
			if (!Vehicle.getServiceDueDate().isEmpty()) {
				query = query + " v.serviceDueDate ='" + Vehicle.getServiceDueDate() + "' and ";
			}
			if (!Vehicle.getVehicleNo().isEmpty()) {
				query = query + " v.vehicleNo='" + Vehicle.getVehicleNo() + "' and ";
			}
			if (!Vehicle.getVehicleType().isEmpty()) {
				query = query + "v.vehicleType ='" + Vehicle.getVehicleType() + "'";
			}
			if (query.endsWith("and ")) {
				query = query.substring(0, query.length() - 5);
			}
			if (!query.endsWith("where ")) {
				vehicleList = sessionFactory.getCurrentSession().createQuery(query).list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

}