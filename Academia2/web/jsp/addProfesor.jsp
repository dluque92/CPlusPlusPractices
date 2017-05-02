<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.academia.common.Constantes" %>

<%@ include file="cabecera.jsp" %>

	<table class="cablist"> 
	<tr ><th>AÑADIR PROFESOR</th></tr>
	</table> 
<span id="errores"></span>
<table >
<FORM name="profesor" ACTION="<%= Constantes.URLSERVIDOR %>" METHOD="post" onsubmit="return validacionProfesor()"> 
<INPUT TYPE="hidden" NAME="tabla" VALUE="profesores">
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
   	  <td>Asignatura:</td>
   </tr>
   <tr>
   		<td>
   			<c:forEach items="${asignaturas}" var="valor">
   				<c:if test="${valor.idAsignatura != 0}">
   					<input type="radio" name="idasignatura" value="${valor.idAsignatura}">${valor.nombre}
					<br>
				</c:if>
			</c:forEach>
		</td>
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