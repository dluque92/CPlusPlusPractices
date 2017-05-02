<html>
<script type="text/javascript">
	function validation() {
		if ((document.getElementById('nombre').value != "")
				&& (document.getElementById('password').value != "")) {
			document.getElementById('formulario').submit();

		} else {
			alert('Los campos no deben ir vacios');
		}

	}
</script>
<body>
	<form id="formulario" method="post"
		action="http://localhost:8080/PruebaServlet/ServletPrueba">

		Nombre: <input type="text" name="nombre" id="nombre"><br>
		Password: <input type="password" name="password" id="password"><br>
		<input type="button" value="Login" onclick="validation();">



	</form>

</body>

</html>