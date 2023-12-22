package ci.gs2e.dsi.evalrecrute.module.domaineactivites.repository;

import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.DomaineActivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineActiviteRepository extends JpaRepository<DomaineActivite, Integer> {

}
