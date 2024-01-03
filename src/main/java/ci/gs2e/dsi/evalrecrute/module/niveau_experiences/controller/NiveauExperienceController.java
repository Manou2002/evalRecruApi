package ci.gs2e.dsi.evalrecrute.module.niveau_experiences.controller;

import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.NiveauExperience;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.domain.dto.NiveauExperienceDto;
import ci.gs2e.dsi.evalrecrute.module.niveau_experiences.service.NiveauExperienceService;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/niveau-experiences")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class NiveauExperienceController {

    private NiveauExperienceService niveauExperienceService;

    @Autowired
    public NiveauExperienceController(NiveauExperienceService niveauExperienceService) {
        this.niveauExperienceService = niveauExperienceService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody NiveauExperienceDto niveauExperienceDto) {
        Map<String, Object> response = new HashMap<>();
        NiveauExperienceDto data = niveauExperienceService.create(niveauExperienceDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        NiveauExperienceDto data = niveauExperienceService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("Error message", "Type du niveau d'experience numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<NiveauExperienceDto> data = niveauExperienceService.getAll(paging);
        response.put("statut", true);
        response.put("data", data.getContent());
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());
        response.put("page-size", data.getSize());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody NiveauExperienceDto niveauExperienceDto){
        Map<String, Object> response = new HashMap<>();
        NiveauExperienceDto data = niveauExperienceService.update(Integer.parseInt(id), niveauExperienceDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("Error message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        niveauExperienceService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("Error message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}/offres")
    public List<OffreDto> getAllNiveauExperiences(@PathVariable("id") String id) {
        return niveauExperienceService.getAllOffreByNiveauExperienceId(Integer.parseInt(id));
    }

}
