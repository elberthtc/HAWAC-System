/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import java.util.HashMap;
//import ferreteriaentidades.Empleado;

public class LoginModel extends java.util.Observable{
    Usuario current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;
    
    public LoginModel(){
        setCurrent(new Usuario());
        clearErrors();
    }

    public Usuario getCurrent() {
        return current;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
        setChanged();
        this.notifyObservers();
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public HashMap<String, String> getErrores(){
        return errores;
    }
    public void setErrores(HashMap<String, String> errores){
        this.errores = errores;
    }
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");  
    }
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}

