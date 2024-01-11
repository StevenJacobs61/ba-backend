package com.blockarch.blockarch.model.dlt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
public class DltSolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String solutionName;

    @OneToOne
    private DltSolutionPurpose solutionPurpose;

    @OneToOne
    private DltSolutionIndustry solutionIndustry;

    @OneToOne
    private DltParticipants participants;

//    Over or under a certain amount
    private Long budget;
//    Over or under a certain amount
    private Long tps;
//    Over certain amount score 0
    private Long transactionSize;
    private Long transactionsPerMonth;
//    Binary, yes/no, maybe : 1/2, 3
    private Integer participantsInviteOnly;
    private Integer participantsIdentifiable;
    private Integer controllerViewMandatory;
    private Integer regulatedEnvironment;
    private Integer meetsRegulations;

    private Integer physicalDeviceIntegration;
//Out-sourced build, all except corda 0, corda 1 for all
//    Generalist/specialist null

//    private static final Logger logger = LoggerFactory.getLogger(DltSolution.class);
    @Override
    public String toString(){
        return "DltSolution{"+
                "Id='" + id + '\'' +
                ", SolutionName='" + solutionName + '\''+
//                Block 1
                ", SolutionPurpose='" + solutionPurpose + '\''+
                ", SolutionIndustry='" + solutionIndustry + '\''+
//                Block 2
                ", Participants='" + participants + '\''+
                ", ParticipantsInviteOnly='" + participantsInviteOnly + '\''+
                ", ParticipantsIdentifiable='" + participantsIdentifiable + '\''+
                ", ControllerViewMandatory='" + controllerViewMandatory + '\''+
//                 Block 3
                ", TransactionSize='" + transactionSize + '\''+
//                 Block 4
//                Add an extra one for actively engaged
                ", TransactionsPerMonth='" + transactionsPerMonth + '\''+
                ", Tps='" + tps + '\''+
//                Block 5
                ", PhysicalDeviceIntegration='" + physicalDeviceIntegration + '\''+
//                Block 6
//                Out-sourced build points for corda only for both answers
                ", Budget='" + budget + '\''+
//                Block 7
                ", RegulatedEnvironment='" + regulatedEnvironment + '\''+
                ", MeetsRegulations='" + meetsRegulations + '\''+
                "}";
    }
    public static Map<String, Object> getProperties(DltSolution dltSolution){
        Map<String, Object> properties = new HashMap<>();

        Field[] fields = dltSolution.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);

            try{
                Object value = field.get(dltSolution);
                properties.put(field.getName(), value);
            } catch (IllegalAccessException e){
                e.printStackTrace();
//                logger.error("Error mapping DltSolution", e);
            }
        }
        return properties;
    }
    public DltSolution(){

    };
    public DltSolution(
            Long id,
            String solutionName,
            DltSolutionPurpose solutionPurpose,
            DltSolutionIndustry solutionIndustry,
            DltParticipants participants,
            Long budget,
            Long tps,
            Long transactionSize,
            Long transactionsPerMonth,
            Integer participantsInviteOnly,
            Integer participantsIdentifiable,
            Integer controllerViewMandatory,
            Integer regulatedEnvironment,
            Integer meetsRegulations,
            Integer physicalDeviceIntegration
    ) {
        this.id = id;
        this.solutionName = solutionName;
        this.solutionPurpose = solutionPurpose;
        this.solutionIndustry = solutionIndustry;
        this.participants = participants;
//        this.dataFormats = dataFormats;
        this.budget = budget;
        this.tps = tps;
        this.transactionSize = transactionSize;
        this.transactionsPerMonth = transactionsPerMonth;
        this.participantsInviteOnly = participantsInviteOnly;
        this.participantsIdentifiable = participantsIdentifiable;
        this.controllerViewMandatory = controllerViewMandatory;
        this.regulatedEnvironment = regulatedEnvironment;
        this.meetsRegulations = meetsRegulations;
        this.physicalDeviceIntegration = physicalDeviceIntegration;
    }
}
