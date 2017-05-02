<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function enviar() {
		document.getElementById('formulario').submit();
	}
</script>

<body>
	<form id="formulario" method="post" action="Servlet">
		<table>
			<tr>
				<td>Nombre</td>
				<td><input type="text" id="nombre" name="nombre"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="password" name="password"></td>
			</tr>

		</table>
		<br> <input type="button" onclick="enviar();" value="Enviar">


	</form>

</body>
</html>