package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class InventarioTableModel extends AbstractTableModel {
    
    List<Inventario> filas;
    int[] columnas;
    
    public InventarioTableModel(int[] cols, List<Inventario> fils){
        this.columnas=cols;
        this.filas=fils;
        inicializarNombCols();
    }
   
    public String getColumnName(int col){
        return colNombs[columnas[col]];
    }
    
    public Inventario getFila(int fil){
        return filas.get(fil);
    }
       
    public int getRowCount() {
         return filas.size();
    }

    public int getColumnCount() {
        return columnas.length;
    }

    public Object getValueAt(int fila, int columna) {
        Inventario empl= filas.get(fila);
        switch(columnas[columna]){
            case PRODUCTO: return empl.getId().getProducto();
            case CANTIDAD: return empl.getCantidad();
            case NOMBRE: return empl.getProducto().getDescripcion();
            default: return "";
        }
    }
  
    
    public static final int PRODUCTO=0;
    public static final int CANTIDAD=2;
    public static final int NOMBRE=1;

    
    String [] colNombs= new String[3];
    private void inicializarNombCols(){
        colNombs[PRODUCTO]="PRODUCTO";
        colNombs[CANTIDAD]="CANTIDAD";
        colNombs[NOMBRE]="NOMBRE";
    }
}
