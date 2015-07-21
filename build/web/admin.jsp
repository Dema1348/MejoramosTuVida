<%-- 
    Document   : admin
    Created on : 18-11-2014, 22:52:47
    Author     : EdsonAlexander
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.HorasDsponiblesService" session="true"%>
<%!HorasDsponiblesService servicio = new HorasDsponiblesService();%>
<%
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
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
            <h1>Cupos <small> Horas disponibles</small></h1>
        </div>
        <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='./controllerLogout.jsp'">Salir</button>
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="admin.jsp">Horas Disponibles</a></li>
            <li role="presentation"><a href="adminReservas.jsp">Horas reservadas</a></li>
            <li role="presentation"><a href="adminPagoFecha.jsp">Pagos especialistas por fecha</a></li>
            <li role="presentation" ><a href="adminPagoFechaRango.jsp">Pagos especialistas por rango de fecha</a></li>
            <li role="presentation" ><a href="adminReservaEspecialista.jsp">Reservas programadas  por especialista  y fecha </a></li>
        </ul>
        <div class="panel panel-default">
            <div class="panel-heading">Horas que aun se encuentras disponibles por el sistema</div>
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
                        Valor
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
