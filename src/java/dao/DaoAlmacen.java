package dao;


import dto.AlmacenDTO;

import java.util.List;

public interface DaoAlmacen {
    
    List <AlmacenDTO> almacenSel();
    String getMensaje();
    
    
}
