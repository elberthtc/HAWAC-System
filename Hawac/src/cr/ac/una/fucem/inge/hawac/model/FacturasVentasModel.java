/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class FacturasVentasModel extends java.util.Observable {
    Factura filtro;
    FacturaTableModel facturas;
    HashMap<String, String> errores;
    String mensaje;
    
    public FacturasVentasModel(){
        
    }
    
    public void init(){
        filtro = new Factura();
        clearErrors();
        List<Factura> filas = new ArrayList<Factura>();
        this.setFacturas(filas);
    }

    public void setFacturas(List<Factura> facturas) {
        int[] cols={FacturaTableModel.NUMERO,FacturaTableModel.CLIENTE,FacturaTableModel.VENDEDOR,FacturaTableModel.FECHA,FacturaTableModel.TOTAL};
        this.facturas = new FacturaTableModel(cols,facturas);
        setChanged();
        notifyObservers();
    }
    

    public Factura getFiltro() {
        return filtro;
    }

    public void setFiltro(Factura filtro) {
        this.filtro = filtro;
    }

    public FacturaTableModel getFacturas() {
        return facturas;
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
