package ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.controller;

import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.domain.dto.CompteUtilisateurDto;
import ci.gs2e.dsi.evalrecrute.module.compteUtilisateurs.service.CompteUtilisateurService;
import ci.gs2e.dsi.evalrecrute.module.recruteurs.domain.dto.RecruteurDto;
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
@RequestMapping("api/v1/compte-utilisateurs")

public class CompteUtilisateurController {

    private CompteUtilisateurService compteUtilisateurService;

    @Autowired
    public CompteUtilisateurController(CompteUtilisateurService compteUtilisateurService) {
        this.compteUtilisateurService = compteUtilisateurService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CompteUtilisateurDto compteUtilisateurDto) {
        Map<String, Object> response = new HashMap<>();
        CompteUtilisateurDto data = compteUtilisateurService.create(compteUtilisateurDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        CompteUtilisateurDto data = compteUtilisateurService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("Error message", "compte urilisateur numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<CompteUtilisateurDto> data = compteUtilisateurService.getAll(paging);
        response.put("statut", true);
        response.put("data", data.getContent());
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());
        response.put("page-size", data.getSize());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody CompteUtilisateurDto compteUtilisateurDto){
        Map<String, Object> response = new HashMap<>();
        CompteUtilisateurDto data = compteUtilisateurService.update(Integer.parseInt(id), compteUtilisateurDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("Error message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        compteUtilisateurService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("Error message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/candidats")
    public List<CandidatDto> getAll3Candidats(@PathVariable("id") String id) {
        return compteUtilisateurService.getAllCandidatByCompteUtilisateurId(Integer.parseInt(id));
    }

  @GetMapping("/{id}/recruteurs")
    public List<RecruteurDto> getAllRecruteurs(@PathVariable("id") String id){
        return compteUtilisateurService.getAllRecruteurByCompteUtilisateurId(Integer.parseInt(id));
  }
}
