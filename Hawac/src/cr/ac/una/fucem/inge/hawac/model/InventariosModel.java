/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class InventariosModel extends java.util.Observable {
    Inventario filtro;
    InventarioTableModel empleados;
    HashMap<String, String> errores;
    String mensaje;
    
    public InventariosModel(){
        
    }
    
    public void inicializar(){
        filtro= new Inventario();
        borrarErrores();
        List<Inventario> filas= new ArrayList<Inventario>();
        this.setUsuarios(filas);
    }
    
    public void setUsuarios(List<Inventario> empleados){
        int[] cols={InventarioTableModel.PRODUCTO,InventarioTableModel.CANTIDAD,InventarioTableModel.INVENTARIO,InventarioTableModel.ESTADO};
        this.empleados= new InventarioTableModel(cols, empleados);
        setChanged();
        notifyObservers();
    }
    
    public Inventario getFiltro(){
        return filtro;
    }
    
    public void setFiltro(Inventario filt){
        this.filtro=filt;
    }
    
    public InventarioTableModel getUsuarios(){
        return empleados;
    }
    
     @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setMensaje(String mens){
        this.mensaje=mens;
    }
    
    public HashMap<String,String> getErrores(){
        return errores;
    }
    
    public void setErrores(HashMap<String,String> errores){
        this.errores=errores;
    }
    
    public void borrarErrores(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
    }
    public void commit(){
        setChanged();
        notifyObservers();       
    }
}
