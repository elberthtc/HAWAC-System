
package cr.ac.una.fucem.inge.hawac.model;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import java.util.HashMap;

public class UsuarioModel extends java.util.Observable {
    Usuario current;
    HashMap<String, String> errores;
    String mensaje;
    int modo;
    
    public UsuarioModel(){
        
    }
    
    public void init(){
        setCurrent(new Usuario());
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
    
    public Usuario getCurrent(){
        return current;
    }
    
    public void setCurrent(Usuario curr){
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
    
    
}
