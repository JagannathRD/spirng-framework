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
	<script type="text/javascript">
	function validateform(){
	var name=document.Form.fName.value;
	var password=document.Form.password.value;
	var cPassword=document.Form.cPassword.value;
	var email=document.Form.email.value;
	 var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	 
	 
	if(name==null||name==""&&name.length<=2){
		document.getElementById("n").innerHTML="Name cant't be balnk or less than 3 characters";
		return false;
	}
	else if(password==null||password==""){
		document.getElementById("p").innerHTML="password can't be null";
		
		return false;
	}
	else if(password!=cPassword){
		document.getElementById("cp").innerHTML="password not matching";
		
		return false;
	}
	else if(!email.match(reg)){
		document.getElementById("e").innerHTML="email is not in correct format";
		return false;
	}
	
}
</script>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">E-commerce</a> <a class="navbar-brand"
		href="Login.jsp">Login</a> 
	</nav>

	<div class="container">
		<form  name="Form" method="post" onsubmit="return validateform()"  >

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>First Name </label>
				</div>
				<div class="col-sm-6">
					<input title="First Name" type="text" class="form-control mt-3"
						placeholder="First Name"  name="fName" >
					<span id="n"></span>
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
					<span id="e"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Password</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" placeholder="Password" name="password" >
					<span id="p"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label>Confirm Password </label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3"
						placeholder="Confirm Password" name="cPassword" >
						<span id="cp"></span>
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