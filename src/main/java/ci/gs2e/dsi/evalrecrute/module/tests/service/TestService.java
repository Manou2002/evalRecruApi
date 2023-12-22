package ci.gs2e.dsi.evalrecrute.module.tests.service;

import ci.gs2e.dsi.evalrecrute.module.tests.domain.dto.TestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TestService {

    TestDto getById (Integer id);
    TestDto create (TestDto testDto);
    Page<TestDto> getAll (Pageable pageable);
    TestDto update (Integer id, TestDto testDto);
    void delete (Integer id);

    List<TestDto> getByCandidatId(Integer id);
}
