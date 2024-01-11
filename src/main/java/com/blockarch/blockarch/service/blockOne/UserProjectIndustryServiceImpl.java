package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.model.project.UserProjectIndustry;
import com.blockarch.blockarch.model.project.UserProjectIndustryDTO;
import com.blockarch.blockarch.repository.project.UserProjectIndustryRepository;
import com.blockarch.blockarch.repository.project.UserProjectRepository;
import com.blockarch.blockarch.service.UserProjectServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProjectIndustryServiceImpl implements UserProjectIndustryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProjectIndustryServiceImpl.class);
    private final UserProjectRepository userProjectRepository;

    private final UserProjectIndustryRepository userProjectIndustryRepository;
    public UserProjectIndustryServiceImpl(UserProjectIndustryRepository userProjectIndustryRepository, UserProjectRepository userProjectRepository) {
        this.userProjectIndustryRepository = userProjectIndustryRepository;
        this.userProjectRepository = userProjectRepository;
    }

    @Override
    public UserProjectIndustryDTO createUserProjectIndustry(UserProjectIndustryDTO userProjectIndustryDTO){
        UserProjectIndustry userProjectIndustry = convertToUserProjectIndustry(userProjectIndustryDTO);
        UserProjectIndustry newUserProjectindustry = userProjectIndustryRepository.save(userProjectIndustry);
       return convertToUserProjectIndustryDTO(newUserProjectindustry);
    }

    public List<UserProjectIndustryDTO> getAllUserProjectIndustries() {
        List<UserProjectIndustry> allUserProjectIndustries = userProjectIndustryRepository.findAll();
        List<UserProjectIndustryDTO> dtos = allUserProjectIndustries.stream()
                .map(this::convertToUserProjectIndustryDTO)
                .collect(Collectors.toList());

        return dtos;
    }
    private UserProjectIndustryDTO convertToUserProjectIndustryDTO(UserProjectIndustry userProjectIndustry) {
        if(userProjectIndustry == null) return null;
        return new UserProjectIndustryDTO(
                userProjectIndustry.getId(),
                (userProjectIndustry.getUserProject() != null) ? userProjectIndustry.getUserProject().getId() : null,
                userProjectIndustry.getFinance(),
                userProjectIndustry.getDefiNft(),
                userProjectIndustry.getHealthcare(),
                userProjectIndustry.getDigitalAssets(),
                userProjectIndustry.getIntellectualProperty(),
                userProjectIndustry.getEducationAndResearch(),
                userProjectIndustry.getInsurance(),
                userProjectIndustry.getSupplyChain()
        );
    }
    private UserProjectIndustry convertToUserProjectIndustry(UserProjectIndustryDTO userProjectIndustryDTO) {
        if(userProjectIndustryDTO == null) return null;

        Long userProjectId = userProjectIndustryDTO.getUserProjectId();
        UserProject userProject = null;
        if(userProjectId != null){
            UserProjectServiceImpl userProjectService = new UserProjectServiceImpl(userProjectRepository);
            userProject = userProjectService.getUserProjectById(userProjectId);
        }
        return new UserProjectIndustry(
                userProjectIndustryDTO.getId(),
                userProject,
                userProjectIndustryDTO.getFinance(),
                userProjectIndustryDTO.getDefiNft(),
                userProjectIndustryDTO.getHealthcare(),
                userProjectIndustryDTO.getDigitalAssets(),
                userProjectIndustryDTO.getIntellectualProperty(),
                userProjectIndustryDTO.getEducationAndResearch(),
                userProjectIndustryDTO.getInsurance(),
                userProjectIndustryDTO.getSupplyChain()
        );
    }
    @Override
    public UserProjectIndustryDTO getUserProjectIndustryById(Long id){
        Optional<UserProjectIndustry> optionalUserProjectIndustry = userProjectIndustryRepository.findById(id);
        return convertToUserProjectIndustryDTO(optionalUserProjectIndustry.orElse(null));
    }
    @Override
    public UserProjectIndustryDTO updateUserProjectIndustry(Long id, UserProjectIndustryDTO updatedFields){
        UserProjectIndustry updatedFieldsNew = convertToUserProjectIndustry(updatedFields);
        Optional<UserProjectIndustry> optionalUserProjectIndustry = userProjectIndustryRepository.findById(id);
        if(optionalUserProjectIndustry.isPresent()){
            UserProjectIndustry existingUserProjectIndustry = optionalUserProjectIndustry.get();
            Field[] fields = UserProjectIndustry.class.getDeclaredFields();

            for (Field field : fields){
                try {
                    field.setAccessible(true);
                    Object updatedValue = field.get(updatedFieldsNew);
                    if(field.getType().equals(UserProject.class) && updatedValue instanceof Long){
                        Long userProjectId = (Long)updatedValue;
                        UserProject userProject = userProjectRepository.findById(userProjectId).orElse(null);
                        field.set(existingUserProjectIndustry, userProject);
                    } else if(updatedValue != null){
                        field.set(existingUserProjectIndustry, updatedValue);
                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
            existingUserProjectIndustry = userProjectIndustryRepository.save(existingUserProjectIndustry);
            return convertToUserProjectIndustryDTO(existingUserProjectIndustry);
        }
        return null;
    }

    @Override
    public void deleteUserProjectIndustry (Long id){
        Optional<UserProjectIndustry> optionalUserProjectIndustry = userProjectIndustryRepository.findById(id);
        optionalUserProjectIndustry.ifPresent(userProjectIndustry -> {
            userProjectIndustry.setUserProject(null);
            userProjectIndustryRepository.save(userProjectIndustry);
        });
        userProjectIndustryRepository.deleteById(id);
    }

}
