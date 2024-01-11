package com.blockarch.blockarch.service.blockTwo;

import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.model.project.UserProjectNetworkParticipants;
import com.blockarch.blockarch.model.project.UserProjectNetworkParticipantsDTO;
import com.blockarch.blockarch.repository.project.UserProjectNetworkParticipantsRepository;
import com.blockarch.blockarch.repository.project.UserProjectRepository;
import com.blockarch.blockarch.service.UserProjectServiceImpl;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProjectNetworkParticipantServiceImpl implements UserProjectNetworkParticipantsService {

    private final UserProjectNetworkParticipantsRepository userProjectNetworkParticipantsRepository;

    private final UserProjectRepository userProjectRepository;
    public UserProjectNetworkParticipantServiceImpl(UserProjectNetworkParticipantsRepository userProjectNetworkParticipantsRepository, UserProjectRepository userProjectRepository) {
        this.userProjectNetworkParticipantsRepository = userProjectNetworkParticipantsRepository;
        this.userProjectRepository = userProjectRepository;
    }

    public UserProjectNetworkParticipantsDTO convertToUserProjectNetworkParticipantsDTO(UserProjectNetworkParticipants userProjectNetworkParticipants) {
        if (userProjectNetworkParticipants == null) return null;
        return new UserProjectNetworkParticipantsDTO(
                userProjectNetworkParticipants.getId(),
                (userProjectNetworkParticipants.getUserProject() != null) ? userProjectNetworkParticipants.getUserProject().getId() : null,
                userProjectNetworkParticipants.getIndividuals(),
                userProjectNetworkParticipants.getCompanies(),
                userProjectNetworkParticipants.getNgo(),
                userProjectNetworkParticipants.getGovernmentBody(),
                userProjectNetworkParticipants.getConsortia()
        );
    }

    public UserProjectNetworkParticipants convertToUserProjectNetworkParticipants(UserProjectNetworkParticipantsDTO userProjectNetworkParticipantsDTO) {
        if (userProjectNetworkParticipantsDTO == null) return null;

        Long userProjectId = userProjectNetworkParticipantsDTO.getUserProjectId();
        UserProject userProject = null;
        if (userProjectId != null) {
            UserProjectServiceImpl userProjectService = new UserProjectServiceImpl(userProjectRepository);
            userProject = userProjectService.getUserProjectById(userProjectId);
        }

        return new UserProjectNetworkParticipants(
                userProjectNetworkParticipantsDTO.getId(),
                userProject,
                userProjectNetworkParticipantsDTO.getIndividuals(),
                userProjectNetworkParticipantsDTO.getCompanies(),
                userProjectNetworkParticipantsDTO.getNgo(),
                userProjectNetworkParticipantsDTO.getGovernmentBody(),
                userProjectNetworkParticipantsDTO.getConsortia()
        );
    }

    @Override
    public UserProjectNetworkParticipantsDTO createUserProjectNetworkParticipants(UserProjectNetworkParticipantsDTO userProjectNetworkParticipantsDTO){
        UserProjectNetworkParticipants userProjectNetworkParticipants = convertToUserProjectNetworkParticipants(userProjectNetworkParticipantsDTO);
        UserProjectNetworkParticipants newNewUserProjectNetworkParticipants = userProjectNetworkParticipantsRepository.save(userProjectNetworkParticipants);
        return convertToUserProjectNetworkParticipantsDTO(newNewUserProjectNetworkParticipants);
    }
    @Override
    public List<UserProjectNetworkParticipantsDTO> getAllUserProjectNetworkParticipants() {
        List<UserProjectNetworkParticipants> allUserProjectNetworkParticipants = userProjectNetworkParticipantsRepository.findAll();
        List<UserProjectNetworkParticipantsDTO> dtos = allUserProjectNetworkParticipants.stream()
                .map(this::convertToUserProjectNetworkParticipantsDTO)
                .collect(Collectors.toList());
        return dtos;
    }
    @Override
    public UserProjectNetworkParticipantsDTO getUserProjectNetworkParticipantsById(Long id) {
        Optional<UserProjectNetworkParticipants> optionalUserProjectNetworkParticipants = userProjectNetworkParticipantsRepository.findById(id);
        return convertToUserProjectNetworkParticipantsDTO(optionalUserProjectNetworkParticipants.orElse(null));
    }
    @Override
    public UserProjectNetworkParticipantsDTO updateUserProjectNetworkParticipants(Long id, UserProjectNetworkParticipantsDTO updatedFields) {
        UserProjectNetworkParticipants updatedFieldsNew = convertToUserProjectNetworkParticipants(updatedFields);
        Optional<UserProjectNetworkParticipants> optionalUserProjectNetworkParticipants = userProjectNetworkParticipantsRepository.findById(id);
        if (optionalUserProjectNetworkParticipants.isPresent()) {
            UserProjectNetworkParticipants existingUserProjectNetworkParticipants = optionalUserProjectNetworkParticipants.get();
            Field[] fields = UserProjectNetworkParticipants.class.getDeclaredFields();

            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object updatedValue = field.get(updatedFieldsNew);

                    if (field.getType().equals(UserProject.class) && updatedValue instanceof Long) {
                        Long userProjectId = (Long) updatedValue;
                        UserProject userProject = userProjectRepository.findById(userProjectId).orElse(null);
                        field.set(existingUserProjectNetworkParticipants, userProject);
                    } else if (updatedValue != null) {
                        field.set(existingUserProjectNetworkParticipants, updatedValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            existingUserProjectNetworkParticipants = userProjectNetworkParticipantsRepository.save(existingUserProjectNetworkParticipants);
            return convertToUserProjectNetworkParticipantsDTO(existingUserProjectNetworkParticipants);
        }
        return null;
    }

    @Override
    public void deleteUserProjectNetworkParticipants(Long id){
        Optional<UserProjectNetworkParticipants> optionalUserProjectNetworkParticipants = userProjectNetworkParticipantsRepository.findById(id);
        optionalUserProjectNetworkParticipants.ifPresent(userProjectNetworkParticipants -> {
            userProjectNetworkParticipants.setUserProject(null);
            userProjectNetworkParticipantsRepository.save(userProjectNetworkParticipants);
        });
        userProjectNetworkParticipantsRepository.deleteById(id);
    }


}
