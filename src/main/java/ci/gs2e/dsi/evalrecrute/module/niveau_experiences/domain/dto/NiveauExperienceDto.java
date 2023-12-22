package ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.dto;

import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.NiveauExperience;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NiveauExperienceDto {

    private Integer id;
    private String libelle;

    private Boolean estActif;

    public static NiveauExperienceDto toDto(NiveauExperience entity){
        if (entity == null){
            return null;
        }
        return NiveauExperienceDto.builder()
                .id(entity.getId())
                .libelle(entity.getLibelle())
                .estActif(entity.getEstActif())
                .build();

    }
    public static NiveauExperience toEntity(NiveauExperienceDto dto){
        if (dto == null){
            return null;
        }
        NiveauExperience entity = new NiveauExperience();
        entity.setId(dto.getId());
        entity.setLibelle(dto.getLibelle());
        entity.setEstActif(dto.getEstActif());
        return entity;
    }

}
