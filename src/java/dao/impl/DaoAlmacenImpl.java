package dao.impl;

import dao.DaoAlmacen;
import dto.AlmacenDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;

public class DaoAlmacenImpl implements DaoAlmacen {

    private final ConectaBD conectaBD;
    private String mensaje;

    public DaoAlmacenImpl() {
        this.conectaBD = new ConectaBD();
    }

    /**
     * lista los almacen
     *
     */
    @Override
    public List<AlmacenDTO> almacenSel() {
        List<AlmacenDTO> almacen = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_almacen,")
                .append("factura_almacen,")
                .append("codigo_articulo,")
                .append("nombre_articulo,")
                .append("ruc_proveedor,")
                .append("nombre_proveedor,")
                .append("precio_almacen,")
                .append("cantidad_articulo")
                .append(" FROM almacen_view");
        try (Connection cn = conectaBD.getConexion()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            almacen = new ArrayList<>();
            while (rs.next()) {
                AlmacenDTO articulo = new AlmacenDTO();
                articulo.setId(rs.getInt(1));
                articulo.setFactura(rs.getString(2));
                articulo.setCodigo(rs.getString(3));
                articulo.setNomart(rs.getString(4));
                articulo.setRuc(rs.getString(5));
                articulo.setNompro(rs.getString(6));
                articulo.setPrecio(rs.getDouble(7));
                articulo.setCantidad(rs.getInt(8));
                almacen.add(articulo);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return almacen;
    }

  

    @Override
    public String getMensaje() {
        return mensaje;
    }
}
