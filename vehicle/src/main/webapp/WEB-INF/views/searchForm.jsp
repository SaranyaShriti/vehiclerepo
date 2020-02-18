<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Search Form</title>
<style>
.align-center {
	text-align: center;
}
</style>
</head>
<body>
	<form action="/test/searchVehicle" method="POST">
		<div class="container">
			<div class="row">
				<div class="col-3">
					<div class="align-center">
						<h4>VEHICLE SEARCH</h4>
					</div>
					<div class="form-group">
						<label for="vehicleNo"><b>VehicleNumber</b></label> <input
							type="text" class="form-control"
							placeholder="Enter VehicleNumber" name="vehicleNo">
					</div>
					<div class="form-group">
						<label for="branch"><b>Branch</b></label> <input type="text"
							class="form-control" placeholder="Enter Branch" name=Branch>
					</div>
					<div class="form-group">
						<label for="vehicleType"><b>Vehicle Type</b></label> <input
							type="text" class="form-control" placeholder="Enter Vehicle Type"
							name=VehicleType>
					</div>
					<div class="form-group">
						<label for="insuranceExpiryDate"><b>InsuranceExpiryDate</b></label>
						<input type="text" class="form-control"
							placeholder="Enter InsuranceExpiryDate" name=insuranceExpiryDate>
					</div>
					<div class="form-group">
						<label for="lastServiceDate"><b>LastServiceDate</b></label> <input
							type="text" class="form-control"
							placeholder="Enter lastServiceDate" name=lastServiceDate>
					</div>
					<div class="form-group">
						<label for="ServiceDueDate"><b>ServiceDueDate</b></label> <input
							type="text" class="form-control"
							placeholder="Enter ServiceDueDate" name=ServiceDueDate>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Search">
					</div>
				</div>
				<div class="col-9">
					<c:if test="${fn:length(searchListVehicle) > 0}">

						<div class="align-center">
							<h4>VEHICLE LIST</h4>
						</div>

						<table border="1" class="table">
							<thead class="thead-dark">

								<tr>
									<th scope="col">Vehicle Number</th>
									<th scope="col">Vehicle Branch</th>
									<th scope="col">Vehicle Type</th>
									<th scope="col">Vehicle Insurance ExpiryDate</th>
									<th scope="col">Vehicle Service Date</th>
									<th scope="col">serviceDueDate</th>
								</tr>
							</thead>
							<c:forEach items="${searchListVehicle}" var="vehicle">
								<tr>
									<td>${vehicle.vehicleNo}</td>
									<td>${vehicle.branch}</td>
									<td>${vehicle.vehicleType}</td>
									<td>${vehicle.insuranceExpiryDate}</td>
									<td>${vehicle.lastServiceDate}</td>
									<td>${vehicle.serviceDueDate}</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</form>
</body>
</html>