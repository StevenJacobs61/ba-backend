package com.blockarch.blockarch.repository;

import com.blockarch.blockarch.model.ProjectBlockchainResult;
import com.blockarch.blockarch.model.project.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectBlockchainResultRepository extends JpaRepository<ProjectBlockchainResult, Long> {

    @Query("SELECT p FROM ProjectBlockchainResult p WHERE p.user_project_id = :user_project_id")
    List<ProjectBlockchainResult> findByUserProjectId(@Param("user_project_id") UserProject userProjectId);

}
