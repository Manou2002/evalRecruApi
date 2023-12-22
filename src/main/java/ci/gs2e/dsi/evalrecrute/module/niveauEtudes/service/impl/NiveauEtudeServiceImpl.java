package ci.gs2e.dsi.evalrecrute.module.niveauEtudes.service.impl;

import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.NiveauEtude;
import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.dto.NiveauEtudeDto;
import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.repository.NiveauEtudeRepository;
import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.service.NiveauEtudeService;
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
public class NiveauEtudeServiceImpl implements NiveauEtudeService {

    private final NiveauEtudeRepository niveauEtudeRepository;
    private final OffreService offreService;
    public NiveauEtudeServiceImpl(NiveauEtudeRepository niveauEtudeRepository, OffreService offreService){
        this.niveauEtudeRepository = niveauEtudeRepository;
        this.offreService = offreService;
    }

    @Override
    public NiveauEtudeDto getById(Integer id) {
        if (id == null){
            log.error("l'id du niveau d'etude ne doit pas etre nul");
            return null;
        }
        Optional<NiveauEtude> niveauEtude = niveauEtudeRepository.findById(id);
        if (!niveauEtude.isPresent()){
            log.error("l'id du niveau d'etude ne doit pas etre nul");
            return null;
        }
        return NiveauEtudeDto.toDto (niveauEtude.get());
    }
    @Override
    public NiveauEtudeDto create (NiveauEtudeDto niveauEtudeDto){
        if (niveauEtudeDto == null){
            log.error("le type de niveau d'etude ne pas etre nul");
            return null;
        }
        niveauEtudeDto.setEstActif(true);
        return NiveauEtudeDto.toDto(niveauEtudeRepository.save(NiveauEtudeDto.toEntity(niveauEtudeDto)));
    }

    @Override
    public Page<NiveauEtudeDto> getAll(Pageable pageable){
        Page<NiveauEtude> niveauEtudes = niveauEtudeRepository.findAll(pageable);
        if (niveauEtudes.getContent().isEmpty()){
            log.error("Il n'y a aucun type de niveau d'etude dans la base de donnee");
            return null;
        }
        return niveauEtudes.map(NiveauEtudeDto::toDto);
    }

    @Override
    public NiveauEtudeDto update(Integer id, NiveauEtudeDto niveauEtudeDto) {
        NiveauEtudeDto niveauEtudeDto1 = getById(id);
        niveauEtudeDto1.setLibelle(niveauEtudeDto.getLibelle());
        return NiveauEtudeDto.toDto(niveauEtudeRepository.save(NiveauEtudeDto.toEntity(niveauEtudeDto)));
    }

    @Override
    public void delete(Integer id){
        NiveauEtudeDto niveauEtudeDto = getById(id);
        niveauEtudeRepository.delete(NiveauEtudeDto.toEntity(niveauEtudeDto));
    }

    @Override
    public List<OffreDto> getAllOffreByNiveauEtudeId(Integer id) {
        return offreService.getByNiveauEtudeId(id);
    }
}
