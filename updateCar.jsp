<%@page import="com.ty.carmanagementsystem.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="add.css">
</head>
<body>
<% Car car =(Car) request.getAttribute("car") ;%>

<form action="saveUpdateCar" method="post">
<input type="number" name="carId" value="<%= car.getCarId()%>" readonly="readonly"> <br>
<input  type="text" name="carModel"  value="<%= car.getCarModel()%>" > <br>
<input type="text" name="carBrand"   value="<%= car.getCarBrand()%>" > <br>
<input  type="number" name="carPrice"  value="<%= car.getCarPrice()%>" > <br>
<input type="submit"  class="submitbutton" value="update">



</form>
</body>
</html>