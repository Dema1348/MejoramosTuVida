<%-- 
    Document   : main
    Created on : 17-11-2014, 03:50:49 PM
    Author     : edson
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.HorasDsponiblesService" session="true"%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%!HorasDsponiblesService servicio = new HorasDsponiblesService();%>
<%
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
DemoLogFile.info("Se listaron las horas disponibles del sistema");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <div class="container">
        <div class="page-header">
            <h1>Cupos <small>Seleccione una reserva</small></h1>
        </div>
        <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='./controllerLogout.jsp'">Salir</button>
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="main.jsp">Horas Disponibles</a></li>
            <li role="presentation"><a href="reservas.jsp">Horas reservadas</a></li>
        </ul>
        <div class="panel panel-default">
            <div class="panel-heading">Busque el dia y la hora que mas le acomode para poder ser atentido</div>
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
                         <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
                        Sicologo o Especialista
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>
                        Seleccionar
                    </td>
                </tr> 
                
            <%
                for (int i = 0; i < servicio.listarHorasDisponibles().size(); i++) {
            %>
             <tr>
                 <td>
                     <%= formato.format(servicio.listarHorasDisponibles().get(i).getIdcalentadrio().getFecha()) %>
                 </td>
                 <td>
                     <%= servicio.listarHorasDisponibles().get(i).getIdmodulo().getIncio().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.listarHorasDisponibles().get(i).getIdmodulo().getTermino().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.listarHorasDisponibles().get(i).getIdrutuser().getNombres()+" "+servicio.listarHorasDisponibles().get(i).getIdrutuser().getApellidos() %>
                 </td>
                 <td>
                     <%= "$"+servicio.listarHorasDisponibles().get(i).getValor() %>
                 </td>
                 <td>
                     <button type="button" class="btn btn-primary btn-block" onclick = "location='./controllerReserva.jsp?Id=<%=servicio.listarHorasDisponibles().get(i).getId() %>'">Reservar</button>
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
