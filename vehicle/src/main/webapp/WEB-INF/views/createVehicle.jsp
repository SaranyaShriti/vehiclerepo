<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Add Vehicle</title>
<style>
.align-center {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<div class="align-center">
					<h4>VEHICLE REGISTRATION</h4>

				</div>
				<form action="/test/saveVehicle" method="POST">

					<div class="form-group">
						<label for="vehicleId"><b></b></label> <input
							type="hidden" class="form-control" name="id" value="${vehicle.id}">

					</div>
					<div class="form-group">
						<label for="vehicleNo"><b>VehicleNumber</b></label> <input
							type="text" class="form-control"
							placeholder="Enter VehicleNumber" name="vehicleNo"
							value="${vehicle.vehicleNo}">
					</div>
					<div class="form-group">
						<label for="branch"><b>Branch</b></label> <input type="text"
							class="form-control" placeholder="Enter Branch" name="branch"
							value="${vehicle.branch}">
					</div>
					<div class="form-group">
						<label for="vehicleType"><b>Vehicle Type</b> </label> <input
							type="text" class="form-control" placeholder="Enter Vehicle Type"
							name="vehicleType" value="${vehicle.vehicleType}">
					</div>
					<div class="form-group">
						<label for="insuranceExpiryDate"><b>InsuranceExpiryDate</b></label>
						<input type="text" class="form-control"
							placeholder="Enter InsuranceExpiryDate"
							name="insuranceExpiryDate" value="${vehicle.insuranceExpiryDate}">
					</div>
					<div class="form-group">
						<label for="lastServiceDate"><b>LastServiceDate</b></label> <input
							type="text" class="form-control"
							placeholder="Enter lastServiceDate" name="lastServiceDate"
							value="${vehicle.lastServiceDate}">
					</div>
					<div class="form-group">
						<label for="ServiceDueDate"><b>ServiceDueDate</b></label> <input
							type="text" class="form-control"
							placeholder="Enter ServiceDueDate" name="serviceDueDate"
							value="${vehicle.serviceDueDate}">
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Submit">
					</div>


				</form>

			</div>
		</div>
	</div>
</body>
</html>