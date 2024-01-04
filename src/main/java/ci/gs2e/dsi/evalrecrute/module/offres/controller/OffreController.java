package ci.gs2e.dsi.evalrecrute.module.offres.controller;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import ci.gs2e.dsi.evalrecrute.module.offres.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/offres")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class OffreController {
    private OffreService offreService;

    @Autowired
    public OffreController(OffreService offreService){
        this.offreService = offreService;
    }
    @PostMapping

    public ResponseEntity<Map<String, Object>> create(@RequestBody OffreDto posteDto){
        Map<String, Object> response = new HashMap<>();
        OffreDto data = offreService.create(posteDto);
        response.put("status", true);
        response.put("data", data);
        response.put("Message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        OffreDto data = offreService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("Message", "Poste numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<OffreDto> data = offreService.getAll(paging);
        response.put("statut", true);
        response.put("data", data!=null ? data.getContent() : new ArrayList<>());
        response.put("current_page", data!=null ? data.getNumber() : 0);
        response.put("total_items", data!=null ? data.getTotalElements() : 0);
        response.put("total_pages", data!=null ? data.getTotalPages() : 0);
        response.put("page-size", data!=null ? data.getSize() : 0);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody OffreDto posteDto){
        Map<String, Object> response = new HashMap<>();
        OffreDto data = offreService.update(Integer.parseInt(id), posteDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("Message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        offreService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("Message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/candidats")
    public List<CandidatDto> getAllOffres(@PathVariable("id") String id){
        return offreService.getAllCandidatByOffreId(Integer.parseInt(id));
    }
}
