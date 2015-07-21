<%-- 
    Document   : ControllerDeleteReserva
    Created on : 19-11-2014, 12:50:38 PM
    Author     : edson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.ReservaHoraService" session="true"%>
<%@page import="com.app.model.Usuario" session="true"%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%!ReservaHoraService servicio = new ReservaHoraService();Integer id;String mensaje;Usuario usuario;%>
<%
    HttpSession sesion=request.getSession();
    id = Integer.parseInt(request.getParameter("Id"));
    usuario= (Usuario)sesion.getAttribute("usuario");
    DemoLogFile.info("El usuario "+ usuario.getRut()+"solicito la anulacion de una reserva");
    mensaje = servicio.deleteReserva(id);
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
                <h1>Reservas <small>estas son las citas que tiene programas </small></h1>
            </div>
            <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='controllerLogout.jsp'"  >Salir</button>
            <li role="presentation" ><a href="admin.jsp">Horas Disponibles</a></li>
            <li role="presentation" ><a href="adminReservas.jsp">Horas reservadas</a></li>
            <li role="presentation"><a href="adminPagoFecha.jsp">Pagos especialistas por fecha</a></li>
           <li role="presentation" ><a href="adminPagoFechaRango.jsp">Pagos especialistas por rango de fecha</a></li>
           <li role="presentation" ><a href="adminReservaEspecialista.jsp">Reservas programadas  por especialista  y fecha </a></li>
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

