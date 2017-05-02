<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alta Lista Usuarios</title>
	</head>

	<body>
	
		<form action="listarNombres" name="formularioAlta" method="post" >
			<p>Introduzca nombre:</p> <input type="text" name="nombre" id="nombre" > </br>
			<input type="submit" value="Dar de Alta" >
			<input type="reset" value="Limpiar">
		</form>
	
	</body>
	
</html>