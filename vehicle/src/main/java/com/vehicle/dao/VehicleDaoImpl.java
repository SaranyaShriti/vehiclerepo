package com.vehicle.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.model.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean createVehicle(Vehicle vehicle) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(vehicle);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		try {
			sessionFactory.getCurrentSession().update(vehicle);

		} catch (Exception e) {

		}
		return vehicle;
	}

	@Override
	public Vehicle searchVehicle(String criteria, String data) {
		try {

		} catch (Exception e) {

		}

		return null;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			Vehicle vehicle = (Vehicle) sessionFactory.getCurrentSession().createQuery("from Vehicle");
			if (vehicle != null) {
				vehicleList = Arrays.asList(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

	@Override
	public Vehicle getVehicle(int vehicleId) {
		Vehicle vehicle = new Vehicle();
		try {
			vehicle = (Vehicle) sessionFactory.getCurrentSession().get(Vehicle.class, vehicleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}

}

