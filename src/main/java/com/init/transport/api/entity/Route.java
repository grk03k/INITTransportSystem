package com.init.transport.api.entity;

//import java.sql.Date;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ROUTES")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "ROUTE_ID")
	private int routeId;

	@ManyToOne
    @JoinColumn(name="VEHICLE_ID", nullable=false, insertable = false, updatable = false)
	private Vehicle vehicle;
	
	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name = "START_TIME")
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name = "END_TIME")
	private Date endTime;
	
	
	public Route() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", routeId=" + routeId + ", vehicle=" + vehicle + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	
	
	
}
