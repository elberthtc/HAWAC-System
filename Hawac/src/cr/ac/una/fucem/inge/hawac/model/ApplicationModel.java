/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;
//import ferreteria.Application;
//import ferreteriaentidades.Empleado;

import cr.ac.una.fucem.inge.hawac.domain.Usuario;

//import ferreteriaentidades.Rol;

public class ApplicationModel extends java.util.Observable {
    
    String mensaje;
    Usuario current;
    int rolCurrent;

    
     public void init(){
         clearErrors();
     }
     public ApplicationModel(){
          clearErrors();
     }

    public String getMensaje() {
        return mensaje;
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
        this.setChanged();
        this.notifyObservers();
    }
     public void clearErrors(){
         setMensaje("");
     }

    public int getRolCurrent() {
        return rolCurrent;
    }

    public void setRolCurrent(int rolCurrent) {
        this.rolCurrent = rolCurrent;
    }
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
}

