package ma.ac.uir;

import ma.ac.uir.entity.Etudiant;
import ma.ac.uir.entity.Module;
import ma.ac.uir.entity.Specialite;
import ma.ac.uir.service.EtudiantService;
import ma.ac.uir.service.ModuleService;
import ma.ac.uir.service.SpecialiteService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * just for testing the services
 */
public class Test {
    public static void main(String[] args) {


        Specialite specialite = Specialite.builder().designation("info").build();
        SpecialiteService.saveSpecialite(specialite);

        Etudiant etudiant = Etudiant.builder()
                .nom("mouddene")
                .prenom("yassine")
                .moyenne(17.3)
                .specialite(specialite)
                .build();
        EtudiantService.saveEtudiant(etudiant);
        List<Etudiant> ll = EtudiantService.findAllEtudiant();
        for (int i = 0; i < ll.size() ; i++) {
            System.out.println(ll.get(i));
        }
    }

}
