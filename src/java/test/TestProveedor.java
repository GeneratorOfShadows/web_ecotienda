package test;


import dao.DaoProveedor;
import dao.impl.DaoProveedorImpl;

import entidades.Proveedor;





public class TestProveedor {

    public static void main(String[] args) {
       
    Proveedor cli; 
    DaoProveedor dao= new DaoProveedorImpl();
    try{
        cli=dao.proveedorGet(1);
        System.out.println(cli.getNombre());
        System.out.println(cli.getRuc());
        System.out.println(cli.getDireccion());
        System.out.println(cli.getTelefono());
        System.out.println(cli.getCorreo());
        
        
               
    }catch(Exception e){
        dao.getMensaje();
    }




        
    
    
    
        
}
    
    
    
}