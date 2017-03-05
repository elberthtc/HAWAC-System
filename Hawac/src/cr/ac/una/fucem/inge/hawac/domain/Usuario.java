package cr.ac.una.fucem.inge.hawac.domain;
// Generated 04-mar-2017 20:31:30 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String password;
     private int tipo;
     private Dependiente dependiente;
     private Set<Bitacora> bitacoras = new HashSet<Bitacora>(0);

    public Usuario() {
    }

	
    public Usuario(int idUsuario, String password, int tipo) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.tipo = tipo;
    }
    public Usuario(int idUsuario, String password, int tipo, Dependiente dependiente, Set<Bitacora> bitacoras) {
       this.idUsuario = idUsuario;
       this.password = password;
       this.tipo = tipo;
       this.dependiente = dependiente;
       this.bitacoras = bitacoras;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public int getTipo() {
        return this.tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public Dependiente getDependiente() {
        return this.dependiente;
    }
    
    public void setDependiente(Dependiente dependiente) {
        this.dependiente = dependiente;
    }
    public Set<Bitacora> getBitacoras() {
        return this.bitacoras;
    }
    
    public void setBitacoras(Set<Bitacora> bitacoras) {
        this.bitacoras = bitacoras;
    }




}


