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

<title>Vehicle Reservation Login Page</title>
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
					<h4>LOGIN FORM</h4>
				</div>

				<form action="/test/vehicleList" commandName="getList">
					<div class="form-group">
						<label for="username">Username</label> <input type="text" name="username"
							class="form-control" id="username">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password" name="password"
							class="form-control" id="password">
					</div>
					<button type="submit" class="btn btn-primary align-center">Submit</button>
				</form>
			</div>
			<div class="col-3">
				<form action="/test/newUser">
					<div class="row">
						<div class="col-6"></div>
						<div class="col-6">
							<button type="submit" class="btn btn-primary">Register
								</button>
							<br>
							<p>${message}</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>