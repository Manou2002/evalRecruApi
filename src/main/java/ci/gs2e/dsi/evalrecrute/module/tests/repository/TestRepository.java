package ci.gs2e.dsi.evalrecrute.module.tests.repository;

import ci.gs2e.dsi.evalrecrute.module.tests.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findByCandidatId(Integer Id);
}
