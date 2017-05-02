<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

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
		action="http://localhost:8080/Academia1/Academia">
		Busqueda de datos<br>
		
		<select name="modo">
			<option value="2">Busqueda por ID </option>
			<option value="3">Busqueda por nombre de Asignatura</option>
			<option value="4">Busqueda por Horario</option>
			<option value="5">Busqueda por aula</option>
		</select>
		
		<input type="text" name="busqueda" >
		
		<input type="submit" value="Buscar">
	<!-- 	<input type="hidden" name="modo" value="2">
	<input type="hidden" name="idAsignatura" value="1">  -->
</form>



</body>
</html>