<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="green">
<form action="login.do" method="post">
<h2><%=request.getAttribute("error") %></h2>
<pre>

User Name:<input type="text" name="user">
Password:<input type="text" name="password">
<button type="submit">Login</button>
</pre>
</form>

</body>
</html>