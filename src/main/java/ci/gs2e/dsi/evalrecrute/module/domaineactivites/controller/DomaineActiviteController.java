package ci.gs2e.dsi.evalrecrute.module.domaineactivites.controller;

import ci.gs2e.dsi.evalrecrute.module.domaineactivites.domain.dto.DomaineActiviteDto;
import ci.gs2e.dsi.evalrecrute.module.domaineactivites.service.DomaineActiviteService;
import ci.gs2e.dsi.evalrecrute.module.offres.domain.dto.OffreDto;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/domaine-activites")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DomaineActiviteController {
    private DomaineActiviteService domaineActiviteService;


    @Autowired
    public DomaineActiviteController(DomaineActiviteService domaineActiviteService) {
        this.domaineActiviteService = domaineActiviteService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody DomaineActiviteDto domaineActiviteDto) {
        Map<String, Object> response = new HashMap<>();
        DomaineActiviteDto data = domaineActiviteService.create(domaineActiviteDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        DomaineActiviteDto data = domaineActiviteService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("Error message", "Type de domaine d'activité numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<DomaineActiviteDto> data = domaineActiviteService.getAll(paging);
        response.put("statut", true);
        response.put("data", data.getContent());
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());
        response.put("page-size", data.getSize());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody DomaineActiviteDto domaineActiviteDto){
        Map<String, Object> response = new HashMap<>();
        DomaineActiviteDto data = domaineActiviteService.update(Integer.parseInt(id), domaineActiviteDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("Error message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
       Map<String, Object> response = new HashMap<>();
       domaineActiviteService.delete(Integer.parseInt(id));
       response.put("statut", true);
       response.put("Error message", "suppression effectue avec succes");
       return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    @GetMapping("/{id}/offres")
    public List<OffreDto> getAllDomaineActivites(@PathVariable("id") String id) {
        return domaineActiviteService.getAllOffreByDomaineActiviteId(Integer.parseInt(id));
    }

}
