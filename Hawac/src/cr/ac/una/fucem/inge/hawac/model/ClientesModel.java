/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;
import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
//import ferreteriaentidades.Cliente;


public class ClientesModel extends java.util.Observable{
    Cliente filter; 
    ClienteTableModel clientes;
    HashMap<String,String> errores;
    String mensaje;

    public ClientesModel() {
    }

    public void init(){ 
        filter = new Cliente();
        clearErrors();
        List<Cliente> rows = new ArrayList<Cliente>();
        this.setClientes(rows);
    }
    
    public void setClientes(List<Cliente> clientes){
        int[] cols={ClienteTableModel.ID,ClienteTableModel.NOMBRE,ClienteTableModel.CORREO,ClienteTableModel.TELEFONO/*,ClienteTableModel.DESCUENTO*/};
        this.clientes =new ClienteTableModel(cols,clientes);  
        setChanged();
        notifyObservers();        
    }    
    public Cliente getFilter() {
        return filter;
    }
    
    public void setFilter(Cliente filter) {
        this.filter = filter;
    }
    
     public ClienteTableModel getClientes() {
        return clientes;
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

