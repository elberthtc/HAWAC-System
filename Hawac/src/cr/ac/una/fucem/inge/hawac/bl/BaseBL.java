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
 * @author a4e3g6o0
 */
public class BaseBL {
    private final LinkedHashMap<String, IBaseDAO> daos;

    public BaseBL() {
        daos = new LinkedHashMap();
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Abono", new AbonoDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Usuario", new UsuarioDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Inventario", new InventarioDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Producto", new ProductoDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Apartado", new ApartadoDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Bitacora", new BitacoraDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Cliente", new ClienteDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Factura", new FacturaDAO());
        daos.put("cr.ac.una.fucem.inge.hawac.domain.Linea", new LineaDAO());
    }
    
    public IBaseDAO getDao(String className){
        return daos.get(className);
    }
}
