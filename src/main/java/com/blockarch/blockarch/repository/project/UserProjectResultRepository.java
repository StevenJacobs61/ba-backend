package com.blockarch.blockarch.repository.project;

import com.blockarch.blockarch.model.project.UserProjectResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectResultRepository extends JpaRepository<UserProjectResult, Long> {
}
