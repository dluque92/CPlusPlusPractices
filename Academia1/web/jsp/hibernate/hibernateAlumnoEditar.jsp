<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- importar para que el c:foreach funcione -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.academia.hibernate.Alumno" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function sendEditar(id) {
		document.getElementById('idAlumno2').value = id;
		document.getElementById('formEditar').submit();
	}
</script>

<!-- Empezar a compiar el contenido siguiente: -->
<jsp:include page="hibernateMenu.jsp" />
<!-- Terminar a compiar el contenido  -->
	<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate">
	<!-- La tabla por la que se imprimirán los alumnos  -->
	<table border=2 align="center">
		<tr>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>TELEFONO</th>
			<th>EMAIL</th>
			
		</tr>
		<!-- obtendra los datos para la tabla  -->
		<c:forEach items="${listaAlumno}" var="alumno">
			<tr>
				<td align="center"><c:out value="${alumno.nombre}" /></td>
				<td align="center"><c:out value="${alumno.apellidos}" /></td>
				<td align="center"><c:out value="${alumno.telefono}" /></td>
				<td align="center"><c:out value="${alumno.email}" /></td>
				
			</tr>
		</c:forEach>
	</table>
	<br>
	<%
	Alumno a = (Alumno)request.getAttribute("alumnoEditar");
	
	%>
	
	<table border=0 align="center">
		<tr>
			<th></th>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>TELEFONO</th>
			<th>EMAIL</th>
			
		</tr>
		<tr>
			<td align="center"><input type="hidden" style="text-align:center" readonly="readonly" name="idAlumno" id="idAlumnoEA" value="<%=a.getIdAlumno()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="nombre" id="nombreEA" value="<%=a.getNombre()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="apellidos" id="apellidosEA" value="<%=a.getApellidos()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="telefono" id="telefonoEA" value="<%=a.getTelefono()%>"></td>
			<td align="center"><input type="text" style="text-align:center" name="email" id="emailEA" value="<%=a.getEmail()%>"></td>
			
			
		</tr>
		<tr>
			<td align="center" colspan="4">
					<input type="hidden" name="modo" value="32"> <input
						type="submit" value="Guardar cambios"></td>
				<!-- El colspan significa los numeros de columnas a las que queremos que se alinee en este caso el boton -->
				<!-- style='width: 208px'
				onclick="sendEditar('<c:out value="${a.idAsignatura}" />')"> -->
		</tr>
	</table>
	</form>




</body>
</html>