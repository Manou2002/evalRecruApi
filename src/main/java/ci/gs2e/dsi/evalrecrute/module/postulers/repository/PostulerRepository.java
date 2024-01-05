package ci.gs2e.dsi.evalrecrute.module.postulers.repository;

import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.Postuler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulerRepository extends JpaRepository<Postuler,Integer> {

    List<Postuler> findAllByOffreId(Integer offreId);

    List<Postuler> findAllByCandidatId(Integer candidatId);


}
