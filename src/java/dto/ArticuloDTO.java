package dto;

/**
 *
 * @author DanielFernando
 */
public class ArticuloDTO {

    private Integer id;
    private String codigo;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private String proveedor;

    public ArticuloDTO(Integer id, String codigo, String nombre, Double precio, Integer cantidad, String proveedor) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }

   

   
    public ArticuloDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    

    
    
    
}
