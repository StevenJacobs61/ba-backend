package com.blockarch.blockarch.repository.project;

import com.blockarch.blockarch.model.project.UserProjectIndustry; // Make sure to import the correct entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectIndustryRepository extends JpaRepository<UserProjectIndustry, Long> {
}
