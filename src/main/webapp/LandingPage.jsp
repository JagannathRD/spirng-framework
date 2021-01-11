<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="Error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Commerce</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	

	
</head>
<body>
	<script type="text/javascript" src="validate.js">
	
</script>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">E-commerce</a> <a class="navbar-brand"
		href="Login.jsp">Login</a> 
	</nav>
<div class="text-danger" >${message}</div>
	<div class="container">
		<form action="landing.do" name="Form" method="post" onsubmit="return validateform()"  >

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>First Name </label>
				</div>
				<div class="col-sm-6">
					<input title="First Name" type="text" class="form-control mt-3"
						placeholder="First Name"  name="fName" >
					<span id="n" class="text-danger"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Last Name </label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3"
						placeholder="Last Name" name="lName">

				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Email</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" placeholder="Email" name="email" >
					<span id="e" class="text-danger"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Password</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" placeholder="Password" name="password" >
					<span id="p" class="text-danger"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Confirm Password </label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3"
						placeholder="Confirm Password" name="cPassword" >
						<span id="cp" class="text-danger"></span>
				</div>
			</div>

			<input type="submit" class="btn btn-primary" value="Register"/>
		</form>
	</div>
	
	<nav
		class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
	<a class="navbar-brand " href=""><small>&copyCopyright
			good-old-days 2021</small></a> 
	</nav>

	
</body>
</html>