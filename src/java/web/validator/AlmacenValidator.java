package web.validator;

import dao.DaoAlmacen;
import dao.impl.DaoAlmacenImpl;
import dto.AlmacenDTO;

import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class AlmacenValidator {

    private final HttpServletRequest request;
    private final DaoAlmacen daoAlmacen;

    public AlmacenValidator(HttpServletRequest request) {
        this.request = request;
        this.daoAlmacen = new DaoAlmacenImpl();
    }

    public String almacenSel() {
        String result = null;
        List<AlmacenDTO> list = daoAlmacen.almacenSel();
        if (list != null) {
            request.setAttribute("almacenes", list);
        } else {
            result = daoAlmacen.getMensaje();
        }
        return result;
    }

   
}
