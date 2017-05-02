<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="hibernateMenu.jsp" />
<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate">
		Busqueda de datos<br>	
		<select name="modo" class="botones">
			<option value="12">Busqueda por ID Profesor </option>
			<option value="13">Busqueda por Nombre de Profesor</option>
			<option value="14">Busqueda por Apellidos</option>
			<option value="15">Busqueda por Telefono</option>
			<option value="21">Busqueda por Email</option>
			<option value="22">Busqueda por ID Asignatura </option>
		</select>		
		<input type="text" name="busqueda" >		
		<input type="submit" value="Buscar">
</form>
</body>
</html>