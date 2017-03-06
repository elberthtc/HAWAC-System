/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;
import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class FacturaModel extends java.util.Observable {
    Factura current;
    Cliente cliente;
    Usuario empleado;
    Linea filtro;
    LineaTableModel lineas;
    HashMap<String,String> errores;
    String mensaje;
    
    public FacturaModel(){
    }
    
    public void init(){ 
        current = new Factura();
        cliente = new Cliente();
        empleado = new Usuario();
        filtro = new Linea();
        clearErrors();
        List<Linea> rows = new ArrayList<Linea>();
        this.setLineas(rows);
    }

    public Factura getCurrent() {
        return current;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        setChanged();
        notifyObservers(); 
    }

    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
        setChanged();
        notifyObservers(); 
    }

    public Linea getFiltro() {
        return filtro;
    }

    public void setFiltro(Linea filtro) {
        this.filtro = filtro;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public Usuario getEmpleado() {
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

    public void setCurrent(Factura filter) {
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
    
}
