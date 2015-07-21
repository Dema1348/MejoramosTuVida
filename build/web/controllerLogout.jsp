<%-- 
    Document   : controllerLogout
    Created on : 18-11-2014, 10:52:33 AM
    Author     : edson
--%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%@page import="com.app.model.Usuario" session="true"%>
<%
   
    HttpSession sesion = request.getSession();
    if(sesion.getAttribute("cliente")!=null){
        Cliente cliente= (Cliente)sesion.getAttribute("cliente");
         DemoLogFile.info("Se ha deslogeo del sistema el cliente "+cliente.getRut());
    }
    if(sesion.getAttribute("usuario")!=null){
        Usuario usuario= (Usuario)sesion.getAttribute("usuario");
         DemoLogFile.info("Se ha deslogeo del sistema el usuario "+usuario.getRut());
    }
    
    sesion.invalidate();
    response.sendRedirect("index.jsp");
        
   
%>
