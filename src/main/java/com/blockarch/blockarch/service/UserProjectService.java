package com.blockarch.blockarch.service;

import com.blockarch.blockarch.model.Users;
import com.blockarch.blockarch.model.project.UserProject;

import java.util.List;

public interface UserProjectService {
    UserProject createUserProject(UserProject userProject);
    List<UserProject> getAllUserProjects();
    UserProject getUserProjectById(Long id);
    List<UserProject> getUserProjectsByUserId(Users user);
    UserProject updateUserProject(Long id, UserProject userProject);
    void deleteUserProject(Long id);
}
