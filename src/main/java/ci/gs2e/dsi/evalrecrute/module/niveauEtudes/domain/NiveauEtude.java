package ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "niveau_etude")

public class NiveauEtude {

    @Id
    @GeneratedValue
    private Integer id;

    private String libelle;

    @Column(name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

}
