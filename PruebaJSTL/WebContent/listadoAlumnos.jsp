<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<table border="2">
		<thead align="center">
			<tr>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>EDAD</th>
			</tr>
		</thead>
		<c:forEach items="${listaAlumnos}" var="alumno">
			<tr>
				<td align="center"><c:out value="${alumno.nombre}" /></td>
				<td align="center"><c:out value="${alumno.apellidos}" /></td>
				<td align="center"><c:out value="${alumno.edad}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>