/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Producto;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class ProductoBL extends BaseBL implements IBaseBL<Producto, Integer>{
    public ProductoBL() {
        super();
    }
    
    @Override
    public void save(Producto o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Producto merge(Producto o) {
        return (Producto) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Producto o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Producto findById(Integer o) {
        return (Producto) this.getDao(Producto.class.getName()).findById(o);
    }

    @Override
    public List<Producto> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
