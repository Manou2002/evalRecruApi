package ci.gs2e.dsi.evalrecrute.module.candidats.domain;

import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.CompteUtilisateur;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.CurriculumVitae;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidats")
public class Candidat {
    @Id
    @GeneratedValue
    private Integer id;

    private String Nom;
    private String Prenom;
    private String Email;

    @Column (name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

    @ManyToOne
    @JoinColumn
    private Offre offre;

    @OneToOne(mappedBy = "candidat",  cascade = CascadeType.ALL)
    private CurriculumVitae curriculumVitae;

    @ManyToOne
    @JoinColumn
    private CompteUtilisateur compteUtilisateur;
    


}


