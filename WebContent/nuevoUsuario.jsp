<!-- Referenciamos a nuestro taglib libreria.tld-->
<%@ taglib prefix="ct" uri="http://milibreria.aprenderjugando.com/jsp/ctag/mio"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
</head>
<!-- Utilizamos un scriplet para recuperar los datos que llegan en el request -->
<body>
	<table>
		<tr>
			<!-- Aqui va la cabecera -->
			<td colspan="2" align="center">
				<jsp:include page="cabecera.jsp" />
			</td>
		</tr>
		<tr>
			<!-- Aqui va el menu -->
			<td><jsp:include page="menu.jsp" /></td>
			<!-- Aqui va el cuerpo -->
			<td  class="control" >
				<form  method="post" action="usuario.do"  >
					<input  type="hidden" name="operacion" value="registra"  >
					<table>	
						<tr>
							<td class="control">Nombre:</td>
							<td><input type="text" name="nombre"></td>
						</tr>
						<tr>
							<td class="control">Direccion:</td>
							<td><input type="text" name="direccion"></td>
						</tr>
						<tr>
							<td class="control">Distrito:</td>
							<td>
								<!-- <select name="distrito" >
									<option value="01">Lima</option>
									<option value="02">Independencia</option>
									<option value="03">Jesus Maria</option>
									<option value="04">San Isidro</option>
								</select> -->
								<ct:cboDistritos nombre="distrito"></ct:cboDistritos>
							</td>
						</tr>
						<tr>
							<td class="control">Telefono:</td>
							<td><input type="text" name="telefono"></td>
						</tr>
						<tr>
							<td class="control">Fecha de Nacimiento:</td>
							<td><input type="text" name="fecnac"></td>
							<td>dd/MM/yyyy</td>
						</tr>
						<tr>
							<td class="control">Usuario:</td>
							<td><input type="text" name="usuario"></td>
						</tr>
						<tr>
							<td class="control">Clave:</td>
							<td><input type="text" name="clave"></td>
						</tr>
						<tr>
							<td><input type="submit" name="boton01" value="registrar" ></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<!-- Aqui va el pie -->
			<td colspan="2" align="center"><jsp:include page="pie.jsp" /></td>
		</tr>
	</table>
</body>
</html>