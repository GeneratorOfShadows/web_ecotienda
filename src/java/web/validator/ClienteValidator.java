package web.validator;

import dao.DaoCliente;
import dao.impl.DaoClienteImpl;
import entidades.Cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;

public class ClienteValidator {

    private DaoCliente dao;
    private HttpServletRequest request;

    public ClienteValidator(HttpServletRequest request) {
        this.dao = new DaoClienteImpl();
        this.request = request;
    }

/**    
    lista los clientes
            
            */
    
    public String clienteSel() {
        String result = null;
        List<Cliente> clientes = dao.clienteSel();
        if (clientes != null) {
            request.setAttribute("clientes", clientes);
        } else {
            result = "Lista vacía";
        }
        return result;
    }

    public String clienteGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Cliente cliente = dao.clienteGet(id);
        if (cliente != null) {
            request.setAttribute("cliente", cliente);
        } else {
            result = "Sin datos";
        }
        return result;
    }
    
 /**    
   modifica los clientes
            
            */
    public String clienteInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer id = DeString.aInteger(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");

        if (upd && id == null) {
            result.append("<li>ID requerido</li>");
        }
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }
        if (apellido == null || apellido.trim().length() == 0) {
            result.append("<li>Apellido requerido</li>");
        } else if (apellido.trim().length() < 3 || apellido.trim().length() > 50) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }
        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo requerido</li>");
        } else if (correo.trim().length() < 3 || correo.trim().length() > 50) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }
        if (direccion == null || direccion.trim().length() == 0) {
            result.append("<li>Direccion requerido</li>");
        } else if (direccion.trim().length() < 3 || direccion.trim().length() > 50) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo);
        cliente.setDireccion(direccion);
        
        //Si la dimension es 4, no hay errores
        // Se ejecuta INS o UPD
        if (result.length() == 4) {
            String msg = (upd) ? dao.clienteUpd(cliente) : dao.clienteIns(cliente);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }

        //Los datos no se borran si hay errores
        if (result.length() > 4) {
            request.setAttribute("cliente", cliente);
        }

        return (result.length() == 4) ? null : result.append("</ul>").toString();
    }
/**    
   elimina los clientes
            
            */
    
    public String clienteDel() {
        Integer id = DeString.aInteger(request.getParameter("id"));
        String result = dao.clienteDel(id);
        return result;
    }

}
