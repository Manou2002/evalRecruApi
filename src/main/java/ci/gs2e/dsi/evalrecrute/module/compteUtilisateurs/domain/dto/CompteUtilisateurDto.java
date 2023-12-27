package ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.dto;

import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.CompteUtilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompteUtilisateurDto {

    private Integer id;
    private String email;
    private Integer password;
    private Boolean estActif;


    public static CompteUtilisateurDto toDto(CompteUtilisateur entity){
        if (entity == null){
            return null;
        }

        return CompteUtilisateurDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .estActif(entity.getEstActif())
                .build();
    }

    public static CompteUtilisateur toEntity(CompteUtilisateurDto dto){
        if (dto == null){
            return null;
        }
        CompteUtilisateur entity = new CompteUtilisateur();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setEstActif(dto.getEstActif());
        return entity;
    }

}
