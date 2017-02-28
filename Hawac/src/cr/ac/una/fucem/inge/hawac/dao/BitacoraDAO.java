/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class BitacoraDAO extends NewHibernateUtil implements IBaseDAO<Bitacora, Integer>{

    @Override
    public void save(Bitacora o) {
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
    public Bitacora merge(Bitacora o) {
        try {
            iniciaOperacion();
            o = (Bitacora) getSession().merge(o);
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
    public void delete(Bitacora o) {
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
    public Bitacora findById(Integer id) {
        Bitacora abono = null;

        try {
            iniciaOperacion();
            abono = (Bitacora) getSession().get(Bitacora.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Bitacora> findAll() {
        List<Bitacora> listaBitacoras;
        try {
            iniciaOperacion();
            listaBitacoras = getSession().createQuery("from Bitacora").list();
        } finally {
            getSession().close();
        }

        return listaBitacoras;
    }
    
}
