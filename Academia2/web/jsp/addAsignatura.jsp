<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.academia.common.Constantes" %>

<%@ include file="cabecera.jsp" %>

	<table class="cablist"> 
	<tr ><th>AÑADIR ASIGNATURA</th></tr>
	</table> 
<span id="errores"></span>
<table >
<FORM name="asignatura" ACTION="<%= Constantes.URLSERVIDOR %>" METHOD="post" onsubmit="return validacionAsignatura()"> 
<INPUT TYPE="hidden" NAME="tabla" VALUE="asignaturas">
<INPUT TYPE="hidden" NAME="accion" VALUE="add">
   <tr>
      <td>Nombre</td>
      <td> <INPUT TYPE="text" NAME="nombre" SIZE=20 MAXLENGTH=20></td>
   </tr>
   <tr>
      <td>Horario</td>
      <td><INPUT TYPE="text" NAME="horario" SIZE=20 MAXLENGTH=20></td>
   </tr>
   <tr>
      <td>Aula</td>
      <td><INPUT TYPE="text" NAME="aula" SIZE=20 MAXLENGTH=20></td>
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