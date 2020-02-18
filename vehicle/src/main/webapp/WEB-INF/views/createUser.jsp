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
<title>User Registration Form</title>
<style>
.align-center {
	text-align: center;
}
.error{
  color:red
  }  

</style>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
			<div class="align-center">
			<h4>USER REGISTRATION</h4>
			</div>
				<form action="/test/saveUser" method="POST" name="user">

					<div class="form-group">
						<label for="employeeId"><b>EmployeeId</b></label> <input type="text"
							class="form-control" name="employeeId">
					</div>
					<div class="form-group">
						<label for="firstName"><b>FirstName</b></label> <input type="text"
							class="form-control" name="firstName"
							>
					</div>
					<div class="form-group">
						<label for="lastName"><b>LastName</b></label> <input  type="text"
							 class="form-control" name="lastName"  >
					</div>
					<div class="form-group">
						<label for="age"><b>Age</b></label> <input type="number"
							class="form-control" name="age"/>
					</div>
					<div class="form-group">
						<label for="gender"><b>Gender</b></label> <select
							class="form-control" name="gender" >
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select>
					</div>
					<div class="form-group">
						<label for="contactNumber"><b>contactNumber</b></label> <input type="number"
							class="form-control" name="contactNumber" maxlength="10" >
					</div>
					<div class="form-group">
						<label for="email"><b>Email</b></label> <input type="email"
							class="form-control" name="email" >
					</div>
					<div class="form-group">
						<label for="password"><b>Password</b></label> <input type="password"
							 name="password"
							class="form-control" maxlength="15" >
					</div>
					<div class="form-group">
						<label for="branch"><b>Branch</b></label> <input type="text"
							class="form-control" name="branch">
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-6">
								<input type="submit" class="btn btn-primary" value="submit">
							</div>
							<div class="col-6">
								<input type="reset" class="btn btn-primary" value="Reset">
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>