package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.app.service.PagoService;
import com.app.model.Pago;

public final class busqueda_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

PagoService servicio = new PagoService(); String rut;
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
      out.write("\n");
      out.write('\n');

    rut = request.getParameter("rut");
    
    rut="1";
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

      out.write("\n");
      out.write("\n");
      out.write("<table class=\"table\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>  \n");
      out.write("                        <span class=\"glyphicon glyphicon-calendar\" ria-hidden=\"true\"></span>\n");
      out.write("                        Fecha de pago      \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                         <span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>\n");
      out.write("                        Especialista\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                         <span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>\n");
      out.write("                        Rut cliente\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                         <span class=\"glyphicon glyphicon-usd\" aria-hidden=\"true\"></span>\n");
      out.write("                        Valor total\n");
      out.write("                    </td> \n");
      out.write("                </tr> \n");
      out.write("                \n");
      out.write("            ");

                for (int i = 0; i < servicio.pagosFiltro(rut).size() ; i++) {
            
      out.write("\n");
      out.write("             <tr>\n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( formato.format( servicio.pagosFiltro(rut).get(i).getFechapago()) );
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( servicio.pagosFiltro(rut).get(i).getIdrutcliente().getNombres() +" "+servicio.pagosFiltro(rut).get(i).getIdrutcliente().getApellidos() );
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( servicio.pagosFiltro(rut).get(i).getIdrutcliente().getRut() );
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                 \n");
      out.write("                 <td>\n");
      out.write("                     ");
      out.print( "$"+servicio.pagosFiltro(rut).get(i).getTotal() );
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                \n");
      out.write("             </tr>\n");
      out.write("            \n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            </table>\n");
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
