/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class ProductoDAO extends NewHibernateUtil implements IBaseDAO<Producto, Integer>{

    @Override
    public void save(Producto o) {
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
    public Producto merge(Producto o) {
        try {
            iniciaOperacion();
            o = (Producto) getSession().merge(o);
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
    public void delete(Producto o) {
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
    public Producto findById(Integer id) {
        Producto abono = null;

        try {
            iniciaOperacion();
            abono = (Producto) getSession().get(Producto.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> listaProductos;
        try {
            iniciaOperacion();
            listaProductos = getSession().createQuery("from Producto").list();
        } finally {
            getSession().close();
        }

        return listaProductos;
    }
    
}
