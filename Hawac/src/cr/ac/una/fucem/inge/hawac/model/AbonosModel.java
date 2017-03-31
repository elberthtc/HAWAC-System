/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;



import cr.ac.una.fucem.inge.hawac.domain.Abono;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class AbonosModel extends java.util.Observable{
    Abono filter; 
    AbonoTableModel abonos;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public AbonosModel() {
    }

    public void init(){ 
        filter = new Abono();
        clearErrors();
        List<Abono> rows = new ArrayList<Abono>();
        this.setAbonos(rows);
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public void setAbonos(List<Abono> abonos){
        int[] cols={AbonoTableModel.CODIGO,AbonoTableModel.APARTADO,AbonoTableModel.VENDEDOR,AbonoTableModel.REALIZADO,AbonoTableModel.MONTO,AbonoTableModel.SALDO};
        this.abonos =new AbonoTableModel(cols,abonos);  
        setChanged();
        notifyObservers();        
    }    
    
    public Abono getFilter() {
        return filter;
    }
    
    public void setFilter(Abono filter) {
        this.filter = filter;
    }
    
     public AbonoTableModel getAbonos() {
        return abonos;
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
