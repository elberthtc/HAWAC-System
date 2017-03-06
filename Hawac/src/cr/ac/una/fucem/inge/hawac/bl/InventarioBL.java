/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class InventarioBL extends BaseBL implements IBaseBL<Inventario, InventarioId>{
    public InventarioBL() {
        super();
    }
    
    @Override
    public void save(Inventario o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Inventario merge(Inventario o) {
        return (Inventario) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Inventario o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Inventario findById(InventarioId o) {
        return (Inventario) this.getDao(Inventario.class.getName()).findById(o);
    }

    @Override
    public List<Inventario> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
