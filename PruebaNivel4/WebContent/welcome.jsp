<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	A través de la request:
	<br>
	<%
		String nombre = (String) request.getAttribute("nombreObtenido");
	%>
	<p>
		Bienvenido usuario
		<%=nombre%></p>
</body>
</html>