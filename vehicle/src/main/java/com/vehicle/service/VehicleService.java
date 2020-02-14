package com.vehicle.service;

import java.util.List;


import com.vehicle.model.Vehicle;


public interface VehicleService {
	Boolean createVehicle(Vehicle vehicle);

	Vehicle updateVehicle(Vehicle vehicle);

	List<Vehicle> searchVehicle(Vehicle Vehicle);

	List<Vehicle> getAllVehicle();
	
	Vehicle getVehicle(int vehicleId);
}