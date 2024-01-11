package com.blockarch.blockarch.service.dlt;

import com.blockarch.blockarch.model.dlt.DltSolution;
import com.blockarch.blockarch.repository.dlt.DltSolutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DltSolutionServiceImpl implements DltSolutionService {

    private final DltSolutionRepository dltSolutionRepository;

    public DltSolutionServiceImpl (DltSolutionRepository dltSolutionRepository){
        this.dltSolutionRepository = dltSolutionRepository;
    }

    @Override
    public DltSolution getDltSolutionById(Long id){
        Optional<DltSolution> optionalDltSolution = dltSolutionRepository.findById(id);
        return optionalDltSolution.orElse(null);
    }
    @Override
    public List<DltSolution> getAllDltSolutions (){
        return dltSolutionRepository.findAll();
    }
}
