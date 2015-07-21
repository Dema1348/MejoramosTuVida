<%-- 
    Document   : controllerLoginCliente
    Created on : 17-11-2014, 03:51:39 PM
    Author     : edson
--%>
<%@page import="com.app.service.ClienteService" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%! ClienteService servicio = new ClienteService();String rut, pass;Cliente cliente;%>
<%
    rut = request.getParameter("rut");
    pass = request.getParameter("pass");
    cliente=servicio.buscarCliente(rut, pass);
    if(cliente!=null){
        HttpSession sesion=request.getSession();
        sesion.setAttribute("cliente", cliente);
        DemoLogFile.info("El cliente "+cliente.getRut()+" se ha logeado");
        response.sendRedirect("main.jsp");
        
    }
    
    else{
        DemoLogFile.warn("Intento de logeo fallido");
        response.sendRedirect("index.jsp");
    }
%>

