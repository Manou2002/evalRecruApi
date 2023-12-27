package ci.gs2e.dsi.evalrecrute.module.candidats.service.impl;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.candidats.repository.CandidatRepository;
import ci.gs2e.dsi.evalrecrute.module.candidats.service.CandidatService;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.tests.domain.dto.TestDto;
import ci.gs2e.dsi.evalrecrute.module.tests.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CandidatServiceImpl implements CandidatService {
    private final CandidatRepository candidatRepository ;
    private final TestService testService;

    public CandidatServiceImpl(CandidatRepository candidatRepository, TestService testService){
        this.candidatRepository = candidatRepository;
        this.testService = testService;
    }
    @Override
    public CandidatDto getById(Integer id) {
        if (id == null) {
            log.error("l'id du candidat ne doit pas etre nul");
            return null;
        }
        Optional<Candidat> candidat = candidatRepository.findById(id);
        if (!candidat.isPresent()) {
            log.error("l'id du candidat ne doit pas etre nul");
            return null;
        }
        return CandidatDto.toDto(candidat.get());
    }

    @Override
    public CandidatDto create (CandidatDto candidatDto){
        if (candidatDto == null){
            log.error("le type de candidat ne pas etre nul");
            return null;
        }
        candidatDto.setEstActif(true);
        return CandidatDto.toDto(candidatRepository.save(CandidatDto.toEntity(candidatDto)));
    }

    @Override
    @Transactional
    public CandidatDto createWithCV(CandidatDto candidatDto, CurriculumVitaeDto curriculumVitaeDto) {
        if (candidatDto == null){
            log.error("le type de candidat ne pas etre nul");
            return null;
        }
        curriculumVitaeDto.setCandidat(candidatDto);
        candidatDto.setEstActif(true);
        candidatDto.setCurriculumVitae(curriculumVitaeDto);
        return CandidatDto.toDto(candidatRepository.save(CandidatDto.toEntity(candidatDto)));
    }

    @Override
    public Page<CandidatDto> getAll(Pageable pageable){
        Page<Candidat> candidats = candidatRepository.findAll(pageable);
        if (candidats.getContent().isEmpty()){
            log.error("Il n'y a aucun type de client dans la base de donnee");
            return null;
        }
        return candidats.map(CandidatDto::toDto);
    }
    @Override
    public CandidatDto update(Integer id, CandidatDto candidatDto) {
        CandidatDto candidatDto1 = getById(id);
        candidatDto1.setNom(candidatDto.getNom());
        candidatDto1.setPrenom(candidatDto.getPrenom());
        candidatDto1.setEmail(candidatDto.getEmail());
        return CandidatDto.toDto(candidatRepository.save(CandidatDto.toEntity(candidatDto1)));
    }
    @Override
    public void delete(Integer id){
        CandidatDto candidatDto = getById(id);
        candidatRepository.delete(CandidatDto.toEntity(candidatDto));
    }
    @Override
    public List<CandidatDto> getByOffreId(Integer offreId){
        List<Candidat> candidats = candidatRepository.findByOffreId(offreId);
        if (candidats.isEmpty()){
            log.error("il n'y a aucun candidat dans la base de donnee");
        }
        return candidats.stream().map(CandidatDto :: toDto).collect(Collectors.toList());
    }

    @Override
    public List<TestDto> getAllTestByCandidatId(Integer id){
        return testService.getByCandidatId(id);
    }

    @Override
    public List<CandidatDto> getByCompteUtilisateurId(Integer compteUtilisateurId){
        List<Candidat> candidats = candidatRepository.findByCompteUtilisateurId(compteUtilisateurId);
        if (candidats.isEmpty()){
            log.error("il n'y a aucun candidat dans la base de donnee");
        }
        return candidats.stream().map(CandidatDto :: toDto).collect(Collectors.toList());
    }


}