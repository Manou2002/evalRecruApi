package ci.gs2e.dsi.evalrecrute.module.niveauEtudes.controller;

import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.domain.dto.NiveauEtudeDto;
import ci.gs2e.dsi.evalrecrute.module.niveauEtudes.service.NiveauEtudeService;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
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
@RequestMapping("api/v1/niveau-etudes")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class NiveauEtudeController {

    private NiveauEtudeService niveauEtudeService;


    @Autowired
    public NiveauEtudeController(NiveauEtudeService niveauEtudeService) {
        this.niveauEtudeService = niveauEtudeService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody NiveauEtudeDto niveauEtudeDto) {
        Map<String, Object> response = new HashMap<>();
        NiveauEtudeDto data = niveauEtudeService.create(niveauEtudeDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        NiveauEtudeDto data = niveauEtudeService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("Error message", "Type de domaine d'activité numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<NiveauEtudeDto> data = niveauEtudeService.getAll(paging);
        response.put("statut", true);
        response.put("data", data!=null ? data.getContent() : new ArrayList<>());
        response.put("current_page", data!=null ? data.getNumber() : 0);
        response.put("total_items", data!=null ? data.getTotalElements() : 0);
        response.put("total_pages", data!=null ? data.getTotalPages() : 0);
        response.put("page-size", data!=null ? data.getSize() : 0);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody NiveauEtudeDto domaineActiviteDto){
        Map<String, Object> response = new HashMap<>();
        NiveauEtudeDto data = niveauEtudeService.update(Integer.parseInt(id), domaineActiviteDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("Error message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        niveauEtudeService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("Error message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}/offres")
    public List<OffreDto> getAllNiveauEtudes(@PathVariable("id") String id) {
        return niveauEtudeService.getAllOffreByNiveauEtudeId(Integer.parseInt(id));
    }

}
