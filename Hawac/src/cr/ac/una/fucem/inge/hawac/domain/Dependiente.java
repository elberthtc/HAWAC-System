package cr.ac.una.fucem.inge.hawac.domain;
// Generated 05-mar-2017 13:30:26 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Dependiente generated by hbm2java
 */
public class Dependiente  implements java.io.Serializable {


     private int idDependiente;
     private Usuario usuario;
     private String nombreDependiente;
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Dependiente() {
    }

	
    public Dependiente(Usuario usuario, String nombreDependiente) {
        this.usuario = usuario;
        this.nombreDependiente = nombreDependiente;
    }
    public Dependiente(Usuario usuario, String nombreDependiente, Set<Factura> facturas) {
       this.usuario = usuario;
       this.nombreDependiente = nombreDependiente;
       this.facturas = facturas;
    }
   
    public int getIdDependiente() {
        return this.idDependiente;
    }
    
    public void setIdDependiente(int idDependiente) {
        this.idDependiente = idDependiente;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNombreDependiente() {
        return this.nombreDependiente;
    }
    
    public void setNombreDependiente(String nombreDependiente) {
        this.nombreDependiente = nombreDependiente;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
}


