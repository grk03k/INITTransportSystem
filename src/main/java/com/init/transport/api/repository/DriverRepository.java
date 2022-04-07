package com.init.transport.api.repository;

import java.util.Date;
import java.util.List;

import com.init.transport.api.entity.Driver;


public interface DriverRepository {
	
    public List<Driver> findDriversByRouteId(int routeId);
	
	public List<Driver> findDriverByRouteIdAndTime(int routeId, Date time);

}
