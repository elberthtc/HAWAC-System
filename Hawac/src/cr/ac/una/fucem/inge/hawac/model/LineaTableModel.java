/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Linea;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import ferreteriaentidades.Linea;

public class LineaTableModel extends AbstractTableModel{
    
    List<Linea> rows;
    int[] cols;
    
    public LineaTableModel(int[] cols, List<Linea> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    @Override
    public int getRowCount() {
       return rows.size();
    }
     public Linea getRowAt(int row) {
        return rows.get(row);
    }
    public String getColumnName(int col){
        return colNames[cols[col]];
    } 

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Linea l1 = rows.get(rowIndex);
        switch (cols[columnIndex]){
            case CANTIDAD: return l1.getCantidad();
            case ARTICULO: return l1.getProducto().getDescripcion();
            case PRECIO_UNIT: return l1.getProducto().getPrecio();
            case TOTAL: return calculaPrecio(l1);
            default: return "";
    
        }
    }
    public double calculaPrecio(Linea l1){
        double precio = l1.getCantidad()*(double)l1.getProducto().getPrecio();
        return precio;
    }
    
    public static final int CANTIDAD=0;
    public static final int ARTICULO=1;
    public static final int PRECIO_UNIT=2;
    public static final int TOTAL=3;
    
    String[] colNames = new String[4];
     private void initColNames(){
        colNames[CANTIDAD]= "CANTIDAD";
        colNames[ARTICULO]= "ARTICULO";
        colNames[PRECIO_UNIT]="PRECIO/UNIT";
        colNames[TOTAL]="TOTAL";
    }
    
}
