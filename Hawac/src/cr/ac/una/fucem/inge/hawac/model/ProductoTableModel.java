/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


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
            case TALLA: return c1.getTalla();
            case PRECIO: return c1.getPrecio();
            case COLOR: return c1.getColor();
            case GENERO: if(c1.isGenero()){
                return "Masculino";
            }
            else
                return "Femenino";
            default: return "";
        }
    }    
    public Producto getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int CODIGO=0;
    public static final int DESCRIPCION=1;
    public static final int TALLA=2;
    public static final int PRECIO=3;
    public static final int COLOR=4;
    public static final int GENERO=5;
    
    

   
    
    String[] colNames = new String[6];
    private void initColNames(){
        colNames[CODIGO]= "CODIGO";
        colNames[DESCRIPCION]= "DESCRIPCION";
        colNames[TALLA]="TALLA";
        colNames[PRECIO]="PRECIO";
        colNames[COLOR]="COLOR";
        colNames[GENERO]="GENERO";
    }
            
}
