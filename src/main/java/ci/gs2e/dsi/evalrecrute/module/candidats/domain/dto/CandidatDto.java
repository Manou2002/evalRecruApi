package ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.dto.CompteUtilisateurDto;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidatDto {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;

    private Boolean estActif;
    private OffreDto offre;
    private CurriculumVitaeDto curriculumVitae;
    private CompteUtilisateurDto compteUtilisateur;

    public static CandidatDto toDto(Candidat entity){
        if (entity == null){
            return null;
        }
        return CandidatDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .email(entity.getEmail())
                .estActif(entity.getEstActif())
                .compteUtilisateur(CompteUtilisateurDto.toDto(entity.getCompteUtilisateur()))
                .curriculumVitae(CurriculumVitaeDto.toDto(entity.getCurriculumVitae()))
                .build();
    }
    public static Candidat toEntity(CandidatDto dto){
        if (dto == null){
            return null;
        }
        Candidat entity = new Candidat();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());
        entity.setEstActif(dto.getEstActif());
        entity.setCompteUtilisateur(CompteUtilisateurDto.toEntity(dto.getCompteUtilisateur()));
        entity.setCurriculumVitae(CurriculumVitaeDto.toEntity(dto.getCurriculumVitae()));
        return entity;
    }

}

