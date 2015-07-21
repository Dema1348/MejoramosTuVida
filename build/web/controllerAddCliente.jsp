<%-- 
    Document   : controllerAddCliente
    Created on : 17-11-2014, 04:20:11 PM
    Author     : edson
--%>
<%@page import="com.app.service.ClienteService" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%! ClienteService servicio = new ClienteService();String rut, pass1,pass2,nombres,apellidos,correo,resultado;Cliente cliente;%>
<%
    rut = request.getParameter("rut");
    nombres = request.getParameter("nombres");
    apellidos = request.getParameter("apellidos");
    correo = request.getParameter("correo");
    pass1 = request.getParameter("pass1");
    pass2 = request.getParameter("pass2");
    
    if(servicio.compararPass(pass1, pass2))
        resultado=(servicio.addCliente(new Cliente(rut, nombres, apellidos, correo, pass1)));
    else
        resultado="Por favor no ingrese  contraseñas diferentes";
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado registro</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>Su registro fue llevado a cabo</h1>
                <p><%=resultado %></p>
                <p><a class="btn btn-primary btn-lg"  href="index.jsp">Inicio</a></p>
            </div>
        </div>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
