package com.init.transport.api.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.transport.api.entity.Driver;
import com.init.transport.api.service.DriverService;
import com.init.transport.api.ui.dto.DriverDTO;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

	@Autowired
	private DriverService driverService;

	@GetMapping("/{routeId}/DriverDetails")
	public List<DriverDTO> getAll(@PathVariable("routeId") int routeId,
			@RequestParam(name="time", required = false) String dateTimeString ) throws ParseException {
		List<Driver> drivers = dateTimeString==null ? driverService.findDriversByRouteId(routeId) : driverService.findDriverByRouteIdAndTime(routeId, dateTimeString);
		List<DriverDTO> driverDTOs = new ArrayList<>();
		for(Driver driver : drivers) {
			DriverDTO driverDTO = new DriverDTO(driver.getFirstName(), driver.getLastName());
			driverDTOs.add(driverDTO);
		}
		return driverDTOs;
	}

}
