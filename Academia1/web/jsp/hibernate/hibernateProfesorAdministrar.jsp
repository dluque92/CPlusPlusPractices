<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- importar para que el c:foreach funcione -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function sendBorrar(id) {
		document.getElementById('idProfesor1').value = id;
		document.getElementById('formBorrar').submit();
	}
	function sendEditar(id) {
		document.getElementById('idProfesor2').value = id;
		document.getElementById('formEditar').submit();
	}
</script>
<jsp:include page="hibernateMenu.jsp" />
	<!-- Terminar a compiar el contenido  -->
	<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate"></form>
	<!-- La tabla por la que se imprimirán las asignaturas  -->
	<table border=0 align="center">
		<tr>
		<!-- 	<th>idPROFESOR</th> -->
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>TELEFONO</th>
			<th>EMAIL</th>
			<th>idASIG</th>
<!-- 			<th>EDITAR</th>
			<th>BORRAR</th> -->
		</tr>
		<!-- obtendra los datos para la tabla  -->
		<c:forEach items="${listaProfesor}" var="profesor">
			<tr>
				<%-- <td align="center"><c:out value="${profesor.idProfesor}" /></td> --%>
				<td align="center"><c:out value="${profesor.nombre}" /></td>
				<td align="center"><c:out value="${profesor.apellidos}" /></td>
				<td align="center"><c:out value="${profesor.telefono}" /></td>
				<td align="center"><c:out value="${profesor.email}" /></td>
				<td align="center"><c:out value="${profesor.asignatura.idAsignatura}" /></td>
				<td><input type="button" style='width: 75px' name="modo" value="Editar"
					onclick="sendEditar('<c:out value="${profesor.idProfesor}" />')">
				</td>
				<td><input type="button" style='width: 75px' name="modo" value="Borrar"
					onclick="sendBorrar('<c:out value="${profesor.idProfesor}" />')">
				</td>
			</tr>
		</c:forEach>
	</table>
	<form id="formBorrar" action="http://localhost:8080/Academia1/AcademiaHibernate"
		method="post">
		<input type="hidden" name="modo" value="16"> <input
			type="hidden" name="idProfesor" id="idProfesor1">
	</form>
	<form id="formEditar" action="http://localhost:8080/Academia1/AcademiaHibernate"
		method="post">
		<input type="hidden" name="modo" value="17"> <input
			type="hidden" name="idProfesor" id="idProfesor2">
	</form>

	<!--Empieza los campos de añadir asignaturas-->
	<br>
	<p align="center">Rellene el siguiente formulario para añadir un
		Profesor:</p>

	<form id="formAnyadir"
		action="http://localhost:8080/Academia1/AcademiaHibernate" method="post">
		<table border="0" align="center">
			<thead align="center">
				<tr>
					<th>NOMBRE</th>
					<th>APELLIDOS</th>
					<th>TELEFONO</th>
					<th>EMAIL</th>
					<th>idASIGNATURA</th>
				</tr>
				<tr>
					<td><input type="text" name="nombre" id="nombreP"></td>
					<td><input type="text" name="apellidos" id="apellidosP"></td>
					<td><input type="text" name="telefono" id="telefonoP"></td>
					<td><input type="text" name="email" id="emailP"></td>
					<td><input type="text" name="idAsignatura" id="idAsignaturaP"></td>
				</tr>
				<tr>
					<!--Ahora se añade el boton-->
					<td align="center" colspan="5"><input type="hidden"
						name="modo" value="18"> <input type="submit" value="Añadir"></td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>