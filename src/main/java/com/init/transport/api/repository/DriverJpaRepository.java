package com.init.transport.api.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.init.transport.api.entity.Driver;

@Repository
public class DriverJpaRepository implements DriverRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Driver> findDriversByRouteId(int routeId) {
		List<Driver> drivers = this.entityManager.createQuery("Select distinct d from Driver d "
				+ "JOIN Vehicle v on v.driver.driverId = d.driverId "
				+ "JOIN Route r on r.vehicle.vehicleId = v.vehicleId "
				+ "Where r.routeId = :routeId", Driver.class)
				.setParameter("routeId", routeId).getResultList();
		return drivers;
	}

	@Override
	public List<Driver> findDriverByRouteIdAndTime(int routeId, Date time) {
		List<Driver> drivers = new ArrayList<>();
		try {
		 drivers.add(entityManager.createQuery("Select d from Driver d "
				+ "JOIN Vehicle v on v.driver.driverId = d.driverId "
				+ "JOIN Route r on r.vehicle.vehicleId = v.vehicleId "
				+ "Where r.routeId = :routeId and r.startTime<= :time and (r.endTime is null or r.endTime >=:time) ", Driver.class)
				.setParameter("routeId", routeId)
				.setParameter("time", time)
				.setFirstResult(0)
				.setMaxResults(1)
				.getSingleResult());
		}catch (NoResultException nre) {
			System.out.println("No Records present for RouteID:"+routeId);
		}
		return drivers;
	}
	

}
