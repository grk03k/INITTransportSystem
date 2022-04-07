package com.init.transport.api.service;

import java.text.ParseException;
import java.util.List;

import com.init.transport.api.entity.Driver;


public interface DriverService {
	
	List<Driver> findDriversByRouteId(int routeId);
	
	List<Driver> findDriverByRouteIdAndTime(int routeId, String dateTimeString) throws ParseException;
	

}
