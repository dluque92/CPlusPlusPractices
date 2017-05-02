<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.academia.common.Constantes" %>

<div>
	<ul class="nav">
		<li>
		<form name="inicio"
			action="<%= Constantes.URLSERVIDOR %>" method="post">
			<a onclick="document.forms['inicio'].submit();" /><img src="img/inicio.png"></a> 
			<input type="hidden" name="tabla" value="" />
		</form>
		</li>
		<li><a />Profesores</a>

			<ul>
				<li>
					<form name="listarprofesor"
						action="<%= Constantes.URLSERVIDOR %>" method="post">
						<a onclick="document.forms['listarprofesor'].submit();" />Listar
						Profesor</a> <input type="hidden" name="tabla" value="profesores" />
						<input type="hidden" name="accion" value="listar" />
					</form>
				</li>
				<li>
					<form name="addprofesor"
						action="<%= Constantes.URLSERVIDOR %>" method="post">
						<a onclick="document.forms['addprofesor'].submit();" />Añadir
						Profesor</a> <input type="hidden" name="tabla" value="profesores" />
						<input type="hidden" name="accion" value="addFormulario" />
					</form>
				</li>
			</ul></li>


		<li><a />Alumnos</a>

			<ul>
				<li>
					<form name="listaralumno"
						action="<%= Constantes.URLSERVIDOR %>" method="post">
						<a onclick="document.forms['listaralumno'].submit();" />Listar
						Alumno</a> <input type="hidden" name="tabla" value="alumnos" /> <input
							type="hidden" name="accion" value="listar" />
					</form>
				</li>
				<li>
					<form name="addalumno"
						action="<%= Constantes.URLSERVIDOR %>" method="post">
						<a onclick="document.forms['addalumno'].submit();" />Añadir
						Alumno</a> <input type="hidden" name="tabla" value="alumnos" /> <input
							type="hidden" name="accion" value="addFormulario" />
					</form>
				</li>
			</ul></li>
		<li><a />Asignaturas</a>
			<ul>
				<li><form name="listarasignatura"
						action="<%= Constantes.URLSERVIDOR %>" method="post">
						<a onclick="document.forms['listarasignatura'].submit();" />Listar
						Asignatura</a> <input type="hidden" name="tabla" value="asignaturas" />
						<input type="hidden" name="accion" value="listar" />
					</form></li>
				<li><form name="addasignatura"
						action="<%= Constantes.URLSERVIDOR %>" method="post">
						<a onclick="document.forms['addasignatura'].submit();" />Añadir
						Asignatura</a> <input type="hidden" name="tabla" value="asignaturas" />
						<input type="hidden" name="accion" value="addFormulario" />
					</form></li>
</div>

<div class="lineamenu">
	<%@ include file="buscador.jsp"%>
</div>
