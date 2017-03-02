/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.bl;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import java.util.List;

/**
 *
 * @author a4e3g6o0
 */
public class ClienteBL extends BaseBL implements IBaseBL<Cliente, Integer>{
    public ClienteBL() {
        super();
    }
    
    @Override
    public void save(Cliente o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Cliente merge(Cliente o) {
        return (Cliente) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Cliente o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Cliente findById(Integer o) {
        return (Cliente) this.getDao(o.getClass().getName()).findById(o);
    }

    @Override
    public List<Cliente> findAll(String className) {
        //Cliente c = new Cliente();
        return this.getDao(className).findAll();
    }
    
}
