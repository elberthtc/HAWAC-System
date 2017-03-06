package cr.ac.una.fucem.inge.hawac.domain;
// Generated 05-mar-2017 20:19:45 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Abono generated by hbm2java
 */
public class Abono  implements java.io.Serializable {


     private Integer idAbonos;
     private Apartado apartado;
     private Date fechaRealizado;
     private float monto;

    public Abono() {
    }

    public Abono(Apartado apartado, Date fechaRealizado, float monto) {
       this.apartado = apartado;
       this.fechaRealizado = fechaRealizado;
       this.monto = monto;
    }
   
    public Integer getIdAbonos() {
        return this.idAbonos;
    }
    
    public void setIdAbonos(Integer idAbonos) {
        this.idAbonos = idAbonos;
    }
    public Apartado getApartado() {
        return this.apartado;
    }
    
    public void setApartado(Apartado apartado) {
        this.apartado = apartado;
    }
    public Date getFechaRealizado() {
        return this.fechaRealizado;
    }
    
    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }
    public float getMonto() {
        return this.monto;
    }
    
    public void setMonto(float monto) {
        this.monto = monto;
    }




}


