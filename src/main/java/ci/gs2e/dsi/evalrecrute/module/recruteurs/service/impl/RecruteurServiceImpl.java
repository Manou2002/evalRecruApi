package ci.gs2e.dsi.evalrecrute.module.recruteurs.service.impl;

import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.service.CurriculumVitaeService;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.Recruteur;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto.RecruteurDto;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.repository.RecruteurRepository;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.service.RecruteurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RecruteurServiceImpl implements RecruteurService {

    private final RecruteurRepository recruteurRepository;
    private CurriculumVitaeService curriculumVitaeService;
    public RecruteurServiceImpl(RecruteurRepository recruteurRepository, CurriculumVitaeService curriculumVitaeService){
        this.recruteurRepository = recruteurRepository;
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @Override
    public RecruteurDto getById(Integer id) {
        if (id == null){
            log.error("l'id du recruteur ne doit pas etre nul");
            return null;
        }
        Optional<Recruteur> recruteur = recruteurRepository.findById(id);
        if (!recruteur.isPresent()){
            log.error("l'id du recruteur doit pas etre nul");
            return null;
        }
        return RecruteurDto.toDto (recruteur.get());
    }

    @Override
    public RecruteurDto create (RecruteurDto recruteurDto){
        if (recruteurDto == null){
            log.error("le type de recruteur ne pas etre nul");
            return null;
        }
        recruteurDto.setEstActif(true);
        return RecruteurDto.toDto(recruteurRepository.save(recruteurDto.toEntity(recruteurDto)));
    }

    @Override
    public Page<RecruteurDto> getAll(Pageable pageable){
        Page<Recruteur> recruteurs = recruteurRepository.findAll(pageable);
        if (recruteurs.getContent().isEmpty()){
            log.error("Il n'y a aucun recruteur dans la base de donnee");
            return null;
        }
        return recruteurs.map(RecruteurDto::toDto);
    }

    @Override
    public RecruteurDto update(Integer id, RecruteurDto recruteurDto) {
        RecruteurDto recruteurDto1 = getById(id);
        recruteurDto1.setNom(recruteurDto.getNom());
        recruteurDto1.setPrenom(recruteurDto.getPrenom());
        return RecruteurDto.toDto(recruteurRepository.save(RecruteurDto.toEntity(recruteurDto)));
    }

    @Override
    public void delete(Integer id){
        RecruteurDto recruteurDto = getById(id);
        recruteurRepository.delete(RecruteurDto.toEntity(recruteurDto));
    }
    
    @Override
    public List<CurriculumVitaeDto> getAllCurriculumVitaeByRecruteurId (Integer id){
        return curriculumVitaeService.getByRecruteurId(id);
    }

}
