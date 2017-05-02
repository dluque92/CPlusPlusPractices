<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- importar para que el c:foreach funcione -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="hibernateMenu.jsp" />
<!-- La tabla por la que se imprimirán las asignaturas  -->
<table border=0 align="center">
<tr>
				<th>idASIG</th>
				<th>NOMBRE</th>
				<th>HORARIO</th>
				<th>AULA</th>
</tr>
<!-- obtendra los datos para la tabla  --> 
<c:forEach items="${listaAsignatura}" var="asignatura">
			<tr>
				<td align="center"><c:out value="${asignatura.idAsignatura}" /></td>
				<td align="center"><c:out value="${asignatura.nombre}" /></td>
				<td align="center"><c:out value="${asignatura.horario}" /></td>
				<td align="center"><c:out value="${asignatura.aula}" /></td>
				
			</tr>
		</c:forEach>



</table>
</body>
</html>