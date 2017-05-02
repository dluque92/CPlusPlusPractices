<%@page import="com.academia.bd.Asignatura"%>
<%@page import="com.academia.servlet.AcademiaHibernate"%>
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
		Asignatura asignatura = (Asignatura) request
				.getAttribute("asignatura");
	%>
	<table border="2">
		<thead align="center">
			<tr>
				<th>idASIGNATURA</th>
				<th>NOMBRE</th>
				<th>HORARIO</th>
				<th>CLASE</th>

			</tr>
		</thead>
		<tr>
			<td align="center"><%=asignatura.getIdAsignatura()%></td>
			<td align="center"><%=asignatura.getNombre()%></td>
			<td align="center"><%=asignatura.getHorario()%></td>
			<td align="center"><%=asignatura.getAula()%></td>

		</tr>
	</table>


</body>
</html>