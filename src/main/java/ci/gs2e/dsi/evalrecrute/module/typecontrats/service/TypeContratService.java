package ci.gs2e.dsi.evalrecrute.module.typecontrats.service;

import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.dto.TypeContratDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeContratService {

    TypeContratDto getById (Integer id);
    TypeContratDto create (TypeContratDto typeContratDto);
    Page<TypeContratDto> getAll (Pageable pageable);
    TypeContratDto update (Integer id, TypeContratDto typeContratDto);
    void delete (Integer id);

    List<OffreDto> getAllOffreByTypeContratId(Integer id);

}
