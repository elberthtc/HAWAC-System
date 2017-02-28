/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class InventarioDAO extends NewHibernateUtil implements IBaseDAO<Inventario, InventarioId>{

    @Override
    public void save(Inventario o) {
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
    public Inventario merge(Inventario o) {
        try {
            iniciaOperacion();
            o = (Inventario) getSession().merge(o);
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
    public void delete(Inventario o) {
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
    public Inventario findById(InventarioId id) {
        Inventario abono = null;

        try {
            iniciaOperacion();
            abono = (Inventario) getSession().get(Inventario.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Inventario> findAll() {
        List<Inventario> listaInventarios;
        try {
            iniciaOperacion();
            listaInventarios = getSession().createQuery("from Inventario").list();
        } finally {
            getSession().close();
        }

        return listaInventarios;
    }
    
}
