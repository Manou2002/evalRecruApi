package ci.gs2e.dsi.evalrecrute.module.niveau_experiences.service;


import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.dto.NiveauExperienceDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NiveauExperienceService {

    NiveauExperienceDto getById (Integer id);
    NiveauExperienceDto create (NiveauExperienceDto niveauExperienceDto);
    Page<NiveauExperienceDto> getAll (Pageable pageable);
    NiveauExperienceDto update (Integer id, NiveauExperienceDto niveauExperienceDto);
    void delete (Integer id);


    List<OffreDto> getAllOffreByNiveauExperienceId(Integer id);
}
