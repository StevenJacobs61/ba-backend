package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.project.UserProjectIndustryDTO;

import java.util.List;

public interface UserProjectIndustryService {
    UserProjectIndustryDTO createUserProjectIndustry(UserProjectIndustryDTO userProjectIndustryDTO);
    List<UserProjectIndustryDTO> getAllUserProjectIndustries();
    UserProjectIndustryDTO getUserProjectIndustryById(Long id);
    UserProjectIndustryDTO updateUserProjectIndustry(Long id, UserProjectIndustryDTO updatedFields);
    void deleteUserProjectIndustry(Long id);
}
