package ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "domaine_activites")
    public class DomaineActivite {
    @Id
    @GeneratedValue
    private Integer id;

    private String libelle;
    private String description;

    @Column (name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

}
