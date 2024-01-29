
package dto;

public class AlmacenDTO {
    private Integer id;
    private String factura;
    private String codigo;
    private String nomart;
    private String ruc;
    private String nompro;
    private Double precio;
    private Integer cantidad;

    public AlmacenDTO(Integer id, String factura, String codigo, String nomart, String ruc, String nompro, Double precio, Integer cantidad) {
        this.id = id;
        this.factura = factura;
        this.codigo = codigo;
        this.nomart = nomart;
        this.ruc = ruc;
        this.nompro = nompro;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public  AlmacenDTO(){
        
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomart() {
        return nomart;
    }

    public void setNomart(String nomart) {
        this.nomart = nomart;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
