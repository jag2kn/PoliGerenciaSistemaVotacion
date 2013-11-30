<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<jsp:useBean id="respuesta" class="java.util.HashMap" scope="request" />  
    
<html>
<body>
<h2>Sistema de Votaciones - Poligran</h2>
<%if (respuesta.get("tipoUsuario")==null || (respuesta!=null && respuesta.get("tipoUsuario").equals("anonimo"))) { %>
	<li><a href="login">Login</a></li>
	<li><a href="registro">Registrarse</a></li>
	<li><a href="verResultados">Ver resultados</li>
<% }else if (respuesta.get("tipoUsuario").equals("usuario")) { %>
	<li><a href="panel">Panel de votaciones</a></li>
	<li><a href="logout">Logout</a></li>
<% }else if (respuesta.get("tipoUsuario").equals("administrador")) { %>
	<h3>Administrador</h3>
	<li><a href="admin/usuarios">Administrar Usuarios</a></li>
	<li><a href="admin/elecciones">Administrar Elecciones</a></li>
	<li>Logout</li>
<% } else { %>
	Error: sin rol
	<li><a href="logout">Logout</a></li>
<% } %>




</ul>

</body>
</html>
