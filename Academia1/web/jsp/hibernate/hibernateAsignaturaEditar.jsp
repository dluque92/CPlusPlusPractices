<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- importar para que el c:foreach funcione -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.academia.bd.Asignatura"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function sendEditar(id) {
		document.getElementById('idAsignatura2').value = id;
		document.getElementById('formEditar').submit();
	}
</script>

<jsp:include page="hibernateMenu.jsp" />
	<form method="post" id="formulario"
		action="http://localhost:8080/Academia1/AcademiaHibernate">
		<!-- La tabla por la que se imprimirán las asignaturas  -->
		<table border=2 align="center">
			<tr>
				<th>NOMBRE</th>
				<th>HORARIO</th>
				<th>AULA</th>
			</tr>
			<!-- obtendra los datos para la tabla  -->
			<c:forEach items="${listaAsignatura}" var="asignatura">
				<tr>
					<td align="center"><c:out value="${asignatura.nombre}" /></td>
					<td align="center"><c:out value="${asignatura.horario}" /></td>
					<td align="center"><c:out value="${asignatura.aula}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<%
		com.academia.hibernate.Asignatura a = (com.academia.hibernate.Asignatura) request
					.getAttribute("asignaturaEditar");
		%>

		<table border=0 align="center">
			<tr>
				<th></th>
				<th>NOMBRE</th>
				<th>HORARIO</th>
				<th>AULA</th>
			</tr>
			<tr>
				<td align="center"><input type="hidden"
					style="text-align: center" readonly="readonly" name="idAsignatura"
					id="idAsignaturaE" value="<%=a.getIdAsignatura()%>"></td>
				<td align="center"><input type="text"
					style="text-align: center" name="nombre" id="nombreE"
					value="<%=a.getNombre()%>"></td>
				<td align="center"><input type="text"
					style="text-align: center" name="horario" id="horarioE"
					value="<%=a.getHorario()%>"></td>
				<td align="center"><input type="text"
					style="text-align: center" name="aula" id="aulaE"
					value="<%=a.getAula()%>"></td>
				<!-- El id lo he puesto así pensando que luego hará falta para operar con el, la E es de editar -->
			</tr>
			<tr>
				<td align="center" colspan="4"><input type="hidden" name="modo"
					value="10"> <input type="submit" value="Guardar cambios"></td>
				<!-- El colspan significa los numeros de columnas a las que queremos que se alinee en este caso el boton -->
				<!-- style='width: 208px'
				onclick="sendEditar('<c:out value="${a.idAsignatura}" />')"> -->
			</tr>
		</table>
	</form>




</body>
</html>