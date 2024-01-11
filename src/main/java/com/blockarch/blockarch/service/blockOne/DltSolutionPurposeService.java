package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.dlt.DltSolutionPurpose;

import java.util.List;

public interface DltSolutionPurposeService {
    DltSolutionPurpose createDltSolutionPurpose(DltSolutionPurpose dltSolutionPurpose);
    List<DltSolutionPurpose> getAllDltSolutionPurpose();
    DltSolutionPurpose getDltSolutionPurposeById(Long id);
    DltSolutionPurpose updateDltSolutionPurpose(Long id, DltSolutionPurpose dltSolutionPurpose);
    void deleteDltSolutionPurpose(Long id);
}
