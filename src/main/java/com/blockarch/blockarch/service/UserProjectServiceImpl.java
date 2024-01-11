package com.blockarch.blockarch.service;

import com.blockarch.blockarch.model.Users;
import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.repository.project.UserProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class UserProjectServiceImpl implements UserProjectService {
    @Autowired
    private final UserProjectRepository userProjectRepository;

    public UserProjectServiceImpl(UserProjectRepository userProjectRepository) {
        this.userProjectRepository = userProjectRepository;
    }
    @Override
    @Transactional
    public UserProject createUserProject(UserProject userProject) {

        return userProjectRepository.save(userProject);
    }
    @Override
    @Transactional
    public List<UserProject> getAllUserProjects() {
        return userProjectRepository.findAll();
    }

    @Override
    @Transactional
    public UserProject getUserProjectById(Long id) {
        Optional<UserProject> optionalUserProject = userProjectRepository.findById(id);
        return optionalUserProject.orElse(null);
    }
    @Override
    @Transactional
    public List<UserProject> getUserProjectsByUserId(Users user){
        Optional<List<UserProject>> optionalUserProjects = userProjectRepository.findByUserId(user);
        return optionalUserProjects.orElse(null);
    }
    @Override
    @Transactional
    public UserProject updateUserProject(Long id, UserProject updatedFields) {
//        Optional<UserProject> optionalUserProject = userProjectRepository.findById(id);
//        if (optionalUserProject.isPresent()) {
//            UserProject existingUserProject = optionalUserProject.get();
//
//            // Get all fields of the UserProject class
//            Field[] fields = UserProject.class.getDeclaredFields();
//
//            // Iterate through the fields
//            for (Field field : fields) {
//                try {
//                    // Set the field accessible to allow modification
//                    field.setAccessible(true);
//
//                    // Get the value of the corresponding field from updatedFields
//                    Object updatedValue = field.get(updatedFields);
//
//                    // Check if the updated value is not null and update the field in existingUserProject
//                    if (updatedValue != null) {
//                        field.set(existingUserProject, updatedValue);
//                    }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
            return userProjectRepository.save(updatedFields);
//        }
//        return null;
    }


    @Override
    @Transactional
    public void deleteUserProject(Long id) {
        userProjectRepository.deleteById(id);
    }
}
