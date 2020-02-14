package com.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.VehicleDao;
import com.vehicle.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	VehicleDao vehicleDAO;

	@Override
	public Boolean createVehicle(Vehicle vehicle) {
		return vehicleDAO.createVehicle(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleDAO.updateVehicle(vehicle);
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

	@Override
	public List<Vehicle> searchVehicle(Vehicle Vehicle) {
		return vehicleDAO.searchVehicle(Vehicle);
	}

}