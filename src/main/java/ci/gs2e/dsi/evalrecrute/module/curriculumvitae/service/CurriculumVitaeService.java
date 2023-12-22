package ci.gs2e.dsi.evalrecrute.module.curriculumvitae.service;

import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CurriculumVitaeService {

    CurriculumVitaeDto getById (Integer id);
    CurriculumVitaeDto create (CurriculumVitaeDto curriculumVitaeDto);
    Page<CurriculumVitaeDto> getAll (Pageable pageable);
    CurriculumVitaeDto update (Integer id, CurriculumVitaeDto curriculumVitaeDto);
    void delete (Integer id);
    List<CurriculumVitaeDto> getByRecruteurId (Integer id);
}
