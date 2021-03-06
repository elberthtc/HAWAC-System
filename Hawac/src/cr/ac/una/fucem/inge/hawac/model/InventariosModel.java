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
        this.setInventarios(filas);
    }
    
    public void setInventarios(List<Inventario> empleados){
        int[] cols={InventarioTableModel.PRODUCTO,InventarioTableModel.NOMBRE,InventarioTableModel.CANTIDAD};
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
    
    public InventarioTableModel getInventarios(){
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
