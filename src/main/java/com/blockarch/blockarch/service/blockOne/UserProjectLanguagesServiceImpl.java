package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.model.project.UserProjectIndustry;
import com.blockarch.blockarch.model.project.UserProjectLanguages;
import com.blockarch.blockarch.model.project.UserProjectLanguagesDTO;
import com.blockarch.blockarch.repository.project.UserProjectLanguagesRepository;
import com.blockarch.blockarch.repository.project.UserProjectRepository;
import com.blockarch.blockarch.service.UserProjectServiceImpl;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProjectLanguagesServiceImpl implements UserProjectLanguagesService {
    private final UserProjectLanguagesRepository userProjectLanguagesRepository;

    private final UserProjectRepository userProjectRepository;
    public UserProjectLanguagesServiceImpl(UserProjectLanguagesRepository userProjectLanguagesRepository, UserProjectRepository userProjectRepository) {
        this.userProjectLanguagesRepository = userProjectLanguagesRepository;
        this.userProjectRepository = userProjectRepository;
    }
    public UserProjectLanguagesDTO convertToUserProjectLanguagesDTO(UserProjectLanguages userProjectLanguages) {
        if (userProjectLanguages == null) return null;
        return new UserProjectLanguagesDTO(
                userProjectLanguages.getId(),
                (userProjectLanguages.getUserProject() != null) ? userProjectLanguages.getUserProject().getId() : null,
                userProjectLanguages.getJava(),
                userProjectLanguages.getKotlin(),
                userProjectLanguages.getScala(),
                userProjectLanguages.getRust(),
                userProjectLanguages.getPython(),
                userProjectLanguages.getGo(),
                userProjectLanguages.getSolidity()
        );
    }

    public UserProjectLanguages convertToUserProjectLanguages(UserProjectLanguagesDTO userProjectLanguagesDTO) {
        if (userProjectLanguagesDTO == null) return null;

        Long userProjectId = userProjectLanguagesDTO.getUserProjectId();
        UserProject userProject = null;
        if (userProjectId != null) {
            UserProjectServiceImpl userProjectService = new UserProjectServiceImpl(userProjectRepository);
            userProject = userProjectService.getUserProjectById(userProjectId);
        }

        return new UserProjectLanguages(
                userProjectLanguagesDTO.getId(),
                userProject,
                userProjectLanguagesDTO.getJava(),
                userProjectLanguagesDTO.getKotlin(),
                userProjectLanguagesDTO.getScala(),
                userProjectLanguagesDTO.getRust(),
                userProjectLanguagesDTO.getPython(),
                userProjectLanguagesDTO.getGo(),
                userProjectLanguagesDTO.getSolidity()
        );
    }

    @Override
    public UserProjectLanguagesDTO createUserProjectLanguages(UserProjectLanguagesDTO userProjectLanguagesDTO){
        UserProjectLanguages userProjectLanguages = convertToUserProjectLanguages(userProjectLanguagesDTO);
        UserProjectLanguages newUserProjectLanguages = userProjectLanguagesRepository.save(userProjectLanguages);
        return convertToUserProjectLanguagesDTO(newUserProjectLanguages);
    }
    @Override
    public List<UserProjectLanguagesDTO> getAllUserProjectLanguages(){
        List<UserProjectLanguages> allUserProjectLanguages = userProjectLanguagesRepository.findAll();
        List<UserProjectLanguagesDTO> dtos = allUserProjectLanguages.stream()
                .map(this::convertToUserProjectLanguagesDTO)
                .collect(Collectors.toList());
        return dtos;
    }
    @Override
    public UserProjectLanguagesDTO getUserProjectLanguagesById(Long id){
        Optional<UserProjectLanguages> optionalUserProjectLanguages = userProjectLanguagesRepository.findById(id);
        return convertToUserProjectLanguagesDTO(optionalUserProjectLanguages.orElse(null));
    }
    @Override
    public UserProjectLanguagesDTO updateUserProjectLanguages(Long id, UserProjectLanguagesDTO updatedFields){
        UserProjectLanguages updatedFieldsNew = convertToUserProjectLanguages(updatedFields);
        Optional<UserProjectLanguages> optionalUserProjectLanguages = userProjectLanguagesRepository.findById(id);
        if(optionalUserProjectLanguages.isPresent()){
            UserProjectLanguages existingUserProjectLanguages = optionalUserProjectLanguages.get();
            Field[] fields = UserProjectLanguages.class.getDeclaredFields();

            for (Field field : fields){
                try {
                    field.setAccessible(true);
                    Object updatedValue = field.get(updatedFieldsNew);
                    if(field.getType().equals(UserProject.class) && updatedValue instanceof Long){
                        Long userProjectId = (Long)updatedValue;
                        UserProject userProject = userProjectRepository.findById(userProjectId).orElse(null);
                        field.set(existingUserProjectLanguages, userProject);
                    }else if(updatedValue != null){
                        field.set(existingUserProjectLanguages, updatedValue);
                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
            existingUserProjectLanguages = userProjectLanguagesRepository.save(existingUserProjectLanguages);
            return convertToUserProjectLanguagesDTO(existingUserProjectLanguages);
        }
        return null;
    }

    @Override
    public void deleteUserProjectLanguages (Long id){
        Optional<UserProjectLanguages> optionalUserProjectLanguages = userProjectLanguagesRepository.findById(id);
        optionalUserProjectLanguages.ifPresent(userProjectLanguages -> {
            userProjectLanguages.setUserProject(null);
            userProjectLanguagesRepository.save(userProjectLanguages);
        });
        userProjectLanguagesRepository.deleteById(id);
    }

}
