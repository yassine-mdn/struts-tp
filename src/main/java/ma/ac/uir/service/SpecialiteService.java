package ma.ac.uir.service;

import ma.ac.uir.entity.Etudiant;
import ma.ac.uir.entity.Specialite;
import ma.ac.uir.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SpecialiteService {

    public static boolean saveSpecialite(Specialite specialite) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            int savedId = (int) session.save(specialite);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Specialite findSpecialiteByID(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Specialite specialite = session.get(Specialite.class, id);
        t.commit();
        return specialite;
    }

    public static Specialite findSpecialiteByDesignation(String designation) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        Query<Specialite> query = session.createQuery("from Specialite s where s.designation=: designation", Specialite.class);
        query.setParameter("designation", designation);
        Specialite specialite = query.uniqueResult();
        t.commit();
        return specialite;
    }

    public static List<Specialite> findAllSpecialite() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Specialite> l = (ArrayList<Specialite>) session.createQuery("from Specialite").list();
        return l;
    }
}
