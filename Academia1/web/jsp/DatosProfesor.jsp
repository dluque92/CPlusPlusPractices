<%@page import="com.academia.bd.Profesor"%>
<%@page import="com.academia.servlet.Academia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Profesor profesor = (Profesor) request
				.getAttribute("profesor");
	%>
	<table border="2">
		<thead align="center">
			<tr>
				<th>idPROFESOR</th>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>TELEFONO</th>
				<th>EMAIL</th>
				<th>idASIGNATURA</th>
			</tr>
		</thead>
		<tr>
			<td align="center"><%=profesor.getIdProfesor()%></td>
			<td align="center"><%=profesor.getNombre()%></td>
			<td align="center"><%=profesor.getApellidos()%></td>
			<td align="center"><%=profesor.getTelefono()%></td>
			<td align="center"><%=profesor.getEmail()%></td>
			<td align="center"><%=profesor.getIdAsignatura()%></td>
		</tr>
	</table>
</body>
</html>