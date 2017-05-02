<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.academia.common.Constantes" %>


<%@ include file="cabecera.jsp" %>
	<table class="cablist"> 
	<tr ><th>AÑADIR ALUMNO</th></tr>
	</table> 
<span id="errores"></span>
<table >
<FORM name="alumno" ACTION="<%= Constantes.URLSERVIDOR %>" METHOD="post" onsubmit="return validacionAlumno()"> 
<INPUT TYPE="hidden" NAME="tabla" VALUE="alumnos">
<INPUT TYPE="hidden" NAME="accion" VALUE="add">
   <tr>
      <td>Nombre</td>
      <td> <INPUT TYPE="text" NAME="nombre" SIZE=20></td>
   </tr>
   <tr>
      <td>Apellidos</td>
      <td><INPUT TYPE="text" NAME="apellidos" SIZE=20></td>
   </tr>
   <tr>
      <td>Teléfono</td>
      <td><INPUT TYPE="text" NAME="telefono" SIZE=20></td>
   </tr>
   <tr>
      <td>Email</td>
      <td><INPUT TYPE="text" NAME="email" SIZE=20></td>
   </tr>
   <tr>
   		<td>Asignaturas:</td>
   </tr>
   <tr>
   		<td colspan="2">
			<select name="asignaturas" multiple="multiple" style="width: 200px;">
				<c:forEach items="${asignaturas}" var="valor">
					<c:if test="${valor.idAsignatura != 0}">
   						<option value="${valor.idAsignatura}">${valor.nombre}</option>
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
      <td><INPUT TYPE="submit" CLASS="boton" VALUE="Añadir"></td>
   </tr>
</table>
</td>
   </tr>
   </table>
</FORM>      


<%@ include file="pie.jsp" %>