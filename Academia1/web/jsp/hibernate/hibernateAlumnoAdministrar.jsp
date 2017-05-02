<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- importar para que el c:foreach funcione -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function sendBorrar(id) {
		document.getElementById('idAlumno1').value = id;
		document.getElementById('formBorrar').submit();
	}
	function sendEditar(id) {
		document.getElementById('idAlumno2').value = id;
		document.getElementById('formEditar').submit();
	}
</script>
<head>


<jsp:include page="hibernateMenu.jsp" />
</head>
<body>

	
<!-- Terminar a compiar el contenido  -->
	<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate"></form>
	<!-- La tabla por la que se imprimirán las asignaturas  -->
	<table border=0 align="center">
		<tr>
			<!-- <th>idALUMNO</th> -->
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>TELEFONO</th>
			<th>EMAIL</th>
<!-- 			<th>EDITAR</th>
			<th>BORRAR</th> -->
		</tr>
		<!-- obtendra los datos para la tabla  -->
		<c:forEach items="${listaAlumno}" var="alumno">
			<tr>
				<%-- <td align="center"><c:out value="${alumno.idAlumno}" /></td> --%>
				<td align="center"><c:out value="${alumno.nombre}" /></td>
				<td align="center"><c:out value="${alumno.apellidos}" /></td>
				<td align="center"><c:out value="${alumno.telefono}" /></td>
				<td align="center"><c:out value="${alumno.email}" /></td>
				<td><input type="button" style='width: 75px' name="modo" value="Editar"
					onclick="sendEditar('<c:out value="${alumno.idAlumno}" />')">
				</td>
				<td><input type="button" style='width: 75px' name="modo" value="Borrar"
					onclick="sendBorrar('<c:out value="${alumno.idAlumno}" />')">
				</td>
			</tr>
		</c:forEach>
	</table>
	<form id="formBorrar" action="http://localhost:8080/Academia1/AcademiaHibernate"
		method="post">
		<input type="hidden" name="modo" value="28"> <input
			type="hidden" name="idAlumno" id="idAlumno1">
	</form>
	<form id="formEditar" action="http://localhost:8080/Academia1/AcademiaHibernate"
		method="post">
		<input type="hidden" name="modo" value="29"> <input
			type="hidden" name="idAlumno" id="idAlumno2">
	</form>

	<!--Empieza los campos de añadir asignaturas-->
	<br>
	<p align="center">Rellene el siguiente formulario para añadir un
		Alumno:</p>

	<form id="formAnyadir"
		action="http://localhost:8080/Academia1/AcademiaHibernate" method="post">
		<table border="0" align="center">
			<thead align="center">
				<tr>
					<th>NOMBRE</th>
					<th>APELLIDOS</th>
					<th>TELEFONO</th>
					<th>EMAIL</th>
				</tr>
				<tr>
					<td><input type="text" name="nombre" id="nombreAl"></td>
					<td><input type="text" name="apellidos" id="apellidosAl"></td>
					<td><input type="text" name="telefono" id="telefonoAl"></td>
					<td><input type="text" name="email" id="emailAl"></td>
					
				</tr>
				<tr>
					<!--Ahora se añade el boton-->
					<td align="center" colspan="4"><input type="hidden"
						name="modo" value="30"> <input type="submit" value="Añadir"></td>
				</tr>
			</thead>
		</table>
	</form>
</div>	
</body>
</html>