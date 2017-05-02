<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.academia.common.Constantes"%>

<script>
	function sendBuscar() {
		document.getElementById('clasesB').value = document.getElementById('Clases').selectedIndex;
		document.getElementById('camposB').value = document.getElementById('Campos').selectedIndex;
		document.getElementById('formBuscar').submit();
	}	
</script>


<table class="buscador">
	<tr>
		<td>Buscar&nbsp;&nbsp;</td>
		<th><select id="Clases" onchange="combocampos()">

				<option value="profesores">Profesores</option>
				<option value="asignaturas">Asignaturas</option>
				<option value="alumnos">Alumnos</option>
		</select></th>
		<th><select id="Campos">

		</select></th>


		<th>
			<form name="buscar" id="formBuscar"
				action="<%=Constantes.URLSERVIDOR%>" method="post" onsubmit="comprobart1(); sendBuscar();">
				<input type="hidden" name="tabla" value="buscar" size="20">
				
				<input type="text" name="T1" size="20" id="T1" value="${T1}"> 
				
				<input type="hidden" name="clasesB" id="clasesB" value=""> 
				<input type="hidden" name="camposB" id="camposB" value="">
			</form>
		</th>
		<th><img id="lupa"  onclick="comprobart1(); sendBuscar();">
		</th>

	</tr>
</table>

