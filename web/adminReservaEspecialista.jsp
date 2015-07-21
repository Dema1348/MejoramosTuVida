<%-- 
    Document   : adminReservas
    Created on : 18-11-2014, 22:57:16
    Author     : EdsonAlexander
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.service.EspecialistaService" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%!EspecialistaService servicio = new EspecialistaService();
    Cliente cliente;%>
<%
    HttpSession sesion = request.getSession();
    cliente = (Cliente) sesion.getAttribute("cliente");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
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
            <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location = './controllerLogout.jsp'">Salir</button>
            <ul class="nav nav-pills">
                <li role="presentation" ><a href="admin.jsp">Horas Disponibles</a></li>
                <li role="presentation" ><a href="adminReservas.jsp">Horas reservadas</a></li>
                <li role="presentation" ><a href="adminPagoFecha.jsp">Pagos especialistas por fecha</a></li>
                <li role="presentation" ><a href="adminPagoFechaRango.jsp">Pagos especialistas por rango de fecha</a></li>
                <li role="presentation" class="active"><a href="adminReservaEspecialista.jsp">Reservas programadas  por especialista  y fecha </a></li>
            </ul>
            <div class="panel panel-default">
                <div class="panel-heading">Seleccione el especialista y la fecha a buscar</div>

                <div class="form-group grupo"> 
                    <label class="control-label">Especialista Rut</label>    
                    <select class="form-control" name="rut" id="rut">
                        <%
                            for (int i = 0; i < servicio.listaEspecialistas().size(); i++) {
                        %>
                        <option><%= servicio.listaEspecialistas().get(i).getRut() %> </option>
                        <%
                            }
                        %>


                    </select>
                </div>

                <div class="form-group grupo"> 
                    <label class="control-label">Fecha</label>    
                    <input name="fecha" class="form-control" type="date"  step="1" min="2014-11-00" max="2015-00-00" value="2014-11-01">
                </div>
                <div class="form-group grupo"> 
                    <label class="control-label">Iniciar busqueda</label>    
                    <button id="busqueda" class="btn btn-block btn-primary">Buscar</button>
                </div>
                <div id="resultado"></div>
            </div>
        </div>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            
            function iniciarBusqueda(){
                var rut= $('select#rut').val();
                var fecha= $('input[name=fecha]').val();
                console.log(fecha+rut);
                var conexion;
                if (window.XMLHttpRequest) {
                        conexion = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject) {
                        conexion = new ActiveXObject("Microsoft.XMLHTTP");
                    } 
                    
                conexion.open("GET","busqueda3.jsp?rut="+rut+"&fecha="+fecha,true);
                conexion.onreadystatechange= function ()
                {
                    if (conexion.readyState == 4) {
                            if (conexion.status == 200) {
                                 document.getElementById("resultado").innerHTML=conexion.responseText;
                            }
                        }
                     
                     
                    
                    
                };
                
                 conexion.send();
            }
            
            
        $(function (){
                 
              $('#busqueda').on('click', iniciarBusqueda);
        });
                
        </script>
    </body>
</html>    
