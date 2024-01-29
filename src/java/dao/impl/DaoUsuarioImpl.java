package dao.impl;

import dao.DaoUsuario;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConectaBD;

public class DaoUsuarioImpl implements DaoUsuario {

    private final ConectaBD conectaBD;
    private String mensaje;

    public DaoUsuarioImpl() {
        this.conectaBD = new ConectaBD();
    }

/**    
    lista los usuarios
            
            */
  

    @Override
    public Usuario usuarioLogin(String usuario, String clave) {
        Usuario user = new Usuario();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_tipo, ")
                .append("nombre_tipo")
                .append(" FROM tipo_usuario WHERE nombre_tipo =?")
                .append(" AND AES_DECRYPT(clave, ?) = ? ");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ps.setString(3, clave);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                    user.setUsuario(rs.getString(2));
                }else {
                    user = null;
                    mensaje = "Credenciales Invalidas";
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return user;
    }

     /**    
   inserta  los usuarios
            
            */



    @Override
    public String getMensaje() {
        return mensaje;
    }
}
