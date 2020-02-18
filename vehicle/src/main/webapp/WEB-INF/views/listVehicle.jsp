<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Vehicle List Page</title>
<style>
.align-center {
	text-align: center;
}

.align-right {
	float: right;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-2">

				<form action="/test/newVehicle">

					<button type="submit" class="btn btn-primary">Add Vehicle
					</button>
					<p>${message}</p>
				</form>
				<form action="/test/searchVehicle" method="POST">
					<button type="submit" class="btn btn-primary">Search</button>
				</form>

			</div>

			<div class="col-10">
				<div>
					<div class="align-center">
						<h4>VEHICLE LIST</h4>
					</div>
					<div class="align-center">
						<form action="/test/logout" method="POST">
							<button type="submit" class="btn btn-primary align-right">Logout</button>
						</form>
					</div>
				</div>
				<table border="1" class="table">
					<thead class="thead-dark">

						<tr>
							<th scope="col">ID</th>
							<th scope="col">Vehicle Number</th>
							<th scope="col">Vehicle Branch</th>
							<th scope="col">Vehicle Type</th>
							<th scope="col">Vehicle Insurance ExpiryDate</th>
							<th scope="col">Vehicle Service Date</th>
							<th scope="col">serviceDueDate</th>
							<th scope="col">Update Vehicle</th>
						</tr>
					</thead>
					<c:choose>
						<c:when test="${fn:length(listVehicle) > 0}">
							<c:forEach items="${listVehicle}" var="vehicle">
								<tr>
									<td>${vehicle.id}</td>
									<td>${vehicle.vehicleNo}</td>
									<td>${vehicle.branch}</td>
									<td>${vehicle.vehicleType}</td>
									<td>${vehicle.insuranceExpiryDate}</td>
									<td>${vehicle.lastServiceDate}</td>
									<td>${vehicle.serviceDueDate}</td>
									<td><a href="<c:url value="/editVehicle/${vehicle.id}"/>">Edit</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="8">No vehicles Found</td>
								
							</tr>
						</c:otherwise>
					</c:choose>

				</table>
			</div>

		</div>

	</div>
</body>
</html>