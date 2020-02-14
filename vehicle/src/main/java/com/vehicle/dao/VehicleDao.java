package com.vehicle.dao;

import java.util.List;

import com.vehicle.model.Vehicle;


public interface VehicleDao {

	Boolean createVehicle(Vehicle vehicle);

	Vehicle updateVehicle(Vehicle vehicle);

	Vehicle searchVehicle(String criteria, String data);

	List<Vehicle> getAllVehicle();

	Vehicle getVehicle(int vehicleId);
}
