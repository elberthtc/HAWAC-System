/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class ApartadoBL extends BaseBL implements IBaseBL<Apartado, Integer>{
    public ApartadoBL() {
        super();
    }
    
    @Override
    public void save(Apartado o) {
        int n = o.getIdApartado();
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Apartado merge(Apartado o) {
        return (Apartado) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Apartado o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Apartado findById(Integer o) {
        return (Apartado) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Apartado> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
