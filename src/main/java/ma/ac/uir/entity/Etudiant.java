package ma.ac.uir.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="tbl_etudiant")
public class Etudiant {


    @Id
    @SequenceGenerator(
            name = "etudiant_id_sequence",
            sequenceName = "etudiant_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "etudiant_id_sequence"
    )
    private int idE;
    private String nom;
    private String prenom;
    private Double moyenne;
    @ManyToOne
    private Specialite specialite;

    @ManyToMany(mappedBy = "etudiants")
    private Set<Module> modules;

}
