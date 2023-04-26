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

@Table(name="tbl_specialite")
public class Specialite {


    @Id
    @SequenceGenerator(
            name = "specialite_id_sequence",
            sequenceName = "specialite_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "specialite_id_sequence"
    )
    private int idS;
    private String designation;
    @OneToMany(mappedBy = "specialite")
    private Set<Etudiant> etudiants;
}
