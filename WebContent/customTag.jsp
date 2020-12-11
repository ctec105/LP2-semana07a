<!-- Referenciamos a nuestro taglib libreria.tld-->
<%@ taglib prefix="ct" uri="http://milibreria.aprenderjugando.com/jsp/ctag/mio"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<h2>
		<font color="orange">Custom Tags - Etiquetas Personalizadas (Taglibs)</font>
	</h2>
	
	<form>
		<table>
			<tr>
				<td class="etiqueta">Tag1 - Tag sin atributos ni cuerpo: </td>
				<td class="control">
					<!-- Aquí ponemos nuestro tag creado -->
					<ct:tag1/>
				</td>
			</tr>
			<tr>
				<td class="etiqueta">Tag2 - Tag con atributos y cuerpo: </td>
				<td class="control">
					<ct:tag2 veces="4">Hola Mundo!<br></ct:tag2>
				</td>
			</tr>
			<tr>
				<td class="etiqueta">Tag3 - Tag con atributos sin cuerpo: </td>
				<td class="control">
					<ct:tag3 tama="4" texto="Hola mundo" color="green"/>
				</td>
			</tr>
			<tr>
				<td class="etiqueta">Tag4 - Tag sin atributos ni cuerpo: </td>
				<td class="control">
					<ct:tag4/>
				</td>
			</tr>
			
			
		</table>
	</form>

</body>
</html>