package ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.repository;

import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.CompteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Integer> {
}
