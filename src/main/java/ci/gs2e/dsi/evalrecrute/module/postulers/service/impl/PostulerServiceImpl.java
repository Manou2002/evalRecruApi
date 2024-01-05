package ci.gs2e.dsi.evalrecrute.module.postulers.service.impl;

import ci.gs2e.dsi.evalrecrute.module.candidats.service.CandidatService;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.offres.service.OffreService;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.Postuler;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.dto.PostulerDto;
import ci.gs2e.dsi.evalrecrute.module.postulers.repository.PostulerRepository;
import ci.gs2e.dsi.evalrecrute.module.postulers.service.PostulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostulerServiceImpl implements PostulerService {

    private final PostulerRepository postulerRepository;

    private final OffreService offreService;
    private final CandidatService candidatService;

    public PostulerServiceImpl(PostulerRepository postulerRepository, OffreService offreService, CandidatService candidatService){
        this.postulerRepository = postulerRepository;
        this.offreService = offreService;
        this.candidatService = candidatService;
    }
    @Override
    public PostulerDto getById(Integer id){
        if (id == null){
            log.error("l'id du poste ne dois pas etre nul");
            return null;
        }
        Optional<Postuler> postuler = postulerRepository.findById(id);
        if (!postuler.isPresent()){
            log.error("l'id du poste ne doit pas etre nul");
            return null;
        }
        return PostulerDto.toDto(postuler.get());
    }
    @Override
    public PostulerDto create (PostulerDto postulerDto){
        if (postulerDto == null){
            log.error("le poste ne doit pas etre nul");
            return null;
        }
        postulerDto.setEstActif(true);
        return PostulerDto.toDto((postulerRepository.save(PostulerDto.toEntity(postulerDto))));
    }
    @Override
    public Page<PostulerDto> getAll(Pageable pageable){
        Page<Postuler> postulers = postulerRepository.findAll(pageable);
        if (postulers.getContent().isEmpty()){
            log.error("il n'y a aucune offre dans le base donnee");
        }
        return postulers.map(PostulerDto:: toDto);
    }
    @Override
    public PostulerDto update(Integer id, PostulerDto postulerDto){
        PostulerDto postulerDto1 = getById(id);
        postulerDto1.setAcceptation(postulerDto.getAcceptation());
        postulerDto1.setDatePostulation(postulerDto.getDatePostulation());
        return PostulerDto.toDto(postulerRepository.save(PostulerDto.toEntity(postulerDto1)));
    }
    @Override
    public void delete(Integer id){
        PostulerDto postulerDto = getById(id);
        postulerRepository.delete(PostulerDto.toEntity(postulerDto));
    }
    @Override
    public List<PostulerDto> getAllByOffreId(Integer offreId) {
        List<Postuler> postulers = postulerRepository.findAllByOffreId(offreId);
        if (postulers.isEmpty()){
            log.error("il n'y a aucune mkjhgqsdfghj");
        }
        return postulers.stream().map(PostulerDto::toDto).collect(Collectors.toList());
    }
    @Override
    public List<PostulerDto> getAllByCandidatId(Integer candidatId) {
        List<Postuler> postulers = postulerRepository.findAllByOffreId(candidatId);
        if (postulers.isEmpty()){
            log.error("il n'y a aucune mkjhgqsdfghj");
        }
        return postulers.stream().map(PostulerDto::toDto).collect(Collectors.toList());
    }


}


