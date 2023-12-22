package ci.gs2e.dsi.evalrecrute.module.tests.service.impl;

import ci.gs2e.dsi.evalrecrute.module.tests.domain.Test;
import ci.gs2e.dsi.evalrecrute.module.tests.domain.dto.TestDto;
import ci.gs2e.dsi.evalrecrute.module.tests.repository.TestRepository;
import ci.gs2e.dsi.evalrecrute.module.tests.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    @Autowired
    public TestServiceImpl(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    @Override
    public TestDto getById(Integer id) {
        if (id == null){
            log.error("l'id du test ne doit pas etre nul");
            return null;
        }
        Optional<Test> test = testRepository.findById(id);
        if (!test.isPresent()){
            log.error("l'id du test ne doit pas etre nul");
            return null;
        }
        return TestDto.toDto(test.get());
    }
    @Override
    public TestDto create (TestDto testDto){
        if (testDto == null){
            log.error("le type du test ne pas etre nul");
            return null;
        }
        testDto.setEstActif(true);
        return TestDto.toDto(testRepository.save(TestDto.toEntity(testDto)));
    }

    @Override
    public Page<TestDto> getAll(Pageable pageable){
        Page<Test> tests = testRepository.findAll(pageable);
        if (tests.getContent().isEmpty()){
            log.error("Il n'y a aucun type de domaine dans la base de donnee");
            return null;
        }
        return tests.map(TestDto::toDto);
    }

    @Override
    public TestDto update(Integer id, TestDto testDto) {
        TestDto testDto1 = getById(id);
        testDto1.setLibelle(testDto.getLibelle());
        testDto1.setDescription(testDto.getDescription());
        return TestDto.toDto(testRepository.save(TestDto.toEntity(testDto1)));
    }

    @Override
    public void delete(Integer id){
        TestDto testDto = getById(id);
        testRepository.delete(TestDto.toEntity(testDto));
    }

    @Override
    public List<TestDto> getByCandidatId(Integer candidatId){
        List<Test> tests = testRepository.findByCandidatId(candidatId);
        if (tests.isEmpty()){
            log.error("Il n'y a aucun test dans la base de donnee");
        }
        return tests.stream().map(TestDto :: toDto).collect(Collectors.toList());
    }
}
