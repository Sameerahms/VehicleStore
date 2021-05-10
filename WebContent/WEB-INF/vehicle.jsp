<%@page import="com.hms.database.VehicleDb"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Vehicle Store</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<style type="text/css">
	.input-error{
	box-shadow: 0 0 5px red;
	}

</style>
<script src="https://cdn.jsdelivr.net/npm/handsontable@8.3.2/dist/handsontable.full.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/handsontable@8.3.2/dist/handsontable.full.min.css" rel="stylesheet" media="screen">
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<div class="card">
			<div class="card-header">Add New Vehicle</div>
			<div class="card-body">
				<form action="<%= request.getContextPath() %>/VehiceServelet" name="addVehicle" method="post" >
					<div class="form-row" id="form-group">
						<div class="form-group col-md-6" id="name-group">
							<label for="inputCity">Vehicle Brand</label> <input type="text"
								class="form-control" name="vehicalBrand"id="vehicalBrand" placeholder="ex: Toyota">
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">Vehicle Model</label> <input
								type="text" class="form-control" name="vehicalModel" id="vehicalModel"
								placeholder="ex: Aqua">
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">Model Year</label> <input type="text"
								class="form-control" id="modelYear" name="modelYear" placeholder="ex: 2020">
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">Vehicle Count</label> <input
								type="text" class="form-control" name="vehicalCount" id="vehicalCount"
								placeholder="ex: 10">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
					<br><br>
					<div class="form-group col-md-12" id="name-alert"></div>
				</form>
			</div>
		</div>
		<br><br>
		
			
			
			<%
			VehicleDb vehicleDb = new VehicleDb();
            List<Vehicle> list = vehicleDb.loadVehicleData();
            request.setAttribute("list", list);
          %>
			
			<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List Vehicle</h3>
                    <hr>

                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Vehicle Brand</th>
                                <th>vehicle Model</th>
                                <th>Model Year</th>
                                <th>Vehicle Count</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            
                            <c:forEach var="user" items="${list}">

                                <tr>
                                    <td>
                                        <c:out value="${user.vehicalBrand}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.vehicalModel}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.modelYear}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.vehicalCount}" />
                                    </td>
                                    
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
			
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="jq/validator.js"></script>
	<script src="jq/handsontable.js"></script>


</body>
</html>