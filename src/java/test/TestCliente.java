package test;


import dao.DaoCliente;
import dao.impl.DaoClienteImpl;

import entidades.Cliente;





public class TestCliente {

    public static void main(String[] args) {
       
    Cliente cli; 
    DaoCliente dao= new DaoClienteImpl();
    try{
        cli=dao.clienteGet(1);
        System.out.println(cli.getNombre());
        System.out.println(cli.getApellido());
        System.out.println(cli.getCorreo());
        System.out.println(cli.getDireccion());
               
    }catch(Exception e){
        dao.getMensaje();
    }




        
    
    
    
        
}
    
    
    
}