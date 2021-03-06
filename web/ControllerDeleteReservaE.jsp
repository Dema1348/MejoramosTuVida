<%-- 
    Document   : ControllerDeleteReserva
    Created on : 19-11-2014, 12:50:38 PM
    Author     : cetecom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.ReservaHoraService" session="true"%>
<%@page import="com.app.model.Usuario" session="true"%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%!ReservaHoraService servicio = new ReservaHoraService(); Integer id; String mensaje;Usuario usuario;%>
<%
     HttpSession sesion=request.getSession();
     id= Integer.parseInt(request.getParameter("Id"));
     usuario= (Usuario)sesion.getAttribute("usuario");
     DemoLogFile.info("El usuario "+ usuario.getRut()+"solicito la anulacion de una reserva");
     mensaje=servicio.deleteReserva(id);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado de eliminacion</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">

    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Eliminando <small>Su solicitud se esta procesando</small></h1>
            </div>
                 <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='controllerLogout.jsp'" >Salir</button>
        <ul class="nav nav-pills">
             <li role="presentation"><a href="especialista.jsp">Citas programadas</a></li>
            <li role="presentation" ><a href="especialistaTurno.jsp">Cambiar Horario</a></li>
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

