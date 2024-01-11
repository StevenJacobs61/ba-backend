package com.blockarch.blockarch.service.results;

import com.blockarch.blockarch.model.ProjectBlockchainResult;
import com.blockarch.blockarch.model.project.UserProject;

import java.util.List;

public interface ProjectBlockchainResultService {
    List<ProjectBlockchainResult> getByUserProjectId(UserProject user_project_id);
    List<ProjectBlockchainResult> getAll();
    ProjectBlockchainResult createProjectBlockchainResult(ProjectBlockchainResult projectBlockchainResult);
    ProjectBlockchainResult updateProjectBlockchainResult(ProjectBlockchainResult updatedFields);
    void deleteProjectBlockchainResult (Long id);
}
