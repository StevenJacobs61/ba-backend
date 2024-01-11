package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.project.UserProjectPurposeDTO;

import java.util.List;

public interface UserProjectPurposeService {
    UserProjectPurposeDTO createUserProjectPurpose(UserProjectPurposeDTO userProjectPurpose);
    List<UserProjectPurposeDTO> getAllUserProjectPurposes();
    UserProjectPurposeDTO getUserProjectPurposeById(Long id);
    UserProjectPurposeDTO updateUserProjectPurpose(Long id, UserProjectPurposeDTO updatedFields);
    void deleteUserProjectPurpose(Long id);
}
