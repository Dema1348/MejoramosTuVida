<%-- 
    Document   : busqueda
    Created on : 19-11-2014, 0:00:00
    Author     : EdsonAlexander
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.app.service.PagoService" session="true"%>
<%@page import="com.app.model.Pago" session="true"%>
<%!PagoService servicio = new PagoService(); String rut;String fechapago,fechapago2;%>
<%
    rut = request.getParameter("rut");
    fechapago= request.getParameter("fecha");
    fechapago2= request.getParameter("fecha2");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
%>

<table class="table">
                <tr>
                    <td>  
                        <span class="glyphicon glyphicon-calendar" ria-hidden="true"></span>
                        Fecha de pago      
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Especialista o sicologo
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Rut cliente
                    </td>
                    <td>
                         <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
                        Valor total
                    </td> 
                </tr> 
                
            <%
                for (int i = 0; i < servicio.pagosFiltroR(rut,fechapago,fechapago2).size() ; i++) {
            %>
             <tr>
                 <td>
                     <%= formato.format( servicio.pagosFiltroR(rut,fechapago,fechapago2).get(i).getFechapago()) %>
                 </td>
                 <td>
                     <%= servicio.pagosFiltroR(rut,fechapago,fechapago2).get(i).getIdrutuser().getNombres()+" "+servicio.pagosFiltroR(rut,fechapago,fechapago2).get(i).getIdrutcliente().getApellidos() %>
                 </td>
                 <td>
                     <%= servicio.pagosFiltroR(rut,fechapago,fechapago2).get(i).getIdrutcliente().getRut() %>
                 </td>
                 
                 <td>
                     <%= "$"+servicio.pagosFiltroR(rut,fechapago,fechapago2).get(i).getTotal() %>
                 </td>
                
             </tr>
            
            <%
                }
            %>
            </table>
