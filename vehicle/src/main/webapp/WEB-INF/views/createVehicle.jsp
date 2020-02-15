<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form> </form>
<div class="conatiner">
<h1>VEHICLE REGISTRATION</h1>


<input type="text" placeholder="Enter Employee Id" class="form-control"
							name=employeeId maxlength="6">
							




<label for="vehicleNo"><b>Vehicle Number</b></label>

<input type="text" placeholder="Enter Vehicle Number " name=vehicle  maxlength="5">



<label for="branch"><b>Branch</b></label>
<input type="text" placeholder="Enter Branch" name=Branch  maxlength="15">


<tr>
<td><label for="vehicleType"><b>Vehicle Type</b></td></label>
<td><input type="text" placeholder="Enter Vehicle Type" name=Vehicle  maxlength="10">></td></tr>

<tr>
<td><label for="insuranceExpiryDate"><b>InsuranceExpiryDate</b></label></td>
<td><input type="text" placeholder="Enter InsuranceExpiryDate" name=insuranceExpiryDate  maxlength="10">></td></tr>

<tr>
<td><label for="lastServiceDate"><b>lastServiceDate</b></label></td>
<td><input type="text" placeholder="Enter lastServiceDate" name=lastServiceDate  maxlength="10">></td></tr>

<tr>
<td>
<input type="button" value="submit">
<input type="button" value="clear">
</td>
</tr>
</body>
</html>