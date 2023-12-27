package ci.gs2e.dsi.evalrecrute.module.recruteurs.repository;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Integer> {

    List<Recruteur> findByCompteUtilisateurId(Integer compteUtilisateurId);
}
