package ci.gs2e.dsi.evalrecrute.module.tests.domain;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue
    private Integer id;

    private String libelle;
    private String description;

    @Column(name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

    @ManyToOne
    @JoinColumn Candidat candidat;


}
