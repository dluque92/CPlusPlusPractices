<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- importar para que el c:foreach funcione -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="hibernateMenu.jsp" />
<!-- La tabla por la que se imprimirán los profesores  -->
<table border=0 align="center">
<tr>
				<th>idPROFESOR</th>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>TELEFONO</th>
				<th>EMAIL</th>
				<th>idASIGNATURA</th>
</tr>
<!-- obtendra los datos para la tabla  --> 
<c:forEach items="${listaProfesor}" var="profesor">
			<tr>
				<td align="center"><c:out value="${profesor.idProfesor}" /></td>
				<td align="center"><c:out value="${profesor.nombre}" /></td>
				<td align="center"><c:out value="${profesor.apellidos}" /></td>
				<td align="center"><c:out value="${profesor.telefono}" /></td>
				<td align="center"><c:out value="${profesor.email}" /></td>
				<td align="center"><c:out value="${profesor.asignatura.idAsignatura}" /></td>
			</tr>
		</c:forEach>
</table>
</body>
</html>