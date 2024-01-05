package ci.gs2e.dsi.evalrecrute.module.postulers.service;

import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.postulers.domain.dto.PostulerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostulerService {
    PostulerDto getById(Integer id);
    PostulerDto create(PostulerDto postulerDto);
    Page<PostulerDto> getAll (Pageable pageable);
    PostulerDto update (Integer id, PostulerDto postulerDto);
    void delete (Integer id);

    List<PostulerDto> getAllByOffreId(Integer id);

    List<PostulerDto> getAllByCandidatId(Integer id);


}
