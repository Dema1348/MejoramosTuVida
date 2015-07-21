<%-- 
    Document   : especialista
    Created on : 18-11-2014, 11:59:34 AM
    Author     : edson
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.ReservaHoraService" session="true"%>
<%@page import="com.app.model.Usuario" session="true"%>
<%!ReservaHoraService servicio = new ReservaHoraService(); Usuario usuario; %>
<%
HttpSession sesion=request.getSession();    
usuario=(Usuario)sesion.getAttribute("usuario");
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver citas</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <div class="container">
        <div class="page-header">
            <h1>Citas programadas <small>estas son las citas que tiene programadas </small></h1>
        </div>
             <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='controllerLogout.jsp'" >Salir</button>
        <ul class="nav nav-pills">
            <li role="presentation" class="active" ><a href="especialista.jsp">Citas programadas</a></li>
            <li role="presentation" ><a href="especialistaTurno.jsp">Cambiar Horario</a></li>
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
                        Rut cliente
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>
                        Seleccionar
                    </td>
                </tr> 
                
            <%
                for (int i = 0; i < servicio.reservasEspecilista(usuario.getRut()).size(); i++) {
            %>
             <tr>
                 <td>
                     <%= formato.format(servicio.reservasEspecilista(usuario.getRut()).get(i).getIdhora().getIdcalentadrio().getFecha()) %>
                 </td>
                 <td>
                     <%= servicio.reservasEspecilista(usuario.getRut()).get(i).getIdhora().getIdmodulo().getIncio().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.reservasEspecilista(usuario.getRut()).get(i).getIdhora().getIdmodulo().getTermino().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.reservasEspecilista(usuario.getRut()).get(i).getIdrutcliente().getRut() %>
                 </td>
                 <td>
                     <button type="button" class="btn btn-danger btn-block"  onclick = "location='./ControllerDeleteReservaE.jsp?Id=<%=servicio.reservasEspecilista(usuario.getRut()).get(i).getId() %>'">Cancelar</button>
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
