/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class FacturaDAO extends NewHibernateUtil implements IBaseDAO<Factura, Integer>{

    @Override
    public void save(Factura o) {
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
    public Factura merge(Factura o) {
        try {
            iniciaOperacion();
            o = (Factura) getSession().merge(o);
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
    public void delete(Factura o) {
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
    public Factura findById(Integer id) {
        Factura abono = null;

        try {
            iniciaOperacion();
            abono = (Factura) getSession().get(Factura.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Factura> findAll() {
        List<Factura> listaFacturas;
        try {
            iniciaOperacion();
            listaFacturas = getSession().createQuery("from Factura").list();
        } finally {
            getSession().close();
        }

        return listaFacturas;
    }
    
}
