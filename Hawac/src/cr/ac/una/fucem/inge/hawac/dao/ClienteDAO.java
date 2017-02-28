/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class ClienteDAO extends NewHibernateUtil implements IBaseDAO<Cliente, Integer>{

    @Override
    public void save(Cliente o) {
           try {
            iniciaOperacion();
            getSession().save(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            getSession().close();
        }
    }

    @Override
    public Cliente merge(Cliente o) {
        try {
            iniciaOperacion();
            o = (Cliente) getSession().merge(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            getSession().close();
        }
        return o;
    }

    @Override
    public void delete(Cliente o) {
        try {
            iniciaOperacion();
            getSession().delete(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            getSession().close();
        }
    }

    @Override
    public Cliente findById(Integer id) {
        Cliente abono = null;

        try {
            iniciaOperacion();
            abono = (Cliente) getSession().get(Cliente.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> listaClientes;
        try {
            iniciaOperacion();
            listaClientes = getSession().createQuery("from Cliente").list();
        } finally {
            getSession().close();
        }

        return listaClientes;
    }
    
}
