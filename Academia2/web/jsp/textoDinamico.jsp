<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.academia.common.Constantes" %>


<%@ include file="cabecera.jsp" %>

<table class="cablist"> 
	<tr>
		<th>${texto}</th>
	</tr>
</table>
<br><br>
<table>			
	<tr>
		<td>
		<FORM name="alumno" ACTION="<%= Constantes.URLSERVIDOR %>" METHOD="post">
			<INPUT TYPE="hidden" NAME="tabla" VALUE="${tabla}">
			<INPUT TYPE="hidden" NAME="accion" VALUE="${accion}">
			
			<input type = "submit" value = "Aceptar">
		</FORM>
		</td>
	</tr>
</table>


<%@ include file="pie.jsp" %>