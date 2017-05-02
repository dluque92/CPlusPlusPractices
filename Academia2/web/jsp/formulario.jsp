<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.academia.common.Constantes" %>

<div class = "login">
<form id="formulario" ACTION="<%= Constantes.URLSERVIDOR %>" method="post">
		<input type="hidden" name="tabla" value="login">
<table>
	<tr>
	<td>Usuario</td>
	<td> <input type="text" name="nombre" id="nombre" size="10"></td>
	</tr>
	<tr>	
	<td>Password</td>
	<td><input type="password" name="password" id="password" size="10"></td>
	</tr>
	<tr>	
	<td><input type="submit" value="Login"></td>
	</tr>
</table>
</form>
</div>