<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.academia.common.Constantes" %>

<%@ include file="cabecera.jsp" %>

	<table class="cablist"> 
	<tr ><th>EDITAR ALUMNO</th></tr>
	</table> 
<span id="errores"></span>

<FORM name="alumno" ACTION="<%= Constantes.URLSERVIDOR %>" METHOD="post" onsubmit="return validacionAlumno()">
<INPUT TYPE="hidden" NAME="tabla" VALUE="alumnos">
<INPUT TYPE="hidden" NAME="accion" VALUE="editarenbd">

<INPUT TYPE="hidden" NAME="idalumno" VALUE="${alumno.idAlumno}">
<table border="0">			
	<tr>
		<td>Nombre</td>
		<td><input type= "text" name= "nombre" Value= "${alumno.nombre}"></td>

	</tr>
	<tr>
		<td>Apellido</td>
		<td><input type= "text" name= "apellidos" Value= "${alumno.apellidos}"></td>

	</tr>
	<tr>
		<td>Telefono</td>
		<td><input type= "text" name= "telefono" Value= "${alumno.telefono}"></td>

	</tr>
	<tr>
		<td>Email</td>
		<td><input type= "text" name= "email" Value= "${alumno.email}"></td>

	</tr>
	<tr>
   		<td>Asignaturas:</td>
   </tr>
   <tr>
   		<td colspan="2">
			<select name="asignaturas" multiple="multiple" style="width: 200px;">
				<c:forEach items="${asignaturas}" var="valor">
					<c:if test="${valor.idAsignatura != 0}">
						<c:set var="encontrado" value="no" />
						<c:forEach items="${relacion}" var="valorrelacion">
							<c:if test="${valor.idAsignatura == valorrelacion.idAsignatura}">
							  <c:set var="encontrado" value="si" />
							  <option value="${valor.idAsignatura}" SELECTED>${valor.nombre}</option>	
							</c:if>
						</c:forEach>
						<c:if test="${encontrado == 'no'}">
							<option value="${valor.idAsignatura}">${valor.nombre}</option>	
						</c:if>
					</c:if>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
   		<td colspan="2"><br>Elija tantas asignaturas como quieras <br>(manteniendo presionada la tecla "Ctrl")<br></td>
   </tr>
	
	<tr>
	<td></td>
	<td><input name= "editar" id= "editar" type= "submit" value= "Editar Alumno"></td>
	</tr>	
	
</table>

<%@ include file="pie.jsp" %>
