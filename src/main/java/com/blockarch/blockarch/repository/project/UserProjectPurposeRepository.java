package com.blockarch.blockarch.repository.project;

import com.blockarch.blockarch.model.project.UserProjectPurpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectPurposeRepository extends JpaRepository<UserProjectPurpose, Long> {
}
