/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Abono;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author chgari
 */
public class AbonoDAO extends NewHibernateUtil implements IBaseDAO<Abono, Integer>{

    @Override
    public void save(Abono o) {
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
    public Abono merge(Abono o) {
        try {
            iniciaOperacion();
            o = (Abono) getSession().merge(o);
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
    public void delete(Abono o) {
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
    public Abono findById(Integer id) {
        Abono abono = null;

        try {
            iniciaOperacion();
            abono = (Abono) getSession().get(Abono.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Abono> findAll() {
        List<Abono> listaAbonos;
        try {
            iniciaOperacion();
            listaAbonos = getSession().createQuery("from Abono").list();
        } finally {
            getSession().close();
        }

        return listaAbonos;
    }
    
}
