package ma.ac.uir.service;

import ma.ac.uir.entity.Etudiant;
import ma.ac.uir.entity.Module;
import ma.ac.uir.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModuleService {

    public static boolean saveModule(Module module) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            int savedId = (int) session.save(module);
            t.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Module findModuleByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Module module = session.get(Module.class, id);
        t.commit();
        session.close();
        return module;
    }

    public static boolean addEtudiant(int idEtudiant ,int idModule){
        Etudiant e = EtudiantService.findEtudiantByID(idEtudiant);
        Module m = ModuleService.findModuleByID(idModule);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Set<Etudiant> le = m.getEtudiants();
            le.add(e);
            m.setEtudiants(le);
            session.update(m);
            t.commit();
            session.close();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public static Module findModuleByDesignation(String designation) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        Query<Module> query = session.createQuery("from Module s where s.designation=: designation", Module.class);
        query.setParameter("designation", designation);
        Module module = query.uniqueResult();
        t.commit();
        return module;
    }

    public static List<Module> findAllModule() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Module> l = (ArrayList<Module>) session.createQuery("from Module").list();
        return l;
    }
}
