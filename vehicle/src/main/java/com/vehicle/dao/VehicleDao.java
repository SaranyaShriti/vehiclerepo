package com.vehicle.dao;

import java.util.List;

import com.vehicle.model.Vehicle;

public interface VehicleDao {
	/**
	 * This method is used to create vehicle
	 * 
	 * @param vehicle
	 * @return
	 */
	Boolean createVehicle(Vehicle vehicle);

	/**
	 * This method is used to update vehicle
	 * 
	 * @param vehicle
	 * @return
	 */
	Boolean updateVehicle(Vehicle vehicle);

	/**
	 * This method is used to search vehicle
	 * 
	 * @param Vehicle
	 * @return
	 */
	List<Vehicle> searchVehicle(Vehicle Vehicle);

	/**
	 * This method is used to create vehicle
	 * 
	 * @return
	 */
	List<Vehicle> getAllVehicle();

	/**
	 * This method is used to get all vehicle
	 * 
	 * @param vehicleId
	 * @return
	 */
	Vehicle getVehicle(int vehicleId);
}