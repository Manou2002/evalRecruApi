package ci.gs2e.dsi.evalrecrute.module.domaineactivites.service.impl;

import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.DomaineActivite;
import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.dto.DomaineActiviteDto;
import ci.gs2e.dsi.evalrecrute.module.domaineactivites.repository.DomaineActiviteRepository;
import ci.gs2e.dsi.evalrecrute.module.domaineactivites.service.DomaineActiviteService;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.offres.service.OffreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DomaineActiviteServiceImpl implements DomaineActiviteService {
    private final DomaineActiviteRepository domaineActiviteRepository;
    private final OffreService offreService;
    public DomaineActiviteServiceImpl(DomaineActiviteRepository domaineActiviteRepository, OffreService offreService){
        this.domaineActiviteRepository = domaineActiviteRepository;
        this.offreService = offreService;
    }

    @Override
    public DomaineActiviteDto getById(Integer id) {
        if (id == null){
            log.error("l'id du domaine d'activite ne doit pas etre nul");
            return null;
        }
        Optional<DomaineActivite> domaineActivite = domaineActiviteRepository.findById(id);
        if (!domaineActivite.isPresent()){
            log.error("l'id du domaine d'activite ne doit pas etre nul");
            return null;
        }
        return DomaineActiviteDto.toDto (domaineActivite.get());
    }
    @Override
    public DomaineActiviteDto create (DomaineActiviteDto domaineActiviteDto){
        if (domaineActiviteDto == null){
            log.error("le type de domaine d'activite ne pas etre nul");
            return null;
        }
        domaineActiviteDto.setEstActif(true);
        return DomaineActiviteDto.toDto(domaineActiviteRepository.save(DomaineActiviteDto.toEntity(domaineActiviteDto)));
    }

    @Override
    public Page<DomaineActiviteDto> getAll(Pageable pageable){
        Page<DomaineActivite> domaineActivites = domaineActiviteRepository.findAll(pageable);
        if (domaineActivites.getContent().isEmpty()){
            log.error("Il n'y a aucun type de domaine dans la base de donnee");
            return null;
        }
        return domaineActivites.map(DomaineActiviteDto::toDto);
    }

    @Override
    public DomaineActiviteDto update(Integer id, DomaineActiviteDto domaineActiviteDto) {
        DomaineActiviteDto domaineActiviteDto1 = getById(id);
        domaineActiviteDto1.setLibelle(domaineActiviteDto.getLibelle());
        domaineActiviteDto1.setDescription(domaineActiviteDto.getDescription());
        return DomaineActiviteDto.toDto(domaineActiviteRepository.save(DomaineActiviteDto.toEntity(domaineActiviteDto1)));
    }

    @Override
    public void delete(Integer id){
        DomaineActiviteDto domaineActiviteDto = getById(id);
        domaineActiviteRepository.delete(DomaineActiviteDto.toEntity(domaineActiviteDto));
    }

    @Override
    public List<OffreDto> getAllOffreByDomaineActiviteId(Integer id) {
        return offreService.getByDomaineActiviteId(id);
    }
}
