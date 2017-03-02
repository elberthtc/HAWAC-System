/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import ferreteriaentidades.Producto;


public class ProductoTableModel extends AbstractTableModel{
    
    List<Producto> rows;
    int[] cols;

    public  ProductoTableModel(int[] cols, List<Producto> rows){
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
        Producto c1 = rows.get(row);
        switch (cols[col]){
            case CODIGO: return c1.getIdProducto();
            case DESCRIPCION: return c1.getDescripcion();
            case EXISTENCIA: return 10;//c1.getExistencias();
            case PRECIO: return c1.getPrecio();
            default: return "";
        }
    }    
    public Producto getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int CODIGO=0;
    public static final int DESCRIPCION=1;
    public static final int EXISTENCIA=2;
    public static final int PRECIO=3;
    

   
    
    String[] colNames = new String[4];
    private void initColNames(){
        colNames[CODIGO]= "CODIGO";
        colNames[DESCRIPCION]= "DESCRIPCION";
        colNames[EXISTENCIA]="EXISTENCIAS";
        colNames[PRECIO]="PRECIO";
    }
            
}
