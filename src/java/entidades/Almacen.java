
package entidades;


public class Almacen {
    private Integer id;
    private String factura;
    private Integer articulo;
    private Integer proveedor;
    private Double precio;
    private String  fecha;

    public Almacen(Integer id, String factura, Integer articulo, Integer proveedor, Double precio, String fecha) {
        this.id = id;
        this.factura = factura;
        this.articulo = articulo;
        this.proveedor = proveedor;
        this.precio = precio;
        this.fecha = fecha;
    }
    
    
    public Almacen(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Integer getArticulo() {
        return articulo;
    }

    public void setArticulo(Integer articulo) {
        this.articulo = articulo;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
