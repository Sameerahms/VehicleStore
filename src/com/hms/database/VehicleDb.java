package com.hms.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hms.model.Vehicle;

public class VehicleDb {
	

	public void insertVehicalData (Vehicle vehicle) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DatabaseConnection.getConnection();
			
		}catch (SQLException exception) {
			
			exception.printStackTrace();
		}
		
		String query = "INSERT INTO `vehicle`"
					+ " (`vehicalBrand`, "
					+ "`vehicalModel`,"
					+ " `modelYear`, "
					+ "`vehicalCount`)"
					+ " VALUES (?, ?, ?, ?)";
		
		try {
			statement = (PreparedStatement) connection.prepareStatement(query);
			
			statement.setString(1, vehicle.getVehicalBrand());
			statement.setString(2, vehicle.getVehicalModel());
			statement.setString(3, vehicle.getModelYear());
			statement.setString(4, vehicle.getVehicalCount());
			
			statement.executeUpdate();
			connection.close();
			
		}catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public List <Vehicle>  loadVehicleData() {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		List<Vehicle> listVehicle = new ArrayList<Vehicle>();
		
		try {
			connection = DatabaseConnection.getConnection();
			
		}catch (SQLException exception) {
			
			exception.printStackTrace();
		}
		
		String query = "SELECT `vehicalBrand`, `vehicalModel`,`modelYear`, `vehicalCount`  FROM `vehicle`";
		
		try {
			statement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String vehicalBrand = rs.getString("vehicalBrand");
				String vehicalModel = rs.getString("vehicalModel");
				String modelYear = rs.getString("modelYear");
				String vehicalCount = rs.getString("vehicalCount");
			
				listVehicle.add(new Vehicle(vehicalBrand, modelYear, vehicalCount,vehicalModel));
				
			}
			
			for(Vehicle b:listVehicle){  
			    System.out.println("inside vehicledb:"+b.getModelYear()+" "+b.getVehicalBrand()+" "+b.getVehicalCount());  
			}
			//connection.close();
			//System.out.println(listVehicle);
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
		return listVehicle;
		
	}

}
