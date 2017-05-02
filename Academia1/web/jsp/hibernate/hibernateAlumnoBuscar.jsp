<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="hibernateMenu.jsp" />


<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate">
		<p>Busqueda de datos</p><br>	
		<select name="modo" data-native-menu="false">
			<option value="24" id='buscar'>Busqueda por ID Alumno </option>
			<option value="25">Busqueda por Nombre de Alumno</option>
			<option value="26">Busqueda por Apellidos</option>
			<option value="27">Busqueda por Telefono</option>
			<option value="33">Busqueda por Email</option>
		</select>		
		<input type="text" name="busqueda"">		
		<input type="submit" value="Buscar" data-role="button">
</form>
</div>
</body>
</html>