<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.academia.common.Constantes" %>

<%@ include file="cabecera.jsp" %>

	<table class="cablist"> 
	<tr ><th>EDITAR PROFESOR</th></tr>
	</table> 
<span id="errores"></span>

		<FORM name="profesor" ACTION="<%= Constantes.URLSERVIDOR %>" METHOD="post" onsubmit="return validacionProfesor()">
		<INPUT TYPE="hidden" NAME="tabla" VALUE="profesores">
		<INPUT TYPE="hidden" NAME="accion" VALUE="editarenbd">
		
		<INPUT TYPE="hidden" NAME="idprofesor" VALUE="${profesor.idProfesor}">
		<table>			
			<tr>
				<td>Nombre</td>
				<td><input type= "text" name= "nombre" Value= "${profesor.nombre}"></td>
		
			</tr>
			<tr>
				<td>Apellido</td>
				<td><input type= "text" name= "apellidos" Value= "${profesor.apellidos}"></td>
		
			</tr>
			<tr>
				<td>Telefono</td>
				<td><input type= "text" name= "telefono" Value= "${profesor.telefono}"></td>
		
			</tr>
			<tr>
				<td>Email</td>
				<td><input type= "text" name= "email" Value= "${profesor.email}"></td>
		
			</tr>
			<tr>
		   	  <td>Asignatura:</td>
		   </tr>
		   <tr>
		   		<td>
		   			<c:forEach items="${asignaturas}" var="valor">
		   				<c:if test="${valor.idAsignatura != 0}">
			   				<c:if test="${valor.idAsignatura == profesor.idAsignatura}">
							   <input type="radio" name="idasignatura" value="${valor.idAsignatura}" checked>${valor.nombre}
							</c:if>
			   				<c:if test="${valor.idAsignatura != profesor.idAsignatura}">
							   <input type="radio" name="idasignatura" value="${valor.idAsignatura}">${valor.nombre}
							</c:if>
							<br>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		
			<td></td>
			<td><input name= "editar" id= "editar" type= "submit" value= "Editar Profesor"></td>
			</tr>	
			
		</table>
		</FORM>		

<%@ include file="pie.jsp" %>
