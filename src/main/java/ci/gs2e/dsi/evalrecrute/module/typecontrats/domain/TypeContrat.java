package ci.gs2e.dsi.evalrecrute.module.typecontrats.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "type_offres")
public class TypeContrat {

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


}
