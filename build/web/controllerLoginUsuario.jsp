<%-- 
    Document   : controllerLoginCliente
    Created on : 17-11-2014, 03:51:39 PM
    Author     : edson
--%>
<%@page import="com.app.service.UserService" session="true"%>
<%@page import="com.app.model.Usuario" session="true"%>
<%@page import="com.app.log.DemoLogFile" session="true"%>
<%! UserService servicio = new UserService();String rut, pass; Usuario usuario;%>
<%
    rut = request.getParameter("rut");
    pass = request.getParameter("pass");
    usuario=servicio.buscarUsuario(rut, pass);
    if(usuario!=null){
        HttpSession sesion=request.getSession();
        sesion.setAttribute("usuario", usuario);
         DemoLogFile.info("El usuario "+usuario.getRut()+" se ha logeado con rol de "+usuario.getRolId().getCargo());
        switch (usuario.getRolId().getId()){
            case 1:
                response.sendRedirect("admin.jsp");
                break;
            case 2:
                response.sendRedirect("asistente.jsp");
                break;
            case 3:
                response.sendRedirect("sicologo.jsp");
                break;
            case 4:
                response.sendRedirect("especialista.jsp");
                break;
            default:
                response.sendRedirect("logiUsuarios.jsp");
                break;
        
        
        }
        
    }
    
    else{
        DemoLogFile.warn("Intento de logeo fallido");
        response.sendRedirect("loginUsuarios.jsp");
    }
%>

