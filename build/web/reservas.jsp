<%-- 
    Document   : reservas
    Created on : 18-11-2014, 2:58:29
    Author     : EdsonAlexander
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.ReservaHoraService" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%!ReservaHoraService servicio = new ReservaHoraService(); Cliente cliente; %>
<%
HttpSession sesion=request.getSession();    
cliente=(Cliente)sesion.getAttribute("cliente");
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
DemoLogFile.info("Se listaron la reservas total del sistema para el cliente "+cliente.getRut());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver reservas</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <div class="container">
        <div class="page-header">
            <h1>Reservas <small>estas son las citas que tiene programas </small></h1>
        </div>
             <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='./controllerLogout.jsp'" >Salir</button>
        <ul class="nav nav-pills">
            <li role="presentation" ><a href="main.jsp">Horas Disponibles</a></li>
            <li role="presentation" class="active"><a href="reservas.jsp">Horas reservadas</a></li>
        </ul>
        <div class="panel panel-default">
            <div class="panel-heading">Si desea cancelar una hora solo haga click en el boton</div>
            <table class="table">
                <tr>
                    <td>  
                         <span class="glyphicon glyphicon-calendar" ria-hidden="true"></span>
                        Día       
                       
                    </td>
                    <td>
                        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        Hora de inicio
                    </td>
                    <td>
                        <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                        Hora de Termino
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Sicologo o Especialista
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>
                        Seleccionar
                    </td>
                </tr> 
                
            <%
                for (int i = 0; i < servicio.reservasCliente(cliente.getRut()).size(); i++) {
            %>
             <tr>
                 <td>
                     <%= formato.format(servicio.reservasCliente(cliente.getRut()).get(i).getIdhora().getIdcalentadrio().getFecha()) %>
                 </td>
                 <td>
                     <%= servicio.reservasCliente(cliente.getRut()).get(i).getIdhora().getIdmodulo().getIncio().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.reservasCliente(cliente.getRut()).get(i).getIdhora().getIdmodulo().getTermino().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.reservasCliente(cliente.getRut()).get(i).getIdhora().getIdrutuser().getNombres()+" "+ servicio.reservasCliente(cliente.getRut()).get(i).getIdhora().getIdrutuser().getApellidos() %>
                 </td>
                 <td>
                     <button type="button" class="btn btn-danger btn-block" onclick = "location='./ControllerDeleteReserva.jsp?Id=<%=servicio.reservasCliente(cliente.getRut()).get(i).getId() %>'">Cancelar</button>
                 <td>
             </tr>
            
            <%
                }
            %>
            </table>
        </div>
        </div>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

