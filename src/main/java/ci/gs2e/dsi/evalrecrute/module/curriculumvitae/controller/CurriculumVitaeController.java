package ci.gs2e.dsi.evalrecrute.module.curriculumvitae.controller;

import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.service.CurriculumVitaeService;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.service.RecruteurService;
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
@RequestMapping("api/v1/curriculum-vitaes")
public class CurriculumVitaeController {

    private RecruteurService recruteurService;
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService, RecruteurService recruteurService) {
        this.curriculumVitaeService = curriculumVitaeService;
        this.recruteurService = recruteurService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CurriculumVitaeDto curriculumVitaeDto) {
        Map<String, Object> response = new HashMap<>();
        CurriculumVitaeDto data = curriculumVitaeService.create(curriculumVitaeDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        CurriculumVitaeDto data = curriculumVitaeService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("Error message", "Curriculum vitae numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<CurriculumVitaeDto> data = curriculumVitaeService.getAll(paging);
        response.put("statut", true);
        response.put("data", data.getContent());
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());
        response.put("page-size", data.getSize());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody CurriculumVitaeDto curriculumVitaeDto){
        Map<String, Object> response = new HashMap<>();
        CurriculumVitaeDto data = curriculumVitaeService.update(Integer.parseInt(id), curriculumVitaeDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        curriculumVitaeService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/curriculumvitaes")
    public List<CurriculumVitaeDto> getAllRecruteurs(@PathVariable("id") Integer id){
        return recruteurService.getAllCurriculumVitaeByRecruteurId(id);
    }

}
