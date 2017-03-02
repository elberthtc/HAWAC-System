/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;


import java.util.HashMap;
//import ferreteriaentidades.Efectivo;


public class EfectivoModel extends java.util.Observable {
  //  Efectivo current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public EfectivoModel() {
    }

    public void init(){
    //    setCurrent(new Efectivo());
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
    /*public Efectivo getCurrent() {
        return current;
    }

    public void setCurrent(Efectivo current) {
        this.current = current;
        setChanged();
        notifyObservers();        
    }
*/
  
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
