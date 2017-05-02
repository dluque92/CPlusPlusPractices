<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="academia.modelo.Alumno" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
		academia.modelo.Alumno alumno = (academia.modelo.Alumno) request.getAttribute("alumno");
	%>
	<table border="2">
		<thead align="center">
			<tr>
				<th>idALUMNO</th>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>TELÉFONO</th>
				<th>EMAIL</th>
			</tr>
		</thead>
		<tr>
			<td align="center"><%=alumno.getId()%></td>
			<td align="center"><%=alumno.getNombre()%></td>
			<td align="center"><%=alumno.getApellidos()%></td>
			<td align="center"><%=alumno.getTelefono()%></td>
			<td align="center"><%=alumno.getEmail()%></td>
		</tr>
	</table>


</body>
</html>