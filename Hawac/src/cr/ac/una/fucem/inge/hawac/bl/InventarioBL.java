/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import java.util.List;

/**
 *
 * @author chgari
 */
public class InventarioBL extends BaseBL implements IBaseBL<Inventario, String>{
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
    public Inventario findById(String o) {
        return (Inventario) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Inventario> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
