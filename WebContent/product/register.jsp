<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP 'register.jsp' starting page</title>
</head>
<body>
	<center>
		<h1>Register Page</h1>
		<form action="registerHandler.jsp" method="post">
			User Name: <input type="text" name="username"/><br>
			Full Name: <input type="text" name="fullname"/><br>
			Password: <input type="password" name="password"/><br>
			Title: <input type="text" name="title"/><br>
			<input type="submit" value="Register">
		</form>
	</center>
</body>
</html>