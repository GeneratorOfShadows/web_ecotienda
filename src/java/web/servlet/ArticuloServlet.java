package web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.ArticuloValidator;

@WebServlet(name = "ArticuloServlet", urlPatterns = {"/Articulo"})
public class ArticuloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result;
        String target = "articuloSel.jsp";

        ArticuloValidator validator = new ArticuloValidator(request);

        switch (accion) {
            case "SEL":
                result = validator.articuloSel();
                break;
            case "CBO":
                result = validator.articuloCbo();
                target = "articuloIns.jsp";
                break;
            case "INS":
                result = validator.articuloInsUpd(false);
                target = result == null ? "articulo.jsp" : "articuloIns.jsp";
                break;
            case "DEL":
                result = validator.articuloDel();
                target = "articulo.jsp";
                break;
            case "GET":
                result = validator.articuloGet();
                target = "articuloUpd.jsp";
                break;
            case "UPD":
                result = validator.articuloInsUpd(true);
                target = result == null ? "articulo.jsp" : "articuloUpd.jsp";
                break;
            case "":
                result = "Solicitud requerida";
                break;
            default:
                result = "Solicitud no reconocida";
        }

        if (result != null) {
            request.setAttribute("message", result);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
