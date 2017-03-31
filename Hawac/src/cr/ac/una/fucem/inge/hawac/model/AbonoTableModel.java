/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;


import cr.ac.una.fucem.inge.hawac.domain.Abono;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class AbonoTableModel extends AbstractTableModel{
    
    List<Abono> rows;
    int[] cols;

    public  AbonoTableModel(int[] cols, List<Abono> rows){
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
        Abono c1 = rows.get(row);
        switch (cols[col]){
            case CODIGO: return c1.getIdAbonos();
            case APARTADO: return c1.getApartado();
            case VENDEDOR: return c1.getU().getNombre();
            case REALIZADO: return c1.getFechaRealizado();
            case MONTO: return c1.getMonto();
            case SALDO: return c1.getSaldo();
            default: return "";
        }
    }
    
    public Abono getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int CODIGO=0;
    public static final int APARTADO=1;
    public static final int VENDEDOR=2;
    public static final int REALIZADO=3;
    public static final int MONTO=4;
    public static final int SALDO=5;
    
    

   
    
    String[] colNames = new String[6];
    private void initColNames(){
        colNames[CODIGO]= "CODIGO";
        colNames[APARTADO]= "APARTADO";
        colNames[VENDEDOR]= "VENDEDOR";
        colNames[REALIZADO]="REALIZADO";
        colNames[MONTO]="MONTO";
        colNames[SALDO]="SALDO";
    }
            
}
