<%-- 
    Document   : registroClientes
    Created on : 17-11-2014, 04:02:27 PM
    Author     : cetecom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Cliente</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        
    </head>
    <body>
        <h1 class="text-center">Mejoramos tu vida, <small>desde tiempos inmemorables</small></h1>
        <form class="form-signin login" method="get" action="controllerAddCliente.jsp">
            <h3 class="form-signin-heading">Ingresa tus Datos</h3>
            <input type="text" class="form-control" name="rut"  placeholder="Rut" required autofocus>
            <input type="text" class="form-control" name="nombres"  placeholder="Nombres" required>
            <input type="text" class="form-control" name="apellidos"  placeholder="Apellidos" required>
            <input type="email" class="form-control" name="correo"  placeholder="Correo electronico" required>
            <input type="password" class="form-control" name="pass1"  placeholder="Password" required>
            <input type="password" class="form-control" name="pass2"  placeholder="Reingrese su password para confirmar" required>
            <input class="btn btn-lg btn-success btn-block" type="submit" value="Guardar">
            <a href="index.jsp" class="pull-left ">Inicio </a>
        </form>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
