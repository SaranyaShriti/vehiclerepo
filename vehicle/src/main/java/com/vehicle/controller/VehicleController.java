package com.vehicle.controller;

import java.io.IOException;
import java.util.List;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.model.Login;
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

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
		User user = new User();
		model.addObject("User", user);
		model.setViewName("createUser");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@ModelAttribute User user) {
		Boolean result = userService.createUser(user);
		ModelAndView model = new ModelAndView();
		if (result) {
			model.addObject("message", "Registered Successfully!");
			model.setViewName("/login");
		} else {
			model.setViewName("/Error");
		}
		return model;
	}


	@RequestMapping(value = "/vehicleList", method= RequestMethod.POST )
	public ModelAndView listVehicle(@ModelAttribute("getList") Login login, ModelAndView model) throws IOException 
	{
		User user1 = new User();
		user1.setEmail(login.getUsername());
		user1.setPassword(login.getPassword());

		if(userService.getUserObject(user1))
		{
			List<Vehicle> vehilceList = vehicleService.getAllVehicle();
			if(vehilceList!=null)
			{
				model.addObject("listVehicle", vehilceList);
				model.setViewName("listVehicle");
			}
			else
			{
				model.setViewName("listVehicle");
			}
		}
		else
			model.setViewName("Error");

		return model;
	}

	@RequestMapping(value = "/newVehicle", method = RequestMethod.GET)
	public ModelAndView newVehicle(ModelAndView model) {
		Vehicle vehicle = new Vehicle();
		model.addObject("vehicle", vehicle);
		model.setViewName("vehicleForm");
		return model;
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

	/*@RequestMapping(value = "/editVehicle", method = RequestMethod.GET)
	public ModelAndView editVehicle(HttpServletRequest request) {
		int vehicleId = Integer.parseInt(request.getParameter("id"));
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		ModelAndView model = new ModelAndView("VehicleForm");
		model.addObject("vehicle", vehicle);

		return model;
	}*/

	@RequestMapping(value = "/searchVehicle", method = RequestMethod.GET)
	public ModelAndView searchVehicle(@ModelAttribute Vehicle vehicle) {
		List<Vehicle> searchVehicleList = vehicleService.getAllVehicle();
		ModelAndView model = new ModelAndView();
		model.addObject("searchListVehicle", searchVehicleList);
		model.setViewName("searchList");
		return (model);
	}

}