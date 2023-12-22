package ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.dto;

import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.DomaineActivite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DomaineActiviteDto {

private Integer id;
    private String libelle;
    private String description;

    private Boolean estActif;

    public static DomaineActiviteDto toDto(DomaineActivite entity){
        if (entity == null){
            return null;
        }
        return DomaineActiviteDto.builder()
                .id(entity.getId())
                .libelle(entity.getLibelle())
                .description(entity.getDescription())
                .estActif(entity.getEstActif())
                .build();

    }
    public static DomaineActivite toEntity(DomaineActiviteDto dto){
        if (dto == null){
            return null;
        }
        DomaineActivite entity = new DomaineActivite();
        entity.setId(dto.getId());
        entity.setLibelle(dto.getLibelle());
        entity.setDescription(dto.getDescription());
        entity.setEstActif(dto.getEstActif());
        return entity;
    }

}
