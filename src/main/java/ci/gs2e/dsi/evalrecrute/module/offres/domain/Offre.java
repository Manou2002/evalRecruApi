package ci.gs2e.dsi.evalrecrute.module.offres.domain;


import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.DomaineActivite;
import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.NiveauEtude;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.NiveauExperience;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.service.NiveauExperienceService;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.Postuler;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.TypeContrat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "offre")
public class Offre {
    @Id
    @GeneratedValue
    private Integer id;

    private String titre;
    private String mission;
    private String competence;

    @Column(name = "date_offre", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDate dateOffre;
    private LocalDate dateFin;

    @Column(name = "nombre_poste")
    private Integer nombrePoste;

    @Column(name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

    @ManyToOne
    @JoinColumn(name = "domaine_activite_id")
    private DomaineActivite domaineActivite;

    @ManyToOne
    @JoinColumn(name = "type_contrat_id")
    private TypeContrat typeContrat;

    @ManyToOne
    @JoinColumn(name = "niveau_experience_id")
    private NiveauExperience niveauExperience;

    @ManyToOne
    @JoinColumn(name = "niveau_etude_id")
    private NiveauEtude niveauEtude;

    @OneToMany(targetEntity = Postuler.class, mappedBy = "offre")
   // @JsonIgnore
    private List<Postuler> postuler = new ArrayList<>();

}


