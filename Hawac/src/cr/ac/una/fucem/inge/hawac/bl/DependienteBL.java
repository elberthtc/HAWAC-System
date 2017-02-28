/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Dependiente;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class DependienteBL extends BaseBL implements IBaseBL<Dependiente, Integer>{
    public DependienteBL() {
        super();
    }
    
    @Override
    public void save(Dependiente o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Dependiente merge(Dependiente o) {
        return (Dependiente) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Dependiente o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Dependiente findById(Integer o) {
        return (Dependiente) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Dependiente> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
