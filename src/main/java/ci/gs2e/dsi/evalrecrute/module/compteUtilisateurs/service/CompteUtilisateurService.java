package ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.service;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.dto.CompteUtilisateurDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto.RecruteurDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompteUtilisateurService {

    CompteUtilisateurDto getById(Integer id);
    CompteUtilisateurDto create(CompteUtilisateurDto candidatDto);
    Page<CompteUtilisateurDto> getAll (Pageable pageable);
    CompteUtilisateurDto update (Integer id, CompteUtilisateurDto candidatDto);
    void delete (Integer id);

    List<CandidatDto> getAllCandidatByCompteUtilisateurId(Integer parseInt);

    List<RecruteurDto> getAllRecruteurByCompteUtilisateurId(Integer parseInt);
}
