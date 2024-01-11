package com.blockarch.blockarch.service.dlt;

import com.blockarch.blockarch.model.dlt.DltSolution;

import java.util.List;

public interface DltSolutionService {

    DltSolution getDltSolutionById(Long id);
    List<DltSolution> getAllDltSolutions();
}
