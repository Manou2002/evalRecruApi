package ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.dto;


import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.NiveauEtude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NiveauEtudeDto {

    private Integer id;
    private String libelle;

    private Boolean estActif;

    public static NiveauEtudeDto toDto(NiveauEtude entity){
        if (entity == null){
            return null;
        }
        return NiveauEtudeDto.builder()
                .id(entity.getId())
                .libelle(entity.getLibelle())
                .estActif(entity.getEstActif())
                .build();

    }
    public static NiveauEtude toEntity(NiveauEtudeDto dto){
        if (dto == null){
            return null;
        }
        NiveauEtude entity = new NiveauEtude();
        entity.setId(dto.getId());
        entity.setLibelle(dto.getLibelle());
        entity.setEstActif(dto.getEstActif());
        return entity;
    }

}
