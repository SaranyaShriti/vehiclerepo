
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle List</title>
</head>
<body>
	<c:forEach items="${listVehicle}" var="vehicle">
		${vehicle.id}
			<%-- <td> <c:out value="${vehicle.vehicleNo}"/></td>  
        <td> <c:out value="${vehicle.branch}"/></td>  
        <td> <c:out value="${vehicle.vehicleType}"/></td>  
        <td> <c:out value="${vehicle.insuranceExpiryDate}"/></td>  
        <td> <c:out value="${vehicle.lastServiceDate}"/></td> --%>

	</c:forEach>

</body>
</html>