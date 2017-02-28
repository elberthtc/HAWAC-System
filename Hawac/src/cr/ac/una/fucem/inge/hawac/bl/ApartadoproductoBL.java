/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Apartadoproducto;
import cr.ac.una.fucem.inge.hawac.domain.ApartadoproductoId;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class ApartadoproductoBL extends BaseBL implements IBaseBL<Apartadoproducto, ApartadoproductoId>{
    public ApartadoproductoBL() {
        super();
    }
    
    @Override
    public void save(Apartadoproducto o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Apartadoproducto merge(Apartadoproducto o) {
        return (Apartadoproducto) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Apartadoproducto o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Apartadoproducto findById(ApartadoproductoId o) {
        return (Apartadoproducto) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Apartadoproducto> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
