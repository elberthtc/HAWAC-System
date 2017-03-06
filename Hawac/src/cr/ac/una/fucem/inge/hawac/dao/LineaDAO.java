/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.LineaId;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Josue
 */
public class LineaDAO extends NewHibernateUtil implements IBaseDAO<Linea, LineaId>{

    @Override
    public void save(Linea o) {
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
    public Linea merge(Linea o) {
        try {
            iniciaOperacion();
            o = (Linea) getSession().merge(o);
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
    public void delete(Linea o) {
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
    public Linea findById(LineaId id) {
        Linea abono = null;

        try {
            iniciaOperacion();
            abono = (Linea) getSession().get(Linea.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Linea> findAll() {
        List<Linea> listaLineas;
        try {
            iniciaOperacion();
            listaLineas = getSession().createQuery("from Linea").list();
        } finally {
            getSession().close();
        }

        return listaLineas;
    }
    
}
