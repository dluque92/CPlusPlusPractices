<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page import="com.academia.common.Constantes" %>

<%@ include file="cabecera.jsp" %>
	<table class="cablist"> 
	<tr ><th>LISTADO DE PROFESORES</th></tr>
	</table>

<table class="listado">
		<thead align="center">
			<tr>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>TELÉFONO</th>
				<th>EMAIL</th>
				<th>ASIGNATURA</th>
				<th>ACCIONES</th>
			</tr>
		</thead>
		<c:forEach items="${listadoProfesores}" var="profesor">
			<tr>
				<td align="center">${profesor.nombre}</td>
				<td align="center">${profesor.apellidos}</td>
				<td align="center">${profesor.telefono}</td>
				<td align="center">${profesor.email}</td>
				<td align="center">${profesor.asignatura.nombre}</td>
				<td align="center">
					<table class="vacio">
						<tr>
							<td>
								<form name="editar${profesor.idProfesor}" action="<%= Constantes.URLSERVIDOR %>" method="post"> 
				                	<a onclick="document.forms['editar${profesor.idProfesor}'].submit();"/>
				                		<img class="editar">
				                	</a>
				                <input type="hidden" name="tabla" value="profesores" />
				                <input type="hidden" name="accion" value="editar" />
				                <input type="hidden" name="idprofesor" value="${profesor.idProfesor}" />
				                </form>
	                		</td>
	                		<td>
				                <form name="borrar${profesor.idProfesor}" action="<%= Constantes.URLSERVIDOR %>" method="post" onsubmit="confirmar();"> 
				                	<a onclick="return confirmar('borrar${profesor.idProfesor}');"/>
				                		<img class="borrar">
				                	</a>
				                <input type="hidden" name="tabla" value="profesores" />
				                <input type="hidden" name="accion" value="borrar" />
				                <input type="hidden" name="idprofesor" value="${profesor.idProfesor}" />
				                </form>
				            </td>
				        </tr>
				    </table>
	                </td>
			</tr>
		</c:forEach>
	</table>

<%@ include file="pie.jsp" %>