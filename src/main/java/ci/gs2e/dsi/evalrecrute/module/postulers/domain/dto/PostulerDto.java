package ci.gs2e.dsi.evalrecrute.module.postulers.domain.dto;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.Candidat;
import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.dto.DomaineActiviteDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.Offre;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.Postuler;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.PostulerKey;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PostulerDto {

    private PostulerKey id;

    private String acceptation;
    private LocalDate datePostulation;
    private OffreDto offre;
    private CandidatDto candidat;
    private Boolean estActif;


    public static PostulerDto toDto(Postuler entity) {
        if (entity == null) {
            return null;
        }
        return PostulerDto.builder()
                .id(entity.getId())
                .acceptation(entity.getAcceptation())
                .datePostulation(entity.getDatePostulation())
                .offre(OffreDto.toDto(entity.getOffre()))
                .candidat(CandidatDto.toDto(entity.getCandidat()))
                .build();
    }

        public static Postuler toEntity(PostulerDto dto) {
            if (dto == null) {
                return null;
            }
            Postuler entity = new Postuler();
            entity.setId(dto.getId());
            entity.setAcceptation(dto.getAcceptation());
            entity.setDatePostulation(dto.getDatePostulation());
            entity.setOffre(OffreDto.toEntity(dto.getOffre()));
            entity.setCandidat(CandidatDto.toEntity(dto.getCandidat()));
            return entity;
        }

        }
