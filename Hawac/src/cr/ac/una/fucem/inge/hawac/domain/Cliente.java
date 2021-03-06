package cr.ac.una.fucem.inge.hawac.domain;
// Generated 24-mar-2017 14:24:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int cedula;
     private String nombre;
     private float totalComprado;
     private String telefono;
     private String correo;
     private Set<Apartado> apartados = new HashSet<Apartado>(0);
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Cliente() {
        cedula = -1;
        nombre = "";
        totalComprado = 0;
        telefono = "";
        correo = "";
    }

	
    public Cliente(int cedula, String nombre, float totalComprado, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.totalComprado = totalComprado;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Cliente(int cedula, String nombre, float totalComprado, String telefono, String correo, Set<Apartado> apartados, Set<Factura> facturas) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.totalComprado = totalComprado;
       this.telefono = telefono;
       this.correo = correo;
       this.apartados = apartados;
       this.facturas = facturas;
    }
   
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getTotalComprado() {
        return this.totalComprado;
    }
    
    public void setTotalComprado(float totalComprado) {
        this.totalComprado = totalComprado;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Set<Apartado> getApartados() {
        return this.apartados;
    }
    
    public void setApartados(Set<Apartado> apartados) {
        this.apartados = apartados;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }




}


