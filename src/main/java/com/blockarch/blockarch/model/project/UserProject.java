package com.blockarch.blockarch.model.project;

import com.blockarch.blockarch.model.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
public class UserProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String projectName;
    private String outsourcedBuild;
    private Integer budgetAmount;
    private Integer transactionsPerMonth;
    private Integer transactionsPerSecond;
    private Integer transactionSize;
    private Boolean inviteOnlyAccess;
    private Boolean identityMandatory;
    private String informationType;
    private Float maximumMessageSize;
    private Boolean additionalSystems;
    private Boolean activelyMaintained;
    private String activelyEngaged;
    private Integer idealTransactionsPerSecond;
    private Boolean solutionControllerParticipantView;
    private Boolean operateInRegulatoryEnvironment;
    private Boolean meetLegalRequirements;
    private Boolean requirePhysicalDevices;
    private String esgRelevant;

    @Lob
    @Column(name= "summary", columnDefinition = "TEXT")
    @Basic(fetch = FetchType.EAGER)
    private String summary;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;

    @OneToOne(fetch = FetchType.EAGER)
    private UserProjectIndustry industryUsage;

    @OneToOne(fetch = FetchType.EAGER)
    private UserProjectNetworkParticipants networkParticipants;

    @OneToOne(fetch = FetchType.EAGER)
    private UserProjectLanguages developmentLanguages;

    @OneToOne(fetch = FetchType.EAGER)
    private UserProjectPurpose purpose;

    public UserProject() {
    }

    public UserProject(Long id,
                       String projectName,
                       String outsourcedBuild,
                       Integer budgetAmount,
                       Integer transactionsPerMonth,
                       Integer transactionsPerSecond,
                       Integer transactionSize,
                       Boolean inviteOnlyAccess,
                       Boolean identityMandatory,
                       Boolean solutionControllerParticipantView,
                       Boolean operateInRegulatoryEnvironment,
                       String informationType,
                       Float maximumMessageSize,
                       Integer idealTransactionsPerSecond,
                       Boolean meetLegalRequirements,
                       Boolean requirePhysicalDevices,
                       String esgRelevant,
                       Boolean additionalSystems,
                       Boolean activelyMaintained,
                       String activelyEngaged,
                       Users user,
                       UserProjectIndustry industryUsage,
                       UserProjectNetworkParticipants networkParticipants,
                       UserProjectLanguages developmentLanguages,
                       UserProjectPurpose purpose,
                       String summary) {

        this.id = id;
        this.idealTransactionsPerSecond = idealTransactionsPerSecond;
        this.activelyEngaged = activelyEngaged;
        this.activelyMaintained = activelyMaintained;
        this.additionalSystems = additionalSystems;
        this.maximumMessageSize = maximumMessageSize;
        this.informationType = informationType;
        this.projectName = projectName;
        this.outsourcedBuild = outsourcedBuild;
        this.budgetAmount = budgetAmount;
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
        this.user = user;
        this.industryUsage = industryUsage;
        this.networkParticipants = networkParticipants;
        this.developmentLanguages = developmentLanguages;
        this.purpose = purpose;
        this.summary = summary;
    }



}
