package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.model.project.UserProjectPurpose;
import com.blockarch.blockarch.model.project.UserProjectPurposeDTO;
import com.blockarch.blockarch.repository.project.UserProjectPurposeRepository;
import com.blockarch.blockarch.service.UserProjectServiceImpl;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProjectPurposeServiceImpl implements UserProjectPurposeService {

    private final UserProjectPurposeRepository userProjectPurposeRepository;
    private final UserProjectServiceImpl userProjectService;

    public UserProjectPurposeServiceImpl(UserProjectPurposeRepository userProjectPurposeRepository, UserProjectServiceImpl userProjectService) {
        this.userProjectPurposeRepository = userProjectPurposeRepository;
        this.userProjectService = userProjectService;
    }

    public UserProjectPurposeDTO convertToUserProjectPurposeDTO(UserProjectPurpose userProjectPurpose) {
        if (userProjectPurpose == null) return null;
        return new UserProjectPurposeDTO(
                userProjectPurpose.getId(),
                (userProjectPurpose.getUserProject() != null) ? userProjectPurpose.getUserProject().getId() : null,
                userProjectPurpose.getBusiness(),
                userProjectPurpose.getPersonal(),
                userProjectPurpose.getGovernment(),
                userProjectPurpose.getResearch()
        );
    }

    public UserProjectPurpose convertToUserProjectPurpose(UserProjectPurposeDTO userProjectPurposeDTO) {
        if (userProjectPurposeDTO == null) return null;

        Long userProjectId = userProjectPurposeDTO.getUserProjectId();
        UserProject userProject = null;
        if (userProjectId != null) {
            userProject = userProjectService.getUserProjectById(userProjectId);
        }

        return new UserProjectPurpose(
                userProjectPurposeDTO.getId(),
                userProject,
                userProjectPurposeDTO.getBusiness(),
                userProjectPurposeDTO.getPersonal(),
                userProjectPurposeDTO.getGovernment(),
                userProjectPurposeDTO.getResearch()
        );
    }

    @Override
    public UserProjectPurposeDTO createUserProjectPurpose(UserProjectPurposeDTO userProjectPurposeDTO) {
        UserProjectPurpose userProjectPurpose = convertToUserProjectPurpose(userProjectPurposeDTO);
        UserProjectPurpose newUserProjectPurpose = userProjectPurposeRepository.save(userProjectPurpose);
        return convertToUserProjectPurposeDTO(newUserProjectPurpose);
    }

    @Override
    public List<UserProjectPurposeDTO> getAllUserProjectPurposes() {
        List<UserProjectPurpose> allUserProjectPurposes = userProjectPurposeRepository.findAll();
        return allUserProjectPurposes.stream()
                .map(this::convertToUserProjectPurposeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserProjectPurposeDTO getUserProjectPurposeById(Long id) {
        Optional<UserProjectPurpose> optionalUserProjectPurpose = userProjectPurposeRepository.findById(id);
        return convertToUserProjectPurposeDTO(optionalUserProjectPurpose.orElse(null));
    }

    @Override
    public UserProjectPurposeDTO updateUserProjectPurpose(Long id, UserProjectPurposeDTO updatedFields) {
        UserProjectPurpose updatedFieldsNew = convertToUserProjectPurpose(updatedFields);
        Optional<UserProjectPurpose> optionalUserProjectPurpose = userProjectPurposeRepository.findById(id);
        if (optionalUserProjectPurpose.isPresent()) {
            UserProjectPurpose existingUserProjectPurpose = optionalUserProjectPurpose.get();
            Field[] fields = UserProjectPurpose.class.getDeclaredFields();

            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object updatedValue = field.get(updatedFieldsNew);
                    if (updatedValue != null) {
                        field.set(existingUserProjectPurpose, updatedValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            existingUserProjectPurpose = userProjectPurposeRepository.save(existingUserProjectPurpose);
            return convertToUserProjectPurposeDTO(existingUserProjectPurpose);
        }
        return null;
    }

    @Override
    public void deleteUserProjectPurpose(Long id){
        Optional<UserProjectPurpose> optionalUserProjectPurpose = userProjectPurposeRepository.findById(id);
        optionalUserProjectPurpose.ifPresent(userProjectPurpose -> {
            userProjectPurpose.setUserProject(null);
            userProjectPurposeRepository.save(userProjectPurpose);
        });
        userProjectPurposeRepository.deleteById(id);
    }

}
