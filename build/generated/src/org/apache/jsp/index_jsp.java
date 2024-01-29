package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>ECOTIENDA - INICIO</title>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <link href=\"css/inicio.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/productos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link  rel=\"stylesheet\"   href=\"https://fonts.googleapis.com/css2?family=Kaushan+Script\"  />\n");
      out.write("        <link  rel=\"stylesheet\"  href=\"https://fonts.googleapis.com/css2?family=Poppins&display=swap\"  />\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-expand-lg bg-light\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <Img src=\"svg/planta.svg\" alt=\"logo\" />\n");
      out.write("                    </div>\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                        <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"ae\" href=\"index.html\">INICIO</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a href=\"Productos.html\" class=\"ae\">PRODUCTOS</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"ae\" href=\"nosotros.html\">NOSOTROS</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"ae\" href=\"login.jsp\">INICIAR SESION</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"carouselExampleControls\" class=\"carousel slide conf mb-5\" data-bs-ride=\"carousel\">\n");
      out.write("  <div class=\"carousel-inner\">\n");
      out.write("    <div class=\"carousel-item active\">\n");
      out.write("        <img src=\"Img/pexels-daria-shevtsova-1070979.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("        <img src=\"Img/pexels-darya-sannikova-2422444.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("        <img src=\"Img/pexels-oleksandr-pidvalnyi-7373035.jpg\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleControls\" data-bs-slide=\"prev\">\n");
      out.write("    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"visually-hidden\">Previous</span>\n");
      out.write("  </button>\n");
      out.write("  <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleControls\" data-bs-slide=\"next\">\n");
      out.write("    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("    <span class=\"visually-hidden\">Next</span>\n");
      out.write("  </button>\n");
      out.write("</div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"bor\">-</div>\n");
      out.write("            <div class=\"datosgenerales\">\n");
      out.write("                <div class=\"textgeneral\">\n");
      out.write("                    <p align=\"center\">- VENTA DE ECOTIENDA -</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"bor\">-</div>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <a id=\"computadora\">\n");
      out.write("                        <img src=\"./Img/AceiteKrill.jpg\" alt=\"\" class=\"item-img\"\n");
      out.write("                             /></a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <a id=\"computadora\">\n");
      out.write("                        <img src=\"./Img/HeladoFresa.jpg\" alt=\"\" class=\"item-img\"\n");
      out.write("                             /></a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item\">\n");
      out.write("                    <a id=\"computadora\">\n");
      out.write("                        <img src=\"./Img/HeladoFresa.jpg\" alt=\"\" class=\"item-img\"\n");
      out.write("                             /></a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <main>\n");
      out.write("                <section class=\"contenedor\">\n");
      out.write("                    <h2 class=\"titulo-seccion\">Nuestros puntos fuertes</h2>\n");
      out.write("                    <p class=\"copy\">\n");
      out.write("                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Repellat\n");
      out.write("                        consequuntur atque nam. Maxime quae consequatur autem iure, placeat\n");
      out.write("                        vero itaque sunt, quia soluta accusamus neque distinctio veritatis rem\n");
      out.write("                        facere eius.\n");
      out.write("                    </p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"card mb-3\">\n");
      out.write("                        <Img  src=\"./Img/pexels-polina-tankilevitch-3875427.jpg\" class=\"card-Img-top\" >\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title\">Card title</h5>\n");
      out.write("                            <p class=\"card-text\">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>\n");
      out.write("                            <p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title\">Card title</h5>\n");
      out.write("                            <p class=\"card-text\">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>\n");
      out.write("                            <p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>\n");
      out.write("                        </div>\n");
      out.write("                        <Img src=\"Img/pexels-daria-shevtsova-1070979.jpg\" class=\"card-Img-bottom\" >\n");
      out.write("                    </div>\n");
      out.write("            </main>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <footer>\n");
      out.write("                <div class=\"contenedor\">\n");
      out.write("                    <h2 class=\"titulo-seccion\">Contacto</h2>\n");
      out.write("                    <p class=\"copy\">\n");
      out.write("                    <td><strong>Direccion:</strong> Santa Clara - Ate 15487 &nbsp;</td>\n");
      out.write("                    <td><strong>Telf: </strong>987-654-321 &nbsp;- &nbsp;01-3692581</td>\n");
      out.write("                    </p>\n");
      out.write("\n");
      out.write("                    <div class=\"redes-sociales\">\n");
      out.write("                        <i class=\"fab fa-twitter\"></i>\n");
      out.write("                        <i class=\"fab fa-facebook-f\"></i>\n");
      out.write("                        <i class=\"fab fa-instagram\"></i>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div >\n");
      out.write("                    <a href=\"https://wa.link/yoj2e7\"\n");
      out.write("                       class=\"whatsapp\" target=\"_blank\">\n");
      out.write("                        <i class=\"fab fa-whatsapp\"></i>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script\n");
      out.write("                src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("                integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\"\n");
      out.write("                crossorigin=\"anonymous\"\n");
      out.write("            ></script>\n");
      out.write("\n");
      out.write("            <script\n");
      out.write("                src=\"https://kit.fontawesome.com/f955c68031.js\"\n");
      out.write("                crossorigin=\"anonymous\"\n");
      out.write("            ></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
