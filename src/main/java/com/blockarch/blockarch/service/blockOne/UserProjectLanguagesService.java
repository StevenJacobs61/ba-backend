package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.project.UserProjectLanguagesDTO;

import java.util.List;

public interface UserProjectLanguagesService {
    UserProjectLanguagesDTO createUserProjectLanguages(UserProjectLanguagesDTO userProjectLanguages);
    List<UserProjectLanguagesDTO> getAllUserProjectLanguages();
    UserProjectLanguagesDTO getUserProjectLanguagesById(Long id);
    UserProjectLanguagesDTO updateUserProjectLanguages(Long id, UserProjectLanguagesDTO updatedFields);
    void deleteUserProjectLanguages(Long id);
}
