package dao.impl;

import dao.DaoProveedor;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;

public class DaoProveedorImpl implements DaoProveedor {

    private final ConectaBD conectaBD;
    private String mensaje;

    public DaoProveedorImpl() {
        this.conectaBD = new ConectaBD();
    }

    /**
     * lista los proveedors
     *
     */
    @Override
    public List<Proveedor> proveedorSel() {
        List<Proveedor> proveedores = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_proveedor, ")
                .append("nombre_proveedor,")
                .append("ruc_proveedor,")
                .append("direccion_proveedor,")
                .append("telefono_proveedor, ")
                .append("correo_proveedor ")
                .append(" FROM proveedor");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            proveedores = new ArrayList<>();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt(1));
                proveedor.setNombre(rs.getString(2));
                proveedor.setRuc(rs.getString(3));
                proveedor.setDireccion(rs.getString(4));
                proveedor.setTelefono(rs.getString(5));
                proveedor.setCorreo(rs.getString(6));
                proveedores.add(proveedor);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return proveedores;
    }
    
    @Override
    public List<Proveedor> proveedorCbo() {
        List<Proveedor> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_proveedor,")
                .append("ruc_proveedor ")
                .append(" FROM proveedor");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt(1));
                proveedor.setRuc(rs.getString(2));
                list.add(proveedor);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Proveedor proveedorGet(Integer id) {
        Proveedor proveedor = new Proveedor();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_proveedor, ")
                .append("nombre_proveedor,")
                .append("ruc_proveedor,")
                .append("direccion_proveedor,")
                .append("telefono_proveedor, ")
                .append("correo_proveedor ")
                .append(" FROM proveedor WHERE id_proveedor =?");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proveedor.setId(rs.getInt(1));
                    proveedor.setNombre(rs.getString(2));
                    proveedor.setRuc(rs.getString(3));
                    proveedor.setDireccion(rs.getString(4));
                    proveedor.setTelefono(rs.getString(5));
                    proveedor.setCorreo(rs.getString(6));
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return proveedor;
    }

    /**
     * inserta los proveedors
     *
     */
    @Override
    public String proveedorIns(Proveedor proveedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO proveedor (")
                .append("nombre_proveedor,")
                .append("ruc_proveedor,")
                .append("direccion_proveedor,")
                .append("telefono_proveedor, ")
                .append("correo_proveedor ")
                .append(") VALUES (?,?,?,?,?)");

        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());

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
     * modifica los proveedors
     *
     */
    @Override
    public String proveedorUpd(Proveedor proveedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE proveedor SET ")
                .append("nombre_proveedor =?, ")
                .append("ruc_proveedor =?, ")
                .append("direccion_proveedor =?, ")
                .append("telefono_proveedor =?, ")
                .append("correo_proveedor =? ")
                .append(" WHERE id_proveedor =?");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());
            ps.setInt(6, proveedor.getId());
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
     * Elimina los proveedors
     *
     */
    @Override
    public String proveedorDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM proveedor WHERE ")
                .append("id_proveedor = ? ");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            cn.setAutoCommit(false);
            boolean ok = true;
            for (int id = 0; id < ids.size(); id++) {
                ps.setInt(1, ids.get(id));
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    mensaje = "ID: " + ids.get(id) + " no existe";
                }
            }
            if (ok) {
                cn.commit();
            } else {
                cn.rollback();
            }
            cn.setAutoCommit(true);
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }
}
