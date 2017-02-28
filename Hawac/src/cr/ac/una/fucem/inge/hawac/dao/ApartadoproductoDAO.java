/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Apartadoproducto;
import cr.ac.una.fucem.inge.hawac.domain.ApartadoproductoId;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class ApartadoproductoDAO extends NewHibernateUtil implements IBaseDAO<Apartadoproducto, ApartadoproductoId>{

    @Override
    public void save(Apartadoproducto o) {
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
    public Apartadoproducto merge(Apartadoproducto o) {
        try {
            iniciaOperacion();
            o = (Apartadoproducto) getSession().merge(o);
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
    public void delete(Apartadoproducto o) {
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
    public Apartadoproducto findById(ApartadoproductoId id) {
        Apartadoproducto abono = null;

        try {
            iniciaOperacion();
            abono = (Apartadoproducto) getSession().get(Apartadoproducto.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Apartadoproducto> findAll() {
        List<Apartadoproducto> listaApartadoproductos;
        try {
            iniciaOperacion();
            listaApartadoproductos = getSession().createQuery("from Apartadoproducto").list();
        } finally {
            getSession().close();
        }

        return listaApartadoproductos;
    }
    
}
