package ci.gs2e.dsi.evalrecrute.module.postulers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PostulerKey {

    @Column(name = "id_offre")
    private long offreId;

    @Column(name = "id_candidat")
    private long candidatId;
}
