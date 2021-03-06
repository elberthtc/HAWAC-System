/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {
    
    List<Usuario> filas;
    int[] columnas;
    
    public UsuarioTableModel(int[] cols, List<Usuario> fils){
        this.columnas=cols;
        this.filas=fils;
        inicializarNombCols();
    }
   
    public String getColumnName(int col){
        return colNombs[columnas[col]];
    }
    
    public Usuario getFila(int fil){
        return filas.get(fil);
    }
       
    public int getRowCount() {
         return filas.size();
    }

    public int getColumnCount() {
        return columnas.length;
    }

    public Object getValueAt(int fila, int columna) {
        Usuario empl= filas.get(fila);
        switch(columnas[columna]){
            case ID: return empl.getIdUsuario();
            case CLAVE: return empl.getPassword();
            case NOMBRE: return empl.getNombre();
            case TIPO: {
                if (empl.getTipo() == 0) {
                    return "Administrador";
                } else
                    return "Dependiente";
            }
            default: return "";
        }
    }
  
    
    public static final int ID=0;
    public static final int CLAVE=1;
    public static final int NOMBRE=2;
    public static final int TIPO=3;

    
    String [] colNombs= new String[4];
    private void inicializarNombCols(){
        colNombs[ID]="ID";
        colNombs[CLAVE]="CLAVE";
        colNombs[NOMBRE]="NOMBRE";
        colNombs[TIPO]="TIPO";
    }

}
