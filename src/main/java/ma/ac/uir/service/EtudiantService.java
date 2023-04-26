package ma.ac.uir.service;

import ma.ac.uir.entity.Etudiant;
import ma.ac.uir.entity.Module;
import ma.ac.uir.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EtudiantService {

    public static boolean saveEtudiant(Etudiant p) {
        if (p == null)
            return false;
        if (p.getSpecialite()== null)
            p.setSpecialite(SpecialiteService.findSpecialiteByID(1));
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            int savedId = (int) session.save(p);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Etudiant findEtudiantByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Etudiant p = session.get(Etudiant.class, id);
        t.commit();
        return p;
    }

    public static boolean deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Etudiant p = session.get(Etudiant.class, id);
            session.delete(p);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static Etudiant findEtudiantByNomAndPrenom(String nom, String prenom) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        Query<Etudiant> query = session.createQuery("from Etudiant e where e.nom=: nom and  e.prenom=: prenom", Etudiant.class);
        query.setParameter("nom", nom);
        query.setParameter("prenom", prenom);
        Etudiant pRes = query.uniqueResult();
        t.commit();
        return pRes;
    }

    public static List<Etudiant> findAllEtudiant() {
        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            List<Etudiant> l = (ArrayList<Etudiant>) session.createQuery("from Etudiant").list();

            return l;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
