<%-- 
    Document   : asistenteTurno
    Created on : 18-11-2014, 22:44:32
    Author     : EdsonAlexander
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.ReservaHoraService" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%!ReservaHoraService servicio = new ReservaHoraService(); Cliente cliente; %>
<%
HttpSession sesion=request.getSession();    
cliente=(Cliente)sesion.getAttribute("cliente");
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulo asistente</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <div class="container">
        <div class="page-header">
            <h1>Cupos reservados <small>Seleccione una reserva que desee anular</small></h1>
        </div>
        <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='./controllerLogout.jsp'">Salir</button>
        <ul class="nav nav-pills">
            <li role="presentation" ><a href="asistente.jsp">Horas reservadas</a></li>
            <li role="presentation" class="active"><a href="asistenteReservas.jsp">Eliminar reservas</a></li>
             <li role="presentation" ><a href="asistenteCrearHora.jsp">Crear modulos disponibles</a></li>
        </ul>
        <div class="panel panel-default">
            <div class="panel-heading">Busque el dia y el modulo que desee pagar</div>
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
                         <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Rut cliente
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
                        Valor
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        Seleccionar
                    </td>
                </tr> 
                
            <%
                for (int i = 0; i < servicio.reservasTotales().size(); i++) {
            %>
             <tr>
                 <td>
                     <%= formato.format( servicio.reservasTotales().get(i).getIdhora().getIdcalentadrio().getFecha()) %>
                 </td>
                 <td>
                     <%= servicio.reservasTotales().get(i).getIdhora().getIdmodulo().getIncio().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.reservasTotales().get(i).getIdhora().getIdmodulo().getTermino().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.reservasTotales().get(i).getIdhora().getIdrutuser().getNombres()+" "+ servicio.reservasTotales().get(i).getIdhora().getIdrutuser().getApellidos() %>
                 </td>
                 <td>
                     <%= servicio.reservasTotales().get(i).getIdrutcliente().getRut() %>
                 </td>
                 <td>
                     <%= "$"+servicio.reservasTotales().get(i).getIdhora().getValor() %>
                 </td>
                 <td>
                     <button type="button" class="btn btn-danger btn-block" onclick = "location='./ControllerDeleteReservaA.jsp?Id=<%=servicio.reservasTotales().get(i).getId() %>'">Anular</button>
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