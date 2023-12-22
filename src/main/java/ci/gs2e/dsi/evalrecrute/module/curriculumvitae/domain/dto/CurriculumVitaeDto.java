package ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto;


import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.CurriculumVitae;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto.RecruteurDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurriculumVitaeDto {
    private Integer id;
    private String presentation;
    private String niveau;
    private String competences;
    private String experienceProfessionnelle;

    private Boolean estActif;
    private RecruteurDto recruteur;
    private CandidatDto candidat;

    public static CurriculumVitaeDto toDto(CurriculumVitae entity){
        if (entity == null) {
            return null;
        }
        return CurriculumVitaeDto.builder()
                .id(entity.getId())
                .presentation(entity.getPresentation())
                .niveau(entity.getNiveau())
                .competences(entity.getCompetences())
                .experienceProfessionnelle(entity.getExperienceProfessionnelle())
                .estActif(entity.getEstActif())
                .recruteur(RecruteurDto.toDto(entity.getRecruteur()))
                .candidat(CandidatDto.toDto(entity.getCandidat()))
                .build();

    }
    public static CurriculumVitae toEntity(CurriculumVitaeDto dto) {
        if (dto == null){
            return null;
        }
        CurriculumVitae entity = new CurriculumVitae();
        entity.setId(dto.getId());
        entity.setPresentation(dto.getPresentation());
        entity.setNiveau(dto.getNiveau());
        entity.setCompetences(dto.getCompetences());
        entity.setExperienceProfessionnelle(dto.getExperienceProfessionnelle());
        entity.setEstActif(dto.getEstActif());
        entity.setRecruteur(RecruteurDto.toEntity(dto.getRecruteur()));
        entity.setCandidat(CandidatDto.toEntity(dto.getCandidat()));
        return entity;
    }
}
