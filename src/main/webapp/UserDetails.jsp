<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	
<title>User Details</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">E-Commerce</a> <a class="navbar-brand"
		href="spring-cm-page/Home.jsp">Home</a> </nav>
	
<div class="">
	<div class="container ">
	${list.fName}
		<form class="" action="/spring-cm-page/update"  method="post"  >
		<input type="hidden" value="${list.email}" name="email">
		First Name: <input type="text" value="${list.fName}" name="fName">
		Last Name: <input type="text" value="${list.lName}" name="lName">
		
		
	
			
			<button type="submit" class="btn btn-primary" >Save Changes</button>
			
			
						
		</form> 
	</div>
</div>

	<nav
		class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
	<a class="navbar-brand " href="#"><small>&copyCopyright
			good-old-days 2021</small></a> </nav>

</body>
</html>