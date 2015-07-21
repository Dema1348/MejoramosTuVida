package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import com.app.service.HorasDsponiblesService;
import com.app.model.Usuario;

public final class especialistaTurno_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

HorasDsponiblesService servicio = new HorasDsponiblesService(); Usuario usuario; 
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

HttpSession sesion=request.getSession();    
usuario=(Usuario)sesion.getAttribute("usuario");
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ver modulos</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilo.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <div class=\"page-header\">\n");
      out.write("            <h1>Modulos programados <small>si desea cambiar su horario borre el modulo </small></h1>\n");
      out.write("        </div>\n");
      out.write("             <button type=\"button\" class=\"btn btn-default navbar-btn pull-right\" onclick =\"location='controllerLogout.jsp'\" >Salir</button>\n");
      out.write("        <ul class=\"nav nav-pills\">\n");
      out.write("            <li role=\"presentation\"  ><a href=\"especialista.jsp\">Citas programadas</a></li>\n");
      out.write("            <li role=\"presentation\" class=\"active\"><a href=\"especialistaTurno.jsp\">Cambiar Horario</a></li>\n");
      out.write("        </ul>\n");
      out.write("       <div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\">Modulos que se encuentran  disponibles por el sistema</div>\n");
      out.write("            <table class=\"table\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>  \n");
      out.write("                         <span class=\"glyphicon glyphicon-calendar\" ria-hidden=\"true\"></span>\n");
      out.write("                        Día       \n");
      out.write("                       \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <span class=\"glyphicon glyphicon-time\" aria-hidden=\"true\"></span>\n");
      out.write("                        Hora de inicio\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <span class=\"glyphicon glyphicon-time\" aria-hidden=\"true\"></span>\n");
      out.write("                        Hora de Termino\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <span class=\"glyphicon glyphicon-eye-open\" aria-hidden=\"true\"></span>\n");
      out.write("                        Estado\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <span class=\"glyphicon glyphicon-pushpin\" aria-hidden=\"true\"></span>\n");
      out.write("                        Cancelar modulo\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr> \n");
      out.write("                \n");
      out.write("            ");

                for (int i = 0; i < servicio.listarHorasDisponibles(usuario.getRut()).size(); i++) {
            
      out.write("\n");
      out.write("             <tr>\n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( formato.format(servicio.listarHorasDisponibles(usuario.getRut()).get(i).getIdcalentadrio().getFecha()) );
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( servicio.listarHorasDisponibles(usuario.getRut()).get(i).getIdmodulo().getIncio().toString().substring(10,20) );
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( servicio.listarHorasDisponibles(usuario.getRut()).get(i).getIdmodulo().getTermino().toString().substring(10,20) );
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( servicio.listarHorasDisponibles(usuario.getRut()).get(i).getEstado() );
      out.write("\n");
      out.write("                 </td>         \n");
      out.write("                  <td>\n");
      out.write("                     <button type=\"button\" class=\"btn btn-danger btn-block\" onclick = \"location='./ControllerDeleteModulojsp?Id=");
      out.print( servicio.listarHorasDisponibles(usuario.getRut()).get(i).getId() );
      out.write("'\">Cancelar</button>\n");
      out.write("                 <td>\n");
      out.write("             </tr>\n");
      out.write("            \n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
