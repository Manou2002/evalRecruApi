package ci.gs2e.dsi.evalrecrute.module.curriculumvitae.service.impl;

import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.CurriculumVitae;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.repository.CurriculumVitaeRepository;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.service.CurriculumVitaeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CurriculumVitaeServiceImpl implements CurriculumVitaeService {

    private final CurriculumVitaeRepository curriculumViteaRepository;
    public CurriculumVitaeServiceImpl(CurriculumVitaeRepository curriculumViteaRepository){
        this.curriculumViteaRepository = curriculumViteaRepository;
    }

    @Override
    public CurriculumVitaeDto getById(Integer id) {
        if (id == null){
            log.error("l'id du curriculum vitea ne doit pas etre nul");
            return null;
        }
        Optional<CurriculumVitae> curriculumVitae = curriculumViteaRepository.findById(id);
        if (!curriculumVitae.isPresent()){
            log.error("l'id du curriculum vitea ne doit pas etre nul");
            return null;
        }
        return CurriculumVitaeDto.toDto (curriculumVitae.get());
    }

    @Override
    public CurriculumVitaeDto create (CurriculumVitaeDto curriculumVitaeDto){
        if (curriculumVitaeDto == null){
            log.error("le curriculum vitea ne pas etre nul");
            return null;
        }
        curriculumVitaeDto.setEstActif(true);
        return CurriculumVitaeDto.toDto(curriculumViteaRepository.save(CurriculumVitaeDto.toEntity(curriculumVitaeDto)));
    }

    @Override
    public Page<CurriculumVitaeDto> getAll(Pageable pageable){
        Page<CurriculumVitae> curriculumVitaes = curriculumViteaRepository.findAll(pageable);
        if (curriculumVitaes.getContent().isEmpty()){
            log.error("Il n'y a aucun curriculum vitea dans la base de donnee");
            return null;
        }
        return curriculumVitaes.map(CurriculumVitaeDto::toDto);
    }

    @Override
    public CurriculumVitaeDto update(Integer id, CurriculumVitaeDto curriculumVitaeDto) {
        CurriculumVitaeDto curriculumVitaeDto1 = getById(id);
        curriculumVitaeDto1.setPresentation(curriculumVitaeDto.getPresentation());
        curriculumVitaeDto1.setNiveau(curriculumVitaeDto.getNiveau());
        curriculumVitaeDto1.setCompetences(curriculumVitaeDto.getCompetences());
        curriculumVitaeDto1.setExperienceProfessionnelle(curriculumVitaeDto.getExperienceProfessionnelle());
        return CurriculumVitaeDto.toDto(curriculumViteaRepository.save(CurriculumVitaeDto.toEntity(curriculumVitaeDto1)));
    }

    @Override
    public void delete(Integer id){
        CurriculumVitaeDto curriculumVitaeDto = getById(id);
        curriculumViteaRepository.delete(CurriculumVitaeDto.toEntity(curriculumVitaeDto));
    }

    @Override
    public List<CurriculumVitaeDto> getByRecruteurId(Integer recruteurId){
        List<CurriculumVitae> curriculumVitaes = curriculumViteaRepository.findByRecruteurId(recruteurId);
        if (curriculumVitaes.isEmpty()){
            log.error("il n'y a aucun curriculum vitea dans la base de donnee");
        }
        return curriculumVitaes.stream().map(CurriculumVitaeDto :: toDto).collect(Collectors.toList());
    }

}
