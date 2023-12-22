package ci.gs2e.dsi.evalrecrute.module.curriculumvitae.repository;

import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae, Integer> {
     List<CurriculumVitae> findByRecruteurId(Integer id);
}
