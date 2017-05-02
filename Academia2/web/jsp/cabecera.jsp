<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/estilos.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/validacionformularios.js"></script>
	<script type="text/javascript" src="js/combocampos.js"></script>
</head>

<c:if test="${clasesB == null}">
	<c:set var="clasesB" value="0" />
</c:if>
<c:if test="${camposB == null}">
	<c:set var="camposB" value="0" />
</c:if>


<body onload="javascript:combocampos(${clasesB},${camposB})">

<c:if test="${UsuarioLogueado == null}">
	<%@ include file="formulario.jsp" %>
</c:if>
<c:if test="${UsuarioLogueado != null}">
	<%@ include file="desconectarUsuario.jsp" %>
</c:if>


<div align="center" class="cabecera">
	<img src="img/logo2.png">
</div>

<div class="cuerpo">
	
<%@ include file="menu.jsp" %>

<div class="divespacio"></div>

<div class="contenido">