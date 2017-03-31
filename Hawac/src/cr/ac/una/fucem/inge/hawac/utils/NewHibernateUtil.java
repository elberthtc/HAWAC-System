/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.utils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Josue
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    private Session session;
    private Transaction transac;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void iniciaOperacion() throws HibernateException {
        session = getSessionFactory().openSession();
        transac = session.beginTransaction();
    }

    public void manejaException(HibernateException he) throws HibernateException {
        transac.rollback();
        throw new HibernateException("Se genero un error con la base de datos"+he.getMessage());

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransac() {
        return transac;
    }

    public void setTransac(Transaction transac) {
        this.transac = transac;
    }

}
