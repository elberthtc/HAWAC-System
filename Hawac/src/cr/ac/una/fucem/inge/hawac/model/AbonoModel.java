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
import cr.ac.una.fucem.inge.hawac.domain.Abono;
import java.util.HashMap;


public class AbonoModel extends java.util.Observable {
    Abono current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public AbonoModel() {
    }

    public void init(){
        setCurrent(new Abono());
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
    public Abono getCurrent() {
        return current;
    }

    public void setCurrent(Abono current) {
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
