<%@page import="com.academia.bd.Alumno"%>
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
		Alumno alumno = (Alumno) request
				.getAttribute("alumno");
	%>
	<table border="2">
		<thead align="center">
			<tr>
				<th>idALUMNO</th>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>TELEFONO</th>
				<th>EMAIL</th>
			</tr>
		</thead>
		<tr>
			<td align="center"><%=alumno.getIdAlumno()%></td>
			<td align="center"><%=alumno.getNombre()%></td>
			<td align="center"><%=alumno.getApellidos()%></td>
			<td align="center"><%=alumno.getTelefono()%></td>
			<td align="center"><%=alumno.getEmail()%></td>
		</tr>
	</table>
</body>
</html>