package ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto;



import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.dto.CompteUtilisateurDto;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.Recruteur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecruteurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private CompteUtilisateurDto compteUtilisateur;

    private Boolean estActif;

    public static RecruteurDto toDto(Recruteur entity){
        if (entity == null){
            return null;
        }

        return RecruteurDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .email(entity.getEmail())
                .compteUtilisateur(CompteUtilisateurDto.toDto(entity.getCompteUtilisateur()))
                .estActif(entity.getEstActif())
                .build();

    }

    public static Recruteur toEntity(RecruteurDto dto){
        if (dto == null){
            return null;
        }
        Recruteur entity = new Recruteur();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());
        entity.setCompteUtilisateur(CompteUtilisateurDto.toEntity(dto.getCompteUtilisateur()));
        entity.setEstActif(dto.getEstActif());
        return entity;
    }
}
