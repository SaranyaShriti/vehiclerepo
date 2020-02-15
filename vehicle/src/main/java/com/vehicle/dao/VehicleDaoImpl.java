package com.vehicle.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
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
			e.printStackTrace();
		}
		return vehicle;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		Session session = sessionFactory.openSession();
		try {
			List<Vehicle> vehicle =  session.createQuery("from Vehicle").list();
			if (vehicle.size()>0) {
				
				session.close();
				System.out.println("{{{{{{"+vehicle.get(0).getBranch()+"}}}}}");

				return vehicleList;

			}
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
			return vehicleList;

		}
		session.close();
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

	@Override
	public List<Vehicle> searchVehicle(Vehicle Vehicle) {
		String query = "from Vehicle as v where ";
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			if (!Vehicle.getBranch().isEmpty()) {
				query = query + " v.branch = " + Vehicle.getBranch() + "";
			}
			if (!Vehicle.getInsuranceExpiryDate().isEmpty()) {
				query = query + " v.insuranceExpiryDate = " + Vehicle.getInsuranceExpiryDate() + "";
			}
			if (!Vehicle.getLastServiceDate().isEmpty()) {
				query = query + " v.lastServiceDate =" + Vehicle.getLastServiceDate() + "";
			}
			if (!Vehicle.getServiceDueDate().isEmpty()) {
				query = query + " v.serviceDueDate =" + Vehicle.getServiceDueDate() + "";
			}
			if (!Vehicle.getVehicleNo().isEmpty()) {
				query = query + " v.vehicleNo=" + Vehicle.getVehicleNo() + "";
			}
			if (!Vehicle.getVehicleType().isEmpty()) {
				query = query + "v.vehicleType =" + Vehicle.getVehicleType() + "";
			}
			Vehicle vehicle = (Vehicle) sessionFactory.getCurrentSession().createQuery(query);
			if (vehicle != null) {
				vehicleList = Arrays.asList(vehicle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleList;
	}

}