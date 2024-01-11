package com.blockarch.blockarch.repository;

import com.blockarch.blockarch.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.emailAddress = :email")
    Users findByEmailAddress(String email);

}
