package web.validator;

import dao.DaoArticulo;
import dao.DaoProveedor;
import dao.impl.DaoArticuloImpl;
import dao.impl.DaoProveedorImpl;
import dto.ArticuloDTO;
import entidades.Articulo;
import entidades.Proveedor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;

public class ArticuloValidator {

    private final HttpServletRequest request;
    private final DaoArticulo daoArticulo;

    public ArticuloValidator(HttpServletRequest request) {
        this.request = request;
        this.daoArticulo = new DaoArticuloImpl();
    }

    public String articuloSel() {
        String result = null;
        List<ArticuloDTO> list = daoArticulo.articuloSel();
        if (list != null) {
            request.setAttribute("articulos", list);
        } else {
            result = daoArticulo.getMensaje();
        }
        return result;
    }

    public String articuloCbo() {
        
        DaoProveedor daoProveedor = new DaoProveedorImpl();
        String result = null;
        List<Proveedor> proveedores = daoProveedor.proveedorCbo();
        if (proveedores != null) {
            request.setAttribute("proveedores", proveedores);
        } else {
           
            result = daoProveedor.getMensaje();
        }
        return result;
    }

    public String articuloGet() {
        String result = null;
        DaoProveedor daoProveedor = new DaoProveedorImpl();
        List<Proveedor> proveedores = daoProveedor.proveedorCbo();
        Integer idarticulo = DeString.aInteger(request.getParameter("id"));
        Articulo articulo = daoArticulo.articuloGet(idarticulo);
        if (articulo != null  && proveedores != null) {
            request.setAttribute("articulo", articulo);
            request.setAttribute("proveedores", proveedores);
        } else {
            result = daoArticulo.getMensaje();
        }
        return result;
    }

    public String articuloInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");
        Integer id = DeString.aInteger(request.getParameter("id"));
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        Double precio = DeString.aDouble(request.getParameter("precio"));
        Integer cantidad = DeString.aInteger(request.getParameter("cantidad"));
        Integer proveedor = DeString.aInteger(request.getParameter("proveedor"));
        

        if (upd && id == null) {
            result.append("<li>Id requerido</li>");
        }
        if (codigo == null || codigo.trim().length() == 0) {
            result.append("<li>Codigo requerido</li>");
        } else if (codigo.trim().length() < 3 || codigo.trim().length() > 50) {
            result.append("<li>La dimensión del codigo debe estar entre")
                    .append("3 a 50 caracteres</li>");
        }
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append("3 a 50 caracteres</li>");
        }
      
        if (precio == null) {
            result.append("<li>precio requerido</li>");
        }
        if (cantidad == null) {
            result.append("<li>cantidad requerida</li>");
        }
        if (proveedor == null) {
            result.append("<li>proveedor requerido</li>");
        }
       
        Articulo articulo = new Articulo();
        articulo.setId(id);
        articulo.setCodigo(codigo);
        articulo.setNombre(nombre);
        articulo.setPrecio(precio);
        articulo.setCantidad(cantidad);
        articulo.setProveedor(proveedor);

        if (result.length() == 4) {
            String msg = upd
                    ? daoArticulo.articuloUpd(articulo)
                    : daoArticulo.articuloIns(articulo);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        
        if (result.length() > 4) {
            request.setAttribute("articulo", articulo);
            DaoProveedor daoProveedor = new DaoProveedorImpl();
            List<Proveedor> proveedores = daoProveedor.proveedorCbo();
            request.setAttribute("proveedores", proveedores);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String articuloDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
        String result = (ids != null)
                ? daoArticulo.articuloDel(ids)
                : "IDs incorrectos";
        return result;
    }
}
