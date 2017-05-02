<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Empezar a compiar el contenido siguiente: -->
<jsp:include page="hibernateMenu.jsp" />
<!-- Terminar a compiar el contenido  -->
<!-- La tabla por la que se imprimirán los alumnos  -->
<table border=0 align="center">
<tr>
				<th>idALUMNO</th>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>TELEFONO</th>
				<th>EMAIL</th>
				
</tr>
<!-- obtendra los datos para la tabla  --> 
<c:forEach items="${listaAlumno}" var="alumno">
			<tr>
				<td align="center"><c:out value="${alumno.idAlumno}" /></td>
				<td align="center"><c:out value="${alumno.nombre}" /></td>
				<td align="center"><c:out value="${alumno.apellidos}" /></td>
				<td align="center"><c:out value="${alumno.telefono}" /></td>
				<td align="center"><c:out value="${alumno.email}" /></td>
			</tr>
		</c:forEach>
</table>
</body>
</html>