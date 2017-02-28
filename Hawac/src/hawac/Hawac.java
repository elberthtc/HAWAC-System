/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hawac;

import cr.ac.una.fucem.inge.hawac.bl.*;
import cr.ac.una.fucem.inge.hawac.domain.*;

/**
 *
 * @author Josue
 */
public class Hawac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println("Wlliam es un banano");
        ProductoBL uBL= new ProductoBL();
        Producto angel = new Producto(5500,"Camisa cuello V","M","Negra",true);
        //uBL.save(angel);
        angel.setIdProducto(1);
        Inventario i = new Inventario(new InventarioId("tienda",1),angel,10); 
        InventarioBL iBl = new InventarioBL();
        iBl.save(i);
        
    }
    
}
