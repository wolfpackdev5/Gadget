package com.gadget.Weather;

public class Weather {
	private double maxTemp;
	private double minTemp;
	private String forecast;
	private String location;
	//Constructor
	public Weather(double maxTemp, double minTemp, String forecast, String location) {
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.forecast = forecast;
		this.location = location;
	}
	//Empty Constructor
	public Weather() {}
	//getters and setters
	public double getMaxTemp() {
		return this.maxTemp;
	}
	public double getMinTemp() {
		return this.minTemp;
	}
	public String getForecast() {
		return this.forecast;
	}
	public String getLocation() {
		return this.location;
	}
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
