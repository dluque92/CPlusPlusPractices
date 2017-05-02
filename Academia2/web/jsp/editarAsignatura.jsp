<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.academia.common.Constantes" %>

<%@ include file="cabecera.jsp" %>

	<table class="cablist"> 
	<tr ><th>EDITAR ASIGNATURA</th></tr>
	</table> 
<span id="errores"></span>

		<FORM name="asignatura" ACTION="<%= Constantes.URLSERVIDOR %>" METHOD="post" onsubmit="return validacionAsignatura()">
		<INPUT TYPE="hidden" NAME="tabla" VALUE="asignaturas">
		<INPUT TYPE="hidden" NAME="accion" VALUE="editarenbd">
		
		<INPUT TYPE="hidden" NAME="idasignatura" VALUE="${asignatura.idAsignatura}">
		<table border="0">			
			<tr>
				<td>Nombre</td>
				<td><input type= "text" name= "nombre" Value= "${asignatura.nombre}"></td>
		
			</tr>
		
			<tr>
				<td>Horario</td>
				<td><input type= "text" name= "horario" Value= "${asignatura.horario}"></td>
			</tr>
		
			<tr>
				<td>Aula</td>
				<td><input type= "text" name= "aula" Value= "${asignatura.aula}"></td>
			</tr>
			
			<tr>
			<td></td>
			<td><input name= "editar" id= "editar" type= "submit" value= "Editar Asignatura"></td>
			</tr>	
			
		</table>
		</FORM>		

<%@ include file="pie.jsp" %>
