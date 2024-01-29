/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DaoUsuario;
import dao.impl.DaoUsuarioImpl;
import entidades.Usuario;

/**
 *
 * @author DanielFernando
 */
public class TestLogin {
    public static void main(String[] args) {
        
        DaoUsuario dao = new DaoUsuarioImpl();
        try{
            Usuario user = dao.usuarioLogin("paul", "2021");
            System.out.println(user.getUsuario());
        } catch(Exception e){
            System.out.println(dao.getMensaje()+" "+ e.getMessage());
        } 
    }
}
