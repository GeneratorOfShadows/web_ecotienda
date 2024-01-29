package dao.impl;

import dao.DaoArticulo;
import dto.ArticuloDTO;
import entidades.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;

public class DaoArticuloImpl implements DaoArticulo {

    private final ConectaBD conectaBD;
    private String mensaje;

    public DaoArticuloImpl() {
        this.conectaBD = new ConectaBD();
    }

    /**
     * lista los articulos
     *
     */
    @Override
    public List<ArticuloDTO> articuloSel() {
        List<ArticuloDTO> articulos = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_articulo,")
                .append("codigo_articulo,")
                .append("nombre_articulo,")
                .append("precio_articulo,")
                .append("cantidad_articulo,")
                .append("proveedor")
                .append(" FROM articulo_view");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            articulos = new ArrayList<>();
            while (rs.next()) {
                ArticuloDTO articulo = new ArticuloDTO();
                articulo.setId(rs.getInt(1));
                articulo.setCodigo(rs.getString(2));
                articulo.setNombre(rs.getString(3));
                articulo.setPrecio(rs.getDouble(4));
                articulo.setCantidad(rs.getInt(5));
                articulo.setProveedor(rs.getString(6));

                articulos.add(articulo);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return articulos;
    }

    @Override
    public Articulo articuloGet(Integer id) {
        Articulo articulo = new Articulo();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_articulo,")
                .append("codigo_articulo,")
                .append("nombre_articulo,")
                .append("precio_articulo,")
                .append("cantidad_articulo,")
                .append("proveedor_articulo")
                .append(" FROM articulo WHERE id_articulo = ?");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    articulo.setId(rs.getInt(1));
                    articulo.setCodigo(rs.getString(2));
                    articulo.setNombre(rs.getString(3));
                    articulo.setPrecio(rs.getDouble(4));
                    articulo.setCantidad(rs.getInt(5));
                    articulo.setProveedor(rs.getInt(6));
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return articulo;
    }

    /**
     * inserta los articulos
     *
     */
    @Override
    public String articuloIns(Articulo articulo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO articulo (")
                .append("codigo_articulo,")
                .append("nombre_articulo,")
                .append("precio_articulo,")
                .append("cantidad_articulo,")
                .append("proveedor_articulo ")
                .append(") VALUES (?,?,?,?,?) ");

        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());

            ps.setString(1, articulo.getCodigo());
            ps.setString(2, articulo.getNombre());
            ps.setDouble(3, articulo.getPrecio());
            ps.setInt(4, articulo.getCantidad());
            ps.setInt(5, articulo.getProveedor());

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
     * modifica los articulos
     *
     */
    @Override
    public String articuloUpd(Articulo articulo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE articulo SET ")
                .append("codigo_articulo =?, ")
                .append("nombre_articulo =?, ")
                .append("precio_articulo =?, ")
                .append("cantidad_articulo =?, ")
                .append("proveedor_articulo =? ")
                .append(" WHERE id_articulo=?");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());

            ps.setString(1, articulo.getCodigo());
            ps.setString(2, articulo.getNombre());
            ps.setDouble(3, articulo.getPrecio());
            ps.setInt(4, articulo.getCantidad());
            ps.setInt(5, articulo.getProveedor());
            ps.setInt(6, articulo.getId());
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
     * Elimina los articulos
     *
     */
    @Override
    public String articuloDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM articulo WHERE ")
                .append("id_articulo = ? ");
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
