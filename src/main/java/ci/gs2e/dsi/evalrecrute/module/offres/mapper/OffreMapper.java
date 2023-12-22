package ci.gs2e.dsi.evalrecrute.module.offres.mapper;

import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;

public class OffreMapper {
    public static OffreDto toDto(Offre offre){
        if (offre == null){
            return null;
        }
        return OffreDto.builder()
                .id(offre.getId())
                .titre(offre.getTitre())
                .mission(offre.getMission())
                .competence(offre.getCompetence())
                .estActif(offre.getEstActif())
                .build();
    }
    public static Offre toOffre(OffreDto dto){
        if (dto == null){
            return null;
        }
        Offre entity = new Offre();
        entity.setId(dto.getId());
        entity.setTitre(dto.getTitre());
        entity.setMission(dto.getMission());
        entity.setCompetence(dto.getCompetence());
        entity.setEstActif(dto.getEstActif());
        return entity;


    }
}