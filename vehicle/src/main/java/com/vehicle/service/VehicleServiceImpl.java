package com.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.dao.VehicleDao;
import com.vehicle.model.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleDao vehicleDAO;

	@Override
	@Transactional
	public Boolean createVehicle(Vehicle vehicle) {
		return vehicleDAO.createVehicle(vehicle);
	}

	@Override
	@Transactional
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleDAO.updateVehicle(vehicle);
	}

	@Override
	@Transactional
	public Vehicle searchVehicle(String criteria, String data) {
		return vehicleDAO.searchVehicle(criteria, data);
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return vehicleDAO.getAllVehicle();

	}

	@Override
	public Vehicle getVehicle(int vehicleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
