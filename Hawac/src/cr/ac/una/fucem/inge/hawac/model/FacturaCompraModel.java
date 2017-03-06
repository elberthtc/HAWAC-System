/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class FacturaCompraModel extends java.util.Observable {
    
    /*
    
    FacturaCompra current;
    Empleado empleado;
    Linea filtro;
    LineaTableModel lineas;
    HashMap<String,String> errores;
    String mensaje;
    
    public FacturaCompraModel(){
        
    }
    public void init(){ 
        current = new FacturaCompra();
        empleado = new Empleado();
        filtro = new Linea();
        clearErrors();
        List<Linea> rows = new ArrayList<Linea>();
        this.setLineas(rows);
    }

    public FacturaCompra getCurrent() {
        return current;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Linea getFiltro() {
        return filtro;
    }

    public void setFiltro(Linea filtro) {
        this.filtro = filtro;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setLineas(List<Linea> lineas) {
        int[] cols={LineaTableModel.CANTIDAD,LineaTableModel.ARTICULO,LineaTableModel.PRECIO_UNIT,LineaTableModel.TOTAL}; 
        this.lineas = new LineaTableModel(cols,lineas);
        setChanged();
        notifyObservers();
    }

    public LineaTableModel getLineas() {
        return lineas;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setCurrent(FacturaCompra filter) {
        this.current = filter;
        setChanged();
        notifyObservers();
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje(""); 
    }
    
    public void commit(){
        setChanged();
        notifyObservers();       
    }
    
    */
    
}
