<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.academia.common.Constantes" %>


	<%@ include file="cabecera.jsp" %>
	<table class="cablist"> 
	<tr ><th>LISTADO DE ASIGNATURAS</th></tr>
	</table> 
		<table class="listado">
			<thead align="center">
				<tr>
					<th>NOMBRE</th>
					<th>HORARIO</th>
					<th>AULA</th>
					<th>ACCIONES</th>
				</tr>
			</thead>
			<c:forEach items="${listadoAsignatura}" var="valor">
				<c:if test="${valor.idAsignatura != 0}">
					<tr>
						<td align="center"><c:out value="${valor.nombre}" /></td>
						<td align="center"><c:out value="${valor.horario}" /></td>
						<td align="center"><c:out value="${valor.aula}" /></td>
						<td align="center">
						<table class="vacio">
							<tr>
								<td>
									<form name="editar${valor.idAsignatura}" action="<%= Constantes.URLSERVIDOR %>" method="post"> 
					                	<a onclick="document.forms['editar${valor.idAsignatura}'].submit();"/>
					                		<img class="editar">
					                	</a>
					                <input type="hidden" name="tabla" value="asignaturas" />
					                <input type="hidden" name="accion" value="editar" />
					                <input type="hidden" name="idasignatura" value="${valor.idAsignatura}" />
					                </form>
					            </td>
					            <td>
					                <form name="borrar${valor.idAsignatura}" action="<%= Constantes.URLSERVIDOR %>" method="post"> 
					                	<a onclick="return confirmar('borrar${valor.idAsignatura}');"/>
					                		<img class="borrar">
					                	</a>
					                <input type="hidden" name="tabla" value="asignaturas" />
					                <input type="hidden" name="accion" value="borrar" />
					                <input type="hidden" name="idasignatura" value="${valor.idAsignatura}" />
					                </form>
					            </td>
					        </tr>
					    </table>
		                </td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	
	<%@ include file="pie.jsp" %>
	