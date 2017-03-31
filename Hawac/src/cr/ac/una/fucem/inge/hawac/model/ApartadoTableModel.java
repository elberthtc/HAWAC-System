/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;


import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ApartadoTableModel extends AbstractTableModel{
    
    List<Apartado> rows;
    int[] cols;

    public  ApartadoTableModel(int[] cols, List<Apartado> rows){
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
        Apartado c1 = rows.get(row);
        switch (cols[col]){
            case CODIGO: return c1.getIdApartado();
            case CLIENTE: return c1.getC().getNombre();
            case VENDEDOR: return c1.getU().getNombre();
            case REALIZADO: return c1.getFechaRealizado();
            case LIMITE: return c1.getFechaLimite();
            case PRODUCTO: return c1.getP().getDescripcion();
            case SALDO: return c1.getSaldo();
            default: return "";
        }
    }
    
    public Apartado getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int CODIGO=0;
    public static final int CLIENTE=1;
    public static final int VENDEDOR=2;
    public static final int REALIZADO=3;
    public static final int LIMITE=4;
    public static final int PRODUCTO=5;
    public static final int SALDO=6;
    
    

   
    
    String[] colNames = new String[7];
    private void initColNames(){
        colNames[CODIGO]= "CODIGO";
        colNames[CLIENTE]= "CLIENTE";
        colNames[VENDEDOR]= "VENDEDOR";
        colNames[REALIZADO]="REALIZADO";
        colNames[LIMITE]="LIMITE";
        colNames[PRODUCTO]="PRODUCTO";
        colNames[SALDO]="SALDO";
    }
            
}
