<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<title>Covid Patient Info</title>
</head>
<body>

	<form action="covid.do" method="get">

		Name:<input type="text" class="form-control form-control-sm "
			placeholder="Name" name="name" ><br> Age:<input
			type="text" class="form-control form-control-sm" placeholder="Age"
			name="age"><br> Mobile Number:<input type="text"
			class="form-control form-control-sm" placeholder="Mobile"
			name="mobile"><br> Email:<input type="text"
			class="form-control form-control-sm" placeholder="Email" name="email"><br>
		Address:
		<textarea class="form-control" rows="3"></textarea>
		<br> Result Yes :<input type="checkbox" value="y" name="result" />
		No: <input type="checkbox" value="n" name="result" /> <br> State:<select
			name="state">
			<option>--Select--</option>
			<c:forEach items="${states}" var="s">
				<option>${s}</option>
			</c:forEach>
		</select><br> <input type="submit" value="Save">
	</form>


</body>
</html>