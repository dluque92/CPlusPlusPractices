<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link href="http://localhost:8080/Academia1/css/menu.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Academia 1</title>



<body>
	<div id="logo">
		<img id="imagen" alt="besoftware"
			src="http://localhost:8080/Academia1/img/cabecera.jpg">
	</div>

	<div id="cuerpo">
		<p>Bienvenido a Besoftware</p>
	</div>

	<form action="http://localhost:8080/Academia1/Academia" method=post
		name="login">
		<table align="center">
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="user" /></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<input type="hidden" name="modo" value="0">
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="Entrar" /></td>

			</tr>
		</table>
	</form>
	<br>
	<div id="cuerpoerror">
	Error, la contraseña/usuario incorrecto
	</div>
</body>
</html>