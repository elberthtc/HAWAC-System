/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import java.util.HashMap;
/*import ferreteriaentidades.Linea;
import ferreteriaentidades.Factura;
import ferreteriaentidades.Producto;*/

public class LineaModel extends java.util.Observable {
    Linea current;
    HashMap<String, String> errores;
    Factura factura;
    Producto producto;
    String mensaje;
    int modo;
    
    public LineaModel(){
        
    }
//    public void init(){
//        setPuestos(puestos);
//        setCurrent(new Empleado());
//        clearErrors();
//    }

    public Linea getCurrent() {
        return current;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public Factura getFactura() {
        return factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getModo() {
        return modo;
    }

    public void setCurrent(Linea current) {
        this.current = current;
        setChanged();
        notifyObservers();
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setModo(int modo) {
        this.modo = modo;
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