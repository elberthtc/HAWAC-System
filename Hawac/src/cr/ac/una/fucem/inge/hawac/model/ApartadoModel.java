/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

/**
 *
 * @author a4e3g6o0
 */
import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import java.util.HashMap;


public class ApartadoModel extends java.util.Observable {
    Apartado current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public ApartadoModel() {
    }

    public void init(){
        setCurrent(new Apartado());
        clearErrors();
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
        
    }
    public Apartado getCurrent() {
        return current;
    }

    public void setCurrent(Apartado current) {
        this.current = current;
        setChanged();
        notifyObservers();        
    }

    public void commit(){
        setChanged();
        notifyObservers();       
    }
  
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
