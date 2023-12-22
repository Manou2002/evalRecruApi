package ci.gs2e.dsi.evalrecrute.module.niveau_experiences.service.impl;

import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.NiveauExperience;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.dto.NiveauExperienceDto;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.repository.NiveauExperienceRepository;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.service.NiveauExperienceService;
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
public class NiveauExperienceServiceImpl implements NiveauExperienceService {

    private final NiveauExperienceRepository niveauExperienceRepository;
    private final OffreService offreService;
    public NiveauExperienceServiceImpl(NiveauExperienceRepository niveauExperienceRepository, OffreService offreService){
        this.niveauExperienceRepository = niveauExperienceRepository;
        this.offreService = offreService;
    }

    @Override
    public NiveauExperienceDto getById(Integer id) {
        if (id == null){
            log.error("l'id du niveau d'expereince ne doit pas etre nul");
            return null;
        }
        Optional<NiveauExperience> niveauExperience = niveauExperienceRepository.findById(id);
        if (!niveauExperience.isPresent()){
            log.error("l'id du niveau d'experience ne doit pas etre nul");
            return null;
        }
        return NiveauExperienceDto.toDto (niveauExperience.get());
    }
    @Override
    public NiveauExperienceDto create (NiveauExperienceDto niveauExperienceDto){
        if (niveauExperienceDto == null){
            log.error("le type du niveau d'experience ne doit pas etre nul");
            return null;
        }
        niveauExperienceDto.setEstActif(true);
        return NiveauExperienceDto.toDto(niveauExperienceRepository.save(NiveauExperienceDto.toEntity(niveauExperienceDto)));
    }

    @Override
    public Page<NiveauExperienceDto> getAll(Pageable pageable){
        Page<NiveauExperience> niveauExperiences = niveauExperienceRepository.findAll(pageable);
        if (niveauExperiences.getContent().isEmpty()){
            log.error("Il n'y a aucun type de domaine dans la base de donnee");
            return null;
        }
        return niveauExperiences.map(NiveauExperienceDto::toDto);
    }

    @Override
    public NiveauExperienceDto update(Integer id, NiveauExperienceDto niveauExperienceDto) {
        NiveauExperienceDto niveauExperienceDto1 = getById(id);
        niveauExperienceDto1.setLibelle(niveauExperienceDto.getLibelle());
        return NiveauExperienceDto.toDto(niveauExperienceRepository.save(NiveauExperienceDto.toEntity(niveauExperienceDto1)));
    }

    @Override
    public void delete(Integer id){
        NiveauExperienceDto niveauExperienceDto = getById(id);
        niveauExperienceRepository.delete(NiveauExperienceDto.toEntity(niveauExperienceDto));
    }

    @Override
    public List<OffreDto> getAllOffreByNiveauExperienceId(Integer id) {
        return offreService.getByNiveauExperienceId(id);
    }
}


