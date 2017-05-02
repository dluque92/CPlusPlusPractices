<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- Empezar a compiar el contenido siguiente: -->
<jsp:include page="hibernateMenu.jsp" />
<!-- Terminar a compiar el contenido  -->

<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate">
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