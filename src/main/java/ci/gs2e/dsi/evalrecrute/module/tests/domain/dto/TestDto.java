package ci.gs2e.dsi.evalrecrute.module.tests.domain.dto;


import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.tests.domain.Test;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {
    private Integer id;
    private String libelle;
    private String description;

    private Boolean estActif;
    private CandidatDto candidat;

    public static TestDto toDto(Test entity){
        if (entity == null){
            return null;
        }
        return TestDto.builder()
                .id(entity.getId())
                .libelle(entity.getLibelle())
                .description(entity.getDescription())
                .estActif(entity.getEstActif())
                .candidat(CandidatDto.toDto(entity.getCandidat()))
                .build();

    }
    public static Test toEntity(TestDto dto){
        if (dto == null){
            return null;
        }
        Test entity = new Test();
        entity.setId(dto.getId());
        entity.setLibelle(dto.getLibelle());
        entity.setDescription(dto.getDescription());
        entity.setEstActif(dto.getEstActif());
        entity.setCandidat(CandidatDto.toEntity(dto.getCandidat()));
        return entity;
    }


}
