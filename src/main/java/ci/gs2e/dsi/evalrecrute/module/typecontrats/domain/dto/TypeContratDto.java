package ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.dto;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.TypeContrat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeContratDto {

    private Integer id;
    private String libelle;
    private String description;

    private Boolean estActif;

    public static TypeContratDto toDto(TypeContrat entity){
        if (entity == null){
            return null;
        }
        return TypeContratDto.builder()
                .id(entity.getId())
                .libelle(entity.getLibelle())
                .description(entity.getDescription())
                .estActif(entity.getEstActif())
                .build();

    }
    public static TypeContrat toEntity(TypeContratDto dto){
        if (dto == null){
            return null;
        }
        TypeContrat entity = new TypeContrat();
        entity.setId(dto.getId());
        entity.setLibelle(dto.getLibelle());
        entity.setDescription(dto.getDescription());
        entity.setEstActif(dto.getEstActif());
        return entity;
    }

}
