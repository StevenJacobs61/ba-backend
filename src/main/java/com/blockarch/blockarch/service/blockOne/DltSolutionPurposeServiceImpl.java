package com.blockarch.blockarch.service.blockOne;

import com.blockarch.blockarch.model.dlt.DltSolutionPurpose;
import com.blockarch.blockarch.repository.dlt.DltSolutionPurposeRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
@Service
public class DltSolutionPurposeServiceImpl implements DltSolutionPurposeService {

    private final DltSolutionPurposeRepository dltSolutionPurposeRepository;
    public DltSolutionPurposeServiceImpl(DltSolutionPurposeRepository dltSolutionPurposeRepository) {
        this.dltSolutionPurposeRepository = dltSolutionPurposeRepository;
    }

    @Override
    public DltSolutionPurpose createDltSolutionPurpose(DltSolutionPurpose dltSolutionPurpose){
        return dltSolutionPurposeRepository.save(dltSolutionPurpose);
    }
    @Override
    public List<DltSolutionPurpose> getAllDltSolutionPurpose(){
        return dltSolutionPurposeRepository.findAll();
    }
    @Override
    public DltSolutionPurpose getDltSolutionPurposeById(Long id){
        Optional<DltSolutionPurpose> optionalDltSolutionPurpose = dltSolutionPurposeRepository.findById(id);
        return optionalDltSolutionPurpose.orElse(null);
    }
    @Override
    public DltSolutionPurpose updateDltSolutionPurpose(Long id, DltSolutionPurpose updatedFields){
        Optional<DltSolutionPurpose> optionalDltSolutionPurpose = dltSolutionPurposeRepository.findById(id);
        if(optionalDltSolutionPurpose.isPresent()){
            DltSolutionPurpose existingDltSolutionPurpose = optionalDltSolutionPurpose.get();
            Field[] fields = DltSolutionPurpose.class.getDeclaredFields();

            for (Field field : fields){
                try {
                    field.setAccessible(true);
                    Object updatedValue = field.get(updatedFields);

                    if(updatedValue != null){
                        field.set(existingDltSolutionPurpose, updatedValue);
                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
            return dltSolutionPurposeRepository.save(existingDltSolutionPurpose);
        }
        return null;
    }

    @Override
    public void deleteDltSolutionPurpose (Long id){
        dltSolutionPurposeRepository.deleteById(id);
    }


}
