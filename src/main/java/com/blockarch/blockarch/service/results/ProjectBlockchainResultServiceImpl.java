package com.blockarch.blockarch.service.results;

import com.blockarch.blockarch.model.ProjectBlockchainResult;
import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.repository.ProjectBlockchainResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectBlockchainResultServiceImpl implements ProjectBlockchainResultService{
    @Autowired
    private final ProjectBlockchainResultRepository projectBlockchainResultRepository;
    public ProjectBlockchainResultServiceImpl(
            ProjectBlockchainResultRepository projectBlockchainResultRepository){
        this.projectBlockchainResultRepository = projectBlockchainResultRepository;
    }
    @Override
    public ProjectBlockchainResult createProjectBlockchainResult(ProjectBlockchainResult projectBlockchainResult){
        return this.projectBlockchainResultRepository.save(projectBlockchainResult);
    }
    @Override
    public List<ProjectBlockchainResult>getAll(){
        return this.projectBlockchainResultRepository.findAll();
    }
    @Override
    public List<ProjectBlockchainResult>getByUserProjectId(UserProject user_project_id){
        return this.projectBlockchainResultRepository.findByUserProjectId(user_project_id);
    }
    @Override
    public ProjectBlockchainResult updateProjectBlockchainResult(ProjectBlockchainResult updatedFields){
        return projectBlockchainResultRepository.save(updatedFields);
    }
    @Override
    public void deleteProjectBlockchainResult(Long id){
        this.projectBlockchainResultRepository.deleteById(id);
    }
}
