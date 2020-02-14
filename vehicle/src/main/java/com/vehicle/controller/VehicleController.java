package com.vehicle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.model.User;
import com.vehicle.model.Vehicle;
import com.vehicle.service.UserService;
import com.vehicle.service.VehicleService;

@Controller
public class VehicleController {
	private static final Logger logger = Logger.getLogger(VehicleController.class);

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String publicHome() {
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String privateHome() {
		return "privatePage";
	}

	@RequestMapping(value = "/vehicleList")
	public ModelAndView listVehicle(ModelAndView model) throws IOException {
		List<Vehicle> vehilceList = vehicleService.getAllVehicle();
		model.addObject("listVehicle", vehilceList);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newVehicle", method = RequestMethod.GET)
	public ModelAndView newVehicle(ModelAndView model) {
		Vehicle vehicle = new Vehicle();
		model.addObject("vehicle", vehicle);
		model.setViewName("vehicleForm");
		return model;
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
		User user = new User();
		model.addObject("User", user);
		model.setViewName("userForm");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@ModelAttribute User user) {

		userService.createUser(user);

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@ModelAttribute Vehicle vehicle) {
		if (vehicle.getId() == null) { // if vehicle id is 0 then creating the
			// vehicle other updating the vehicle
			vehicleService.createVehicle(vehicle);
		} else {
			vehicleService.updateVehicle(vehicle);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editVehicle", method = RequestMethod.GET)
	public ModelAndView editVehicle(HttpServletRequest request) {
		int vehicleId = Integer.parseInt(request.getParameter("id"));
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		ModelAndView model = new ModelAndView("VehicleForm");
		model.addObject("vehicle", vehicle);

		return model;
	}

	@RequestMapping(value = "/searchVehicle", method = RequestMethod.GET)
	public ModelAndView searchVehicle(HttpServletRequest request) {
		int vehicleId = Integer.parseInt(request.getParameter("id"));
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		ModelAndView model = new ModelAndView("VehicleForm");
		model.addObject("vehicle", vehicle);

		return model;
	}

}
