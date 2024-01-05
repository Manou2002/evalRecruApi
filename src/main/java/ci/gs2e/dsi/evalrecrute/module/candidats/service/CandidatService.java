package ci.gs2e.dsi.evalrecrute.module.candidats.service;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.tests.domain.dto.TestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CandidatService {
    CandidatDto getById(Integer id);
    CandidatDto create(CandidatDto candidatDto);
    CandidatDto createWithCV(CandidatDto candidatDto, CurriculumVitaeDto curriculumVitaeDto);
    Page<CandidatDto> getAll (Pageable pageable);
    CandidatDto update (Integer id, CandidatDto candidatDto);
    void delete (Integer id);

    List<CandidatDto> getByCompteUtilisateurId(Integer id);
    List<TestDto> getAllTestByCandidatId(Integer id);

}
