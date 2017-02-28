/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.dao;

import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.utils.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author a4e3g6o0
 */
public class UsuarioDAO extends NewHibernateUtil implements IBaseDAO<Usuario, Integer>{

    @Override
    public void save(Usuario o) {
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
    public Usuario merge(Usuario o) {
        try {
            iniciaOperacion();
            o = (Usuario) getSession().merge(o);
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
    public void delete(Usuario o) {
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
    public Usuario findById(Integer id) {
        Usuario abono = null;

        try {
            iniciaOperacion();
            abono = (Usuario) getSession().get(Usuario.class, id);
        } finally {
            getSession().close();
        }
        return abono;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listaUsuarios;
        try {
            iniciaOperacion();
            listaUsuarios = getSession().createQuery("from Usuario").list();
        } finally {
            getSession().close();
        }

        return listaUsuarios;
    }
    
}
