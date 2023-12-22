package ci.gs2e.dsi.evalrecrute.module.offres.service;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OffreService {
    OffreDto getById(Integer id);
    OffreDto create(OffreDto offreDto);
    Page<OffreDto> getAll (Pageable pageable);
    OffreDto update (Integer id, OffreDto offreDto);
    void delete (Integer id);

    List<OffreDto> getByDomaineActiviteId(Integer id);
    List<CandidatDto> getAllCandidatByOffreId(Integer id);

    List<OffreDto> getByTypeContratId(Integer id);

    List<OffreDto> getByNiveauExperienceId(Integer id);

    List<OffreDto> getByNiveauEtudeId(Integer id);
}
