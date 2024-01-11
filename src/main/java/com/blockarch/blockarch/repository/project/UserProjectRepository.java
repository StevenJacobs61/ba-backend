package com.blockarch.blockarch.repository.project;

import com.blockarch.blockarch.model.Users;
import com.blockarch.blockarch.model.project.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Long> {

    @Query("SELECT u FROM UserProject u WHERE u.user = :user")
    Optional<List<UserProject>> findByUserId(Users user);


}
