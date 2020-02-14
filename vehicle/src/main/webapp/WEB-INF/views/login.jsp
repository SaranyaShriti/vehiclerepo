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
</head>
<body>
<div><h4>Login Form</h4>
<form action="/test/newUser">
<button type="submit" class="btn btn-primary" >Register User</button>
</form>
</div>
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form action="/vehicleList">
					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" id="username">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</body>
</html>