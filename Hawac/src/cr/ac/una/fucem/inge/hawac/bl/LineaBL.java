/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.LineaId;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class LineaBL extends BaseBL implements IBaseBL<Linea, LineaId>{
    public LineaBL() {
        super();
    }
    
    @Override
    public void save(Linea o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Linea merge(Linea o) {
        return (Linea) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Linea o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Linea findById(LineaId o) {
        return (Linea) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Linea> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
