<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form method="post" id="formulario"
		action="http://localhost:8080/PruebaNivel4/Servlet">
		Introduce tu nombre:&nbsp;<input type="text" name="nombre" id="nombre"><br>
		<input type="submit" value="Enviar"> <input type="hidden"
			name="modo" value="2">

	</form>

</body>
</html>