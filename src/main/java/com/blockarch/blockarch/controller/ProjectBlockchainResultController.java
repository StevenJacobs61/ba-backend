package com.blockarch.blockarch.controller;

import com.blockarch.blockarch.model.ProjectBlockchainResult;
import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.service.calculate.CalculateScoreService;
import com.blockarch.blockarch.service.results.ProjectBlockchainResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-blockchain-result")
public class ProjectBlockchainResultController {

    @Autowired
    private final ProjectBlockchainResultService projectBlockchainResultService;
    @Autowired
    private final CalculateScoreService calculateScoreService;

    public ProjectBlockchainResultController(
            ProjectBlockchainResultService projectBlockchainResultService,
            CalculateScoreService calculateScoreService) {
        this.projectBlockchainResultService = projectBlockchainResultService;
        this.calculateScoreService = calculateScoreService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectBlockchainResult>> getAllProjectBlockchainResults() {
        List<ProjectBlockchainResult> projectBlockchainResults = projectBlockchainResultService.getAll();
        return ResponseEntity.ok(projectBlockchainResults);
    }
    @PostMapping
    public ResponseEntity<UserProject> createProjectBlockchainResult(@RequestBody UserProject userProject){
        List<ProjectBlockchainResult> newProjectBlockchainResult = calculateScoreService.calculateScore(userProject);
        return ResponseEntity.ok(userProject);
    }
    @GetMapping("/{user_project_id}")
    public ResponseEntity<List<ProjectBlockchainResult>> getProjectBlockchainResultsById(@PathVariable UserProject user_project_id){
        List<ProjectBlockchainResult> results = this.projectBlockchainResultService.getByUserProjectId(user_project_id);
        return ResponseEntity.ok(results);
    }
    @PutMapping("/{id}")
    public ProjectBlockchainResult updateProjectBlockchainResult(@RequestBody ProjectBlockchainResult updatedFields) {
        return projectBlockchainResultService.updateProjectBlockchainResult(updatedFields);
    }
    @DeleteMapping("/{id}")
    public void deleteProjectBlockchainResult(@PathVariable Long id) {
        projectBlockchainResultService.deleteProjectBlockchainResult(id);
    }
}
