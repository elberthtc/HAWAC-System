/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hawac;

import cr.ac.una.fucem.inge.hawac.bl.UsuarioBL;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;

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
        UsuarioBL uBL= new UsuarioBL();
        Usuario angel = new Usuario(1234,"43g01234",0);
        uBL.save(angel);
    }
    
}
