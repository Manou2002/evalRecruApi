package ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compte_utilisateur")

public class CompteUtilisateur {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;
    private Integer password;

    @Column (name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

}
