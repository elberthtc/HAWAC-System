/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
//import ferreteriaentidades.Usuario;

public class UsuariosModel extends java.util.Observable {
    Usuario filtro;
    UsuarioTableModel empleados;
    HashMap<String, String> errores;
    String mensaje;
    
    public UsuariosModel(){
        
    }
    
    public void inicializar(){
        filtro= new Usuario();
        borrarErrores();
        List<Usuario> filas= new ArrayList<Usuario>();
        this.setUsuarios(filas);
    }
    
    public void setUsuarios(List<Usuario> empleados){
        int[] cols={UsuarioTableModel.ID,UsuarioTableModel.CLAVE,UsuarioTableModel.TIPO};
        this.empleados= new UsuarioTableModel(cols, empleados);
        setChanged();
        notifyObservers();
    }
    
    public Usuario getFiltro(){
        return filtro;
    }
    
    public void setFiltro(Usuario filt){
        this.filtro=filt;
    }
    
    public UsuarioTableModel getUsuarios(){
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
