/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;



import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class ApartadosModel extends java.util.Observable{
    Apartado filter; 
    ApartadoTableModel apartados;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public ApartadosModel() {
    }

    public void init(){ 
        filter = new Apartado();
        clearErrors();
        List<Apartado> rows = new ArrayList<Apartado>();
        this.setApartados(rows);
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public void setApartados(List<Apartado> apartados){
        int[] cols={ApartadoTableModel.CODIGO,ApartadoTableModel.CLIENTE,ApartadoTableModel.VENDEDOR,ApartadoTableModel.REALIZADO,ApartadoTableModel.LIMITE,ApartadoTableModel.PRODUCTO,ApartadoTableModel.SALDO};
        this.apartados =new ApartadoTableModel(cols,apartados);  
        setChanged();
        notifyObservers();        
    }    
    
    public Apartado getFilter() {
        return filter;
    }
    
    public void setFilter(Apartado filter) {
        this.filter = filter;
    }
    
     public ApartadoTableModel getApartados() {
        return apartados;
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
