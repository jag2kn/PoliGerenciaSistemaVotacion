<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<jsp:useBean id="respuesta" class="java.util.HashMap" scope="request" />  
    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Ingreso al sistema</h3>
<%=respuesta.get("mensaje")%> <br>
<form method="POST" action="/login">
	Usuario: <input name="usuario" /><br>
	Clave: <input name="clave" /><br>
	<input type="submit" value="Ingresar" /><br>
</form>
	<a href="registro">Registrarse</a>

</body>
</html>