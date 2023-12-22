package ci.gs2e.dsi.evalrecrute.module.recruteurs.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recruteurs")
public class Recruteur {

    @Id
    @GeneratedValue
    private Integer id;

    private String nom;
    private String prenom;
    private String email;

    @Column(name = "est_actif")
    private Boolean estActif;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "updated_by")
    private String updatedBy;

}
