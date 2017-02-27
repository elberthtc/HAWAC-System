/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.dao.*;
import java.util.LinkedHashMap;

/**
 *
 * @author chgari
 */
public class BaseBL {
    private final LinkedHashMap<String, IBaseDAO> daos;

    public BaseBL() {
        daos = new LinkedHashMap();
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Abono", new AbonoDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Usuario", new UsuarioDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Inventario", new InventarioDAO());
    }
    
    public IBaseDAO getDao(String className){
        return daos.get(className);
    }
}
