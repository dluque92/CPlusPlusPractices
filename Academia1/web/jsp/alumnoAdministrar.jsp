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
<!-- Empezar a compiar el contenido siguiente: -->
<link href="http://localhost:8080/Academia1/css/menu.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Academia 1</title>

<script>
	function asignaturalistar() {
		document.asignaturalistar.submit()
	}
	function asignaturabuscar() {
		document.asignaturabuscar.submit()
	}
	function asignaturaadministrar() {
		document.asignaturaadministrar.submit()
	}
	function profesorlistar() {
		document.profesorlistar.submit()
	}
	function profesorbuscar() {
		document.profesorbuscar.submit()
	}
	function profesoradministrar() {
		document.profesoradministrar.submit()
	}
	function alumnolistar() {
		document.alumnolistar.submit()
	}
	function alumnobuscar() {
		document.alumnobuscar.submit()
	}
	function alumnoadministrar() {
		document.alumnoadministrar.submit()
	}
</script>

</head>
<body>

	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="asignaturalistar">
		<input type="hidden" name="modo" value="1">
	</form>

	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="asignaturabuscar">
		
	</form>

	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="asignaturaadministrar">
		<input type="hidden" name="modo" value="9">
	</form>
	
	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="profesorlistar">
		<input type="hidden" name="modo" value="11">
	</form>
	
	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="profesorbuscar">
	</form>
	
	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="profesoradministrar">
		<input type="hidden" name="modo" value="19">
	</form>
	
	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="alumnolistar">
		<input type="hidden" name="modo" value="23">
	</form>
	
	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="alumnobuscar">
	</form>
	
	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="alumnoadministrar">
		<input type="hidden" name="modo" value="31">
	</form>
	
<div id="logo">
	<img id="imagen" alt="besoftware"
		src="http://localhost:8080/Academia1/img/cabecera.jpg">
</div>
	<div id="header">
		<ul id="menu">
			<li><a href="http://localhost:8080/Academia1/jsp/index.jsp">Inicio</a></li>
			<li><a href="#">Asignatura</a>
				<ul>

					<li><a href="javascript:asignaturalistar()">Listar</a></li>
					<li><a href="http://localhost:8080/Academia1/jsp/asignaturaBuscar.jsp">Buscar</a></li>
					<li><a href="javascript:asignaturaadministrar()">Administrar</a></li>
				</ul></li>
			<li><a href="#">Profesor</a>
				<ul>
					<li><a href="javascript:profesorlistar()">Listar</a></li>
					<li><a href="http://localhost:8080/Academia1/jsp/profesorBuscar.jsp">Buscar</a></li>
					<li><a href="javascript:profesoradministrar()">Administrar</a></li>
				</ul></li>
			<li><a href="#">Alumno</a>
				<ul>
					<li><a href="javascript:alumnolistar()">Listar</a></li>
					<li><a href="http://localhost:8080/Academia1/jsp/alumnoBuscar.jsp">Buscar</a></li>
					<li><a href="javascript:alumnoadministrar()">Administrar</a></li>
				</ul>
		</ul>
	</div>
<!-- Terminar a compiar el contenido  -->
	<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/Academia"></form>
	<!-- La tabla por la que se imprimirán las asignaturas  -->
	<table border=2 align="center">
		<tr>
			<th>idALUMNO</th>
			<th>NOMBRE</th>
			<th>APELLIDOS</th>
			<th>TELEFONO</th>
			<th>EMAIL</th>
			<th>EDITAR</th>
			<th>BORRAR</th>
		</tr>
		<!-- obtendra los datos para la tabla  -->
		<c:forEach items="${listaAlumno}" var="alumno">
			<tr>
				<td align="center"><c:out value="${alumno.idAlumno}" /></td>
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
	<form id="formBorrar" action="http://localhost:8080/Academia1/Academia"
		method="post">
		<input type="hidden" name="modo" value="28"> <input
			type="hidden" name="idAlumno" id="idAlumno1">
	</form>
	<form id="formEditar" action="http://localhost:8080/Academia1/Academia"
		method="post">
		<input type="hidden" name="modo" value="29"> <input
			type="hidden" name="idAlumno" id="idAlumno2">
	</form>

	<!--Empieza los campos de añadir asignaturas-->
	<br>
	<p align="center">Rellene el siguiente formulario para añadir un
		Alumno:</p>

	<form id="formAnyadir"
		action="http://localhost:8080/Academia1/Academia" method="post">
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
						name="modo" value="30"> <input type="submit" style='width: 100px' value="Añadir"></td>
				</tr>
			</thead>
		</table>
	</form>
</body>
</html>