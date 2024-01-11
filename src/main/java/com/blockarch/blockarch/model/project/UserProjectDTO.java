package com.blockarch.blockarch.model.project;

import com.blockarch.blockarch.model.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private Integer version;
    private String projectName;
    private String outsourcedBuild;
    private String budgetCurrency;
    private Long budgetAmount;
    private String generalistSpecialist;
    private Integer transactionsPerMonth;
    private Integer transactionsPerSecond;
    private Integer transactionSize;
    private Boolean inviteOnlyAccess;
    private Boolean identityMandatory;
    private String informationType;
    private String maximumMessageSize;
    private Boolean grc;
    private Boolean additionalSystems;
    private Boolean activelyMaintained;
    private String activelyEngaged;
    private Integer idealTransactionsPerSecond;
    private Boolean solutionControllerParticipantView;
    private Boolean operateInRegulatoryEnvironment;
    private Boolean meetLegalRequirements;
    private Boolean requirePhysicalDevices;
    private Boolean esgRelevant;

    private Long userId;

    private Long industryUsageId;

    private Long networkParticipantsId;

    private Long developmentLanguagesId;

    private Long purposeId;

    @Lob
    @Column(columnDefinition = "TEXT")
    @Basic(fetch = FetchType.EAGER)
    private String summary;

    public UserProjectDTO() {
    }

    public UserProjectDTO(Long id,
                       Integer version,
                       String projectName,
                       String outsourcedBuild,
                       String budgetCurrency,
                       Long budgetAmount,
                       String generalistSpecialist,
                       Integer transactionsPerMonth,
                       Integer transactionsPerSecond,
                       Integer transactionSize,
                       Boolean inviteOnlyAccess,
                       Boolean identityMandatory,
                       Boolean solutionControllerParticipantView,
                       Boolean operateInRegulatoryEnvironment,
                       String informationType,
                       String maximumMessageSize,
                       Integer idealTransactionsPerSecond,
                       Boolean grc,
                       Boolean meetLegalRequirements,
                       Boolean requirePhysicalDevices,
                       Boolean esgRelevant,
                       Boolean additionalSystems,
                       Boolean activelyMaintained,
                       String activelyEngaged,
                       Long userId,
                       Long industryUsageId,
                       Long networkParticipantsId,
                       Long developmentLanguagesId,
                       Long purposeId, String summary) {

        this.id = id;
        this.idealTransactionsPerSecond = idealTransactionsPerSecond;
        this.activelyEngaged = activelyEngaged;
        this.activelyMaintained = activelyMaintained;
        this.additionalSystems = additionalSystems;
        this.grc = grc;
        this.maximumMessageSize = maximumMessageSize;
        this.informationType = informationType;
        this.version = version;
        this.projectName = projectName;
        this.outsourcedBuild = outsourcedBuild;
        this.budgetCurrency = budgetCurrency;
        this.budgetAmount = budgetAmount;
        this.generalistSpecialist = generalistSpecialist;
        this.transactionsPerMonth = transactionsPerMonth;
        this.transactionsPerSecond = transactionsPerSecond;
        this.transactionSize = transactionSize;
        this.inviteOnlyAccess = inviteOnlyAccess;
        this.identityMandatory = identityMandatory;
        this.solutionControllerParticipantView = solutionControllerParticipantView;
        this.operateInRegulatoryEnvironment = operateInRegulatoryEnvironment;
        this.meetLegalRequirements = meetLegalRequirements;
        this.requirePhysicalDevices = requirePhysicalDevices;
        this.esgRelevant = esgRelevant;
        this.userId = userId;
        this.industryUsageId = industryUsageId;
        this.networkParticipantsId = networkParticipantsId;
        this.developmentLanguagesId = developmentLanguagesId;
        this.purposeId = purposeId;
        this.summary = summary;
    }
}

