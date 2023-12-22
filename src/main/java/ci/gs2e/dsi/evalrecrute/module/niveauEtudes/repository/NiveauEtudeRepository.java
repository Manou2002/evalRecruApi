package ci.gs2e.dsi.evalrecrute.module.niveauEtudes.repository;

import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.NiveauEtude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauEtudeRepository extends JpaRepository<NiveauEtude, Integer> {
}
