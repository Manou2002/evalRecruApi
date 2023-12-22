package ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.Recruteur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CurriculumVitae")
public class CurriculumVitae {

    @Id
    @GeneratedValue
    private Integer id;

    private String presentation;
    private String niveau;
    private String competences;

    @Column(name = "experience_professionnelle")
    private String experienceProfessionnelle;

    @Column(name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

    @ManyToOne
    @JoinColumn Recruteur recruteur;

    @OneToOne
    @JoinColumn(name = "candidat_id", referencedColumnName = "id")
    private Candidat candidat;

}
