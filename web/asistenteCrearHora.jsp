<%-- 
    Document   : asistente
    Created on : 18-11-2014, 21:48:52
    Author     : EdsonAlexander
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.app.modelDAOPImpl.CalendarioDAOImpl" session="true"%>
<%@page import="com.app.modelDAOPImpl.ModuloDAOImpl" session="true"%>
<%@page import="com.app.service.UserService" session="true"%>
<%@page import="com.app.model.Cliente" session="true"%>
<%!CalendarioDAOImpl calendario = new CalendarioDAOImpl();
    ModuloDAOImpl modulo = new ModuloDAOImpl();
    UserService servicio = new UserService();
    Cliente cliente;%>
<%
    HttpSession sesion = request.getSession();
    cliente = (Cliente) sesion.getAttribute("cliente");
    SimpleDateFormat formato = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
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
                <h1>Cupos reservados <small>Cree un nuevo modulo para que pueda ser reservado</small></h1>
            </div>
            <button type="button" class="btn btn-default navbar-btn pull-right" onclick ="location='./controllerLogout.jsp'">Salir</button>
            <ul class="nav nav-pills">
                <li role="presentation" ><a href="asistente.jsp">Horas reservadas</a></li>
                <li role="presentation" ><a href="asistenteReservas.jsp">Eliminar reservas</a></li>
                <li role="presentation" class="active" ><a href="asistenteCrearHora.jsp">Crear modulos disponibles</a></li>
            </ul>
            <div class="panel panel-default">
                <div class="form-group grupo"> 
                    <label class="control-label">Seleccione una fecha</label>    
                    <select class="form-control" name="fecha" id="fecha">
                        
                        <%
                            for (int i = 0; i < calendario.listar().size(); i++) {
                        %>
                        <option><%= formato.format(calendario.listar().get(i).getFecha()) %> </option>
                        <%
                            }
                        %>


                    </select>
                </div>
                <div class="form-group grupo hidden"> 
                    <label class="control-label">Seleccione una fecha</label>    
                    <select class="form-control" name="fechaId" id="fechaId">
                        
                        <%
                            for (int i = 0; i < calendario.listar().size(); i++) {
                        %>
                        <option value="<%= i %>"><%= calendario.listar().get(i).getId() %> </option>
                        <%
                            }
                        %>


                    </select>
                </div>        
                <div class="form-group grupo"> 
                    <label class="control-label">Seleccione una modulo</label>    
                    <select class="form-control" name="modulo" id="modulo">
                        
                        <%
                            for (int i = 0; i < modulo.listar().size(); i++) {
                        %>
                        <option><%= modulo.listar().get(i).getIncio().toString().substring(10,20)+" - "+modulo.listar().get(i).getTermino().toString().substring(10,20) %> </option>
                        <%
                            }
                        %>


                    </select>
                </div> 
                <div class="form-group grupo"> 
                    <label class="control-label">Seleccione una sicologo o especialista</label>    
                    <select class="form-control" name="trabajador" id="trabajador">
                        
                        <%
                            for (int i = 0; i < servicio.userSP().size(); i++) {
                        %>
                        <option><%= servicio.userSP().get(i).getRut() %> </option>
                        <%
                            }
                        %>


                    </select>
                </div>
                <div class="form-group grupo"> 
                    <label class="control-label">Seleccione un valor $</label>    
                    <select class="form-control" name="valor" id="valor">
                        <option>1000</option>
                        <option>1500</option>
                        <option>2000</option>    
                        <option>2500</option>   
                        <option>3000</option>    
                    </select>
                </div>        
                <div class="form-group grupo"> 
                    <label class="control-label">Pulse crear para habilitar el modulo de horario</label>    
                    <button class="btn btn-block btn-success" id="crear">Crear</button>
                </div>
                <div id="resultado" class="alert alert-info"></div>
            </div>
        </div>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            
            function iniciarBusqueda(){
                var rut= $('select#trabajador').val();
                var fecha= $('select#fechaId')[0].selectedIndex+1;
                var valor= $('select#valor').val();
                var modulo= $('select#modulo')[0].selectedIndex+1;
                var conexion;
                if (window.XMLHttpRequest) {
                        conexion = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject) {
                        conexion = new ActiveXObject("Microsoft.XMLHTTP");
                    } 
                
                conexion.open("GET","crearHorario.jsp?valor="+valor+"&rut="+rut+"&fecha="+fecha+"&modulo="+modulo,true);
                
                conexion.onreadystatechange= function ()
                {
                    if (conexion.readyState == 4) {
                            if (conexion.status == 200) {
                                 document.getElementById("resultado").innerHTML=conexion.responseText;
                            }
                        }
                     
                     
                    
                    
                };
                
                 conexion.send();
                
            };
            
            function cambiarId(){
             var index =$('select#fecha')[0].selectedIndex;
             $("#fechaId option[value="+index+"]").attr("selected",true);  
             
            };
            
        $(function (){
                 
              $('#crear').on('click', iniciarBusqueda);
              $('select#fecha').change(cambiarId);
        });
                
        </script>
    </body>
</html>
