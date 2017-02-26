/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Abono;
import java.util.List;

/**
 *
 * @author chgari
 */
public class AbonoBL extends BaseBL implements IBaseBL<Abono, Integer>{
    public AbonoBL() {
        super();
    }
    
    @Override
    public void save(Abono o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Abono merge(Abono o) {
        return (Abono) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Abono o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Abono findById(Integer o) {
        return (Abono) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Abono> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
