<%-- 
    Document   : index
    Created on : 17-11-2014, 02:39:35 PM
    Author     : cetecom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        
    </head>
    <body>
        <h1 class="text-center">Mejoramos tu vida, <small>desde tiempos inmemorables</small></h1>
        <form class="form-signin login" method="post" action="controllerLoginCliente.jsp">
            <h3 class="form-signin-heading">Bienvenido/a Cliente,</h3>
            <input type="text" class="form-control" name="rut"  placeholder="Rut" required autofocus>
            <input type="password" class="form-control" name="pass"  placeholder="Password" required>
            <input class="btn btn-lg btn-success btn-block" type="submit" value="Iniciar Sesion">
            <a href="loginUsuarios.jsp" class="pull-left ">Ingresar como usuario </a>
            <a href="registroClientes.jsp" class="pull-right ">Registrarse</a>
        </form>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
