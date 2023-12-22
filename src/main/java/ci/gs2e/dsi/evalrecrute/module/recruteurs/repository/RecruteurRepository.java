package ci.gs2e.dsi.evalrecrute.module.recruteurs.repository;

import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Integer> {
}
