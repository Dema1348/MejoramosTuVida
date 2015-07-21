<%-- 
    Document   : ControllerPago
    Created on : 18-11-2014, 22:08:24
    Author     : EdsonAlexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.PagoService" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%!PagoService servicio = new PagoService(); Integer id; String mensaje;%>
<%
     id= Integer.parseInt(request.getParameter("Id"));
     mensaje=servicio.realizarPago(id);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado del pago</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">

    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Pagando <small>Su solicitud se esta procesando</small></h1>
            </div>
            <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='./controllerLogout.jsp'" >Salir</button>
            <ul class="nav nav-pills">
                <li role="presentation" ><a href="asistente.jsp">Horas Reservadas</a></li>
            </ul>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="jumbotron">
                        <h1><%=mensaje%></h1>
                    </div>
                </div>
            </div>   
        </div>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>