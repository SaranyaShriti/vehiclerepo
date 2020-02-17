package com.vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.VehicleDao;
import com.vehicle.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	VehicleDao vehicleDAO;

	@Override
	@Transactional
	public Boolean createVehicle(Vehicle vehicle) {
		return vehicleDAO.createVehicle(vehicle);
	}

	@Override
	@Transactional
	public Boolean updateVehicle(Vehicle vehicle) {
		return vehicleDAO.updateVehicle(vehicle);
	}

	@Override
	@Transactional
	public List<Vehicle> getAllVehicle() {
		return vehicleDAO.getAllVehicle();

	}

	@Override
	@Transactional
	public Vehicle getVehicle(int vehicleId) {
		return vehicleDAO.getVehicle(vehicleId);
	}

	@Override
	@Transactional
	public List<Vehicle> searchVehicle(Vehicle Vehicle) {
		return vehicleDAO.searchVehicle(Vehicle);
	}

}