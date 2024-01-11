package com.blockarch.blockarch.repository.project;

import com.blockarch.blockarch.model.project.UserProjectLanguages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectLanguagesRepository extends JpaRepository<UserProjectLanguages, Long> {
}
