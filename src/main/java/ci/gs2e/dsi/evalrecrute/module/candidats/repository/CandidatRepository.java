package ci.gs2e.dsi.evalrecrute.module.candidats.repository;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer>  {
    List<Candidat> findByOffreId(Integer offreId) ;

    List<Candidat> findByCompteUtilisateurId(Integer compteUtilisateurId);
}
