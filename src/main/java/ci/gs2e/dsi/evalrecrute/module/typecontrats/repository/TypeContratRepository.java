package ci.gs2e.dsi.evalrecrute.module.typecontrats.repository;

import ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeContratRepository extends JpaRepository<TypeContrat , Integer> {
}
