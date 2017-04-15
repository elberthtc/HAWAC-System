/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;


import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class BitacorasModel extends java.util.Observable{
    Bitacora filter; 
    BitacoraTableModel productos;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public BitacorasModel() {
    }

    public void init(){ 
        filter = new Bitacora();
        clearErrors();
        List<Bitacora> rows = new ArrayList<Bitacora>();
        this.setBitacoras(rows);
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public void setBitacoras(List<Bitacora> productos){
        int[] cols={BitacoraTableModel.NUMERO,BitacoraTableModel.DESCRIPCION,BitacoraTableModel.USUARIO,BitacoraTableModel.FECHA};
        this.productos =new BitacoraTableModel(cols,productos);  
        setChanged();
        notifyObservers();        
    }    
    
    public Bitacora getFilter() {
        return filter;
    }
    
    public void setFilter(Bitacora filter) {
        this.filter = filter;
    }
    
     public BitacoraTableModel getBitacoras() {
        return productos;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
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
    public void commit(){
        setChanged();
        notifyObservers();       
    }
    
}
