package cr.ac.una.fucem.inge.hawac.domain;
// Generated 05-mar-2017 20:19:45 by Hibernate Tools 4.3.1



/**
 * Linea generated by hbm2java
 */
public class Linea  implements java.io.Serializable {


     private LineaId id;
     private Factura factura;
     private Producto producto;
     private int cantidad;

    public Linea() {
    }

    public Linea(LineaId id, Factura factura, Producto producto, int cantidad) {
       this.id = id;
       this.factura = factura;
       this.producto = producto;
       this.cantidad = cantidad;
    }
   
    public LineaId getId() {
        return this.id;
    }
    
    public void setId(LineaId id) {
        this.id = id;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}


