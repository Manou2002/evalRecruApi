package ci.gs2e.dsi.evalrecrute.module.niveauEtudes.service;

import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.dto.NiveauEtudeDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NiveauEtudeService {

    NiveauEtudeDto getById (Integer id);
    NiveauEtudeDto create (NiveauEtudeDto niveauEtudeDto);
    Page<NiveauEtudeDto> getAll (Pageable pageable);
    NiveauEtudeDto update (Integer id, NiveauEtudeDto niveauEtudeDto);
    void delete (Integer id);

    List<OffreDto> getAllOffreByNiveauEtudeId(Integer niveauEtudeDto);
}
