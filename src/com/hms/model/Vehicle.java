package com.hms.model;

public class Vehicle {
	
	private String  vehicalBrand;
	private String vehicalModel;
	private String modelYear;
	private String vehicalCount;
	


	public Vehicle() {
		
	}
	public Vehicle(String vehicalBrand, String vehicalModel, String modelYear, String vehicalCount) {
		this.vehicalBrand = vehicalBrand;
		this.vehicalModel = vehicalModel;
		this.modelYear = modelYear;
		this.vehicalCount = vehicalCount;
	}
	public String getVehicalBrand() {
		return vehicalBrand;
	}
	public void setVehicalBrand(String vehicalBrand) {
		this.vehicalBrand = vehicalBrand;
	}
	public String getVehicalModel() {
		return vehicalModel;
	}
	public void setVehicalModel(String vehicalModel) {
		this.vehicalModel = vehicalModel;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public String getVehicalCount() {
		return vehicalCount;
	}
	public void setVehicalCount(String vehicalCount) {
		this.vehicalCount = vehicalCount;
	}
	
	
}
