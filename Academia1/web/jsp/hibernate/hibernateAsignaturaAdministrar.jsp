<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- importar para que el c:foreach funcione -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function sendBorrar(id) {
		document.getElementById('idAsignatura1').value = id;
		document.getElementById('formBorrar').submit();
	}
	function sendEditar(id) {
		document.getElementById('idAsignatura2').value = id;
		document.getElementById('formEditar').submit();
	}
</script>
<jsp:include page="hibernateMenu.jsp" />
	<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate"></form>
	<!-- La tabla por la que se imprimirán las asignaturas  -->
	<table border=0 align="center">
		<tr>
			<th>idASIG</th>
			<th>NOMBRE</th>
			<th>HORARIO</th>
			<th>AULA</th>
<!-- 			<th>EDITAR</th>
			<th>BORRAR</th> -->
		</tr>
		<!-- obtendra los datos para la tabla  -->
		<c:forEach items="${listaAsignatura}" var="asignatura">
			<tr>
				<td align="center"><c:out value="${asignatura.idAsignatura}" /></td>
				<td align="center"><c:out value="${asignatura.nombre}" /></td>
				<td align="center"><c:out value="${asignatura.horario}" /></td>
				<td align="center"><c:out value="${asignatura.aula}" /></td>
				<td><input type="button" style='width: 75px' name="modo" value="Editar"
					onclick="sendEditar('<c:out value="${asignatura.idAsignatura}" />')">
				</td>
				<td><input type="button" style='width: 75px' name="modo" value="Borrar"
					onclick="sendBorrar('<c:out value="${asignatura.idAsignatura}" />')">
				</td>
			</tr>
		</c:forEach>
	</table>
	<form id="formBorrar" action="http://localhost:8080/Academia1/AcademiaHibernate"
		method="post">
		<input type="hidden" name="modo" value="6"> <input
			type="hidden" name="idAsignatura" id="idAsignatura1">
	</form>
	<form id="formEditar" action="http://localhost:8080/Academia1/AcademiaHibernate"
		method="post">
		<input type="hidden" name="modo" value="7"> <input
			type="hidden" name="idAsignatura" id="idAsignatura2">
	</form>

	<!--Empieza los campos de añadir asignaturas-->
	<br>
	<p align="center">Rellene el siguiente formulario para añadir una
		Asignatura:</p>

	<form id="formAnyadir"
		action="http://localhost:8080/Academia1/AcademiaHibernate" method="post">
		<table border="0" align="center">
			<thead align="center">
				<tr>
					<th>NOMBRE</th>
					<th>HORARIO</th>
					<th>AULA</th>
				</tr>
				<tr>
					<td><input type="text" name="nombre" id="nombreA"></td>
					<td><input type="text" name="horario" id="horarioA"></td>
					<td><input type="text" name="aula" id="aulaA"></td>
				</tr>
				<tr>
					<!--Ahora se añade el boton-->
					<td align="center" colspan="4"><input type="hidden"
						name="modo" value="8"> <input type="submit" value="Añadir"></td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>