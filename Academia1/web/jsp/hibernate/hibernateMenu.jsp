<!-- Empezar a compiar el contenido siguiente: -->
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css" />
<link rel="stylesheet" href="css/jquery.mobile.structure-1.3.2.min.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jquery.mobile-1.3.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Academia 1</title>

</head>

	<body>
	<div data-role='page' data-theme='b' id='pagina'>
	
		<div id='contenido'>
	
		<form action="http://localhost:8080/Academia1/AcademiaHibernate"
			method=post id="asignaturalistar">
			<input type="hidden" name="modo" value="1">
		</form>
	
		<form action="http://localhost:8080/Academia1/AcademiaHibernate"
			method=post id="asignaturaadministrar">
			<input type="hidden" name="modo" value="9">
		</form>
	
		<form action="http://localhost:8080/Academia1/AcademiaHibernate"
			method=post id="profesorlistar">
			<input type="hidden" name="modo" value="11">
		</form>
	
	
		<form action="http://localhost:8080/Academia1/AcademiaHibernate"
			method=post id="profesoradministrar">
			<input type="hidden" name="modo" value="19">
		</form>
	
		<form action="http://localhost:8080/Academia1/AcademiaHibernate"
			method=post id="alumnolistar">
			<input type="hidden" name="modo" value="23">
		</form>
	
		<form action="http://localhost:8080/Academia1/AcademiaHibernate"
			method=post id="alumnoadministrar">
			<input type="hidden" name="modo" value="31">
		</form>
	
		<div id="logo">
			<img id="imagen" alt="besoftware"
				src="http://localhost:8080/Academia1/img/cabecera.jpg">
		</div>
		<div id="header" data-role='header' data-theme='a'>
			<ul id="menu">
				<li><a
					href="http://localhost:8080/Academia1/jsp/hibernate/hibernateIndex.jsp">Inicio</a></li>
				<li><a href="#">Asignatura</a>
					<ul>
	
						<li><a href="#"
							onclick="document.getElementById('asignaturalistar').submit();">Listar</a></li>
						<li><a
							href="http://localhost:8080/Academia1/jsp/hibernate/hibernateAsignaturaBuscar.jsp">Buscar</a></li>
						<li><a href="#"
							onclick="document.getElementById('asignaturaadministrar').submit();">Administrar</a></li>
					</ul></li>
				<li><a href="#">Profesor</a>
					<ul>
						<li><a href="#"
							onclick="document.getElementById('profesorlistar').submit();">Listar</a></li>
						<li><a
							href="http://localhost:8080/Academia1/jsp/hibernate/hibernateProfesorBuscar.jsp">Buscar</a></li>
						<li><a href="#"
							onclick="document.getElementById('profesoradministrar').submit();">Administrar</a></li>
					</ul></li>
				<li><a href="#">Alumno</a>
					<ul>
						<li><a href="#"
							onclick="document.getElementById('alumnolistar').submit();">Listar</a></li>
						<li><a
							href="http://localhost:8080/Academia1/jsp/hibernate/hibernateAlumnoBuscar.jsp">Buscar</a></li>
						<li><a href="#"
							onclick="document.getElementById('alumnoadministrar').submit();">Administrar</a></li>
					</ul>
			</ul>
		</div>
