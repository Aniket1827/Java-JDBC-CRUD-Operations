package com.dataaccess;

import java.sql.SQLException;

import com.database.DbConfig;

public class Vehicle {
	private int vehid;
	private String vehname;
	private String color;
	private float fuelcap;
	private float avgspeed;
	
	public Vehicle() 
	{
		
	}	
	public Vehicle(int vehid, String vehname, String color, float fuelcap, float avgspeed) 
	{
		this();
		this.vehid = vehid;
		this.vehname = vehname;
		this.color = color;
		this.fuelcap = fuelcap;
		this.avgspeed = avgspeed;
	}
	public void setVehid(int vehid) {
		this.vehid = vehid;
	}
	public void setVehname(String vehname) {
		this.vehname = vehname;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setFuelcap(float fuelcap) {
		this.fuelcap = fuelcap;
	}
	public void setAvgspeed(float avgspeed) {
		this.avgspeed = avgspeed;
	}
	public int getVehid() {
		return vehid;
	}
	public String getVehname() {
		return vehname;
	}
	public String getColor() {
		return color;
	}
	public float getFuelcap() {
		return fuelcap;
	}
	public float getAvgspeed() {
		return avgspeed;
	}
	
	
}
