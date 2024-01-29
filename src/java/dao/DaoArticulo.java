package dao;

import dto.ArticuloDTO;
import entidades.Articulo;
import java.util.List;

public interface DaoArticulo {
    
    List <ArticuloDTO> articuloSel();
    Articulo articuloGet(Integer id);
    String articuloIns(Articulo articulo);
    String articuloUpd(Articulo articulo);
    String articuloDel(List<Integer> ids);
    String getMensaje();
    
    
}
