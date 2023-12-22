package ci.gs2e.dsi.evalrecrute.module.offres.repository;


import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Integer> {

    List<Offre> findByDomaineActiviteId(Integer domaineActiviteId);

    List<Offre> findByTypeContratId(Integer typeContratId);

    List<Offre> findByNiveauExperienceId(Integer niveauExperienceId);

    List<Offre> findByNiveauEtudeId(Integer niveauEtudeId);
}
