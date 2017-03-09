
package cr.ac.una.fucem.inge.hawac.model;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import java.util.HashMap;

public class InventarioModel extends java.util.Observable {
    Inventario current;
    Producto productoActual;
    HashMap<String, String> errores;
    String mensaje;
    int modo;
    
    public InventarioModel(){
        
    }
    
    public void init(){
        setCurrent(new Inventario());
        this.setProductoActual(new Producto());
        clearErrors();
    }
    
    public int getModo(){
        return modo;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setModo(int mod){
        modo=mod;
    }
    
    public void setMensaje(String men){
        mensaje=men;
    }
    
    public HashMap<String,String> getErrores(){
        return errores;
    }
    
    public void setErrores(HashMap<String, String> errores){
        this.errores=errores;
    }
    
    public Inventario getCurrent(){
        return current;
    }
    
    public void setCurrent(Inventario curr){
        current=curr;
        setChanged();
        notifyObservers();
    }
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
    }
    
    @Override
    public void addObserver(java.util.Observer o){
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public Producto getProductoActual() {
        return productoActual;
    }

    public void setProductoActual(Producto productoActual) {
        this.productoActual = productoActual;
    }
    
    
}
