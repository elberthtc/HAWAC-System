/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Dependiente;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class DependienteDAO extends NewHibernateUtil implements IBaseDAO<Dependiente, Integer>{

    @Override
    public void save(Dependiente o) {
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
    public Dependiente merge(Dependiente o) {
        try {
            iniciaOperacion();
            o = (Dependiente) getSession().merge(o);
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
    public void delete(Dependiente o) {
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
    public Dependiente findById(Integer id) {
        Dependiente abono = null;

        try {
            iniciaOperacion();
            abono = (Dependiente) getSession().get(Dependiente.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Dependiente> findAll() {
        List<Dependiente> listaDependientes;
        try {
            iniciaOperacion();
            listaDependientes = getSession().createQuery("from Dependiente").list();
        } finally {
            getSession().close();
        }

        return listaDependientes;
    }
    
}
