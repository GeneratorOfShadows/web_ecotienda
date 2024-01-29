package dao;


import entidades.Cliente;
import java.util.List;

public interface DaoCliente {
    
    List <Cliente> clienteSel();
    Cliente clienteGet(Integer id);
    String clienteIns(Cliente cliente);
    String clienteUpd(Cliente cliente);
    String clienteDel(Integer id);
    String getMensaje();
    
    
}
