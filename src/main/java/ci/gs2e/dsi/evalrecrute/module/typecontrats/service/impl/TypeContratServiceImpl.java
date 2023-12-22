package ci.gs2e.dsi.evalrecrute.module.typecontrats.service.impl;

import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.offres.service.OffreService;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.TypeContrat;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.domain.dto.TypeContratDto;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.repository.TypeContratRepository;
import ci.gs2e.dsi.evalrecrute.module.typecontrats.service.TypeContratService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TypeContratServiceImpl implements TypeContratService {

    private final TypeContratRepository typeContratRepository;

    private final OffreService offreService;
    public TypeContratServiceImpl(TypeContratRepository typeContratRepository, OffreService offreService){
        this.typeContratRepository = typeContratRepository;
        this.offreService = offreService;
    }

    @Override
    public TypeContratDto getById(Integer id) {
        if (id == null){
            log.error("l'id du type de contrat ne doit pas etre nul");
            return null;
        }
        Optional<TypeContrat> typeContrat = typeContratRepository.findById(id);
        if (!typeContrat.isPresent()){
            log.error("l'id du type de contrat ne doit pas etre nul");
            return null;
        }
        return TypeContratDto.toDto (typeContrat.get());
    }
    @Override
    public TypeContratDto create (TypeContratDto typeContratDto){
        if (typeContratDto == null){
            log.error("le type de domaine d'activite ne pas etre nul");
            return null;
        }
        typeContratDto.setEstActif(true);
        return TypeContratDto.toDto(typeContratRepository.save(TypeContratDto.toEntity(typeContratDto)));
    }

    @Override
    public Page<TypeContratDto> getAll(Pageable pageable){
        Page<TypeContrat> typeContrats = typeContratRepository.findAll(pageable);
        if (typeContrats.getContent().isEmpty()){
            log.error("Il n'y a aucun type de contrat dans la base de donnee");
            return null;
        }
        return typeContrats.map(TypeContratDto::toDto);
    }

    @Override
    public TypeContratDto update(Integer id, TypeContratDto typeContratDto) {
        TypeContratDto typeContratDto1 = getById(id);
        typeContratDto1.setLibelle(typeContratDto.getLibelle());
        typeContratDto1.setDescription(typeContratDto.getDescription());
        return TypeContratDto.toDto(typeContratRepository.save(typeContratDto.toEntity(typeContratDto1)));
    }

    @Override
    public void delete(Integer id){
        TypeContratDto typeContratDto = getById(id);
        typeContratRepository.delete(TypeContratDto.toEntity(typeContratDto));
    }

    @Override
    public List<OffreDto> getAllOffreByTypeContratId(Integer id) {
        return offreService.getByTypeContratId(id);
    }



    }
