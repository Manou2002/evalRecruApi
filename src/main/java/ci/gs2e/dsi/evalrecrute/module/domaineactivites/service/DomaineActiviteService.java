package ci.gs2e.dsi.evalrecrute.module.domaineactivites.service;

import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.dto.DomaineActiviteDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomaineActiviteService {
    DomaineActiviteDto getById (Integer id);
    DomaineActiviteDto create (DomaineActiviteDto domaineActiviteDto);
    Page<DomaineActiviteDto> getAll (Pageable pageable);
    DomaineActiviteDto update (Integer id, DomaineActiviteDto domaineActiviteDto);
    void delete (Integer id);

    List<OffreDto> getAllOffreByDomaineActiviteId(Integer parseInt);
}
