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

<h3>Registro en el sistema de votacion</h3>
<%=respuesta.get("mensaje")%> <br>
<form method="POST" action="registro">
	Usuario: <input name="usuario" /><br>
	Clave: <input name="clave" /><br>
	<input type="submit" value="Registrarse" /><br>
</form>
	<a href="login">Ingresar</a>

</body>
</html>