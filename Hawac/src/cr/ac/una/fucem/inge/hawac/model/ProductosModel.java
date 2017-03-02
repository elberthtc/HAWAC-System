/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;


import cr.ac.una.fucem.inge.hawac.domain.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
//import ferreteriaentidades.Producto;


public class ProductosModel extends java.util.Observable{
    Producto filter; 
    ProductoTableModel productos;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public ProductosModel() {
    }

    public void init(){ 
        filter = new Producto();
        clearErrors();
        List<Producto> rows = new ArrayList<Producto>();
        this.setProductos(rows);
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public void setProductos(List<Producto> productos){
        int[] cols={ProductoTableModel.CODIGO,ProductoTableModel.DESCRIPCION,ProductoTableModel.EXISTENCIA,ProductoTableModel.PRECIO};
        this.productos =new ProductoTableModel(cols,productos);  
        setChanged();
        notifyObservers();        
    }    
    public Producto getFilter() {
        return filter;
    }
    
    public void setFilter(Producto filter) {
        this.filter = filter;
    }
    
     public ProductoTableModel getProductos() {
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
