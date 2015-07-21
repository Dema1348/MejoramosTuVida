<%-- 
    Document   : busqueda
    Created on : 19-11-2014, 0:00:00
    Author     : EdsonAlexander
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.app.service.ReservaHoraService" session="true"%>
<%!ReservaHoraService servicio = new ReservaHoraService(); String rut;String fechapago;%>
<%
    rut = request.getParameter("rut");
    fechapago= request.getParameter("fecha");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
%>

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
                        Especialista
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Rut cliente
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
                        Valor 
                    </td> 
                </tr> 
                
            <%
                for (int i = 0; i < servicio.reservasEspecilistaF(rut,fechapago).size() ; i++) {
            %>
             <tr>
                 <td>
                     <%= formato.format( servicio.reservasEspecilistaF(rut,fechapago).get(i).getIdhora().getIdcalentadrio().getFecha()) %>
                 </td>
                 <td>
                     <%=  servicio.reservasEspecilistaF(rut,fechapago).get(i).getIdhora().getIdmodulo().getIncio().toString().substring(10,20) %>
                 </td>
                 <td>
                     <%= servicio.reservasEspecilistaF(rut,fechapago).get(i).getIdhora().getIdmodulo().getTermino().toString().substring(10,20) %>
                 </td>
                  <td>
                     <%= servicio.reservasEspecilistaF(rut,fechapago).get(i).getIdhora().getIdrutuser().getRut() %>
                 </td>
                 <td>
                     <%= servicio.reservasEspecilistaF(rut,fechapago).get(i).getIdrutcliente().getRut() %>
                 </td>
                 <td>
                     <%= servicio.reservasEspecilistaF(rut,fechapago).get(i).getIdhora().getValor() %>
                 </td>
                
             </tr>
            
            <%
                }
            %>
</table>
