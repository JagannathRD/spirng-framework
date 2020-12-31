<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information</title>
</head>
<body>

<h2>Name:${dto.name}</h2>
<h2>Age:${dto.age}</h2>
<h2>Mobile:${dto.mobile}</h2>
<h2>Result:${dto.result}</h2>
<h2>Email:${dto.email}</h2>

<h2>State:${dto.state}</h2>
</body>
</html>