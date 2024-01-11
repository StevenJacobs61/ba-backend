package com.blockarch.blockarch.service.calculate;

import com.blockarch.blockarch.model.ProjectBlockchainResult;
import com.blockarch.blockarch.model.dlt.DltSolution;
import com.blockarch.blockarch.model.dlt.DltSolutionIndustry;
import com.blockarch.blockarch.model.dlt.DltSolutionPurpose;
import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.model.project.UserProjectIndustry;
import com.blockarch.blockarch.model.project.UserProjectPurpose;
import com.blockarch.blockarch.service.dlt.DltSolutionService;
import com.blockarch.blockarch.service.dlt.DltSolutionServiceImpl;
import com.blockarch.blockarch.service.results.ProjectBlockchainResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CalculateScoreServiceImpl implements CalculateScoreService {

    @Autowired
    private final DltSolutionService dltSolutionService;
    @Autowired
    private final ProjectBlockchainResultService projectBlockchainResultService;

    private static final Logger logger = LoggerFactory.getLogger(DltSolutionServiceImpl.class);

    public CalculateScoreServiceImpl(
            DltSolutionService dltSolutionService,
            ProjectBlockchainResultService projectBlockchainResultService){
        this.dltSolutionService = dltSolutionService;
        this.projectBlockchainResultService = projectBlockchainResultService;
    }
    public int booleanBlockScore(boolean result, int score){
        return (result && score == 2) || (!result && score == 1) ? 1 : 0;
    }
    public static String findTrueKey(Object obj, Class clazz){
            Field[] fields = clazz.getDeclaredFields();
            for(Field field: fields){
                field.setAccessible(true);
                try{
                    Object value = field.get(obj);
                    if(value instanceof Boolean && (Boolean) value){
                      return field.getName();
                    };
                }catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        return null;
    }
    public static Integer findDltValue(String key, Object obj){
        Class<?> clazz = obj.getClass();
        try{
            Field field = clazz.getDeclaredField(key);
            field.setAccessible(true);
            return (Integer) field.get(obj);
        }catch(IllegalAccessException | NoSuchFieldException e){
            e.printStackTrace();
            return null;
        }
    }
//    public int amountBlockScore()
    public List<ProjectBlockchainResult> calculateScore(UserProject userProject){
        List<ProjectBlockchainResult> resultsArray = new ArrayList<>();
//        Calculate score:
        List<DltSolution> dltSolutions = dltSolutionService.getAllDltSolutions();
        for(DltSolution dltSolution : dltSolutions) {
            Map<?, ?> properties = DltSolution.getProperties(dltSolution);
            ProjectBlockchainResult projectBlockchainResult = new ProjectBlockchainResult();
            projectBlockchainResult.setUser_project_id(userProject);
            projectBlockchainResult.setDlt_solution_id(dltSolution);
            projectBlockchainResult.setCreated_date_time(LocalDateTime.now());
            projectBlockchainResult.setBlock_1_score(0);
            projectBlockchainResult.setBlock_2_score(0);
            projectBlockchainResult.setBlock_3_score(0);
            projectBlockchainResult.setBlock_4_score(0);
            projectBlockchainResult.setBlock_5_score(0);
            projectBlockchainResult.setBlock_6_score(0);
            projectBlockchainResult.setBlock_7_score(0);

            for (Map.Entry<?, ?> entry : properties.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                String stringKey = key.toString();
                switch (stringKey) {
//                    Block 1
                    case "solutionPurpose" -> {
                        UserProjectPurpose userProjectPurpose = userProject.getPurpose();
                        String purposeTrueKey = findTrueKey(userProjectPurpose, UserProjectPurpose.class);
                        DltSolutionPurpose dltSolutionPurpose = dltSolution.getSolutionPurpose();
                        Integer dltPurposeValue = findDltValue(purposeTrueKey, dltSolutionPurpose);
                        projectBlockchainResult.updateBlockScore(1, dltPurposeValue);
                    }
                    case "solutionIndustry" -> {
                        UserProjectIndustry userProjectIndustry = userProject.getIndustryUsage();
                        String industryTrueKey = findTrueKey(userProjectIndustry, UserProjectIndustry.class);
                        DltSolutionIndustry dltSolutionIndustry = dltSolution.getSolutionIndustry();
                        Integer dltIndustryValue = findDltValue(industryTrueKey, dltSolutionIndustry);
                        projectBlockchainResult.updateBlockScore(1, dltIndustryValue);
                    }
//                    Block 2
                    case "participants" -> {
                        UserProjectPurpose userProjectPurpose = userProject.getPurpose();
                        String participantsTrueKey = findTrueKey(userProjectPurpose, UserProjectPurpose.class);
                        DltSolutionPurpose dltSolutionPurpose = dltSolution.getSolutionPurpose();
                        Integer dltParticipantsValue = findDltValue(participantsTrueKey, dltSolutionPurpose);
                        projectBlockchainResult.updateBlockScore(2, dltParticipantsValue);
                    }
                    case "participantsInviteOnly" -> {
                        projectBlockchainResult.updateBlockScore(2,
                                booleanBlockScore(userProject.getInviteOnlyAccess(), dltSolution.getParticipantsInviteOnly()) * 2);
                    }
                    case "participantsIdentifiable" -> {
                        projectBlockchainResult.updateBlockScore(2,
                                (booleanBlockScore(userProject.getIdentityMandatory(), dltSolution.getParticipantsIdentifiable()) * 2));
                    }
                    case "controllerViewMandatory" -> {
                        projectBlockchainResult.updateBlockScore(2,
                                (booleanBlockScore(userProject.getIdentityMandatory(), dltSolution.getControllerViewMandatory()) * 3));
                    }
//                    Block 3
                    case "transactionSize" -> {
                        int sizeValue = userProject.getTransactionSize() <= dltSolution.getTransactionSize() ? 1 : 0;
                        projectBlockchainResult.updateBlockScore(3, sizeValue * 2);
                    }
//                    Block 4
                    case "transactionsPerMonth" -> {
                        projectBlockchainResult.updateBlockScore(4, 3);
                    }
                    case "tps" -> {
                        int tpsValue = userProject.getIdealTransactionsPerSecond() <= dltSolution.getTps() ? 1 : 0;
                        projectBlockchainResult.updateBlockScore(4, tpsValue * 3);
                    }
//                    Block 5
                    case "physicalDeviceIntegration" -> {
                        projectBlockchainResult.updateBlockScore(5,
                                (booleanBlockScore(userProject.getRequirePhysicalDevices(), dltSolution.getPhysicalDeviceIntegration()) * 2));
                    }
//                    Block 6
                    case "budget" -> {
                        int budgetValue = userProject.getBudgetAmount() >= dltSolution.getBudget() ? 1 : 0;
                        projectBlockchainResult.updateBlockScore(6, budgetValue * 2);
                    }
//                    Block 7
                    case "regulatedEnvironment" -> {
                        projectBlockchainResult.updateBlockScore(7,
                                (booleanBlockScore(userProject.getOperateInRegulatoryEnvironment(), dltSolution.getRegulatedEnvironment()) * 3));
                    }
                    case "meetsRegulations" -> {
                        projectBlockchainResult.updateBlockScore(7,
                                booleanBlockScore(userProject.getMeetLegalRequirements(), dltSolution.getMeetsRegulations()));
                    }
                }
            }
            resultsArray.add(projectBlockchainResultService.createProjectBlockchainResult(projectBlockchainResult));
        }
        return resultsArray;
    }
}
