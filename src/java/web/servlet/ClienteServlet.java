package web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.ClienteValidator;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/Cliente"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;

        // Variable auxiliar para almacenar y mostrar mensaje de error
        String result;

        // Variable auxiliar para inidcar el destino
        String target = "clienteSel.jsp";

        ClienteValidator validator = new ClienteValidator(request);

        switch (accion) {
            case "SEL":
                result = validator.clienteSel();
                break;
            case "GET":
                result = validator.clienteGet();
                target = "clienteUpd.jsp";
                break;
            case "INS":
                result = validator.clienteInsUpd(false);
                target = (result == null) ? "cliente.jsp" : "clienteIns.jsp";
                break;
            case "UPD":
                result = validator.clienteInsUpd(true);
                target = (result == null) ? "cliente.jsp" : "clienteUpd.jsp";
                break;
            case "DEL":
                result = validator.clienteDel();
                target = "cliente.jsp";
                break;
            case "":
                result = "Acción requerida"; 
                break;
            default:
                result = "Acción no reconocida";
        }

        // Asignamos la varialbe result a un campo llamado "mensaje"
        request.setAttribute("mensaje", result);

        // Navegamos a la página "target"
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
