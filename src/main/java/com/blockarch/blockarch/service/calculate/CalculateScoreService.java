package com.blockarch.blockarch.service.calculate;

import com.blockarch.blockarch.model.ProjectBlockchainResult;
import com.blockarch.blockarch.model.project.UserProject;

import java.util.List;

public interface CalculateScoreService {
    List<ProjectBlockchainResult> calculateScore(UserProject userProject);
}
