/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FacturaTableModel extends AbstractTableModel{
    
    List<Factura> rows;
    int[] cols;
    
    public FacturaTableModel(int[] cols, List<Factura> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    @Override
    public int getRowCount() {
       return rows.size();
    }

    public Factura getRowAt(int row) {
        return rows.get(row);
    }
    @Override
    public int getColumnCount() {
         return cols.length;
    }
    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura f1 = rows.get(rowIndex);
        switch (cols[columnIndex]){
            case NUMERO: return f1.getCodigoFactura();
            case CLIENTE: return f1.getC().getNombre();
            case VENDEDOR: return f1.getU().getNombre();
            case FECHA: return f1.getFecha();
            case TOTAL: return f1.getMonto();
            default: return "";
        }
    }
    
    public static final int NUMERO=0;
    public static final int CLIENTE=1;
    public static final int VENDEDOR=2;
    public static final int FECHA=3;
    public static final int TOTAL=4;
    
    String[] colNames = new String[5];
     private void initColNames(){
        colNames[NUMERO]= "NUMERO";
        colNames[CLIENTE]= "CLIENTE";
        colNames[VENDEDOR]= "VENDEDOR";
        colNames[FECHA]="FECHA";
        colNames[TOTAL]="TOTAL";
    }
    
}
