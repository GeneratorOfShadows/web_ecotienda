package web.validator;

import dao.DaoProveedor;
import dao.impl.DaoProveedorImpl;
import entidades.Proveedor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;

public class ProveedorValidator {

    private DaoProveedor dao;
    private HttpServletRequest request;

    public ProveedorValidator(HttpServletRequest request) {
        this.dao = new DaoProveedorImpl();
        this.request = request;
    }

    /**
     * lista los proveedors
     *
     */
    public String proveedorSel() {
        String result = null;
        List<Proveedor> proveedores = dao.proveedorSel();
        if (proveedores != null) {
            request.setAttribute("proveedores", proveedores);
        } else {
            result = "Lista vacía";
        }
        return result;
    }

    public String proveedorGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Proveedor proveedor = dao.proveedorGet(id);
        if (proveedor != null) {
            request.setAttribute("proveedor", proveedor);
        } else {
            result = "Sin datos";
        }
        return result;
    }

    /**
     * modifica los proveedors
     *
     */
    public String proveedorInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer id = DeString.aInteger(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String ruc = request.getParameter("ruc");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        if (upd && id == null) {
            result.append("<li>ID requerido</li>");
        }
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }
        if (ruc == null || ruc.trim().length() == 0) {
            result.append("<li>Ruc requerido</li>");
        } else if (ruc.trim().length() < 3 || ruc.trim().length() > 12) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }
          if (direccion == null || direccion.trim().length() == 0) {
            result.append("<li>Direccion requerido</li>");
        } else if (direccion.trim().length() < 3 || direccion.trim().length() > 50) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }
          if (telefono == null || telefono .trim().length() == 0) {
            result.append("<li>Telefono requerido</li>");
        } else if (telefono .trim().length() < 3 || telefono.trim().length() > 10) {
            result.append("<li>La dimension de telefono debe ser entre 3 y 50</li>");
        }

        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo requerido</li>");
        } else if (correo.trim().length() < 3 || correo.trim().length() > 50) {
            result.append("<li>La dimension de nombre debe ser entre 3 y 50</li>");
        }
      
        
        Proveedor proveedor = new Proveedor();
        proveedor.setId(id);
        proveedor.setNombre(nombre);
        proveedor.setRuc(ruc);
        proveedor.setDireccion(direccion);
        proveedor.setTelefono(telefono);
        proveedor.setCorreo(correo);
        
       

        //Si la dimension es 4, no hay errores
        // Se ejecuta INS o UPD
        if (result.length() == 4) {
            String msg = (upd) ? dao.proveedorUpd(proveedor) : dao.proveedorIns(proveedor);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }

        //Los datos no se borran si hay errores
        if (result.length() > 4) {
            request.setAttribute("proveedor", proveedor);
        }

        return (result.length() == 4) ? null : result.append("</ul>").toString();
    }

    /**
     * elimina los proveedors
     *
     */
    public String proveedorDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
         String result = (ids != null)
                ? dao.proveedorDel(ids)
                : "IDs incorrectos";
        return result;
    }

}
