<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.academia.common.Constantes" %>
<%@ include file="cabecera.jsp" %>

	<table class="cablist"> 
	<tr ><th>LISTADO DE ALUMNOS</th></tr>
	</table>
	
<table class="listado">
		
		<thead align="center">
			
			<tr>
				<th>NOMBRE</th>
				<th>APELLIDOS</th>
				<th>TELÉFONO</th>
				<th>EMAIL</th>
				<th>ACCIONES</th>
			</tr>
		</thead>
		<c:forEach items="${listadoAlumnos}" var="alumno">
			<tr>
				<td align="center">${alumno.nombre}</td>
				<td align="center">${alumno.apellidos}</td>
				<td align="center">${alumno.telefono}</td>
				<td align="center">${alumno.email}</td>
				<td align="center">
				<table class="vacio">
						<tr>
							<td>
								<form name="editar${alumno.idAlumno}" action="<%= Constantes.URLSERVIDOR %>" method="post"> 
				                	<a onclick="document.forms['editar${alumno.idAlumno}'].submit();"/>
				                		<img class="editar">
				                	</a>
				                <input type="hidden" name="tabla" value="alumnos" />
				                <input type="hidden" name="accion" value="editar" />
				                <input type="hidden" name="idalumno" value="${alumno.idAlumno}" />
				                </form>
				            </td>
				            <td>
				                <form name="borrar${alumno.idAlumno}" action="<%= Constantes.URLSERVIDOR %>" method="post"> 
				                	<a onclick="return confirmar('borrar${alumno.idAlumno}');"/>
				                		<img class="borrar">
				                	</a>
				                <input type="hidden" name="tabla" value="alumnos" />
				                <input type="hidden" name="accion" value="borrar" />
				                <input type="hidden" name="idalumno" value="${alumno.idAlumno}" />
				                </form>
				            </td>
				        </tr>
				  </table>
                </td>
			</tr>
		</c:forEach>
	</table>

	<%@ include file="pie.jsp" %>