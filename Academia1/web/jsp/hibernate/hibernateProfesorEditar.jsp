<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- importar para que el c:foreach funcione -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.academia.hibernate.Profesor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function sendEditar(id) {
		document.getElementById('idProfesor2').value = id;
		document.getElementById('formEditar').submit();
	}
</script>
<jsp:include page="hibernateMenu.jsp" />
	<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate">
	<!-- La tabla por la que se imprimirán los profesores  -->
	<table border=2 align="center">
		<tr>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>TELEFONO</th>
			<th>EMAIL</th>
			<th>idASIGNATURA</th>
		</tr>
		<!-- obtendra los datos para la tabla  -->
		<c:forEach items="${listaProfesor}" var="profesor">
			<tr>
				<td align="center"><c:out value="${profesor.nombre}" /></td>
				<td align="center"><c:out value="${profesor.apellidos}" /></td>
				<td align="center"><c:out value="${profesor.telefono}" /></td>
				<td align="center"><c:out value="${profesor.email}" /></td>
				<td align="center"><c:out value="${profesor.asignatura.idAsignatura}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<%
	Profesor p = (Profesor)request.getAttribute("profesorEditar");
	
	%>
	
	<table border=0 align="center">
		<tr>
			<th></th>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>TELEFONO</th>
			<th>EMAIL</th>
			<th>idASIGNATURA</th>
		</tr>
		<tr>
			<td align="center"><input type="hidden" style="text-align:center" readonly="readonly" name="idProfesor" id="idProfesorEP" value="<%=p.getIdProfesor()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="nombre" id="nombreEP" value="<%=p.getNombre()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="apellidos" id="apellidosEP" value="<%=p.getApellidos()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="telefono" id="telefonoEP" value="<%=p.getTelefono()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="email" id="emailEP" value="<%=p.getEmail()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="idAsignatura" id="idAsignaturaEP" value="<%=p.getAsignatura().getIdAsignatura()%>"></td>
			
		</tr>
		<tr>
			<td align="center" colspan="4">
					<input type="hidden" name="modo" value="20"> <input
						type="submit" value="Guardar cambios"></td>
				<!-- El colspan significa los numeros de columnas a las que queremos que se alinee en este caso el boton -->
				<!-- style='width: 208px'
				onclick="sendEditar('<c:out value="${a.idAsignatura}" />')"> -->
		</tr>
	</table>
	</form>




</body>
</html>