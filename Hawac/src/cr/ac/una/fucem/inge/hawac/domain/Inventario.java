package cr.ac.una.fucem.inge.hawac.domain;
// Generated 05-mar-2017 20:19:45 by Hibernate Tools 4.3.1



/**
 * Inventario generated by hbm2java
 */
public class Inventario  implements java.io.Serializable {


     private InventarioId id;
     private Producto producto;
     private int cantidad;
     private String estado;

    public Inventario() {
    }

    public Inventario(InventarioId id, Producto producto, int cantidad, String estado) {
       this.id = id;
       this.producto = producto;
       this.cantidad = cantidad;
       this.estado = estado;
    }
   
    public InventarioId getId() {
        return this.id;
    }
    
    public void setId(InventarioId id) {
        this.id = id;
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
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


