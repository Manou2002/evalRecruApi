package ci.gs2e.dsi.evalrecrute.module.niveau_experiences.repository;

import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.NiveauExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauExperienceRepository extends JpaRepository<NiveauExperience, Integer> {
}
