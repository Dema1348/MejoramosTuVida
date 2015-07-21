package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import com.app.service.EspecialistaService;
import com.app.model.Cliente;

public final class adminPagoFecha_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

EspecialistaService servicio = new EspecialistaService();
    Cliente cliente;
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

    HttpSession sesion = request.getSession();
    cliente = (Cliente) sesion.getAttribute("cliente");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ver reservas</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilo.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h1>Reservas <small>estas son las citas que tiene programas </small></h1>\n");
      out.write("            </div>\n");
      out.write("            <button type=\"button\" class=\"btn btn-default navbar-btn pull-right\" onclick =\"location = './controllerLogout.jsp'\">Salir</button>\n");
      out.write("            <ul class=\"nav nav-pills\">\n");
      out.write("                <li role=\"presentation\" ><a href=\"admin.jsp\">Horas Disponibles</a></li>\n");
      out.write("                <li role=\"presentation\" ><a href=\"adminReservas.jsp\">Horas reservadas</a></li>\n");
      out.write("                <li role=\"presentation\" class=\"active\"><a href=\"adminPagoFecha.jsp\">Pagos especialistas por fecha</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel-heading\">Seleccione el especialista y la fecha a buscar</div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group grupo\"> \n");
      out.write("                    <label class=\"control-label\">Especialista</label>    \n");
      out.write("                    <select class=\"form-control\" name=\"rut\" id=\"rut\">\n");
      out.write("                        ");

                            for (int i = 0; i < servicio.listaEspecialistas().size(); i++) {
                        
      out.write("\n");
      out.write("                        <option>");
      out.print( servicio.listaEspecialistas().get(i).getRut() );
      out.write(" </option>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group grupo\"> \n");
      out.write("                    <label class=\"control-label\">Fecha</label>    \n");
      out.write("                    <input name=\"fecha\" class=\"form-control\" type=\"date\"  step=\"1\" min=\"2014-11-00\" max=\"2015-00-00\" value=\"2014-11-01\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group grupo\"> \n");
      out.write("                    <label class=\"control-label\">Iniciar busqueda</label>    \n");
      out.write("                    <button id=\"busqueda\" class=\"btn btn-block btn-primary\">Buscar</button>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"resultado\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function iniciarBusqueda(){\n");
      out.write("                var rut= $('select#rut').val();\n");
      out.write("                var fecha= $('input[name=fecha]').val();\n");
      out.write("                console.log(fecha+rut);\n");
      out.write("                var conexion;\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                        conexion = new XMLHttpRequest();\n");
      out.write("                    }\n");
      out.write("                    else if (window.ActiveXObject) {\n");
      out.write("                        conexion = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                    } \n");
      out.write("                    \n");
      out.write("                conexion.open(\"GET\",\"busqueda.jsp?rut=\"+rut+\"&fecha=\"+fecha,true);\n");
      out.write("                conexion.onreadystatechange= function ()\n");
      out.write("                {\n");
      out.write("                    if (conexion.readyState == 4) {\n");
      out.write("                            if (conexion.status == 200) {\n");
      out.write("                                 document.getElementById(\"resultado\").innerHTML=conexion.responseText;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                };\n");
      out.write("                \n");
      out.write("                 conexion.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        $(function (){\n");
      out.write("                 \n");
      out.write("              $('#busqueda').on('click', iniciarBusqueda);\n");
      out.write("        });\n");
      out.write("                \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>    \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
