package com.vehicle.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vehicle.model.Login;
import com.vehicle.model.User;
import com.vehicle.model.Vehicle;
import com.vehicle.service.UserService;
import com.vehicle.service.VehicleService;

/**
 * 
 * @author saranya.subramani
 *
 */
@Controller
public class VehicleController {
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

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logout(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.POST)
	public ModelAndView loginError(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute User user, BindingResult br) {
		ModelAndView model = new ModelAndView();
		if (br.hasErrors()) {
			model.addObject("User", user);
			model.setViewName("createUser");
			return model;
		} else {
			Boolean result = userService.createUser(user);

			if (result) {
				model.addObject("message", "Registered Successfully!");
				model.setViewName("/login");
			} else {
				model.setViewName("/Error");
			}
			return model;
		}

	}

	@RequestMapping(value = "/vehicleList", method = RequestMethod.GET)
	public ModelAndView listVehicle(@ModelAttribute("getList") Login login, ModelAndView model) throws IOException {
		if (userService.getUserObject(login)) {
			List<Vehicle> vehilceList = vehicleService.getAllVehicle();
			if (vehilceList.size() > 0) {
				model.addObject("listVehicle", vehilceList);
				model.setViewName("listVehicle");
			} else {
				// model.addObject("listVehicle", "No vehicle Found");
				model.setViewName("listVehicle");
			}
		} else {
			model.addObject("message", "Invalid Credentials");
			model.setViewName("Error");
		}
		List<Vehicle> vehilceList = vehicleService.getAllVehicle();
		model.setViewName("listVehicle");
		model.addObject("listVehicle", vehilceList);
		return model;
	}

	@RequestMapping(value = "/newVehicle", method = RequestMethod.GET)
	public ModelAndView newVehicle(ModelAndView model) {
		Vehicle vehicle = new Vehicle();
		model.addObject("vehicle", vehicle);
		model.setViewName("createVehicle");
		return model;
	}

	@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@ModelAttribute Vehicle vehicle) {
		Boolean result = false;
		ModelAndView model = new ModelAndView();
		if (vehicle.getId() == null) {
			result = vehicleService.createVehicle(vehicle);
			if (result) {
				model.addObject("message", "Vehicle Added Successfully!");
				List<Vehicle> vehilceList = vehicleService.getAllVehicle();
				model.addObject("listVehicle", vehilceList);
				model.setViewName("/listVehicle");
			} else {
				model.addObject("message", "Cannot Add!");
				model.setViewName("/Error");
			}

		} else {
			result = vehicleService.updateVehicle(vehicle);
			if (result) {
				List<Vehicle> vehilceList = vehicleService.getAllVehicle();
				model.addObject("listVehicle", vehilceList);
				model.addObject("message", "Vehicle Updated Successfully!");
				model.setViewName("/listVehicle");
			} else {
				model.addObject("message", "Cannot Add!");
				model.setViewName("/Error");
			}
		}
		return model;
	}

	@RequestMapping(value = "/editVehicle/{id}", method = RequestMethod.GET)
	public ModelAndView editVehicle(@PathVariable Integer id) {
		Vehicle vehicle = vehicleService.getVehicle(id);
		System.out.println(vehicle.getVehicleNo());
		ModelAndView model = new ModelAndView("createVehicle");
		model.addObject("vehicle", vehicle);
		return model;
	}

	@RequestMapping(value = "/searchVehicle", method = RequestMethod.POST)
	public ModelAndView searchVehicle(@ModelAttribute Vehicle vehicle) {
		ModelAndView model = new ModelAndView();
		if (vehicle != null) {
			if (vehicle.getBranch() != null && vehicle.getInsuranceExpiryDate() != null
					&& vehicle.getLastServiceDate() != null && vehicle.getServiceDueDate() != null
					&& vehicle.getVehicleNo() != null && vehicle.getVehicleType() != null) {
				List<Vehicle> searchVehicleList = vehicleService.searchVehicle(vehicle);
				if (searchVehicleList.size() > 0) {
					model.addObject("searchListVehicle", searchVehicleList);
				} else {
					model.addObject("message", "No data Found!");
				}
			}
		}
		model.setViewName("searchForm");
		return (model);
	}
}