<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.academia.common.Constantes" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class = "login2">
<form id="formulario" ACTION="<%= Constantes.URLSERVIDOR %>" method="post">
		<input type="hidden" name="tabla" value="desconectar">
<table>
	<tr>
		<td>Bienvenido ${UsuarioLogueado.user}</td>
	</tr>
	<tr>	
		<td>Último login:</td>
	</tr>
	<tr>
		<td><fmt:formatDate type="both" 
            dateStyle="short" timeStyle="short" 
            value="${UsuarioLogueado.fechaUltimoLogin}" /></td>
	</tr>
	<tr>	
		<td><input type="submit" value="Desconectar"></td>
	</tr>
</table>
</form>
</div>