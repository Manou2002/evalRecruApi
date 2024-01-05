package ci.gs2e.dsi.evalrecrute.module.offres.domain.dto;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.dto.DomaineActiviteDto;
import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.dto.NiveauEtudeDto;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.dto.NiveauExperienceDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.Postuler;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.dto.PostulerDto;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.dto.TypeContratDto;
import lombok.Builder;
import lombok.Data;

;import java.time.LocalDate;
import java.util.ArrayList;

@Data
@Builder
public class OffreDto {
    private Integer id;
    private String titre;
    private String mission;
    private String competence;
    private LocalDate dateOffre;
    private LocalDate dateFin;
    private Integer nombrePoste;
    private DomaineActiviteDto domaineActivite;
    private NiveauEtudeDto niveauEtude;
    private NiveauExperienceDto niveauExperience;
    private TypeContratDto typeContrat;
    private Boolean estActif;
    private ArrayList<PostulerDto>  postuler = new ArrayList<>();

    public static OffreDto toDto(Offre entity){
        if (entity == null) {
            return null;
        }
        return OffreDto.builder()
                .id(entity.getId())
                .titre(entity.getTitre())
                .mission(entity.getMission())
                .competence(entity.getCompetence())
                .dateOffre(entity.getDateOffre())
                .dateFin(entity.getDateFin())
                .nombrePoste(entity.getNombrePoste())
                .domaineActivite(DomaineActiviteDto.toDto(entity.getDomaineActivite()))
                .niveauEtude(NiveauEtudeDto.toDto(entity.getNiveauEtude()))
                .niveauExperience(NiveauExperienceDto.toDto(entity.getNiveauExperience()))
                .typeContrat(TypeContratDto.toDto(entity.getTypeContrat()))
                .build();

    }

    public static Offre toEntity(OffreDto dto) {
        if (dto == null){
            return null;
        }
        Offre entity = new Offre();
        entity.setId(dto.getId());
        entity.setTitre(dto.getTitre());
        entity.setMission(dto.getMission());
        entity.setCompetence(dto.getCompetence());
        entity.setDateOffre(dto.getDateOffre());
        entity.setDateFin(dto.getDateFin());
        entity.setNombrePoste(dto.getNombrePoste());
        entity.setEstActif(dto.getEstActif());
        entity.setDomaineActivite(DomaineActiviteDto.toEntity(dto.getDomaineActivite()));
        entity.setNiveauEtude(NiveauEtudeDto.toEntity(dto.getNiveauEtude()));
        entity.setNiveauExperience(NiveauExperienceDto.toEntity(dto.getNiveauExperience()));
        entity.setTypeContrat(TypeContratDto.toEntity(dto.getTypeContrat()));
        return entity;

    }


}