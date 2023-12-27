package ci.gs2e.dsi.evalrecrute.module.recruteurs.service;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.CurriculumVitae;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto.RecruteurDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RecruteurService {

    RecruteurDto getById (Integer id);
    RecruteurDto create (RecruteurDto recruteurDto);
    Page<RecruteurDto> getAll (Pageable pageable);
    RecruteurDto update (Integer id, RecruteurDto recruteurDto);
    void delete (Integer id);

    List<CurriculumVitaeDto> getAllCurriculumVitaeByRecruteurId(Integer id);

    List<RecruteurDto> getByCompteUtilisateurId(Integer id);
}
