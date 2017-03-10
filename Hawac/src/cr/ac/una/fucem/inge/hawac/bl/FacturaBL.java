/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class FacturaBL extends BaseBL implements IBaseBL<Factura, Integer>{
    public FacturaBL() {
        super();
    }
    
    @Override
    public void save(Factura o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Factura merge(Factura o) {
        return (Factura) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Factura o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Factura findById(Integer o) {
        return (Factura) this.getDao(Factura.class.getName()).findById(o);
    }

    @Override
    public List<Factura> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
