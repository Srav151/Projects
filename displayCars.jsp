<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.ty.carmanagementsystem.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="display.css">
<style type="text/css">
a{
color: Yellow;
}
</style>
</head>

<body>
<h1> My Cars List</h1>
	<%
	List<Car> list = (List) request.getAttribute("carsList");
	%>
	<table border="2px">

		<tr  >
			<th>CAR ID</th>
			<th>CAR MODEL</th>
			<th>CAR Brand</th>
			<th>CAR PRICE</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>


<%

 for(Car cars:list){

%>
<tr>
<td><%= cars.getCarId() %> </td>
<td><%= cars.getCarModel() %> </td>
<td><%= cars.getCarBrand() %> </td>
<td><%= cars.getCarPrice()  %> </td>
<td><a href="UpdateCar?carId=<%=cars.getCarId()%>">Update</a></td>
<td><a href="DeleteCar?carId=<%=cars.getCarId()%>">Delete</a></td>
</tr>

<%} %>
   	</table>

</body>
</html>