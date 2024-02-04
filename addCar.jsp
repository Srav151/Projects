<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="add.css">
</head>
<body>
<div   class="form-container" >
<form action="addCar"  method="post" >
<input placeholder="Enter Car Id" type="number" name="carId" > <br>
<input placeholder="Enter Car Model" type="text" name="carModel" > <br>
<input placeholder="Enter Car Brand" type="text" name="carBrand" > <br>
<input placeholder="Enter Car Price" type="number" name="carPrice" > <br>
<input placeholder="ADD" type="submit"  class="submitbutton">
</form>
</div>
</body>
</html>