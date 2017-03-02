/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import ferreteriaentidades.Factura;

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
            case CLIENTE: return f1.getCliente().getNombre();
            case VENDEDOR: return f1.getDependiente().getNombreDependiente();
            //case FORMA_DE_PAGO: return f1.getTipoPago();
            case TOTAL: return f1.getMonto();
            default: return "";
        }
    }
    
    public static final int NUMERO=0;
    public static final int CLIENTE=1;
    public static final int VENDEDOR=2;
    //public static final int FORMA_DE_PAGO=3;
    public static final int TOTAL=4;
    
    String[] colNames = new String[5];
     private void initColNames(){
        colNames[NUMERO]= "NUMERO";
        colNames[CLIENTE]= "CLIENTE";
        colNames[VENDEDOR]= "VENDEDOR";
      //  colNames[FORMA_DE_PAGO]="FORMA DE PAGO";
        colNames[TOTAL]="TOTAL";
    }
    
}
