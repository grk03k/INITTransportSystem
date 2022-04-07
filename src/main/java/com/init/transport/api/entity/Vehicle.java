package com.init.transport.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLES")
public class Vehicle {

	@Id
	private int vehicleId;

	@ManyToOne
    @JoinColumn(name="DRIVER_ID", nullable=false, insertable = false, updatable = false)
	private Driver driver;

	public Vehicle() {

	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", driver=" + driver + "]";
	}


	

}
