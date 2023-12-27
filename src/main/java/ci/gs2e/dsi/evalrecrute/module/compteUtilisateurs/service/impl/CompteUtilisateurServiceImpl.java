package ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.service.impl;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.candidats.service.CandidatService;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.CompteUtilisateur;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.dto.CompteUtilisateurDto;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.repository.CompteUtilisateurRepository;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.service.CompteUtilisateurService;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto.RecruteurDto;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.service.RecruteurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CompteUtilisateurServiceImpl implements CompteUtilisateurService {

    private final CompteUtilisateurRepository compteUtilisateurRepository;

    private final CandidatService candidatService;
    private final RecruteurService recruteurService;

    public CompteUtilisateurServiceImpl(CompteUtilisateurRepository compteUtilisateurRepository, CandidatService candidatService, RecruteurService recruteurService){
        this.compteUtilisateurRepository=compteUtilisateurRepository;
        this.candidatService = candidatService;
        this.recruteurService = recruteurService;
    }

    @Override
    public CompteUtilisateurDto getById(Integer id) {
        if (id == null){
            log.error("l'id du compte utilisateur ne doit pas etre nul");
            return null;
        }
        Optional<CompteUtilisateur> compteUtilisateur = compteUtilisateurRepository.findById(id);
        if (!compteUtilisateur.isPresent()){
            log.error("l'id du compte utilisateur ne doit pas etre nul");
            return null;
        }
        return CompteUtilisateurDto.toDto (compteUtilisateur.get());
    }
    @Override
    public CompteUtilisateurDto create (CompteUtilisateurDto compteUtilisateurDto){
        if (compteUtilisateurDto == null){
            log.error("le compte utilisateur ne doit pas etre nul");
            return null;
        }
        compteUtilisateurDto.setEstActif(true);
        return CompteUtilisateurDto.toDto(compteUtilisateurRepository.save(CompteUtilisateurDto.toEntity(compteUtilisateurDto)));
    }

    @Override
    public Page<CompteUtilisateurDto> getAll(Pageable pageable){
        Page<CompteUtilisateur> compteUtilisateurs = compteUtilisateurRepository.findAll(pageable);
        if (compteUtilisateurs.getContent().isEmpty()){
            log.error("Il n'y a compte utilisateur dans la base de donnee");
            return null;
        }
        return compteUtilisateurs.map(CompteUtilisateurDto::toDto);
    }

    @Override
    public CompteUtilisateurDto update(Integer id, CompteUtilisateurDto compteUtilisateurDto) {
        CompteUtilisateurDto compteUtilisateurDto1 = getById(id);
        compteUtilisateurDto1.setEmail(compteUtilisateurDto.getEmail());
        compteUtilisateurDto1.setPassword(compteUtilisateurDto.getPassword());
        return CompteUtilisateurDto.toDto(compteUtilisateurRepository.save(CompteUtilisateurDto.toEntity(compteUtilisateurDto1)));
    }

    @Override
    public void delete(Integer id){
        CompteUtilisateurDto compteUtilisateurDto = getById(id);
        compteUtilisateurRepository.delete(CompteUtilisateurDto.toEntity(compteUtilisateurDto));
    }

    @Override
    public List<CandidatDto> getAllCandidatByCompteUtilisateurId(Integer id) {
        return candidatService.getByCompteUtilisateurId(id);
    }

    @Override
    public List<RecruteurDto> getAllRecruteurByCompteUtilisateurId(Integer id) {
        return recruteurService.getByCompteUtilisateurId(id);
    }

}
