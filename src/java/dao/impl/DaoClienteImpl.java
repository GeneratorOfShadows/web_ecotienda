package dao.impl;

import dao.DaoCliente;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;

public class DaoClienteImpl implements DaoCliente {

    private final ConectaBD conectaBD;
    private String mensaje;

    public DaoClienteImpl() {
        this.conectaBD = new ConectaBD();
    }

/**    
    lista los clientes
            
            */
    @Override
    public List<Cliente> clienteSel() {
        List<Cliente> clientes = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_cliente, ")
                .append("nombre_cliente,")
                .append("apellido_cliente,")
                .append("correo_cliente,")
                .append("direccion_cliente ")
                .append(" FROM cliente");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setDireccion(rs.getString(5));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return clientes;
    }

    @Override
    public Cliente clienteGet(Integer id) {
        Cliente cliente = new Cliente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_cliente, ")
                .append("nombre_cliente,")
                .append("apellido_cliente,")
                .append("correo_cliente,")
                .append("direccion_cliente")
                .append(" FROM cliente WHERE id_cliente =?");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente.setId(rs.getInt(1));
                    cliente.setNombre(rs.getString(2));
                    cliente.setApellido(rs.getString(3));
                    cliente.setCorreo(rs.getString(4));
                    cliente.setDireccion(rs.getString(5));
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cliente;
    }

     /**    
   inserta  los clientes
            
            */

    @Override
    public String clienteIns(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cliente (")
                .append("nombre_cliente,")
                .append("apellido_cliente,")
                .append("correo_cliente,")
                .append("direccion_cliente ")
                .append(") VALUES (?,?,?,?)");

        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());

            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas insertadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

     /**    
   modifica los clientes
            
            */
    @Override
    public String clienteUpd(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE cliente SET ")
                .append("nombre_cliente =?, ")
                .append("apellido_cliente =?, ")
                .append("correo_cliente =?, ")
                .append("direccion_cliente =? ")
                .append(" WHERE id_cliente =?");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getId());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    
     /**    
   Elimina  los clientes
            
            */
    @Override
    public String clienteDel(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM cliente WHERE")
                .append(" id_cliente =?");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas eliminadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }
}
