package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Producto;
import java.util.HashMap;

public class ProductoModel extends java.util.Observable {
    Producto current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public ProductoModel() {
    }

    public void init(){
        setCurrent(new Producto());
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
    public Producto getCurrent() {
        return current;
    }

    public void setCurrent(Producto current) {
        this.current = current;
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
