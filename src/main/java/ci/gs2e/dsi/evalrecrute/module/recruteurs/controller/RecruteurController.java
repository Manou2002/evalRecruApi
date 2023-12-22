package ci.gs2e.dsi.evalrecrute.module.recruteurs.controller;

import ci.gs2e.dsi.evalrecrute.module.curriculumvitae.domain.dto.CurriculumVitaeDto;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto.RecruteurDto;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.service.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("api/v1/recruteurs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecruteurController {

    private RecruteurService recruteurService;

    @Autowired
    public RecruteurController(RecruteurService recruteurService) {
        this.recruteurService = recruteurService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody RecruteurDto recruteurDto) {
        Map<String, Object> response = new HashMap<>();
        RecruteurDto data = recruteurService.create(recruteurDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        RecruteurDto data = recruteurService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Recruteur numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<RecruteurDto> data = recruteurService.getAll(paging);
        response.put("statut", true);
        response.put("data", data.getContent());
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());
        response.put("page-size", data.getSize());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody RecruteurDto recruteurDto){
        Map<String, Object> response = new HashMap<>();
        RecruteurDto data = recruteurService.update(Integer.parseInt(id), recruteurDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        recruteurService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/curriculum-vitaes")
    public List<CurriculumVitaeDto> getAllRecruteurs(@PathVariable("id") String id){
        return recruteurService.getAllCurriculumVitaeByRecruteurId(Integer.parseInt(id));
    }

}
