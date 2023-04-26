package ma.ac.uir.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author nb
 */
public class HibernateUtil {
    public static final SessionFactory sessionFactory;
 
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            //sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();

           sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
           throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
