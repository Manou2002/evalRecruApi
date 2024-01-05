package ci.gs2e.dsi.evalrecrute.module.postulers.domain;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "postuler")
public class Postuler {

    @EmbeddedId
    private PostulerKey Id;

    private String acceptation;

    @Column(name = "date_postulation")
    private LocalDate datePostulation;

    @ManyToOne
    @MapsId("offreId")
    @JoinColumn(name = "id_offre")
    private Offre offre;

    @Column(name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;


    @ManyToOne
    @MapsId("candidatId")
    //@JoinColumn(name = "id_candidat")
    private Candidat candidat;





}
