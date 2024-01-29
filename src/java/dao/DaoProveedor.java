package dao;


import entidades.Proveedor;
import java.util.List;

public interface DaoProveedor {
     List <Proveedor> proveedorSel();
    List <Proveedor> proveedorCbo();
    Proveedor proveedorGet(Integer id);
    String proveedorIns(Proveedor proveedor);
    String proveedorUpd(Proveedor proveedor);
    String proveedorDel(List<Integer> ids);
    String getMensaje();
    
    
}
