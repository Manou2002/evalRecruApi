package ci.gs2e.dsi.evalrecrute.module.tests.controller;

import ci.gs2e.dsi.evalrecrute.module.candidats.service.CandidatService;
import ci.gs2e.dsi.evalrecrute.module.tests.domain.dto.TestDto;
import ci.gs2e.dsi.evalrecrute.module.tests.service.TestService;
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
@RequestMapping("api/v1/test")
public class TestController {

    private CandidatService candidatService;
    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody TestDto testDto) {
        Map<String, Object> response = new HashMap<>();
        TestDto data = testService.create(testDto);
        response.put("status", true);
        response.put("data", data);
        response.put("message", "Enresgistrement effectué avec succes ");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        TestDto data = testService.getById((Integer.parseInt(id)));
        response.put("status", true);
        response.put("data", data);
        response.put("Error message", "Type de test numero :" +id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Map<String, Object> response = new HashMap<>();
        Pageable paging = PageRequest.of(page, size);
        Page<TestDto> data = testService.getAll(paging);
        response.put("statut", true);
        response.put("data", data.getContent());
        response.put("current_page", data.getNumber());
        response.put("total_items", data.getTotalElements());
        response.put("total_pages", data.getTotalPages());
        response.put("page-size", data.getSize());
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update (@PathVariable("id") String id, @RequestBody TestDto testDto){
        Map<String, Object> response = new HashMap<>();
        TestDto data = testService.update(Integer.parseInt(id), testDto);
        response.put("statut", true);
        response.put("date", data);
        response.put("Error message", "Modification effectué avec succès");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete (@PathVariable("id") String id){
        Map<String, Object> response = new HashMap<>();
        testService.delete(Integer.parseInt(id));
        response.put("statut", true);
        response.put("Error message", "suppression effectue avec succes");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/tests")
    public List<TestDto> getAllCandidats(@PathVariable("id") String id){
        return candidatService.getAllTestByCandidatId(Integer.parseInt(id));
    }

}
