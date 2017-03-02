/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.model;

//import ferreteria.Application;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import ferreteriaentidades.Usuario;

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
            case TIPO: return puesto(empl);
            default: return "";
        }
    }
    private String puesto(Usuario e){
        String puesto="";
        if(e.getTipo()==0) puesto="Administrador";
        if(e.getTipo()==1) puesto="Dependiente";
        return puesto;
    }
  
    
    public static final int ID=0;
    public static final int CLAVE=1;
    public static final int TIPO=2;

    
    String [] colNombs= new String[3];
    private void inicializarNombCols(){
        colNombs[ID]="ID";
        colNombs[CLAVE]="CLAVE";
        colNombs[TIPO]="TIPO";

    }

}
