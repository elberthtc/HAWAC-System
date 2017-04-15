/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class BitacoraTableModel extends AbstractTableModel{
    
    List<Bitacora> rows;
    int[] cols;

    public  BitacoraTableModel(int[] cols, List<Bitacora> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }   
    
    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Bitacora c1 = rows.get(row);
        switch (cols[col]){
            case NUMERO: return c1.getEntrada();
            case DESCRIPCION: return c1.getDescripcion();
            case USUARIO: return c1.getU().getNombre();
            case FECHA: return c1.getFecha();
            default: return "";
        }
    }
    
    public Bitacora getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int NUMERO=0;
    public static final int DESCRIPCION=1;
    public static final int USUARIO=2;
    public static final int FECHA=3;
    
    String[] colNames = new String[4];
    private void initColNames(){
        colNames[NUMERO]= "NUMERO";
        colNames[DESCRIPCION]= "DESCRIPCION";
        colNames[USUARIO]="USUARIO";
        colNames[FECHA]="FECHA";
    }
            
}
