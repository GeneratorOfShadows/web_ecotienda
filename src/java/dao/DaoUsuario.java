package dao;

import entidades.Usuario;

public interface DaoUsuario {

    Usuario usuarioLogin(String usuario, String clave);

    String getMensaje();

}
