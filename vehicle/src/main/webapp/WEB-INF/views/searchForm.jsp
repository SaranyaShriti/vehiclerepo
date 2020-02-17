<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Form</title>
</head>
<body>
<form action="/test/searchVehicle" method="POST">
		<div class="container">
			<h1>VEHICLE SEARCH</h1>
			<table>

				<tr>
					
					<td><label for="vehicleNo"><b>VehicleNumber</b></label></td>
					<td><input type="text" placeholder="Enter VehicleNumber"
						name="vehicleNo"></td>
				</tr>
				<tr>
					<td><label for="branch"><b>Branch</b></label></td>
					<td><input type="text" placeholder="Enter Branch" name=Branch
						></td>
				</tr>
				<tr>
					<td><label for="vehicleType"><b>Vehicle Type</b></label></td>
					
					<td><input type="text" placeholder="Enter Vehicle Type"
						name=VehicleType></td>
				</tr>
				<tr>
					<td><label for="insuranceExpiryDate"><b>InsuranceExpiryDate</b></label></td>
					<td><input type="text" placeholder="Enter InsuranceExpiryDate"
						name=insuranceExpiryDate></td>
				</tr>
				<tr>
					<td><label for="lastServiceDate"><b>LastServiceDate</b></label></td>
					<td><input type="text" placeholder="Enter lastServiceDate"
						name=lastServiceDate></td>
				</tr>
				<tr>
					<td><label for="ServiceDueDate"><b>ServiceDueDate</b></label></td>
					<td><input type="text" placeholder="Enter ServiceDueDate"
						name=ServiceDueDate></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>