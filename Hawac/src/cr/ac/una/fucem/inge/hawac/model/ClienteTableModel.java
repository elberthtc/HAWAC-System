/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import ferreteriaentidades.Cliente;


public class ClienteTableModel extends AbstractTableModel{
    
    List<Cliente> rows;
    int[] cols;

    public  ClienteTableModel(int[] cols, List<Cliente> rows){
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
        Cliente c1 = rows.get(row);
        switch (cols[col]){
            case ID: return c1.getCedula();
            case NOMBRE: return c1.getNombre();
            case TELEFONO: return c1.getTelefono();
            case CORREO: return c1.getCorreo();
            //case DESCUENTO: return c1.getPorcentajeDescuento();
            default: return "";
        }
    }    
    public Cliente getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int ID=0;
    public static final int NOMBRE=1;
    public static final int TELEFONO=2;
    public static final int CORREO=3;
    //public static final int DESCUENTO=4;

   
    
    String[] colNames = new String[5];
    private void initColNames(){
        colNames[ID]= "ID";
        colNames[NOMBRE]= "NOMBRE";
        colNames[TELEFONO]="TELEFONO";
        colNames[CORREO]="CORREO";
        //colNames[DESCUENTO]="DESCUENTO";
    }
            
}