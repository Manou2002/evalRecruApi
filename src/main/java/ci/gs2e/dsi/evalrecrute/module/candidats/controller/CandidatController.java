package ci.gs2e.dsi.evalrecrute.module.candidats.controller;


import ci.gs2e.dsi.evalrecrute.module.candidats.domain.dto.CandidatDto;
import ci.gs2e.dsi.evalrecrute.module.candidats.service.CandidatService;
import ci.gs2e.dsi.evalrecrute.module.offres.service.OffreService;
import ci.gs2e.dsi.evalrecrute.module.tests.domain.dto.TestDto;
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
@RequestMapping("api/v1/candidats")
public class CandidatController {

   private OffreService offreService;
    private CandidatService candidatService;


    @Autowired
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody CandidatDto candidatDto) {
        Map<String, Object> response = new HashMap<>();
        CandidatDto data = candidatService.create(candidatDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createWithCv(@RequestBody CandidatDto candidatDto) {
        Map<String, Object> response = new HashMap<>();
        CandidatDto data = candidatService.createWithCV(candidatDto, candidatDto.getCurriculumVitae());
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        CandidatDto data = candidatService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Candidat numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<CandidatDto> data = candidatService.getAll(paging);
        response.put("statut", true);
        response.put("data", data.getContent());
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());
        response.put("page-size", data.getSize());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody CandidatDto candidatDto){
        Map<String, Object> response = new HashMap<>();
        CandidatDto data = candidatService.update(Integer.parseInt(id), candidatDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        candidatService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/candidats")
    public List<CandidatDto> getAllOffres(@PathVariable("id") String id){
        return offreService.getAllCandidatByOffreId(Integer.parseInt(id));
    }
    @GetMapping("/{id}/tests")
    public List<TestDto> getAllCandidats(@PathVariable("id") String id){
        return candidatService.getAllTestByCandidatId(Integer.parseInt(id));
    }

}
