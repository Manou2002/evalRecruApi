package ci.gs2e.dsi.evalrecrute.module.offres.service.impl;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.candidats.service.CandidatService;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.offres.repository.OffreRepository;
import ci.gs2e.dsi.evalrecrute.module.offres.service.OffreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OffreServiceImpl implements OffreService {
    private final OffreRepository offreRepository;
    private final CandidatService candidatService;
    public OffreServiceImpl(OffreRepository offreRepository, CandidatService candidatService) {
        this.offreRepository = offreRepository;
        this.candidatService = candidatService;
    }
    @Override
    public OffreDto getById(Integer id){
        if (id == null){
            log.error("l'id du poste ne dois pas etre nul");
            return null;
        }
        Optional<Offre> offre = offreRepository.findById(id);
        if (!offre.isPresent()){
            log.error("l'id du poste ne doit pas etre nul");
            return null;
        }
        return OffreDto.toDto(offre.get());
    }
    @Override
    public OffreDto create (OffreDto offreDto){
        if (offreDto == null){
            log.error("le poste ne doit pas etre nul");
            return null;
        }
        offreDto.setEstActif(true);
        return OffreDto.toDto((offreRepository.save(OffreDto.toEntity(offreDto))));
    }

    @Override
    public Page<OffreDto> getAll(Pageable pageable){
        Page<Offre> offres = offreRepository.findAll(pageable);
        if (offres.getContent().isEmpty()){
            log.error("il n'y a aucune offre dans le base donnee");
        }
        return offres.map(OffreDto:: toDto);
    }
    @Override
    public OffreDto update(Integer id, OffreDto offreDto){
        OffreDto offreDto1 = getById(id);
        offreDto1.setTitre(offreDto.getTitre());
        offreDto1.setMission(offreDto.getMission());
        offreDto1.setCompetence(offreDto.getCompetence());
        return OffreDto.toDto(offreRepository.save(OffreDto.toEntity(offreDto1)));
    }
    @Override
    public void delete(Integer id){
        OffreDto offreDto = getById(id);
        offreRepository.delete(OffreDto.toEntity(offreDto));
    }

    @Override
    public List<OffreDto> getByDomaineActiviteId(Integer domaineActiviteId) {
        List<Offre> offres = offreRepository.findByDomaineActiviteId(domaineActiviteId);
        if (offres.isEmpty()){
            log.error("il n'y a aucun domaine d'activite dans le base donnee");
        }
        return offres.stream().map(OffreDto:: toDto).collect(Collectors.toList());
    }

    @Override
    public List<OffreDto> getByTypeContratId(Integer typeContreatId) {
        List<Offre> offres = offreRepository.findByTypeContratId(typeContreatId);
        if (offres.isEmpty()) {
            log.error("il n'y a aucune offre dans le base donnee");
        }
        return offres.stream().map(OffreDto::toDto).collect(Collectors.toList());
    }

    @Override
    public List<OffreDto> getByNiveauExperienceId(Integer niveauExperienceId) {
        List<Offre> offres = offreRepository.findByNiveauExperienceId(niveauExperienceId);
        if (offres.isEmpty()){
            log.error("il n'y a aucune mkjhgqsdfghj");
        }
        return offres.stream().map(OffreDto::toDto).collect(Collectors.toList());
    }

    @Override
    public List<OffreDto> getByNiveauEtudeId(Integer niveauEtudeId) {
        List<Offre> offres = offreRepository.findByNiveauEtudeId(niveauEtudeId);
        if (offres.isEmpty()){
            log.error("il n'y a aucune mkjhgqsdfghj");
        }
        return offres.stream().map(OffreDto::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CandidatDto> getAllCandidatByOffreId(Integer id){
        return candidatService.getByOffreId(id);
    }


}



