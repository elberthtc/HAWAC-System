/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class ApartadoDAO extends NewHibernateUtil implements IBaseDAO<Apartado, Integer>{

    @Override
    public void save(Apartado o) {
           try {
            iniciaOperacion();
            getSession().save(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaException(he);
            System.out.println(he.toString());
            throw he;
        } finally {
            getSession().close();
        }
    }

    @Override
    public Apartado merge(Apartado o) {
        try {
            iniciaOperacion();
            o = (Apartado) getSession().merge(o);
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
    public void delete(Apartado o) {
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
    public Apartado findById(Integer id) {
        Apartado abono = null;

        try {
            iniciaOperacion();
            abono = (Apartado) getSession().get(Apartado.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Apartado> findAll() {
        List<Apartado> listaApartados;
        try {
            iniciaOperacion();
            listaApartados = getSession().createQuery("from Apartado").list();
        } finally {
            getSession().close();
        }

        return listaApartados;
    }
    
}
