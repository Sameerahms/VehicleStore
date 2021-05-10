package om.hms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.database.VehicleDb;
import com.hms.model.Vehicle;

/**
 * Servlet implementation class VehiceServelet
 */
@WebServlet("/VehiceServelet")
public class VehiceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VehicleDb vehicalDb = new VehicleDb();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiceServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//initial request
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vehicle.jsp");
			
//		JSONObject object =new JSONObject();  
		VehicleDb vehicledb = new VehicleDb();
		//List<Vehicle> listVehicle = vehicledb.loadVehicleData();
//		
//		listVehicle = vehicledb.loadVehicleData();
//		for(Vehicle b:listVehicle){  
//		    System.out.println("Inside server"+b.getModelYear()+" "+b.getVehicalBrand()+" "+b.getVehicalCount()); 
//		    object.put("VehicalBrand", b.getVehicalBrand());
//		    object.put("ModelYear", b.getModelYear());
//		    object.put("VehicalCount", b.getVehicalCount());
//		    System.out.println(object);
//		}
////		
//		String jsonStr = JSONArray.toJSONString(listVehicle);
////		System.out.println("jsonStr"+jsonStr);
//		request.setAttribute("listVehicle", listVehicle);
////	
//////		}
//		//String v = object.toString();
//		response.setContentType("text/plain");
//		response.getWriter().write(jsonStr);
//		dispatcher.forward(request, response);
//		
		
		List < Vehicle > listUser = vehicledb.loadVehicleData();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vehicle.jsp");
        dispatcher.forward(request, response);
		
	}
    




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Map obj=new HashMap();  
		JSONObject obj =new JSONObject();    
		boolean flag = true;
		String regex = "[0-9]+";
		
		Pattern p = Pattern.compile(regex);
		Vehicle vehicle = new Vehicle();
		
		//Vehicle data
		String vehicalBrand = request.getParameter("vehicalBrand");
		String vehicalModel = request.getParameter("vehicalModel");
		String modelYear = request.getParameter("modelYear");
		String vehicalCount = request.getParameter("vehicalCount");
		System.out.println(vehicalBrand);
		
		Matcher matchYear = p.matcher(modelYear);
		Matcher matchCount = p.matcher(vehicalCount);
		
		if(vehicalBrand == "" || vehicalBrand == null) {
			System.out.println(vehicalBrand);
			flag = false;
			
			obj.put("success", false);
			//obj.put("errors", "vehicalBrand");
			obj.put("vehicalBrand", false);
		}else {
			//obj.put("success", true);
			obj.put("vehicalBrand", true);
			vehicle.setVehicalBrand(vehicalBrand);
		}
		
		if(vehicalModel == "" || vehicalModel == null) {
			System.out.println(vehicalModel);
			flag = false;
			
			obj.put("success", false);
			//obj.put("errors", "vehicalModel");
			obj.put("vehicalModel", false);
		}else {
			//obj.put("success", true);
			obj.put("vehicalModel", true);
			vehicle.setVehicalModel(vehicalModel);
		}
		
		if(modelYear == "" || !matchYear.matches()) {
			System.out.println(modelYear);
			flag = false;
			
			obj.put("success", false);
			//obj.put("errors", "vehicalModel");
			obj.put("modelYear", false);
		}else {
			//obj.put("success", true);
			obj.put("modelYear", true);
			vehicle.setModelYear(modelYear);
		}
		
		if(vehicalCount == "" || !matchCount.matches()) {
		
			flag = false;
			
			obj.put("success", false);
			//obj.put("errors", "vehicalModel");
			obj.put("vehicalCount", false);
		}else {
			//obj.put("success", true);
			obj.put("vehicalCount", true);
			vehicle.setVehicalCount(vehicalCount);
		}
		
		
		if(flag == true) {
			obj.put("success", true);
			vehicalDb.insertVehicalData(vehicle);
		}
		
		String v = obj.toString();
		response.setContentType("text/plain");
		response.getWriter().write(v);
		
	}

}
