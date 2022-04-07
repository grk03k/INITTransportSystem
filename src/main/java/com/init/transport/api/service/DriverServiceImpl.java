package com.init.transport.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.transport.api.entity.Driver;
import com.init.transport.api.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	DriverRepository driverRepository;

	@Override
	public List<Driver> findDriversByRouteId(int routeId) {
		return driverRepository.findDriversByRouteId(routeId);
	}

	@Override
	public List<Driver> findDriverByRouteIdAndTime(int routeId, String dateTimeString) throws ParseException {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
		Date time = formatter.parse(dateTimeString);
		return driverRepository.findDriverByRouteIdAndTime(routeId, time);
	}

}
