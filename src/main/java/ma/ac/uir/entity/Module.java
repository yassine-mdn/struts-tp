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
@Table(name="tbl_module")
public class Module {


    @Id
    @SequenceGenerator(
            name = "module_id_sequence",
            sequenceName = "module_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "module_id_sequence"
    )
    private int idM;
    private String designation;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "module_etudiant",
            joinColumns = { @JoinColumn(name = "module_id") },
            inverseJoinColumns = { @JoinColumn(name = "etudiant_id") }
    )
    private Set<Etudiant> etudiants;
}
